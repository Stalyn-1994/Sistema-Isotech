/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Stalyn
 */
@ManagedBean
@SessionScoped
public class selectOneMenuView {

    /**
     * Creates a new instance of selectOneMenuView
     */
     private String car;  
     private String payment;
    private List<SelectItem> cars;
 private Theme theme;   
    private List<Theme> themes;
    @ManagedProperty("#{themeService}")
    private ThemeService service;
    
    public selectOneMenuView() {
    }
      @PostConstruct
    public void init() {
        //cars
        SelectItemGroup g1 = new SelectItemGroup("Pichicha");
        g1.setSelectItems(new SelectItem[] {new SelectItem("Quito", "Quito"),new SelectItem("Tabacundo", "Tabacundo"), new SelectItem("Machachi", "Machachi"),new SelectItem("Sangolqui", "Sangolqui"), new SelectItem("Cayambe", "Cayambe")});
         
        SelectItemGroup g2 = new SelectItemGroup("Azuay");
        g2.setSelectItems(new SelectItem[] {new SelectItem("Cuenca", "Cuenca"), new SelectItem("Gualaseo", "Gualaseo")});
        
        
              SelectItemGroup g3 = new SelectItemGroup("Santo Domingo de los Tsachilas");
        g3.setSelectItems(new SelectItem[] {new SelectItem("Santo Domingo", "Santo Domingo"), new SelectItem("Concordia", "Concordia")});
        cars = new ArrayList<SelectItem>();
        
        cars.add(g1);
        cars.add(g2);
        cars.add(g3);
       
         }

      
      
      
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List<SelectItem> getCars() {
        return cars;
    }

    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public ThemeService getService() {
        return service;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }
    
    
    
    
}
