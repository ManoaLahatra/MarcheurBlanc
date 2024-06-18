import hei.school.Carte.Carte;
import hei.school.Lieu;
import hei.school.Marcheur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurBlancTest {

    private Carte antananarivo;
    private Lieu hei;
    private Lieu esti;

    @BeforeEach
    public void setup() {
        hei = new Lieu("HEI");
        antananarivo = new Carte(hei);

        antananarivo.ajouterLieu("HEI");
        antananarivo.ajouterLieu("Marais");
        antananarivo.ajouterLieu("Sekolintsika");
        antananarivo.ajouterLieu("Pullman");
        antananarivo.ajouterLieu("Nexta");
        antananarivo.ajouterLieu("Balançoire");
        antananarivo.ajouterLieu("Boulevard de l'Europe");
        esti = antananarivo.ajouterLieu("ESTI");

        antananarivo.ajouterRue("Rue 1", "Marais", "Sekolintsika");
        antananarivo.ajouterRue("Rue 2", "Sekolintsika", "HEI");
        antananarivo.ajouterRue("Rue Andriantsihorana", "HEI", "Pullman");
        antananarivo.ajouterRue("Rue 3", "Pullman", "Nexta");
        antananarivo.ajouterRue("Rue 4", "HEI", "Balançoire");
        antananarivo.ajouterRue("Rue Ranaivo", "Pullman", "Balançoire");
        antananarivo.ajouterRue("Rue 5", "Balançoire", "Boulevard de l'Europe");
        antananarivo.ajouterRue("Rue 6", "Balançoire", "ESTI");
    }

    @Test
    public void testMarcher() {
        Marcheur marcheur = new Marcheur(hei, esti);
        marcheur.marcher();

        assertEquals(esti, marcheur.getPosition(), "Le marcheur devrait atteindre ESTI.");
    }

    @Test
    public void testMarcheurDoitPasserParBalancoire() {
        Marcheur marcheur = new Marcheur(hei, esti);
        marcheur.marcher();

        Lieu balancoire = antananarivo.getLieuxSurLaCarte().get("Balançoire");
        
        assertEquals(marcheur.getMarche().get(marcheur.getMarche().size() - 2), balancoire);
    }

    @Test
    public void testMarcherVersUnLieuSansRue() {
        Lieu lieuIsole = antananarivo.ajouterLieu("Lieu Isolé");
        Marcheur marcheur = new Marcheur(hei, lieuIsole);

        marcheur.marcher();

        assertNotEquals(lieuIsole, marcheur.getPosition(), "Le marcheur ne devrait pas atteindre un lieu sans rues accessibles.");
    }
}