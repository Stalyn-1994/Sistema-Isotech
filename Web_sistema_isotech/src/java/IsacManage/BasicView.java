/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stalyn
 */
@ManagedBean
@SessionScoped
public class BasicView {

    /**
     * Creates a new instance of BasicView
     */
    public BasicView() {
    }
    
     private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
