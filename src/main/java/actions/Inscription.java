package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import modele.Facade;
import modele.PseudoDejaPrisException;

import java.util.Objects;

public class Inscription extends ActionSupport {


    private String pseudo;
    private String mdp;



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


    @Override
    public String execute()  throws Exception {
        try {
            this.facade.inscription(pseudo,mdp);
        } catch (PseudoDejaPrisException e) {
            this.addFieldError("pseudo","Pseudo déjà pris !");
            return INPUT;
        }
        return SUCCESS;
    }


    @Override
    public void validate() {
        if (Objects.isNull(pseudo) || pseudo.isEmpty()) {
            addFieldError("pseudo",getText("erreur.pseudoObligatoire"));
        }

        if (Objects.isNull(mdp) || mdp.isEmpty()) {
            addFieldError("mdp", getText("erreur.mdpObligatoire"));
        }
    }
}
