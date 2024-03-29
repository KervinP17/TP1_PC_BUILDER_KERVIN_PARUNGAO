import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TesterAjouter {
    Configuration configuration;
    @Test
    void fonctionne() {
        Composant comp1 = new Composant("CPU", "AMD", "Ryzen 5 5600", 190);
        Composant nouvComp = new Composant("GPU", "AMD", "RX 6700 XT", 500);
        configuration = new Configuration("Build AMD", 1250, new Composant[]{comp1});


        assertTrue(configuration.ajouter(nouvComp));
    }
    @Test
    void fonctionnePasMemeCategorie() {
        Composant comp1 = new Composant("CPU", "AMD", "Ryzen 5 5600", 190);
        Composant nouvComp = new Composant("CPU", "Intel", "Core i5-11600k", 220);
        configuration = new Configuration("Build AMD", 1250, new Composant[]{comp1});

        assertFalse(configuration.ajouter(nouvComp));
    }

    @Test
    void fonctionnePasPrixHaut() {
        Composant comp1 = new Composant("CPU", "AMD", "Ryzen 5 5600", 190);
        Composant nouvComp = new Composant("GPU", "Nvidia", "RTX 4090", 2000);
        configuration = new Configuration("Build AMD", 1250, new Composant[]{comp1});

        assertFalse(configuration.ajouter(nouvComp));
    }

    @Test
    void fonctionnePasTropComp() {
        configuration = new Configuration("Build AMD", 1250, new Composant[]{});

        for (int i = 0; i < 20; i++) {
            configuration.ajouter(new Composant("CPU" + i, "AMD", "Ryzen 5 5600", 190));
        }

        Composant nouvComp = new Composant("CPU", "Intel", "Core i5-11600k", 220);

        Composant composant = new Composant("RAM", "GSkill", "Trident-Z DDR5 16GB", 90);
        assertFalse(configuration.ajouter(nouvComp));
    }
}