package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報関連コントローラ.
 * 
 * @author tomoki.hirobe
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * InsertAdministratorフォームの初期化.
     * 
     * @return InsertAdministratorフォーム
     */
    @ModelAttribute
    public InsertAdministratorForm setUpInsertAdministratorForm() {
        return new InsertAdministratorForm();
    }

    /**
     * Loginフォームの初期化.
     * 
     * @return ログインフォーム
     */
    @ModelAttribute
    public LoginForm setUpLoginForm() {
        return new LoginForm();
    }

    /**
     * 管理者情報登録画面表示.
     * 
     * @return 管理者情報登録画面
     */
    @RequestMapping("/toInsert")
    public String toInsert() {
        return "administrator/insert";
    }

    /**
     * 管理者情報の登録.
     * 
     * @param form フォーム入力情報
     * @return ログイン画面へリダイレクト
     */
    @RequestMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());
        administratorService.insert(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面の表示.
     * 
     * @return ログイン画面
     */
    @RequestMapping("/")
    public String toLogin(Model model) {
        return "administrator/login";
    }

    /**
     * ログイン処理コントローラ.
     * 
     * @param form  フォーム情報
     * @param model requestスコープ
     * @return 従業員一覧
     */
    @RequestMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator admin = administratorService.login(form.getMailAddress(), form.getPassword());
        if (admin == null) {
            model.addAttribute("error", "メールアドレスまたはパスワードが不正です");
            return toLogin(model);
        }
        session.setAttribute("administratorName", admin.getName());
        /**
         * NOTE: テンプレートではなくパスを指定したいときはforwardを使う(redirectと同じ使い方)
         * なにもつけないと、存在しないテンプレートを呼び出そうとして500 ERRORになる
         */
        return "forward:/employee/showList";
    }
}
