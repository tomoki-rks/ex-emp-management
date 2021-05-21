package jp.co.sample.form;

/**
 * 従業員情報をアップデートするフォーム.
 * 
 * @author tomoki.hirobe
 */
public class UpdateEmployeeForm {
    /** 従業員ID */
    private String id;
    /** 扶養人数 */
    private String dependentsCount;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return this.dependentsCount;
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", dependentsCount='" + getDependentsCount() + "'" + "}";
    }

}
