package Model;

import java.util.Vector;

/**
 * Created by thibaut on 04/02/17.
 */
public class Historique {
    private Vector<Session> histo;

    /**
     * Constructeur de l'historique, initialisant la liste de sessions
     */
    public Historique()
    {
        histo = new Vector<>();
    }

    /**
     * Méthode renvoyant la liste de session
     * @return
     */
    public Vector<Session> getHistorique()
    {
        return histo;
    }

    /**
     * Méthode testant si l'historique contient déjà une session avec la date du jour, renvoie -1 si aucune session n'existe à la date du jour
     * @param session
     * @return
     */
    public int ContientSessionDate(Session session)
    {
        int i,res=-1;

        for(i=0;i<histo.size() && res==-1;i++)
        {
            if(histo.get(i).getDate()==session.getDate())
            {
                res=i;
            }
        }
        return res;
    }

    /**
     * Affichage d'un historique en appelant la méthode d'affichage de session pour chaque session contenue dans la liste
     */
    public void AfficheHistorique()
    {
        int i=0;
        while(i<histo.size())
        {
            //Appel à la méthode d'affichage de la session
            histo.get(i).AfficheSession();
            i++;
        }
    }
}
