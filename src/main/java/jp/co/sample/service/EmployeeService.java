package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報関連サービス.
 * 
 * @author tomoki.hirobe
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * 従業員一覧をデータベースに問い合わせる.
     * 
     * @return 従業員一覧
     */
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }

    /**
     * 従業員情報をデータベースに問い合わせる.
     * 
     * @param id 従業員ID
     * @return 従業員情報
     */
    public Employee showDetail(Integer id) {
        return employeeRepository.load(id);
    }

    /**
     * 従業員情報を更新する.
     * 
     * @param employee 従業員情報
     */
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }
}
