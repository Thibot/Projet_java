package Model;

import java.util.Vector;

/**
 * Created by thibaut on 04/02/17.
 */
public abstract class Lecon {

    protected Langue langue;
    protected Vector<Exercice> list_exercices;

    /**
     * Contructeur d'une classe abstraite lecon en affectant une langue à la leçon et une liste d'exercices vide, qui doit être remplie avec chaque exercice effectué
     * @param LANGUE
     */
    public Lecon(Langue LANGUE)
    {
        langue=LANGUE;
        list_exercices = new Vector<>();
    }

    /**
     * Méthode retournant le dernier Exercice de la liste d'exercices
     * @return
     */
    public Exercice getExercice()
    {
        return list_exercices.get(list_exercices.size()-1);
    }

    /**
     * Méthode ajoutant un exercice dans la liste d'exercices
     * @param exo
     */
    public void addExercice(Exercice exo)
    {
        list_exercices.add(exo);
    }

    /**
     * Méthode retournant la liste d'exercices
     * @return
     */
    public Vector<Exercice> getList_exercices()
    {
        return list_exercices;
    }

    /**
     * Méthode retournant la langue de la leçon
     * @return
     */
    public Langue getLangue()
    {
        return langue;
    }

}
