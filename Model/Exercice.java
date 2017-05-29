package Model;

/**
 * Created by thibaut on 06/02/17.
 */
public class Exercice {

    protected String nom;
    public Exercice(String Nom){
        nom=Nom;
    }

    /**
     * Méthode retournant l'intitulé de l'exercice
     * @return
     */
    public String toString()
    {
        return nom;
    }
}
