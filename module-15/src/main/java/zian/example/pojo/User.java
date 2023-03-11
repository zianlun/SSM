package zian.example.pojo;

/**
 * @ClassName User
 * @Description
 * @Author ljzhang
 * @Date 2023/3/10 11:04
 * @Version 1.0
 */
public class User {
    private Integer id;

    private String username;

    private String password;

    private String emile;

    private String gender;

    public User() {
    }

    public User(Integer id, String username, String password, String emile, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emile = emile;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emile='" + emile + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmile() {
        return emile;
    }

    public void setEmile(String emile) {
        this.emile = emile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
