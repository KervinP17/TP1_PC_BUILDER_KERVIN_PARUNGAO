public class Configuration {
    String description;
    double maxPrix;
    Composant[] composants;
    int nbComposants;
    final int MAX_COMPOSANT = 20;

    public Configuration(String description, double maxPrix, Composant[] composants) {
        this.description = description;
        this.maxPrix = maxPrix;
        this.composants = new Composant[MAX_COMPOSANT];
        this.nbComposants = composants.length;
    }

    public Configuration(Configuration originale) {
        this.description = originale.description;
        this.maxPrix = originale.maxPrix;
        this.composants = originale.composants;
        this.nbComposants = originale.nbComposants;
    }


    public double calculerTotal(double taxe) {
        double total = 0.0;

        for (Composant comp : composants) {
            total += comp.getPrix();
        }
        total =+ taxe;

        return total;
    }

    public Composant rechercher(String categorie) {
        for ( int i = 0; i < nbComposants; i++) {
            if ( composants[i].getCategorie().toLowerCase().equals(categorie) ) {
                return composants[i];
            }
        }

        return null;
    }

    public boolean ajouter(Composant composant) {
        if (calculerTotal(0) + composant.getPrix() > maxPrix || rechercher(composant.getCategorie()) != null || nbComposants >= MAX_COMPOSANT) {
            return false;
        }
        composants[nbComposants++] = composant;
        return true;
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
