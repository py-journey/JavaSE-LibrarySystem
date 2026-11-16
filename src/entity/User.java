package entity;

public class User {
    //账户和密码
    private String username;
    private String password;

    //构造方法
    public User(){
    }
    public User(String uname,String passwd){
        this.username=uname;
        this.password=passwd;
    }

    //Getter/Getter方法
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
