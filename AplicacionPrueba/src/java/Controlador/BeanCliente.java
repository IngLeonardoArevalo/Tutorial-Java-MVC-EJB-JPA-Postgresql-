package Controlador;

import Entidades.Cliente;
import EntidadesEJB.ClienteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class BeanCliente {

    public BeanCliente() {
    }
    @EJB
    private ClienteFacadeLocal clienteEJB;
    private Cliente cliente;
    private List<Cliente> clienteLista=null; 

    private int indicador=0;

    public int getIndicador() {
        return indicador;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }
    
            
    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteLista() {
        return clienteLista;
    }

    public void setClienteLista(List<Cliente> clienteLista) {
        this.clienteLista = clienteLista;
    }
    
    public List<Cliente> listatodoslosCliente(){
        clienteLista = clienteEJB.findAll();
        return clienteLista;
    }
    
    public void prepareCreate(){
      cliente =  new Cliente();
      cliente.setDvid("0");
      setIndicador(0);
    }
    
    public void prepareEdit(){
        setIndicador(1);      
    }
    
    public void registro(){
        try {
            int ind = getIndicador();
            if (ind == 0){
               clienteEJB.create(cliente);
        }else{
                clienteEJB.edit(cliente);
                }
            cliente=null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registro Con Exito"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error ",ex.toString()));
        }
    }
    
    public void destroy(){
      if (cliente != null){
          try {
           clienteEJB.remove(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso ","Se Elimino Con Exito"));
            cliente = null;
          } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No se elimino el registro"));
          }
      }
    }
    
}
