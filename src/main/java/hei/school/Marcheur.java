package hei.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Marcheur {
    private Lieu position;
    private final Lieu destination;
    private final Environnement environnement;
    private List<Lieu> marche;

    public Marcheur(Lieu position, Lieu destination, Environnement environnement) {
        this.position = position;
        this.destination = destination;
        this.environnement = environnement;
        this.marche = new ArrayList<>();
        this.marche.add(position);
    }

    public List<Lieu> marcher() {
        Logger logger = Logger.getLogger(Marcheur.class.getName());
        List<Rue> ruesAccessibleDepuisLaDestination = destination.getRuesAccessibleDepuisLeLieu();
        if (ruesAccessibleDepuisLaDestination.isEmpty()) {
            logger.log(Level.WARNING, "Aucune rue accessible depuis la destination : " + destination.getNom());
            return marche;
        }
        Random random = new Random();
        while (!position.equals(destination)) {
            List<Rue> ruesAccessibleDepuisLeLieu = environnement.demanderLeChemin(position);
            if (ruesAccessibleDepuisLeLieu.isEmpty()) {
                logger.log(Level.WARNING, "Aucune rue accessible depuis le lieu actuel: " + position.getNom());
                return marche;
            }

            Rue rueAleatoireAccessibleDepuisLeLieu = ruesAccessibleDepuisLeLieu.get(random.nextInt(ruesAccessibleDepuisLeLieu.size()));
            position = rueAleatoireAccessibleDepuisLeLieu.lieu1().equals(position)
                    ? rueAleatoireAccessibleDepuisLeLieu.lieu2()
                    : rueAleatoireAccessibleDepuisLeLieu.lieu1();
            marche.add(position);
        }
        return marche;
    }
}