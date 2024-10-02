package modele;

public class Partie {

    private String prediction;
    private String tirage;


    public Partie(String prediction, String tirage) {
        this.prediction = prediction;
        this.tirage = tirage;
    }


    public String getPrediction() {
        return prediction;
    }

    public String getTirage() {
        return tirage;
    }


    public boolean isPartieGagnante() {
        return this.prediction.equals(this.tirage);
    }

}
