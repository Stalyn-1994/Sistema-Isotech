/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IsacManage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Stalyn
 */
@ManagedBean
@SessionScoped
public class CalendarView {

    /**
     * Creates a new instance of CalendarView
     */
    public CalendarView() {
    }
   
    private Date date4;
   
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
 
 
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
 
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
 
 
 
    public Date getDate4() {
        return date4;
    }
 
    public void setDate4(Date date4) {
        this.date4 = date4;
    }
 
 
    public List<Date> getMulti() {
        return multi;
    }
 
    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }
 
    public List<Date> getRange() {
        return range;
    }
 
    public void setRange(List<Date> range) {
        this.range = range;
    }
 
    public List<Date> getInvalidDates() {
        return invalidDates;
    }
 
    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }
 
    public List<Integer> getInvalidDays() {
        return invalidDays;
    }
 
    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }
 
    public Date getMinDate() {
        return minDate;
    }
 
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
 
    public Date getMaxDate() {
        return maxDate;
    }
 
    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }
}
