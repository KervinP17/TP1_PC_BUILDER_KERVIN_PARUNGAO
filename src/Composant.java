public class Composant {
    private String categorie;
    private String nom;
    private String marque;
    private double prix;
    private double rabais;


    public Composant(String categorie, String nom, String marque, double prix) {
        this.categorie = categorie;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }


    public Composant copier() {
        Composant nouvComp = new Composant(categorie, nom, marque, prix);
        return nouvComp;
    }

    // not really good
    public boolean estIdentique(Composant autre) {
        boolean identique = false;
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    if (this.categorie == categorie) {
                        identique = true;
                    }
                    break;
                case 1:
                    if (this.marque == marque) {
                        identique = true;
                    }
                    break;
                case 2:
                    if (this.nom == nom) {
                        identique = true;
                    }
                    break;
            }
        }
        return identique;
    }



    public double getPrix() {
            double prixTotal;

            prixTotal = prix - prix * rabais;

        return prixTotal;
    }

    public String toString() {
        return "[" + categorie + "] " + marque + " " + nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getRabais() {
        return rabais;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setRabais(double rabais) {
        this.rabais = rabais;
    }
}


