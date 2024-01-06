
package dto;

public class Account {
    private String accountID;
    private String email;
    private String password;
    private String role;

    public Account() {
        accountID = "";
        email = "";
        password="";
        role="";
    }

    public Account(String accountID, String email, String password, String role) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
