
package dto;

public class Customer {
    private int cusID;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private boolean cusStatus;

    public Customer() {
        cusID = 0;
        email = "";
        password = "";
        name = "";
        address = "";
        phone = "";
        cusStatus = false;
    }

    public Customer(int cusID, String email, String password, String name, String address, String phone, boolean cusStatus) {
        this.cusID = cusID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cusStatus = cusStatus;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(boolean cusStatus) {
        this.cusStatus = cusStatus;
    }
}
