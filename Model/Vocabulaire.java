package Model;

/**
 * Created by thibaut on 05/02/17.
 */
public class Vocabulaire extends Lecon {

    private static String name = "Vocabulaire";
    public Vocabulaire(Langue langue)
    {
        super(langue);
    }

    /**
     * Méthode retournant le type de leçon, nécessaire pour l'affichage du contenu d'une session
     * @return
     */
    public String toString()
    {
        return name;
    }
}
