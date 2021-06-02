/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mngBeans;

import EJB.CitaVisitante;
import EJB.Citas;
import EJB.Consultor;
import EJB.EstadoCita;
import EJB.SolicitudCita;
import EJB.Usuario;
import EJB.Visitante;
import Ejb_entidades.CitaVisitanteFacade;
import Ejb_entidades.CitaVisitanteFacadeLocal;
import Ejb_entidades.CitasFacadeLocal;
import Ejb_entidades.ConsultorFacadeLocal;
import Ejb_entidades.EstadoCitaFacadeLocal;
import Ejb_entidades.SolicitudCitaFacadeLocal;
import Ejb_entidades.UsuarioFacadeLocal;
import Ejb_entidades.VisitanteFacadeLocal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Stalyn
 */
@ManagedBean
@SessionScoped
public class agendamientoCitas {

  
    private Integer numVisitante;
     private Integer idConsultor;
    private Integer idUsuario;
     private Integer idVisitante;
    private Integer idEstado;
    private ScheduleModel eventModel;
     
    private ScheduleModel lazyEventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
    @EJB
    private SolicitudCitaFacadeLocal manejadorSolicitud;
    private SolicitudCita solicitudCita ;
    private List<SolicitudCita> listaSolicitudCita;
    private List<SolicitudCita> listaSolicitudCitax;
      // Manejador Visitante
    @EJB
    private VisitanteFacadeLocal manejadorVisitante;
    private Visitante visitante;
    private List<Visitante> listaVisitante;
    
    // Manejador Usuario
    @EJB
    private UsuarioFacadeLocal manejadorUsuario;
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private List<Usuario> listaUsuariox;
   @EJB
     private CitasFacadeLocal manejadorCitas;
    private Citas citas;
    private List<Citas> listaCitas;
    private List<Citas> listaCitax;
    
     @EJB
     private CitaVisitanteFacadeLocal manejadorCitasVisitante;
    private CitaVisitante citasVisitante;
    private CitaVisitanteFacade citaViFacade;
    private List<CitaVisitante> listaCitavi;
    
    @EJB
     private ConsultorFacadeLocal manejadorConsultor;
    private Consultor consultor;
    private List<Consultor> listaConsultor;
    private List<Consultor> listaConsultorx;
    @EJB
     private EstadoCitaFacadeLocal manejadorEstado;
    private EstadoCita estadoCita;
    private List<EstadoCita> listaEstado;
    private List<EstadoCita> listaEstadox;
 
    @PostConstruct
    public void init() {
 
        eventModel = new DefaultScheduleModel();
        visitante = new Visitante();
        citas=new Citas();
                solicitudCita = new SolicitudCita();
                citasVisitante=new CitaVisitante();
        
       // usuario = new Usuario();
//        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
//        eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));
         
//        lazyEventModel = new LazyScheduleModel() {
//             
//            @Override
//            public void loadEvents(Date start, Date end) {
//                Date random = getRandomDate(start);
//                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
//                 
//                random = getRandomDate(start);
//                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
//            }   
//        };
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }
    

    public CitaVisitanteFacadeLocal getManejadorCitasVisitante() {
        return manejadorCitasVisitante;
    }

    public void setManejadorCitasVisitante(CitaVisitanteFacadeLocal manejadorCitasVisitante) {
        this.manejadorCitasVisitante = manejadorCitasVisitante;
    }

    public CitaVisitante getCitasVisitante() {
        return citasVisitante;
    }

    public void setCitasVisitante(CitaVisitante citasVisitante) {
        this.citasVisitante = citasVisitante;
    }

    public CitaVisitanteFacade getCitaViFacade() {
        return citaViFacade;
    }

    public void setCitaViFacade(CitaVisitanteFacade citaViFacade) {
        this.citaViFacade = citaViFacade;
    }

    public List<CitaVisitante> getListaCitavi() {
        return manejadorCitasVisitante.findAll();
    }

    public void setListaCitavi(List<CitaVisitante> listaCitavi) {
        this.listaCitavi = listaCitavi;
    }

    
    
    public ConsultorFacadeLocal getManejadorConsultor() {
        return manejadorConsultor;
    }

    public void setManejadorConsultor(ConsultorFacadeLocal manejadorConsultor) {
        this.manejadorConsultor = manejadorConsultor;
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public List<Consultor> getListaConsultor() {
        return manejadorConsultor.findAll();
    }

    public void setListaConsultor(List<Consultor> listaConsultor) {
        this.listaConsultor = listaConsultor;
    }

    public List<Consultor> getListaConsultorx() {
        return listaConsultorx;
    }

    public void setListaConsultorx(List<Consultor> listaConsultorx) {
        this.listaConsultorx = listaConsultorx;
    }

    
    public CitasFacadeLocal getManejadorCitas() {
        return manejadorCitas;
    }

    public void setManejadorCitas(CitasFacadeLocal manejadorCitas) {
        this.manejadorCitas = manejadorCitas;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public List<Citas> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Citas> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public List<Citas> getListaCitax() {
        return listaCitax;
    }

    public void setListaCitax(List<Citas> listaCitax) {
        this.listaCitax = listaCitax;
    }

    public Integer getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Integer idConsultor) {
        this.idConsultor = idConsultor;
    }
    
    
     
    
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public SolicitudCitaFacadeLocal getManejadorSolicitud() {
        return manejadorSolicitud;
    }

    public void setManejadorSolicitud(SolicitudCitaFacadeLocal manejadorSolicitud) {
        this.manejadorSolicitud = manejadorSolicitud;
    }

    public SolicitudCita getSolicitudCita() {
        return solicitudCita;
    }

    public void setSolicitudCita(SolicitudCita solicitudCita) {
        this.solicitudCita = solicitudCita;
    }

    public List<SolicitudCita> getListaSolicitudCita() {
        return manejadorSolicitud.findAll();
    }

    public void setListaSolicitudCita(List<SolicitudCita> listaSolicitudCita) {
        this.listaSolicitudCita = listaSolicitudCita;
    }

    public List<SolicitudCita> getListaSolicitudCitax() {
        return listaSolicitudCitax;
    }

    public void setListaSolicitudCitax(List<SolicitudCita> listaSolicitudCitax) {
        this.listaSolicitudCitax = listaSolicitudCitax;
    }

    public Integer getNumVisitante() {
        return numVisitante;
    }

    public void setNumVisitante(Integer numVisitante) {
        this.numVisitante = numVisitante;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public VisitanteFacadeLocal getManejadorVisitante() {
        return manejadorVisitante;
    }

    public void setManejadorVisitante(VisitanteFacadeLocal manejadorVisitante) {
        this.manejadorVisitante = manejadorVisitante;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public List<Visitante> getListaVisitante() {
        return manejadorVisitante.findAll();
    }

    public void setListaVisitante(List<Visitante> listaVisitante) {
        this.listaVisitante = listaVisitante;
    }

    public UsuarioFacadeLocal getManejadorUsuario() {
        return manejadorUsuario;
    }

    public void setManejadorUsuario(UsuarioFacadeLocal manejadorUsuario) {
        this.manejadorUsuario = manejadorUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return manejadorUsuario.findAll();
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<Usuario> getListaUsuariox() {
        return listaUsuariox;
    }

    public void setListaUsuariox(List<Usuario> listaUsuariox) {
        this.listaUsuariox = listaUsuariox;
    }

    public EstadoCitaFacadeLocal getManejadorEstado() {
        return manejadorEstado;
    }

    public void setManejadorEstado(EstadoCitaFacadeLocal manejadorEstado) {
        this.manejadorEstado = manejadorEstado;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public List<EstadoCita> getListaEstado() {
        return manejadorEstado.findAll();
    }

    public void setListaEstado(List<EstadoCita> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public List<EstadoCita> getListaEstadox() {
        return listaEstadox;
    }

    public void setListaEstadox(List<EstadoCita> listaEstadox) {
        this.listaEstadox = listaEstadox;
    }
    
    
     
//    public ScheduleModel getLazyEventModel() {
//        return lazyEventModel;
//    }
 
//    private Calendar today() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
// 
//        return calendar;
//    }
     
//    private Date previousDay8Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 8);
//         
//        return t.getTime();
//    }
     
//    private Date previousDay11Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 11);
//         
//        return t.getTime();
//    }
     
//    private Date today1Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 1);
//         
//        return t.getTime();
//    }
//     
//    private Date theDayAfter3Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 3);
//         
//        return t.getTime();
//    }
// 
//    private Date today6Pm() {
//        Calendar t = (Calendar) today().clone(); 
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 6);
//         
//        return t.getTime();
//    }
//     
//    private Date nextDay9Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 9);
//         
//        return t.getTime();
//    }
//     
//    private Date nextDay11Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 11);
//         
//        return t.getTime();
//    }
//     
//    private Date fourDaysLater3pm() {
//        Calendar t = (Calendar) today().clone(); 
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
//        t.set(Calendar.HOUR, 3);
//         
//        return t.getTime();
//    }
     
  
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }
     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent() {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
    public void grabarSolicitud() {
//      if (manejadorVisitante.find(visitante.getIdVisitante()) == null ){
  //    this.numVisitante = visitante.getIdVisitante();
 
  //solicitudCita.setIdVisitante(manejadorVisitante.find(numVisitante));          
        solicitudCita.setIdUsuario(manejadorUsuario.find(this.usuario.getIdUsuario()));
       manejadorSolicitud.create(solicitudCita);
         this.solicitudCita = new SolicitudCita();
  //} else {
   // }
       
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
   }
    
    
    
    
    
    //#3.-MANDA MENSAJES DE ERROR O APROBACION
   public void save() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Su Solicitud de Cita se han Guardado Exitosamente"));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("                                     "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("En las proximas horas un asesor se contactará para CONFIRMAR la cita"));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("                                     "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ISOTECH LE AGRADECE SU ATENSION"));
    
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public String eliminarClientes(SolicitudCita cli){
        manejadorSolicitud.remove(cli);
        return null;
    }
     
     
     public void editarCitas(){
        
       
        citas.setIdUser(manejadorUsuario.find(idUsuario));
        citas.setIdEstado(manejadorEstado.find(idEstado));
        citas.setIdConsultor(manejadorConsultor.find(idConsultor));
        this.manejadorCitas.create(citas);
        this.citas = new Citas();

       
    }
     
     
      public String configurarCitas(){
        
       
        citas.setIdUser(manejadorUsuario.find(this.solicitudCita.getIdUsuario().getIdUsuario()));
        citas.setIdConsultor(manejadorConsultor.find(idConsultor));
        citas.setIdEstado(manejadorEstado.find(1));
       this.manejadorCitas.create(citas);
        this.citas = new Citas();
            return "../PaginasUsuarios/3_solicitudCitas.xhtml";
       
    }
      
         public String configurarCitasVisitante(){
        
       citasVisitante.setIdVisitante(manejadorVisitante.find(this.solicitudCita.getIdVisitante().getIdVisitante()));
citasVisitante.setIdConsultor(manejadorConsultor.find(idConsultor));
        citasVisitante.setIdEstado(manejadorEstado.find(1));
       this.manejadorCitasVisitante.create(citasVisitante);
        this.citasVisitante = new CitaVisitante();
    return "../PaginasUsuarios/3_solicitudCitas.xhtml";
       
    }
     
      
      public String establecerCita(SolicitudCita solicitud){
          
          String ruta="../PaginasUsuarios/3_Editar_1.xhtml";
      solicitudCita=solicitud;
          try {
             
          if (solicitudCita.getIdUsuario().getIdUsuario()!=null) {
              ruta="../PaginasUsuarios/3_Editar.xhtml";
          } 
      
     if(solicitudCita.getIdVisitante().getIdVisitante()!=null) {
              
          } 
          } catch (Exception e) {
          }
      
      
    
       return  ruta;
               

       
    }
}
