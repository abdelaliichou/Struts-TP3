package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import modele.Facade;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Deconnexion extends ActionSupport implements SessionAware {


    private Map<String,Object> variablesSession;


    private Facade facade;

    @Inject("facade")
    public void setFacade(Facade facade) {
        this.facade = facade;
    }


    @Override
    public String execute()  throws Exception {

        String idTemporaire = (String)this.variablesSession.get("idTemporaire");
        this.facade.deconnexion(idTemporaire);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
