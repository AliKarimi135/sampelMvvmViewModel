package ir.aliprogramer.sampelmvvmlivedata.mode;

public class User {
    String name,mobile,city;

    public User(String name, String mobile, String city) {
        this.name = name;
        this.mobile = mobile;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
