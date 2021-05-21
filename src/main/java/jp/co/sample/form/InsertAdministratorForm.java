package jp.co.sample.form;

/**
 * 管理者情報を登録するフォーム.
 * 
 * @author tomoki.hirobe
 */
public class InsertAdministratorForm {
    /** 名前 */
    private String name;
    /** メールアドレス */
    private String mailAddress;
    /** パスワード */
    private String password;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", mailAddress='" + getMailAddress() + "'" + ", password='"
                + getPassword() + "'" + "}";
    }

}
