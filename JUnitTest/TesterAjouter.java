import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TesterAjouter {
    Configuration configuration;
    @Test
    void ajouterFonctionne() {
        Composant comp1 = new Composant("CPU", "AMD", "Ryzen 5 5600", 190);
        Composant nouvComp = new Composant("GPU", "AMD", "RX 6700 XT", 500);
        configuration = new Configuration("Build AMD", 1250, new Composant[]{nouvComp});

        assertTrue(configuration.ajouter(comp1));
    }
    @Test
    void ajouterFonctionnePas() {
        Composant comp1 = new Composant("CPU", "AMD", "Ryzen 5 5600", 190);
        Composant nouvComp = new Composant("CPU", "Intel", "Core i5-11600k", 220);
        configuration = new Configuration("Build AMD", 1250, new Composant[]{nouvComp});

        assertTrue(configuration.ajouter(comp1));
    }
}