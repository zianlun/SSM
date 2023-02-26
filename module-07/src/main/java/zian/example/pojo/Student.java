package zian.example.pojo;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/10:46
 * @Description:
 */
public class Student {
    private Integer sId;

    private String sName;

    private Integer age;

    private String gender;

    private double score;

    private Clazz clazz;

    private String[] hobby;

    private Map<String, Teacher> teachers;

    public Student() {
    }

    public Student(Integer sId, String sName, Integer age, String gender) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer sId, String sName, Integer age, String gender, double score) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sId, student.sId) && Objects.equals(sName, student.sName) && Objects.equals(age, student.age) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, sName, age, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
