package zian.example.pojo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/11:41
 * @Description:
 */
public class Clazz {
    private Integer cId;

    private String cName;

    private List<Student> stus;

    public Clazz() {
    }

    public Clazz(Integer cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
