public class Configuration {
    String description;
    double maxPrix;
    Composant[] composants;
    int nbComposants;
    final int MAX_COMPOSANT = 20;

    public Configuration(String description, double maxPrix, Composant[] composants) {

        this.description = description.toUpperCase();
        this.maxPrix = maxPrix;
        this.composants = new Composant[MAX_COMPOSANT];
        this.nbComposants = composants.length;
        for (int i = 0; i < composants.length; i++) {
            this.composants[i] = composants[i];
        }
    }

    public Configuration(Configuration originale) {
        this.description = originale.description;
        this.maxPrix = originale.maxPrix;

        //this.composants = new Composant[originale.composants.length];
        for (int i = 0; i < originale.composants.length; i++) {
            if (this.composants != null) {
                this.composants[i] = originale.composants[i].copier();

            }

        }
        this.composants = originale.composants;
        this.nbComposants = originale.nbComposants;
    }

//    Configuration copieP = new Configuration();
//    copieP.description = originale.description;
//    copieP.maxPrix = originale.maxPrix;
//    copieP.nbComposants = originale.nbComposants;
//    copieP.composants = originale.composants;


    public double calculerTotal(double taxe) {
        double total = 0.0;

        for (int i = 0; i < nbComposants; i++) {
            if (composants[i] != null) {
                total += composants[i].getPrix();
            }

        }
        total += (total * taxe);

        return total;
    }

    public Composant rechercher(String categorie) {
        for ( int i = 0; i < nbComposants; i++) {
            if ( composants[i].getCategorie().equalsIgnoreCase(categorie) ) {
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
        for ( int i = 0; i < nbComposants; i++ ) {
            if ( composants[i].estIdentique(composant) ) {
                for ( int j = i; j < nbComposants - 1; j++ ) {
                    composants[j] = composants[j + 1];
                }
                System.out.println(composant + "a été retiré de la configuration (total=" + composant.getPrix() + "$)");
                nbComposants--;
                composants[nbComposants] = null;
                return true;
            }
        }
        return false;
    }

    public boolean remplacer(Composant composant) {
        for ( int i = 0; i < nbComposants; i++ ) {
            if (composants[i].getCategorie().trim().equalsIgnoreCase(composant.getCategorie().trim())) {
                System.out.println(composants[i] + "a été retiré de la configuration (total=" + composants[i].getPrix() + "$)");
                System.out.println(composant + "a été ajouté de la configuration (total=" + composant.getPrix() + "$)");

                composants[i] = composant;
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String resultat;
        resultat = description + " (max " + maxPrix + ") :\n";
        for (int i = 0; i < nbComposants; i++) {
            resultat = resultat + ( i + 1 ) + " : " + composants[i] + " (" + composants[i].getPrix() + ")\n";
            
        }
        return resultat;
    }

    public int getNbComposants() {
        return nbComposants;
    }

    public Composant[] getComposants() {
        return composants;
    }
}

