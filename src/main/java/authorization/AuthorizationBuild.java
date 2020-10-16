
package authorization;

public class AuthorizationBuild {
    private String email;
    private String password;

    public AuthorizationBuild withEmail(String email){
        this.email = email;
        return this;
    }

    public AuthorizationBuild withPassword(String password){
        this.password = password;
        return this;
    }

    public Authorization build(){
        return new Authorization(email, password);
    }

}

