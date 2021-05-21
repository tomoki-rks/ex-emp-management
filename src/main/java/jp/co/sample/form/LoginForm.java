package jp.co.sample.form;

/**
 * ログイン情報を登録するフォーム.
 * 
 * @author tomoki.hirobe
 */
public class LoginForm {
    /** メールアドレス */
    private String mailAddress;
    /** パスワード */
    private String password;

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
        return "{" + " mailAddress='" + getMailAddress() + "'" + ", password='" + getPassword() + "'" + "}";
    }

}
