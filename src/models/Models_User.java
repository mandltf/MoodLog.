package models;

/**
 *
 * @author manda
 */
public class Models_User {
    String username, email, pass;
    int id;
   
    
    //Getter dan Setter
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }
    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    

}
