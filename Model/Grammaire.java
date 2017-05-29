package Model;

/**
 * Created by thibaut on 05/02/17.
 */
public class Grammaire extends Lecon {

    private static String name = "Grammaire";

    public Grammaire(Langue langue)
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
