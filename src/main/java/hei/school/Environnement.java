package hei.school;

import hei.school.Carte.Carte;

import java.util.List;

public class Environnement {
    private final Carte carte;

    public Environnement(Carte carte) {
        this.carte = carte;
    }

    public List<Rue> demanderLeChemin(Lieu position) {
        Lieu lieuAccessibleDepuisLaPosition = carte.getLieuxSurLaCarte().get(position.getNom());
        return lieuAccessibleDepuisLaPosition.getRuesAccessibleDepuisLeLieu();
    }
}