package Model; /**
 * Created by thibaut on 03/02/17.
 */

import java.util.Date;
import java.util.Vector;

public class Session {

    private Date date;
    private Vector<Lecon> list_lecon;

    /**
     * Constructeur de session, initialisant la date de début de celle-ci et la liste de leçon
     */
    public Session()
    {
        date =  new java.util.Date();
        list_lecon=new Vector<Lecon>();
    }

    /**
     * Méthode retournant la date de début de la session
     * @return
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Méthode retournant la liste de leçons dans une session
     * @return
     */
    private Vector<Lecon> getList_lecon()
    {
        return list_lecon;
    }

    /**
     * Méthode modifiant la date de début d'un session
     * @param date
     */
    private void setDate(Date date) {
        this.date = date;
    }

    /**
     * Méthode modifiant la liste de leçons par celle placée en paramètre
     * @param list_lecon
     */
    private void setList_lecon(Vector<Lecon> list_lecon) {
        this.list_lecon = list_lecon;
    }

    /**
     * Affichage du contenu d'une session (Date + les types de leçon et les exercices
     */
    public void AfficheSession()
    {
        int i=0;
        System.out.println("Date : "+date.toString());

        for(i=0;i<list_lecon.size();i++)
        {
            System.out.println(list_lecon.get(i).toString()+"\t"+list_lecon.get(i).getList_exercices().toString()+"\n");
        }

    }

    /**
     * Méthode ajoutant une leçon dans la liste de leçon
     * @param lecon
     */
    public void addLecon(Lecon lecon)
    {
        if(list_lecon.contains(lecon))
        {
            list_lecon.get(list_lecon.indexOf(lecon)).addExercice(lecon.getExercice());
        }else
        {
            list_lecon.add(lecon);
        }

    }

}
