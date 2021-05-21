package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * administratorsテーブルを操作するレポジトリ.
 * 
 * @author tomoki.hirobe
 */
@Repository
public class AdministratorRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String TABLE_NAME = "administrators";

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };

    /**
     * 管理者情報をデータベースに挿入する.
     * 
     * @param administrator 挿入する管理者情報
     */
    public void insert(Administrator administrator) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String insertSql = "INSERT INTO " + TABLE_NAME
                + " (name, mail_address, password) VALUES (:name, :mailAddress, :password);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String[] keyColumnNames = { "id" };
        template.update(insertSql, param, keyHolder, keyColumnNames);
        administrator.setId(keyHolder.getKey().intValue());
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する.
     * 
     * @param mailAddress 検索するメールアドレス
     * @param password    検索するパスワード
     * @return 検索された管理者情報(検索結果が0ならNullを返す)
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT id, name, mail_address, password FROM " + TABLE_NAME
                + " WHERE mail_address = :mailAddress AND password = :password;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password",
                password);
        List<Administrator> administrators = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administrators.size() == 0) {
            return null;
        }
        return administrators.get(0);
    }
}
