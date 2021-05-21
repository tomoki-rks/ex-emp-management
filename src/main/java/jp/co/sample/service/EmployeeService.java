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
}
