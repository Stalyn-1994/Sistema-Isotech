package IsacManage;





import EJB.Cheque;
import EJB.Cuenta;
import EJB.Detalle;
import EJB.Pago;
import EJB.Servicio;
import EJB.SolicitudCita;
import EJB.Tarjeta;
import EJB.Usuario;
import EJB.Visitante;
import Ejb_entidades.ChequeFacade;
import Ejb_entidades.ChequeFacadeLocal;
import Ejb_entidades.CuentaFacade;
import Ejb_entidades.CuentaFacadeLocal;
import Ejb_entidades.DetalleFacade;
import Ejb_entidades.DetalleFacadeLocal;
import Ejb_entidades.PagoFacade;
import Ejb_entidades.PagoFacadeLocal;
import Ejb_entidades.ServicioFacade;
import Ejb_entidades.ServicioFacadeLocal;
import Ejb_entidades.SolicitudCitaFacade;
import Ejb_entidades.SolicitudCitaFacadeLocal;
import Ejb_entidades.TarjetaFacade;
import Ejb_entidades.TarjetaFacadeLocal;
import Ejb_entidades.UsuarioFacade;
import Ejb_entidades.UsuarioFacadeLocal;
import Ejb_entidades.VisitanteFacade;
import Ejb_entidades.VisitanteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "sistemasBean")
@SessionScoped


public class sistemaBean {
 
   @EJB
   private ServicioFacadeLocal ManejadorServicio;
   private Servicio servicio;
  private ServicioFacade ServicioFacade;
  private List<Servicio> servicios;
  private List<Servicio> serviciosEscogidos;
   @EJB
   private PagoFacadeLocal ManejadorPagos;
   private Pago pagos;
   private PagoFacade PagoFacade;
   @EJB
   private SolicitudCitaFacadeLocal ManejadorSolicitud;
   private SolicitudCita solicitudCita;
   private SolicitudCitaFacade SolicitudFacade;
   
  private Integer numeroFactura;
private Double desc;
  private Double totalDesc;
  //tarjeta credito
  private String codigotarget;
  private String desctarjet;
  private String codigoseg;
  private String fechaven;
  @EJB
  private VisitanteFacadeLocal ManejadorVisitante;
  private Visitante visitante;
  private VisitanteFacade VisitanteFacade;
  private List<Visitante> visitantes;
 
  
  @EJB
  private DetalleFacadeLocal ManejadorDetalle;
  private Detalle detalle;
  private DetalleFacade DetalleFacade;
  private List<Detalle>detalles; 
  private List<Detalle>detalles_rep;
  @EJB
  private ChequeFacadeLocal ManejadorCheque;
  private Cheque cheque;
  private ChequeFacade ChequeFacade;
  @EJB
  private TarjetaFacadeLocal ManejadorTarjeta;
  private Tarjeta tarjeta;
  private TarjetaFacade TarjetaFacade;
  @EJB
  private CuentaFacadeLocal ManejadorCuenta;
  private Cuenta cuenta;
  private CuentaFacade CuentaFacade;
  
  @EJB
  private UsuarioFacadeLocal ManejadorUsuario;
  private Usuario usuario;
  private UsuarioFacade UsuarioFacade;
  private List<Usuario>usuarios;
  private boolean value2;
  private Integer tipo_cheque;
  private Double subtotal;
  private Double total;
  private Double iva;

    public Double getDesc() {
        return desc;
    }

    public void setDesc(Double desc) {
        this.desc = desc;
    }

    public Double getTotalDesc() {
        return totalDesc;
    }

    public void setTotalDesc(Double totalDesc) {
        this.totalDesc = totalDesc;
    }

  
  
    public VisitanteFacadeLocal getManejadorVisitante() {
        return ManejadorVisitante;
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
    
    

    public void setManejadorVisitante(VisitanteFacadeLocal ManejadorVisitante) {
        this.ManejadorVisitante = ManejadorVisitante;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public VisitanteFacade getVisitanteFacade() {
        return VisitanteFacade;
    }

    public void setVisitanteFacade(VisitanteFacade VisitanteFacade) {
        this.VisitanteFacade = VisitanteFacade;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

  
    public String getDesctarjet() {
        return desctarjet;
    }

    public void setDesctarjet(String desctarjet) {
        this.desctarjet = desctarjet;
    }

    public String getFechaven() {
        return fechaven;
    }

    public void setFechaven(String fechaven) {
        this.fechaven = fechaven;
    }

  
    public String getCodigotarget() {
        return codigotarget;
    }

    public void setCodigotarget(String codigotarget) {
        this.codigotarget = codigotarget;
    }

    public String getCodigoseg() {
        return codigoseg;
    }

    public void setCodigoseg(String codigoseg) {
        this.codigoseg = codigoseg;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

  
    public List<Detalle> getDetalles_rep() {
        return detalles_rep;
    }

    public void setDetalles_rep(List<Detalle> detalles_rep) {
        this.detalles_rep = detalles_rep;
    }

  
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

  
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTipo_cheque() {
        return tipo_cheque;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }
    

    public void setTipo_cheque(Integer tipo_cheque) {
        this.tipo_cheque = tipo_cheque;
    }

  

    public ChequeFacadeLocal getManejadorCheque() {
        return ManejadorCheque;
    }

    public void setManejadorCheque(ChequeFacadeLocal ManejadorCheque) {
        this.ManejadorCheque = ManejadorCheque;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public ChequeFacade getChequeFacade() {
        return ChequeFacade;
    }

    public void setChequeFacade(ChequeFacade ChequeFacade) {
        this.ChequeFacade = ChequeFacade;
    }

    public TarjetaFacadeLocal getManejadorTarjeta() {
        return ManejadorTarjeta;
    }

    public void setManejadorTarjeta(TarjetaFacadeLocal ManejadorTarjeta) {
        this.ManejadorTarjeta = ManejadorTarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public TarjetaFacade getTarjetaFacade() {
        return TarjetaFacade;
    }

    public void setTarjetaFacade(TarjetaFacade TarjetaFacade) {
        this.TarjetaFacade = TarjetaFacade;
    }

    public CuentaFacadeLocal getManejadorCuenta() {
        return ManejadorCuenta;
    }

    public void setManejadorCuenta(CuentaFacadeLocal ManejadorCuenta) {
        this.ManejadorCuenta = ManejadorCuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaFacade getCuentaFacade() {
        return CuentaFacade;
    }

    public void setCuentaFacade(CuentaFacade CuentaFacade) {
        this.CuentaFacade = CuentaFacade;
    }

  
  
    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
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

  
    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

  
    public List<Servicio> getServiciosEscogidos() {
        return serviciosEscogidos;
    }

    public void setServiciosEscogidos(List<Servicio> serviciosEscogidos) {
        this.serviciosEscogidos = serviciosEscogidos;
    }

    
  
    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

  
    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

  
    public PagoFacade getPagoFacade() {
        return PagoFacade;
    }

    public void setPagoFacade(PagoFacade PagoFacade) {
        this.PagoFacade = PagoFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacade getUsuarioFacade() {
        return UsuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade UsuarioFacade) {
        this.UsuarioFacade = UsuarioFacade;
    }

    public UsuarioFacadeLocal getManejadorUsuario() {
        return ManejadorUsuario;
    }

    public void setManejadorUsuario(UsuarioFacadeLocal ManejadorUsuario) {
        this.ManejadorUsuario = ManejadorUsuario;
    }

   
   

    public Pago getPagos() {
        return pagos;
    }

    public void setPagos(Pago pagos) {
        this.pagos = pagos;
    }

   
    public PagoFacadeLocal getManejadorPagos() {
        return ManejadorPagos;
    }

    public void setManejadorPagos(PagoFacadeLocal ManejadorPagos) {
        this.ManejadorPagos = ManejadorPagos;
    }
    
   
   //codigo programa
   
 @PostConstruct
 public void inicio(){
     usuario=new Usuario();
     pagos=new Pago();     
     servicio=new Servicio();
      cheque=new Cheque();
      cuenta=new Cuenta();
      tarjeta=new Tarjeta();
      visitante=new Visitante();
      solicitudCita=new SolicitudCita();
        cargar_servicios();
        cargar_usuarios();
    //Listar_detalles();
     //cargar_escogidos();
 }
 
 public void grabarFactura(){
     // pagos=new Pago(); 
     ManejadorPagos.create(pagos);
    }
 
 public void cargar_repetidos(){
     setDetalles_rep(ManejadorDetalle.listarporpago(this.pagos.getIdPago()));
 }

 public void cargar_usuarios(){
     setUsuarios(ManejadorUsuario.findAll());
 }
 
 public String siguiente(){
 String direccion;
    
        
    
 
     return "Facturas";
 }

 
    public void servicios_escogidos(Servicio servicio) {
        detalle=new Detalle(); 
        this.servicio=servicio;
   detalle.setIdServicio(this.servicio);
   detalle.setIdPago(this.pagos);
cargar_repetidos();

     
   ManejadorDetalle.create(detalle);
   for (int i = 0; i < detalles_rep.size(); i++) {
      
           if (this.detalle.getIdServicio().getIdServicio()==detalles_rep.get(i).getIdServicio().getIdServicio()) {
            ManejadorDetalle.remove(detalle);
            continue;
       }
       } 
   
   
 
   setDetalles(ManejadorDetalle.listarporpago(this.pagos.getIdPago()));
      
   setSubtotal(ManejadorDetalle.subtotal(detalles));
       setIva(ManejadorDetalle.iva(getSubtotal()));
       //this.pagos.setTotalPago(ManejadorDetalle.total(getSubtotal(), getIva()));
       setTotal(ManejadorDetalle.total(getSubtotal(), getIva()));
       setDesc(ManejadorDetalle.desc(getTotal()));
     setTotalDesc(ManejadorDetalle.totalDesc(getTotal(),getDesc()));
       ManejadorPagos.edit(pagos);       
   this.detalle=new Detalle();
        this.servicio=new Servicio(); 
        
       
         
    }
    
    
   
    
    /*
    public void cargar_escogidos(){
        setServiciosEscogidos(add_servicios(servicio));
    }*/
    

    public ServicioFacadeLocal getManejadorServicio() {
        return ManejadorServicio;
    }

    public void escoger_norma(){
    
}
    public void setManejadorServicio(ServicioFacadeLocal ManejadorServicio) {
        this.ManejadorServicio = ManejadorServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ServicioFacade getServicioFacade() {
        return ServicioFacade;
    }

    public void setServicioFacade(ServicioFacade ServicioFacade) {
        this.ServicioFacade = ServicioFacade;
    }
 
 public void cargar_servicios(){
    setServicios(ManejadorServicio.findAll());
 }
 
 public String siguiente_next(){
     String url=null;
     String url1="tarjeta";
     String url2="transferencia";
     String url3="cheque";
     if (this.pagos.getTipoPago().equals(url1)) {
      url="../Pagos/factura_tarjeta.xhtml";
       } else if(this.pagos.getTipoPago().equals(url2)){
       url="../Pagos/factura_transferencia.xhtml";
       }else if(this.pagos.getTipoPago().equals(url3)){
          url="../Pagos/factura_cheque.xhtml";
     } 
     return url;
 }
  
 
 public String tarjeta_pago(){
     
     return "../Pagos/tarjeta_directa.xhtml";
 }
 
 public void grabar_pago(){
     this.visitante=ManejadorVisitante.busqueda_visitante(usuario.getCiUser());
     this.usuario.setNombreUser(this.visitante.getNombreVisitante());
     this.usuario.setApellidoUser(this.visitante.getApellidoVisitante());
     this.usuario.setCorreoUser(this.visitante.getCorreoVisitante());
     this.usuario.setTelefonoUser(this.visitante.getTelefonoVisitante());
     this.usuario.setNombreEmpresa(this.visitante.getEmpresa());
     this.usuario.setUbicacion(this.visitante.getCiudad());
     
     ManejadorUsuario.create(this.usuario);
     this.pagos.setIdUser(ManejadorUsuario.find(this.usuario.getIdUsuario()));
     this.usuario=ManejadorUsuario.find(this.usuario.getIdUsuario());
     ManejadorPagos.create(pagos);

 }
 
 public void pago_directo(){
      this.pagos.setIdUser(ManejadorUsuario.find(this.usuario.getIdUsuario()));
     this.usuario=ManejadorUsuario.find(this.usuario.getIdUsuario());
     ManejadorPagos.create(pagos);
     
 }
 
 
 public String grabar_totales(){
     
     this.pagos.setTotalPago(getTotal());
      ManejadorPagos.edit(pagos);
       usuario=new Usuario();
     pagos=new Pago();     
     servicio=new Servicio();
      cheque=new Cheque();
      cuenta=new Cuenta();
      tarjeta=new Tarjeta();
      return "../Pagos/factura_d.xhtml";
 
 }
  
 
 public String grabar_totales_tarjeta(){
     
     this.pagos.setTotalPago(getTotalDesc());
      ManejadorPagos.edit(pagos);
       usuario=new Usuario();
     pagos=new Pago();     
     servicio=new Servicio();
      cheque=new Cheque();
      cuenta=new Cuenta();
      tarjeta=new Tarjeta();
      return "../PaginaInicial/index.xhtml";
 
 }
 

 

 public String grabar_cheque(){
     cheque.setIdUsuario(this.usuario);
    
     if(tipo_cheque==1){
     cheque.setTipoCheque("Gerencial");
         cheque.setPagado(Boolean.TRUE);      
     }else if(cheque.getTipoCheque().equals("1")){
         cheque.setTipoCheque("Personal");
         cheque.setPagado(Boolean.FALSE);
      cheque.setNombreTitular(usuario.getNombreUser()+" "+usuario.getApellidoUser());         
     }else if (cheque.getTipoCheque().equals("2")){
     cheque.setTipoCheque("Empresarial");
         cheque.setPagado(Boolean.FALSE);
      cheque.setNombreTitular(usuario.getNombreEmpresa());     
 }
  
     
     if(cheque.getNumeroCheque()!=null){
          ManejadorCheque.edit(cheque);
     }else{
          ManejadorCheque.create(cheque);
     }
     
     
     
    
  this.pagos.setIdCheque(cheque);
  ManejadorPagos.edit(pagos);
     return "factura_d.xhtml";
 }
 
 
 
 public String grabar_cuenta(){
     cuenta.setIdUser(this.usuario);
     if (cuenta.getTipoCuenta().equals("1")) {
         cuenta.setDescripcionCuenta(usuario.getNombreEmpresa());
         cuenta.setTipoCuenta("Empresarial");
     }else{
         cuenta.setDescripcionCuenta(usuario.getNombreUser()+" "+usuario.getApellidoUser());
         cuenta.setTipoCuenta("Personal");
     }
     
     
      if(cuenta.getIdCuenta()!=null){
          ManejadorCuenta.edit(cuenta);
     }else{
          ManejadorCuenta.create(cuenta);
     }
     
     
     
     
     ManejadorCuenta.create(cuenta);
this.pagos.setIdCuenta(cuenta);
  ManejadorPagos.edit(pagos);     

   return "factura_d.xhtml";
}
 
 public String init(){
    return "index";
 }
 /*
  public String grabar_tarjeta(){
     this.pagos.setTotalPago(getTotal());
     ManejadorPagos.edit(pagos);
     tarjeta.setIdUser(usuario);
     ManejadorTarjeta.create(tarjeta);
   return "index";
   
 }
  */
    public void salirSesion(){
               usuario=new Usuario();
     pagos=new Pago();     
     }
  public String consultar_tarjeta(){
Tarjeta tarjeta;
String redireccion =null;
    
       try {
          if (ManejadorTarjeta.listarporcodigo(this.tarjeta)!=null) {
          this.pagos.setIdTarjeta(ManejadorTarjeta.listarporcodigo(this.tarjeta));
            ManejadorPagos.edit(pagos);
      //FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Tarjeta Valida","Credenciales Incorrectas"));
   
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Tarjeta Valida", "Credenciales Correctas");
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
      redireccion="factura_d.xhtml";
          }else{
               
              
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Credenciales Incorrectas", null);
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
          }
          }catch (Exception e) {
           
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Credenciales Incorrectas", null);
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
         //ManejadorPagos.remove(pagos);
         // redireccion="factura_d.xhtml";
      }
     
       return redireccion;
    
 }
  
  
  
  
   public String consultar_tarjeta_directa(){
Tarjeta tarjeta;
String redireccion =null;
    
       try {
          if (ManejadorTarjeta.listarporcodigo(this.tarjeta)!=null) {
          this.pagos.setIdTarjeta(ManejadorTarjeta.listarporcodigo(this.tarjeta));
            ManejadorPagos.edit(pagos);
      //FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Tarjeta Valida","Credenciales Incorrectas"));
   
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Tarjeta Valida", "Credenciales Correctas");
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
      redireccion="detalle_p.xhtml";
          }else{
               
              
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Credenciales Incorrectas", null);
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
          }
          }catch (Exception e) {
           
              FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Credenciales Incorrectas", null);
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
         //ManejadorPagos.remove(pagos);
         // redireccion="factura_d.xhtml";
      }
     
       return redireccion;
    
 }
 
 
  public void grabarSolicitud() {
//      if (manejadorVisitante.find(visitante.getIdVisitante()) == null ){
  //    this.numVisitante = visitante.getIdVisitante();
 
  //solicitudCita.setIdVisitante(manejadorVisitante.find(numVisitante));          
      solicitudCita.setIdUsuario(ManejadorUsuario.find(this.usuario.getIdUsuario()));
       ManejadorSolicitud.create(solicitudCita);
         this.solicitudCita = new SolicitudCita();
  //} else {
   // }
       
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
   }
 String direccion;
     public String continuar(){
          
         try {
         if (value2==true) {
               
            ManejadorUsuario.create(usuario);
             direccion="../Pagos/detalle_p.xhtml";
             
         }
         else{
         //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe aceptar terminos y condiciones"));
           
            
  
FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Debes aceptar terminos y condiciones", null);
 FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
  direccion=null;

         }    
         } catch (Exception e) {
         }
         
     return direccion;
     
     
     
 }
 

     
     public void crear(){
     
            ManejadorUsuario.create(usuario);
            
          
        
     }
     
      public void addMessage() {
        String summary = value2 ? "Listo" : "No aceptado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    public String cancelar(){
        usuario=new Usuario();
        return "index";
    }
    


}
    
    
    

    

  
