package hei.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Marcheur {
    private Lieu position;
    private final Lieu destination;

    public void marcher() {
        Random random = new Random();
        while (!position.equals(destination)) {
            List<Rue> ruesAccessibleDepuisLeLieu = position.getRuesAccessibleDepuisLeLieu();
            List<Rue> ruesAccessibleDepuisLaDestination = destination.getRuesAccessibleDepuisLeLieu();
            if (ruesAccessibleDepuisLaDestination.isEmpty()) {
                System.out.println("Aucune rue accessible depuis la destination : " + destination.getNom());
                break;
            }
            if (ruesAccessibleDepuisLeLieu.isEmpty()) {
                System.out.println("Aucune rue accessible depuis le lieu actuel: " + position.getNom());
                break;
            }
            Rue rueAleatoireAccessibleDepuisLeLieu = ruesAccessibleDepuisLeLieu.get(random.nextInt(ruesAccessibleDepuisLeLieu.size()));
            position = rueAleatoireAccessibleDepuisLeLieu.lieu1().equals(position)
                    ? rueAleatoireAccessibleDepuisLeLieu.lieu2()
                    : rueAleatoireAccessibleDepuisLeLieu.lieu1();
            System.out.println("Marcheur se déplace à: " + position.getNom());
        }
    }
}