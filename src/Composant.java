public class Composant {
    private String categorie;
    private String nom;
    private String marque;
    private double prix;
    private double rabais;
//

    public Composant(String categorie, String nom, String marque, double prix) {
        this.categorie = categorie.toUpperCase();
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.rabais = 0.0;
    }


    public Composant copier() {
        Composant nouvComp = new Composant(this.categorie, this.nom, this.marque, this.prix);
        return nouvComp;
    }

    // not really good?
    public boolean estIdentique(Composant autre) {
        return this.categorie.equals(autre.categorie)
                && this.marque.equals(autre.marque)
                && this.nom.equals(autre.nom);
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


