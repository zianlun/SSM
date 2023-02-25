package zian.example.pojo;

import java.util.ArrayList;

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

    private ArrayList<Employee> emps;


    public Department() {
    }

    public Department(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public ArrayList<Employee> getEmps() {
        return emps;
    }

    public void setEmps(ArrayList<Employee> emps) {
        this.emps = emps;
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
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
