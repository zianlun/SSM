package zian.example.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/18:14
 * @Description:
 */
public class Department {
    private Integer depId;
    private String depName;

    public Department() {
    }

    public Department(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }
}
