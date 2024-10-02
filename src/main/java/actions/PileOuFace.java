package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import modele.Facade;
import modele.MauvaisIdentifiantConnexionException;
import modele.Partie;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class PileOuFace extends ActionSupport
        implements SessionAware {

    private String choix;
    private String tirage;
    private boolean verdict;

    private Partie partieCourante;

    private Map<String,Object> variablesSession;

    public String getChoix() {
        return partieCourante.getPrediction();
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public String getTirage() {
        return partieCourante.getTirage();
    }

    public void setTirage(String tirage) {
        this.tirage = tirage;
    }

    public boolean getVerdict() {
        return this.verdict = tirage.equals(choix);
    }


    private Facade facade;


    @Inject("facade")
    public void setFacade(Facade facade) {
        this.facade = facade;
    }


    private String pseudo;

    private String idTemporaire;


    private int nbPartiesJouees;

    private double pourcentageWins;

    public boolean isVerdict() {
        return verdict;
    }

    public Partie getPartieCourante() {
        return partieCourante;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getNbPartiesJouees() {
        return nbPartiesJouees;
    }

    public double getPourcentageWins() {
        return pourcentageWins;
    }

    @Override
    public String  execute()  throws Exception{

        this.pseudo = (String) variablesSession.get("pseudo");
        this.idTemporaire = (String)
                variablesSession.get("idTemporaire");
        try {
            this.partieCourante =
                    this.facade
                            .jouer(idTemporaire,choix);
        } catch (MauvaisIdentifiantConnexionException e) {
            return ERROR;
        }

        this.nbPartiesJouees = this.facade.getNbParties(idTemporaire);
        this.pourcentageWins = ((double)this.facade.getNbWins(idTemporaire))/((double)nbPartiesJouees);

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}