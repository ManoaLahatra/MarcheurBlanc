package hei.school;

import hei.school.Carte.Carte;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Environnement {
    private final Carte carte;

    public List<Rue> demanderLeChemin(Lieu position) {
        Lieu lieuAccessibleDepuisLaPosition = carte.getLieuxSurLaCarte().get(position.getNom());
        return lieuAccessibleDepuisLaPosition.getRuesAccessibleDepuisLeLieu();
    }
}