package jou.mr.springboot.entity;

public class SysUser {
    private Integer userId;
    private String username;
    private String password;
    private String realName;
    private String phone;

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SysUser() {
    }

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SysUser(Integer userId, String username, String password, String realName, String phone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
    }

    public SysUser(String username, String password, String realName, String phone) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
    }
}