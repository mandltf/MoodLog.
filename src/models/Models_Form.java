package models;

/**
 *
 * @author manda
 */
public class Models_Form {
    private String mood;
    private String catatan;
    private int levelMood, moodid;
    private String timestamp;
    private String username;

    public int getMoodid() {
        return moodid;
    }
    
    public String getMood() {
        return mood;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public int getLevelMood() {
        return levelMood;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public String getUsername() {
        return username;
    }
    
    
    public void setMood(String mood) {
        this.mood = mood;
    }
    
    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
    
    public void setLevelMood(int levelMood) {
        this.levelMood = levelMood;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setMoodid(int moodid) {
        this.moodid = moodid;
    }
    
} 