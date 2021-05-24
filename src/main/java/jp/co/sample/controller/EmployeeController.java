package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報関連コントローラ.
 * 
 * @author tomoki.hirobe
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute
    UpdateEmployeeForm setUpUpdateEmployeeForm() {
        return new UpdateEmployeeForm();
    }

    /**
     * 従業員一覧の画面を表示するコントローラ.
     * 
     * @param model requestスコープ
     * @return 従業員一覧リストを表示
     */
    @RequestMapping("/showList")
    public String showList(Model model) {
        List<Employee> employees = employeeService.showList();
        model.addAttribute("employeeList", employees);
        return "employee/list";
    }

    /**
     * 従業員詳細画面を表示するコントローラ.
     * 
     * @param id    従業員ID
     * @param model requestスコープ
     * @return 従業員詳細画面を表示
     */
    @RequestMapping("/showDetail")
    public String showDetail(String id, Model model) {
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * 従業員の扶養人数を更新するコントローラ.
     * 
     * @param form フォーム情報
     * @return 従業員一覧へリダイレクト
     */
    @RequestMapping("/update")
    public String update(UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }
}
