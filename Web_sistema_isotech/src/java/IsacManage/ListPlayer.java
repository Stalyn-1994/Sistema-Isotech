/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Stalyn
 */
 
 
@ManagedBean
@SessionScoped
   

public class ListPlayer {
    /**
     * Creates a new instance of ListPlayer
     */
  
   
    private List<Player> players;     
    private Player selectedPlayer;
    /**
     *
     */
    public void OrderListBean() {
        players = new ArrayList<Player>();
        players.add(new Player("ejemplo.jpg", 10, "Stalyn Vasconez"));
        players.add(new Player("ejemplo2.jpg", 20, "Leticia Andrade"));
    } //more players } 

    
    public Player findById(){
         
        players.get(0);
        return players.get(0);
    }
    
       @PostConstruct
    public void init(){
           OrderListBean();
       }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }
    
    public ListPlayer() {
    
    
    }
}
