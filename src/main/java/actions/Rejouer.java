package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import modele.Facade;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Rejouer extends ActionSupport implements SessionAware {


    private Map<String,Object> variablesSession;


    private Facade facade;

    @Inject("facade")
    public void setFacade(Facade facade) {
        this.facade = facade;
    }


    private double pourcentageWins;

    public double getPourcentageWins() {
        return pourcentageWins;
    }


    int nbPartiesJouees;
    public int getNbPartiesJouees() {
        return this.nbPartiesJouees;
    }

    @Override
    public String execute() throws Exception  {
        String idTemporaire = (String) this.variablesSession.get("idTemporaire");
        this.nbPartiesJouees = this.facade.getNbParties(idTemporaire);
        this.pourcentageWins = ((double)this.facade.getNbWins(idTemporaire))/((double)nbPartiesJouees);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
