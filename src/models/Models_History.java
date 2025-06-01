package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manda
 */
public class Models_History {
    private List<Models_Form> moodEntries;
    private String username;
    
    public Models_History() {
        this.moodEntries = new ArrayList<>();
    }
    
    // Getters
    public List<Models_Form> getMoodEntries() {
        return moodEntries;
    }
    
    public String getUsername() {
        return username;
    }
    
    // Setters
    public void setMoodEntries(List<Models_Form> moodEntries) {
        this.moodEntries = moodEntries;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Methods to manage entries
    public void addMoodEntry(Models_Form entry) {
        moodEntries.add(entry);
    }
    
    public void removeMoodEntry(Models_Form entry) {
        moodEntries.remove(entry);
    }
    
    public void clearEntries() {
        moodEntries.clear();
    }
} 