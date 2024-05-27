package Potato.Potato_Spring.domain;

public class Member {
    private int userindex;
    private String userid;
    private String password;
    private String name;
    private int age;
    private int gender;
    private int type;

    public int getUserindex() {
        return userindex;
    }

    public void setUserindex(int userindex) {
        this.userindex = userindex;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
