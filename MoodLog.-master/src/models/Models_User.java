package models;

/**
 *
 * @author manda
 */
public class Models_User {
    String username, email, pass;
    int id;
    // Fields for mood data
    private String timestamp;
    private String mood;
    private String catatan;
    private int levelMood;
   
    
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
    
    // Getter and Setter for mood data
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMood() {
        return mood;
    }
    
    public void setMood(String mood) {
        this.mood = mood;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
    
    public int getLevelMood() {
        return levelMood;
    }
    
    public void setLevelMood(int levelMood) {
        this.levelMood = levelMood;
    }
}
