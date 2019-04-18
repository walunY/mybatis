package xyz.walun.domain;

public class UserAccount extends Account {
    private String username;
    private String address;

    @Override
    public String toString() {
        return super.toString()+"UserAccount{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
