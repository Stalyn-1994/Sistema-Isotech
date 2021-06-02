package mngBeans;

import EJB.*;
import Ejb_entidades.*;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



@ManagedBean(name = "sistemaBean")
@SessionScoped

public class sistemaBean implements Serializable  {
    
//VARIABLES EXTERNAS    
private Integer ciVisitante;   //variable para la clave primaria de metodo "GRABAR_VISITANTE"
private String civ;
private String ciUsuario;
private String nombreUser;
private String nombreIso;
private Date fechaInicio;
private Date fechaFin;
private StreamedContent file1;  // variable necesaria para el metodo "sistemaBean" descarga de archivos.
private StreamedContent file2;
private StreamedContent file3;
private StreamedContent file4;
private StreamedContent file5;
private StreamedContent file6;
private StreamedContent file7;
private StreamedContent file8;

 @EJB
   private PagoFacadeLocal ManejadorPagos;
   private Pago pagos;
   private PagoFacade PagoFacade;
    
   
 
 
  @EJB
  private DetalleFacadeLocal ManejadorDetalle;
  private Detalle detalle;
  private DetalleFacade DetalleFacade;
  private List<Detalle>detalles; 
  private List<Detalle>detalles_rep;

private Integer numVisitante;
private Integer idTipo;   
private Integer idUsuario;
private Integer idEstado;
   
    
    //Manejadores:
    // Manejador Visitante
    @EJB
    private VisitanteFacadeLocal manejadorVisitante;
    private Visitante visitante;
    private List<Visitante> listaVisitante;
      @EJB
   private SolicitudCitaFacadeLocal ManejadorSolicitud;
   private SolicitudCita solicitudCita;
   private SolicitudCitaFacade SolicitudFacade;
   
    // Manejador Usuario
    @EJB
    private UsuarioFacadeLocal manejadorUsuario;
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private List<Usuario> listaUsuariox;
    //manejador TipoUsuario
     @EJB
     private TipoUserFacadeLocal manejadorTipoUsuario;
     private TipoUser tipoUser;
     private List<TipoUser> listaTipoUser;
     private List<TipoUser> listaTipo;
     //manejador Consultor
    @EJB
    private ConsultorFacadeLocal manejadorConsultor;
    private Consultor consultor;
    private List<Consultor> listaConsultor;
    private List<Consultor> listaConsultox;
    //manejador Administrador
    @EJB
    private AdministradorFacadeLocal manejadorAdministrador;
    private Administrador administrador;
    private List<Administrador> listaAdministrador;
    //manejador estadoCita
    @EJB
    private EstadoCitaFacadeLocal manejadorEstadoCita;
    private EstadoCita estadoCita;
    private List<EstadoCita> listaEstadoCita;
    //manejador Cita
    @EJB
    private CitasFacadeLocal manejadorCitas;
    private Citas citas;
    private List<Citas> listaCitas;
    private List<Citas> listaCitax;
    //manejador documento
    @EJB
    private DocumentosFacadeLocal manejadorDocumentos;
    private Documentos documentos ;
    private List<Documentos> listaDocumentos;
    private List<Documentos> listaDocumentox;
     @EJB
     private CitaVisitanteFacadeLocal manejadorCitasVisitante;
    private CitaVisitante citasVisitante;
    private CitaVisitanteFacade citaViFacade;
    private List<CitaVisitante> listaCitavi;
    
    
    
    
     private List<String> ocupacion;
     private List<String> ambiental;
     private List<String> calidad;
     private List<String> seguridad;
    //POSTCONSTRUCTOR
    
    @PostConstruct
    private void inicio() {
        visitante = new Visitante();
        usuario = new Usuario();
        tipoUser = new TipoUser();
        consultor = new Consultor();
        administrador = new Administrador();
        solicitudCita=new SolicitudCita();
        citas = new Citas();
        documentos = new Documentos();
        
        getListaUsuario();
       
        
        //PERMITE HACER EL ACORDEON DE IMAGENES 
        ocupacion = new ArrayList<String>();
         for (int i = 1; i <= 12; i++) {
            ocupacion.add("ocupacion" + i + ".jpg");
        }
        ambiental = new ArrayList<String>();
         for (int i = 1; i <= 12; i++) {
            ambiental.add("ambiental" + i + ".jpg");
        }
         seguridad = new ArrayList<String>();
         for (int i = 1; i <= 12; i++) {
            seguridad.add("seguridad" + i + ".jpg");
        }
         calidad = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            calidad.add("calidad" + i + ".jpg");
        }
    }
    
// GETTERS AND SETTERS VISITANTE
    //1.- 
    
    public String getCiv() {
        return civ;
    }

    public void setCiv(String civ) {
        this.civ = civ;
    }
    
    public VisitanteFacadeLocal getManejadorVisitante() {
        return manejadorVisitante;
    }
    public void setManejadorVisitante(VisitanteFacadeLocal manejadorVisitante) {
        this.manejadorVisitante = manejadorVisitante;
    }

    public SolicitudCitaFacadeLocal getManejadorSolicitud() {
        return ManejadorSolicitud;
    }

    public void setManejadorSolicitud(SolicitudCitaFacadeLocal ManejadorSolicitud) {
        this.ManejadorSolicitud = ManejadorSolicitud;
    }

    public SolicitudCita getSolicitudCita() {
        return solicitudCita;
    }

    public void setSolicitudCita(SolicitudCita solicitudCita) {
        this.solicitudCita = solicitudCita;
    }

    public SolicitudCitaFacade getSolicitudFacade() {
        return SolicitudFacade;
    }

    public void setSolicitudFacade(SolicitudCitaFacade SolicitudFacade) {
        this.SolicitudFacade = SolicitudFacade;
    }
    
    //2.- 
    public Visitante getVisitante() {
        return visitante;
    }
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
    //3.- 
    public List<Visitante> getListaVisitante() {
        return manejadorVisitante.findAll();
    }
    public void setListaVisitante(List<Visitante> listaVisitante) {
        this.listaVisitante = listaVisitante;
    }
    //4.-
    public Integer getCiVisitante() {
        return ciVisitante;
    }
    public void setCiVisitante(Integer ciVisitante) {
        this.ciVisitante = ciVisitante;
    }

    //5. Izack
    public PagoFacadeLocal getManejadorPagos() {
        return ManejadorPagos;
    }

    public void setManejadorPagos(PagoFacadeLocal ManejadorPagos) {
        this.ManejadorPagos = ManejadorPagos;
    }

    public Pago getPagos() {
        return pagos;
    }

    public void setPagos(Pago pagos) {
        this.pagos = pagos;
    }

    public PagoFacade getPagoFacade() {
        return PagoFacade;
    }

    public void setPagoFacade(PagoFacade PagoFacade) {
        this.PagoFacade = PagoFacade;
    }

    
   // GETTERS AND SETTERS USUARIO
     //1.-
    public UsuarioFacadeLocal getManejadorUsuario() {
        return manejadorUsuario;
    }
    public void setManejadorUsuario(UsuarioFacadeLocal manejadorUsuario) {
        this.manejadorUsuario = manejadorUsuario;
    }
     //2.-
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //3.-
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

    public String getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
    
    
    
    
    public Integer getNumVisitante() {
        return numVisitante;
    }

    public void setNumVisitante(Integer numVisitante) {
        this.numVisitante = numVisitante;
    }
    //GET Y SET DE TIPOUSUARIO
    public TipoUserFacadeLocal getManejadorTipoUsuario() {
        return manejadorTipoUsuario;
    }

    public void setManejadorTipoUsuario(TipoUserFacadeLocal manejadorTipoUsuario) {
        this.manejadorTipoUsuario = manejadorTipoUsuario;
    }

    public TipoUser getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUser tipoUser) {
        this.tipoUser = tipoUser;
    }

    public List<TipoUser> getListaTipoUser() {
        return manejadorTipoUsuario.findAll();
    }

    public void setListaTipoUser(List<TipoUser> listaTipoUser) {
        this.listaTipoUser = listaTipoUser;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public List<TipoUser> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<TipoUser> listaTipo) {
        this.listaTipo = listaTipo;
    }
    //GET Y SET CONSULTOR
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

    public List<Consultor> getListaConsultox() {
        return listaConsultox;
    }

    public void setListaConsultox(List<Consultor> listaConsultox) {
        this.listaConsultox = listaConsultox;
    }
    
// GET Y SET ADMINISTRADOR
    public AdministradorFacadeLocal getManejadorAdministrador() {
        return manejadorAdministrador;
    }

    public void setManejadorAdministrador(AdministradorFacadeLocal manejadorAdministrador) {
        this.manejadorAdministrador = manejadorAdministrador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    public void setListaAdministrador(List<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }

    public EstadoCitaFacadeLocal getManejadorEstadoCita() {
        return manejadorEstadoCita;
    }

    public void setManejadorEstadoCita(EstadoCitaFacadeLocal manejadorEstadoCita) {
        this.manejadorEstadoCita = manejadorEstadoCita;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public List<EstadoCita> getListaEstadoCita() {
        return manejadorEstadoCita.findAll();
    }

    public void setListaEstadoCita(List<EstadoCita> listaEstadoCita) {
        this.listaEstadoCita = listaEstadoCita;
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
        return manejadorCitas.findAll();
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

    public DocumentosFacadeLocal getManejadorDocumentos() {
        return manejadorDocumentos;
    }

    public void setManejadorDocumentos(DocumentosFacadeLocal manejadorDocumentos) {
        this.manejadorDocumentos = manejadorDocumentos;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

    public List<Documentos> getListaDocumentos() {
        return manejadorDocumentos.findAll();
    }

    public void setListaDocumentos(List<Documentos> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public List<Documentos> getListaDocumentox() {
        return listaDocumentox;
    }

    public void setListaDocumentox(List<Documentos> listaDocumentox) {
        this.listaDocumentox = listaDocumentox;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getNombreIso() {
        return nombreIso;
    }

    public void setNombreIso(String nombreIso) {
        this.nombreIso = nombreIso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DetalleFacadeLocal getManejadorDetalle() {
        return ManejadorDetalle;
    }

    public void setManejadorDetalle(DetalleFacadeLocal ManejadorDetalle) {
        this.ManejadorDetalle = ManejadorDetalle;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public DetalleFacade getDetalleFacade() {
        return DetalleFacade;
    }

    public void setDetalleFacade(DetalleFacade DetalleFacade) {
        this.DetalleFacade = DetalleFacade;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public List<Detalle> getDetalles_rep() {
        return detalles_rep;
    }

    public void setDetalles_rep(List<Detalle> detalles_rep) {
        this.detalles_rep = detalles_rep;
    }

    
     
    
   
   //get para descaragr archivos
    public StreamedContent getFile1() {
        return file1;
    }
     public StreamedContent getFile2() {
        return file2;
    }

    public StreamedContent getFile3() {
        return file3;
    }

    public StreamedContent getFile4() {
        return file4;
    }

    public StreamedContent getFile5() {
        return file5;
    }

    public StreamedContent getFile6() {
        return file6;
    }

    public StreamedContent getFile7() {
        return file7;
    }

    public StreamedContent getFile8() {
        return file8;
    }
    
    

   ///////////////METODOS////////////////////////////////////////
//#1.- ALMACENAR LOS DATOS DEL VISITANTE
   public void grabarVisitante() {
//      if (manejadorVisitante.find(visitante.getIdVisitante()) == null ){
  //    this.numVisitante = visitante.getIdVisitante();
       manejadorVisitante.create(visitante);
         this.visitante = new Visitante();
  //} else {
   // }
       
              save();
              recuperarVisitante();
   }
   

   
   //#2.- RECUPERAR TABLA VISITANTE
  public void recuperarVisitante() {
        setListaVisitante(manejadorVisitante.ListarVisitante());
            }
   
   //#3.-MANDA MENSAJES DE ERROR O APROBACION
   public void save() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sus Datos se han Guardado Exitosamente"));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("                                     "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Si desea una cita inmediata:Porfavor haga Click en 'AGENDAR CITA' "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("                                     "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("De caso contrario nos pondremos en contacto con usted en las proximas horas"));
    
    }
  public void saveContraseña() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sus Datos se han Modificado Exitosamente"));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("                                     "));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Volver a la Pagina Inicial"));
    
    }
  
   public void Confirmacion_cita_visitante() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tu solicitud a sido ingresada exitosamente,pronto nos comunicaremos contigo"));  
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gracias por usar nuestros eservicios"));
    
    }
  
   
   
   //#3.-METODO QUE RESETEA LOS DATOS DE UN FORMULARIO
    public void reset() {
         PrimeFaces.current().resetInputs("form:panel");
    }
    
    //#4.-METODO QUE PERMITE LA DESCARGA DE ARCHIVO
    public sistemaBean() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/Cuestionario9001.xlsx");
        file1 = new DefaultStreamedContent(stream,"document/xlsx", "Cuestionario9001.xlsx");
         InputStream streamm = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/norma9001_2015.pdf");
        file2 = new DefaultStreamedContent(streamm,"document/pdf", "norma9001_2015.pdf");
        
        InputStream seguridad = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/Cuestionario27001.xlsx");
        file3 = new DefaultStreamedContent(seguridad,"document/xlsx", "Cuestionario27001.xlsx");
        InputStream seguridadd = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/norma27001.pdf");
        file4 = new DefaultStreamedContent(seguridadd,"document/pdf", "norma27001.pdf");
        
        InputStream ambiental = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/Cuestionario14001.xlsx");
        file5 = new DefaultStreamedContent(ambiental,"document/xlsx", "Cuestionario14001.xlsx");
        InputStream ambientall = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/norma14001.pdf");
        file6 = new DefaultStreamedContent(ambientall,"document/pdf", "norma14001.pdf");
        
        InputStream ocupacion = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/Cuestionario18001.xlsx");
        file7 = new DefaultStreamedContent(ocupacion,"document/xlsx", "Cuestionario18001.xlsx");
        InputStream ocupacionn = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/files/norma45001.pdf");
        file8 = new DefaultStreamedContent(ocupacionn,"document/pdf", "norma45001.pdf");
    }
    
    
    
    
   public void grabarSolicitud() {
//      if (manejadorVisitante.find(visitante.getIdVisitante()) == null ){
  //    this.numVisitante = visitante.getIdVisitante();
 
  //solicitudCita.setIdVisitante(manejadorVisitante.find(numVisitante));          
        solicitudCita.setIdUsuario(manejadorUsuario.find(this.usuario.getIdUsuario()));
       ManejadorSolicitud.create(solicitudCita);
         this.solicitudCita = new SolicitudCita();
  //} else {
   // }
       
     
   }
    
    //#5.-METODO QUE PERMITE RECUPERAR LOS DATOS DE LA TABLA USUARIO 
  public void recuperarUsuarios() {
        setListaUsuario(manejadorUsuario.ListarUsuarios());
    }
     
     
    //#6.-METODO QUE PERMITE INICIAR SESION CON USUARIO Y CONTRASEÑA
  
    public String iniciarSesionClientes(){
 
        Usuario cli;
    String redireccion = null;
        try {
    cli = manejadorUsuario.iniciariSesion(this.usuario);   
    
       if(cli!=null){
             if(cli.getIdTipo().getIdTipo()==1){
           redireccion="../PaginasUsuarios/1_PagInicio.xhtml";
            this.usuario=cli;   
           this.recuperarUsuarios();
           }
             
           
             if(cli.getIdTipo().getIdTipo()==2){
           redireccion="../PaginasUsuarios/1_2_PagInicio.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
             
             if(cli.getIdTipo().getIdTipo()==3){
           redireccion="../PaginasUsuarios/1_1_PagInicio.xhtml";
            this.usuario=cli;   
           this.recuperarUsuarios();
           }
             
             if(cli.getIdTipo().getIdTipo()==4){
           redireccion="../PaginasUsuarios/1_3_PagInicio.xhtml";
            this.usuario=cli;   
           this.recuperarUsuarios();
           }
           
           if(cli.getIdTipo().getIdTipo()==5){
           redireccion="../Pagos/factura_d.xhtml";
           this.recuperarUsuarios();
           }
           
            if(cli.getIdTipo().getIdTipo()==6){
           redireccion="../PaginasUsuarios/3_PagInicio.xhtml";
           this.recuperarUsuarios();
           }
              
            if(cli.getIdTipo().getIdTipo()==7){
           redireccion="../PaginasUsuarios/Combinacion1_2.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
           
            
               if(cli.getIdTipo().getIdTipo()==8){
           redireccion="../PaginasUsuarios/Combinacion1_3.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
               
                 if(cli.getIdTipo().getIdTipo()==9){
           redireccion="../PaginasUsuarios/Combinacion1_2_3.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
                 
                   if(cli.getIdTipo().getIdTipo()==10){
           redireccion="../PaginasUsuarios/Combinacion2_3.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
                   
                     if(cli.getIdTipo().getIdTipo()==11){
           redireccion="../PaginasUsuarios/Combinacion0_1.xhtml";
           this.usuario=cli;   
           this.recuperarUsuarios();
           }
               
       }else{
           FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales Incorrectas"));
       }
    
        } catch (Exception e) {
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error..."));
        }
    
    /*
    if ("mcollaguazo".equals(cli.getUsuarioUser()) && "admin".equals(cli.getContraseniaUser()))
    {
    redireccion = "/PaginasUsuarios/1_PagInicio";
    this.recuperarUsuarios();
    }
    if ("rmendez".equals(cli.getUsuarioUser()) && "admin".equals(cli.getContraseniaUser())){
    redireccion = "/PaginasUsuarios/1_1_PagInicio";
    this.recuperarUsuarios();
    }
    if ("lcuenca".equals(cli.getUsuarioUser()) && "admin".equals(cli.getContraseniaUser())){
    redireccion = "/PaginasUsuarios/1_2_PagInicio";
    this.recuperarUsuarios();
    }
    if ("sriquelme".equals(cli.getUsuarioUser()) && "admin".equals(cli.getContraseniaUser())){
    redireccion = "/PaginasUsuarios/1_3_PagInicio";
    this.recuperarUsuarios();
    }
    }   
 catch (Exception e){
   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
        }
    */
    
  
      return redireccion;
}
    
    public String iniciarSesionConsultor(){
    Consultor con;
    String redireccion = null;
    try {
    con = manejadorConsultor.iniciarSesion(consultor);
    if (con!=null)
    {
    redireccion = "/PaginasUsuarios/2_PagInicio";
    this.recuperarUsuarios();
    this.consultor=con;
    }
    else{
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
    }
    }   
 catch (Exception e){
   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
        }
      return redireccion;
}
    
public String iniciarSesionAdministrador(){
    Administrador adm;
    String redireccion = null;
    try {
    adm = manejadorAdministrador.iniciarSesion(administrador);
    if (adm!=null){
    redireccion = "/PaginasUsuarios/3_PagInicio";
    this.recuperarUsuarios();
    }else{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
    
    }
    }   
 catch (Exception e){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error..."));
        }
      return redireccion;
}
    
 //#7.-METODO QUE PERMITE MANDAR CORREOS ELECTRONICOS
   //public boolean enviarCorreo(String de, String clave, String[] para, String mensaje, String asunto){
    public boolean enviarCorreo(String de, String clave, String para, String mensaje, String asunto){
        boolean enviado = false;
            try{
            
                String host = "smtp-mail.outlook.com";
                
                Properties prop = System.getProperties();
                
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user",de);
                prop.put("mail.smtp.password", clave);
                prop.put("mail.smtp.port",587);
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop,null);
                
                MimeMessage message = new MimeMessage(sesion);
                
                message.setFrom(new InternetAddress(de));
                
                /*
                    
                    NOTA: para enviar correo electronico masivo
                
                    InternetAddress[] direcciones = new InternetAddress[para.length];
                    for(int i=0;i<para.length;i++){
                        direcciones[i] = new InternetAddress(para[i]);
                    }
                
                    for(int i=0;i<direcciones.length;i++){
                        message.addRecipient(Message.RecipientType.TO, direcciones[i]);
                    }
                
                */
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
                
                message.setSubject(asunto);
                message.setText(mensaje);
                
                Transport transport = sesion.getTransport("smtp");
                
                transport.connect(host,de,clave);
                
                transport.sendMessage(message, message.getAllRecipients());
                
                transport.close();
                
                enviado = true;
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
           
        
        return enviado;
    }  
    
    
       //metodo Cargar Pagina de Usuarios por Tipo de Usuarios
     public String loginUsuarios(){
       String redireccion = null;
       idTipo = this.tipoUser.getIdTipo();
        this.tipoUser = manejadorTipoUsuario.find(idTipo);
        try {
             
        
        if (this.idTipo==1){
        redireccion = "../PaginasUsuarios/loginClientes";
       
        }
        if (this.idTipo==2){
        redireccion = "../PaginasUsuarios/loginAdministrador";
       
        }
        if (this.idTipo==3){
        redireccion = "../PaginasUsuarios/loginConsultor";
       
        }
        if (this.idTipo==5){
        redireccion = "../PaginasUsuarios/loginsecretaria.xhtml";
       this.tipoUser=new TipoUser();
       this.usuario=new Usuario();
        }
        
        }                
        catch(Exception e){        
        }
        return redireccion;
    }
     
     
     
     //CODIGO PRA EDITAR LOS DATOS DEL CLIENTE EN SU PROPIA PAGINA 
     public String enviarClientes(Usuario cli){
         //CAMBIO ..izack
              String redireccion = null;
        this.usuario = cli;
         if (cli.getIdUsuario()==1){
        redireccion = "/PaginasUsuarios/1_Editar";
       
        }
          if (cli.getIdUsuario()==2){
        redireccion = "/PaginasUsuarios/1_1_Editar";
       
        }
           if (cli.getIdUsuario()==3){
        redireccion = "/PaginasUsuarios/1_2_Editar";
       
        }
            if (cli.getIdUsuario()==4){
        redireccion = "/PaginasUsuarios/1_3_Editar";
       
        }
        return redireccion;
    }
     
     
  //editar usuarios
     
         public String editar_usuarios(Usuario cli){
         //CAMBIO ..izack
              String redireccion ="../Pagos/Editar.xhtml" ;
        this.usuario = cli;
        
        return redireccion;
    }
     
         
         
           public String Mandar_correos(Usuario cl){
         //CAMBIO ..izack
               String redireccion ="../mandarCorreo.xhtml" ;
              
        this.usuario=cl;
    return redireccion;
    }
     
           
           public void retorno_detalles(){
               try {
                   
               this.pagos=new Pago();
             this.pagos=ManejadorPagos.listarporpago(this.usuario.getIdUsuario());
             setDetalles(ManejadorDetalle.listarporpago(this.pagos.getIdPago()));
             
               } catch (Exception e) {
               }
               
           }
     
    public String editarClientes(){
       
        tipoUser=manejadorTipoUsuario.find(idTipo);
        this.usuario.setIdTipo(this.tipoUser);
         saveContraseña();
        String redireccion = "../Pagos/Administrador.xhtml";
        this.manejadorUsuario.edit(this.usuario);
        this.usuario = new Usuario();

        return redireccion;
    }
    
    
    
    public String actualizarCliente(){
        //this.usuario=manejadorUsuario.encontrarUser(this.usuario.getIdUsuario());
        String dir=null;
        manejadorUsuario.edit(this.usuario);
        
        if (this.usuario.getIdTipo().getIdTipo()==1) {
           dir= "../PaginasUsuarios/1_Administrar.xhtml";
        }
        if (this.usuario.getIdTipo().getIdTipo()==2) {
            dir="../PaginasUsuarios/1_2_Administrar.xhtml";
        }
        if (this.usuario.getIdTipo().getIdTipo()==3) {
            dir="../PaginasUsuarios/1_1_Administrar.xhtml";
        }
        if (this.usuario.getIdTipo().getIdTipo()==4) {
                 dir="../PaginasUsuarios/1_3_Administrar.xhtml";
        }
        return dir;
    }
    
     //CODIGO PRA EDITAR LOS DATOS DEL CONSULTOR EN SU PROPIA PAGINA 
      public String enviarConsultor(Consultor con){
              String redireccion = null;
        this.consultor = con;
         if (con.getIdConsultor()==1){
        redireccion = "/PaginasUsuarios/2_Editar.xhtml";
       
        }
                   
        return redireccion;
    }
      public String editarConsultores(){
         saveContraseña();
        String redireccion = "../PaginasUsuarios/2_PagInicio.xhtml";
        this.manejadorConsultor.edit(consultor);
        

        return redireccion;
    }
     
      
     public String editarConsultor(){
         saveContraseña();
        String redireccion = "../PaginasUsuarios/2_Editar.xhtml";
        

        return redireccion;
    }
     
      
     
     //CODIGO PRA EDITAR LOS DATOS DEL DOCUMENTO EN SU PROPIA PAGINA 
       public String enviarDocumentos(Documentos doc){
              String redireccion = null;
        this.documentos = doc;
        
        redireccion = "../PaginasUsuarios/2_EditarDocumentos.xhtml";
       
        
                   
        return redireccion;
    }
       public String editarDocumentos(){
         saveContraseña();
        String redireccion = "../PaginasUsuarios/2_PagInicio.xhtml";
        documentos.setIdEstado(manejadorEstadoCita.find(idEstado));
        this.manejadorDocumentos.edit(documentos);
        this.documentos = new Documentos();

        return redireccion;
    }
       
       
       public  String actualizar_Docs(){
           
           
           citas.setIdEstado(manejadorEstadoCita.find(idEstado));
          this.manejadorCitas.edit(citas);
          idEstado=null;
return "../PaginasUsuarios/2_ConsultarCitas.xhtml";
       }
      
       
        public  String actualizar_Docs2(){
           
           
           citasVisitante.setIdEstado(manejadorEstadoCita.find(idEstado));
          this.manejadorCitasVisitante.edit(citasVisitante);
          idEstado=null;
          return "../PaginasUsuarios/2_ConsultarCitas_V.xhtml";
       }
      
       
        public  String actualizar_Docc2(Citas cita){
        citas=cita;
          return "../PaginasUsuarios/3_Editar_cita.xhtml";
          
       }
      
        
          public  String actualizar_Doc3(CitaVisitante cita){
        citasVisitante=cita;
          return "../PaginasUsuarios/3_Editar_cita_2.xhtml";
          
       }
       public void salirSesion(){
               usuario=new Usuario();
     pagos=new Pago();     
     }
   // TRAE LAS IMAGENES TIPO ACORDEON
     public List<String> getOcupacion() {
        return ocupacion;
    }
     public List<String> getAmbiental() {
        return ambiental;
    }
    public List<String> getCalidad() {
        return calidad;
    }
    public List<String> getSeguridad(){
    return seguridad;
    }
    
    //MUESTRA LOS DATOS DEL CLIENTE 1 Y SUS CITAS Y ARCHIVOS PENDIENTES
    public void recuperarCliente1() {
        setListaUsuariox(manejadorUsuario.ListarCliente1());
            }
    public void recuperarCliente2() {
        setListaUsuariox(manejadorUsuario.ListarCliente2());
            }
    public void recuperarCliente3() {
        setListaUsuariox(manejadorUsuario.ListarCliente3());
            }
    public void recuperarCliente4() {
        setListaUsuariox(manejadorUsuario.ListarCliente4());
            }
    //MUESTRA LOS DATOS DEL CLIENTE 1 Y SUS CITAS Y ARCHIVOS PENDIENTES
    public void recuperarConsultor1(){
    setListaConsultox(manejadorConsultor.ListarConsultor1());
    }
    //permite recuperar los datos de la cita para documento (SE DEBE MODIFICAR POR TABLA DOCUMENTO)
     public void recuperarDoc1() {
        setListaDocumentox(manejadorDocumentos.ListarDoc1());
            }
     
       public void recuperarDoc2() {
        setListaDocumentox(manejadorDocumentos.ListarDoc2());
            }
       
       
       
         public void recuperarDoc3() {
        
             setListaDocumentox(manejadorDocumentos.ListarDocumentoxCedula(this.usuario.getIdUsuario()));
        
            }
         
         
           public void recuperarDoc4() {
        setListaDocumentox(manejadorDocumentos.ListarDoc4());
            }
    public void recuperarDocumentos() {
        setListaDocumentox(manejadorDocumentos.ListarDocumentos());
      
            }
     
    public void recuperarDocumentos1() {
        setListaDocumentox(manejadorDocumentos.ListarDocumentos1());
        
            } 
    public void cargarDatos(){
        ciUsuario = this.usuario.getCiUser();
        this.usuario = manejadorUsuario.find(ciUsuario);
       recuperarDocumentosxCedula();
    }
    public void recuperarDocumentosxCedula() {
        
        setListaDocumentox(manejadorDocumentos.ListarDocumentoxCedula(idUsuario));
        
            } 
  
     public void recuperarDocumentosxIso() {
        setListaDocumentox(manejadorDocumentos.ListarDocumentoxIso(nombreIso));
        
            } 
      public void recuperarDocumentosxFechaI() {
        setListaDocumentox(manejadorDocumentos.ListarDocumentoxFecha(fechaInicio));
        
            } 
     public void recuperarDocumentosxFechaf() {
        setListaDocumentox(manejadorDocumentos.ListarDocumentoxFechaf(fechaFin));
        
            } 
     
       public void grabarSolicitudXVisitante() {
//      if (manejadorVisitante.find(visitante.getIdVisitante()) == null ){
  //    this.numVisitante = visitante.getIdVisitante();
 
  //solicitudCita.setIdVisitante(manejadorVisitante.find(numVisitante)); 
       
           
           this.visitante=new Visitante();
        this.visitante=manejadorVisitante.busqueda_visitante(civ);
        
           if (this.visitante!=null) {
                solicitudCita.setIdVisitante(this.visitante);
       ManejadorSolicitud.create(solicitudCita);
         this.solicitudCita = new SolicitudCita();
         civ=null;
          this.visitante=new Visitante();
   
                    FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro correcto", "Pronto nos comunicaremos contigo");
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
               
           } else {
       FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"No se registro solicitud", "Debe registrarce");
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
      
   
               civ=null;
     this.visitante=new Visitante();
     this.solicitudCita = new SolicitudCita();
           }
       
  //} else {
   // }
       
         
         
     
   }
    
     
     // permite la modificacion de contraseña o usuario por si se ha olvidado
     
    public void olvidoDatos(){
    setListaUsuariox(manejadorUsuario.ListarxCi(ciUsuario));
    }
 
    public String enviarEditar(Usuario cli){
           
        this.usuario = cli;
          
        return "cambioContraseña";
       
    }
    
    public String editarContraseña(){
        saveContraseña();
        this.manejadorUsuario.edit(usuario);
        this.usuario = new Usuario();
       
        return null;
        
    }
     public String enviarProcesoCliente(Documentos doc){
              String redireccion = null;
                this.documentos = doc;
         if (doc.getIdDocumentos()==1){
     redireccion = "/PaginasUsuarios/2_documentacion9001";
        }
         if (doc.getIdDocumentos()==2){
     redireccion = "/PaginasUsuarios/2_documentacion27001";
        }
        if (doc.getIdDocumentos()==3){
     redireccion = "/PaginasUsuarios/2_documentacion14001";
        }
         if (doc.getIdDocumentos()==5){
     redireccion = "/PaginasUsuarios/2_documentacion45001";
        }
                   
        return redireccion;
    }
        
      
}
 
     
   

 
   


  
