public class Configuration {
    String description;
    double maxPrix;
    Composant[] composants = new Composant[4];
    int nbComposants;
    final int MAX_COMPOSANT = 20;

    public Configuration(String description, double maxPrix, Composant[] composant) {
        this.description = description;
        this.maxPrix = maxPrix;
        this.composants = composant;
    }

    public Configuration(Configuration originale) {
        this.description = originale.description;
        this.maxPrix = originale.maxPrix;
        this.composants = originale.composants;
    }


    public double calculerTotal(double taxe) {
        double total = 0.0;

        for (int i = 0; i < 4; i++) {
            total += this.composants[i].getPrix();
        }

        total =+ taxe;

        return total;
    }

    public Composant rechercher(String categorie) {
        for (int i = 0; i < 4; i++) {
            if ( composants[0].equals(categorie) ) {
                return composants[0];
            }
        }

        return null;
    }

    public boolean ajouter(Composant composant) {

        if ( composant == null ) {
            return true;
        }


        return false;
    }

    public boolean retirer(Composant composant) {

        if ( composant != null ) {
            return true;
        }

        return false;
    }

    public boolean remplacer(Composant composant) {
        switch (composant.getCategorie()) {
            case "CPU":
            case "Carte mère":
            case "Ram":
            case "gpu":
            case "GPU":
                return true;
        }
        return false;
    }
//    public String toString() {
//
//    }

    public int getNbComposants() {
        return nbComposants;
    }

    public Composant[] getComposants() {
        return composants;
    }
}
