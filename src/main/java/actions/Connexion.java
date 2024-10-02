package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import modele.Facade;
import modele.JoueurDejaConnecteException;
import modele.JoueurInexistantException;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.Objects;

public class Connexion extends ActionSupport
        implements SessionAware {


    private String pseudo;
    private String mdp;
    private Map<String,Object> variablesSession;


    private Facade facade;

    @Inject("facade")
    public void setFacade(Facade facade) {
        this.facade = facade;
    }


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    private double pourcentageWins;

    public double getPourcentageWins() {
        if (Double.isNaN(pourcentageWins)) {
            return 0;
        }
        return pourcentageWins;
    }


    int nbPartiesJouees;
    public int getNbPartiesJouees() {
        return this.nbPartiesJouees;
    }

    @Override
    public String execute() throws Exception  {
        try {
            String idTemporaire =
                    this.facade.connexion(pseudo,mdp);
            this.variablesSession
                    .put("idTemporaire",idTemporaire);
            this.variablesSession.put("pseudo",pseudo);

            this.nbPartiesJouees =
                    this.facade.getNbParties(idTemporaire);
            this.pourcentageWins =
                    ((double)this.facade.getNbWins(idTemporaire))/((double)nbPartiesJouees);
        } catch (JoueurDejaConnecteException e) {
            this.addFieldError("pseudo",getText("erreur.pseudoconnecte"));
            return INPUT;
        }

        catch (JoueurInexistantException e) {
            this.addFieldError("pseudo",getText("erreur.mauvaisIdentifiants"));
            return INPUT;
        }
        return SUCCESS;
    }


    @Override
    public void validate() {
        if (Objects.isNull(pseudo) || pseudo.isEmpty()) {

            addFieldError("pseudo","Le pseudo doit être renseigné !");
        }

        if (Objects.isNull(mdp) || mdp.isEmpty()) {
            addFieldError("mdp","Le mot de passe doit être renseigné !");
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
