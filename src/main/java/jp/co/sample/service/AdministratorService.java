package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報関連サービス.
 * 
 * @author tomoki.hirobe
 */
@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報をデータベースに挿入する.
     * 
     * @param administrator 挿入する管理者情報
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    /**
     * 入力されたメールアドレスとパスワードをもとに管理者情報をデータベースに問い合わせる.
     * 
     * @param mailAddress メールアドレス
     * @param password    パスワード
     * @return 管理者情報 DBに存在しなかった場合はNull
     */
    public Administrator login(String mailAddress, String password) {
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }
}
