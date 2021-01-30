package trius.springframework.security;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user")
public class ApplicationUser extends  User {

    @Id
    private String email;
    private String password;

    public ApplicationUser(String email, String password) {
       super(email,password, new ArrayList<>());
       this.email = email;
       this.password = password;
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
}
