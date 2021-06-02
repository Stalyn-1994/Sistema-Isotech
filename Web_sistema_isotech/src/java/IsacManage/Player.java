/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

/**
 *
 * @author Stalyn
 */

public class Player {
private int id;  

    private String displayName; 
    private String name;    
    
     public Player(String displayName,int id, String name) {
        
        this.displayName = displayName;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
 
}
