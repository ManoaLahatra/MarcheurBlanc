package hei.school.Carte;

import hei.school.Lieu;
import hei.school.Rue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Carte {
    protected final Lieu lieuDeDepart;
    protected Map<String, Lieu> lieuxSurLaCarte;

    public Carte(Lieu lieuDeDepart) {
        this.lieuDeDepart = lieuDeDepart;
        this.lieuxSurLaCarte = new HashMap<>();
        lieuxSurLaCarte.put(lieuDeDepart.getNom(), lieuDeDepart);
    }

    public Lieu ajouterLieu(String nom) {
        if (lieuxSurLaCarte.containsKey(nom)) {
            return lieuxSurLaCarte.get(nom);
        }
        Lieu lieu = new Lieu(nom, new ArrayList<>());
        lieuxSurLaCarte.put(nom, lieu);
        return lieu;
    }

    public Lieu ajouterLieu(Lieu lieu) {
        if (lieuxSurLaCarte.containsKey(lieu.getNom())) {
            return lieuxSurLaCarte.get(lieu.getNom());
        }
        lieuxSurLaCarte.put(lieu.getNom(), lieu);
        return lieu;
    }

    public Rue ajouterRue(String nom, String nomLieu1, String nomLieu2) {
        Lieu lieu1 = lieuxSurLaCarte.get(nomLieu1);
        Lieu lieu2 = lieuxSurLaCarte.get(nomLieu2);

        if (lieu1 == null || lieu2 == null) {
            String missingLieu = (lieu1 == null ? nomLieu1 : "") + (lieu2 == null ? " et " + nomLieu2 : "");
            throw new IllegalArgumentException("Les lieux doivent exister pour créer une rue. Manquant(s) : " + missingLieu.trim());
        }

        Rue rue = new Rue(nom, lieu1, lieu2);
        lieu1.ajouterRue(rue);
        lieu2.ajouterRue(rue);

        return rue;
    }
}