package hei.school;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Lieu {
    private final String nom;
    private List<Rue> ruesAccessibleDepuisLeLieu;

    public Lieu(String nom) {
        this.nom = nom;
        this.ruesAccessibleDepuisLeLieu = new ArrayList<>();
    }

    public void ajouterRue(Rue rue) {
        if (!ruesAccessibleDepuisLeLieu.contains(rue)) {
            ruesAccessibleDepuisLeLieu.add(rue);
        }
    }
}