package authorization;

public class Authorization {
    public String email;
    public String password;

    public Authorization() {
    }

    public Authorization(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }

    public String getPassword() {
        return this.password;
    }


}
