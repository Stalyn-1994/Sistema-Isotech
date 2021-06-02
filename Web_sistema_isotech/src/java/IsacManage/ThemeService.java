/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Stalyn
 */
public class ThemeService {
    private List<Theme> themes;

    
    @PostConstruct
    public void init() {
        
        themes.add(new Theme(0, "Nova-Light", "1.jpg"));
        themes.add(new Theme(1, "Nova-Dark", "2.jpg"));
        
    }
    public List<Theme> getThemes() {
        return themes;
    }
    
}
