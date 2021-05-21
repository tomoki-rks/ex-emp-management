package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
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

    /**
     * フォームの初期化.
     * 
     * @return フォーム
     */
    @ModelAttribute
    public InsertAdministratorForm setUpForm() {
        return new InsertAdministratorForm();
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
}
