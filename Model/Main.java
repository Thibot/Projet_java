package Model;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by thibaut on 01/02/17.
 */
public class Main {
    private static String ID_actif;
    private static Session session;
    private static HashMap<String,User> list=new HashMap<>();
    private static HashMap<String,Historique> list_histo=new HashMap<>();

    public static void main (String[] args){

        int input;
        Boolean user_cree=false;
        Exercice exo = new Exercice("exo1");

        do{
            /**
             * Boucle pour tester si l'utilisateur vient de créer un compte et si à la fin de la création il a choisit d'accéder directement à une nouvelle session
             */
            if(!user_cree)
            {
                System.out.println("\n1 - Creer un compte\n2 - Acceder à un compte\n3 - Utilisateur anonyme\n4 - Quitter");
                Scanner sc = new Scanner(System.in);
                input=sc.nextInt();
            }else
            {
                input=2;
            }
            switch(input)
            {
                case 1:
                    addUser(list);
                    System.out.println("Voulez-vous commencer une leçon ? O/N");
                    Scanner sc=new Scanner(System.in);
                    if(sc.nextLine().equals("O"))
                    {
                        user_cree=true;
                    }
                    break;
                case 2:
                    System.out.println("Nouvelle session");

                    if(user_cree)
                    {
                        session = new Session();
                        compte(exo);
                        user_cree=false;
                    }else
                    {
                        if(new_session(list))
                        {
                            compte(exo);
                        }
                    }
                    break;
                case 3:
                    anonymous();
                    break;
                case 4:
                    System.out.println("\nVous quittez.");
                    break;
            }
        }while(!(input==4));
    }

    /**
     * Ouverture d'une nouvelle session en demandant la saisie de l'identifiant de l'utilisateur et retourne faux si après 3 essais d'identification le système
     * n'est pas parvenu à associé l'identifiant saisi à un compte dans la liste des utilisateurs
     * @param liste
     * @return
     */
    private static Boolean new_session(HashMap<String,User> liste)     //Renvoi vrai s'il existe un utilisateur avec l'identifiant saisi, sinon renvoi faux
    {
        int i=0;
        if(liste.isEmpty())
        {
            System.out.println("Aucun utilisateur existant");
            return false;
        }else
        {
            Boolean valide=false;
            while(i<=2 && !(valide))
            {
                Scanner sc;
                String id;
                System.out.println("Saisissez votre identifiant : ");
                sc=new Scanner(System.in);
                id=sc.nextLine();
                if(liste.containsKey(id))
                {
                    valide=true;
                    session=new Session();
                    ID_actif=id;
                }else
                {
                    i++;
                }
            }
            return valide;
        }
    }

    /**
     * Méthode permettant d'accéder à l'historique d'un utilisateur et au menu demandant le type de leçon que l'utilisateur souhaite faire, ce dernier peut aussi
     * revenir au menu principal s'il le souhaite
     * @param exo
     */
    private static void compte(Exercice exo)
    {
        Lecon lecon;
        int choix;
        Scanner sc;
        Historique histo= new Historique();

        //Menu pour demander ce que l'utilisateur veut faire : 1 - Grammaire ; 2 - COnjugaison ; 3 - Vocabulaire ; 4 - Orthographe ; 5 - Retour au menu principal
        do {
            try{
                list_histo.get(ID_actif).AfficheHistorique();      //Afficher Historique de l'utilisateur
            }catch(NullPointerException e)
            {
                System.out.println("Aucun historique pour cet utilisateur");
            }

            System.out.println("\nQuelle type de leçon voulez-vous faire ?");
            System.out.println("1 - Grammaire\n2 - Conjugaison\n3 - Orthographe\n4 - Vocabulaire\n5 - Retour au menu principal");
            sc=new Scanner(System.in);
            choix = sc.nextInt();
            sc.nextLine();

            switch(choix)
            {
                case 1:
                    lecon=new Grammaire(list.get(ID_actif).getLangue());
                    lecon.addExercice(exo);
                    finLecon_Logged(histo,lecon);
                    break;
                case 2:
                    lecon=new Conjugaison(list.get(ID_actif).getLangue());
                    lecon.addExercice(exo);
                    finLecon_Logged(histo,lecon);
                    break;
                case 3:
                    lecon=new Orthographe(list.get(ID_actif).getLangue());
                    lecon.addExercice(exo);
                    finLecon_Logged(histo,lecon);
                    break;
                case 4:
                    lecon=new Vocabulaire(list.get(ID_actif).getLangue());
                    lecon.addExercice(exo);
                    finLecon_Logged(histo,lecon);
                    break;
                default:
                    break;
            }
        }while(choix!=5);

    }

    /**
     * Ajout d'un utilisateur dans la liste des utilisateurs enregistrés, renvoi d'un booléen pour confirmer que l'enregistrement s'est bien passé
     * @param liste
     * @return
     */
    private static Boolean addUser(HashMap<String,User> liste)
    {
        String nom;
        Scanner sc;
        Boolean ok=false;

        do{
            System.out.println("\nVeuillez renseigner votre nom : ");
            sc = new Scanner(System.in);
            nom=sc.nextLine();
            if(!(liste.containsKey(nom)) && !(nom.equals("")))
            {
                ok=true;
                ID_actif=nom;
            }
        }while(!(ok));

        User utilisateur=new User();
        liste.put(nom,utilisateur);
        System.out.println("\nUtilisateur créé avec succès, votre identifiant est : "+nom+"\n");
        return true;
    }

    /**
     * Méthode pour entamer une session en tant qu'utilisateur anonyme
     */
    private static void anonymous()
    {
        Lecon lecon;
        int choix;
        Scanner sc;
        Historique histo= new Historique();
        Exercice exo=new Exercice("exo1");
        Langue langue;
        Boolean ok=false;
        Session SEssion=new Session();

        do {
            System.out.println("\nChoisissez une langue à apprendre parmi la liste : ");
            for(Langue lang : Langue.values()){
                System.out.println(lang);
            }

            System.out.println("\r");
            sc = new Scanner(System.in);
            String saisie_langue = sc.nextLine();

            switch(saisie_langue) {
                case "Anglais":
                    langue=Langue.Anglais;
                    ok=true;
                    break;
                case "Espagnol":
                    langue=Langue.Espagnol;
                    ok=true;
                    break;
                case "Italien":
                    langue=Langue.Italien;
                    ok=true;
                    break;
                case "Allemand":
                    langue=Langue.Allemand;
                    ok=true;
                    break;
                default:
                    langue=Langue.Anglais;

                    break;
            }
        } while(!ok);

        //Menu pour demander ce que l'utilisateur veut faire : 1 - Grammaire ; 2 - COnjugaison ; 3 - Vocabulaire ; 4 - Orthographe ; 5 - Retour au menu principal
        do {
            try{
                histo.AfficheHistorique();      //Afficher Historique de l'utilisateur
            }catch(NullPointerException e)
            {
                System.out.println("Aucun historique pour cet utilisateur");
            }

            System.out.println("\nQuelle type de leçon voulez-vous faire ?");
            System.out.println("1 - Grammaire\n2 - Conjugaison\n3 - Orthographe\n4 - Vocabulaire\n5 - Retour au menu principal");
            sc=new Scanner(System.in);
            choix = sc.nextInt();
            sc.nextLine();

            switch(choix)
            {

                case 1:
                    lecon=new Grammaire(langue);
                    lecon.addExercice(exo);
                    finLecon_Anonyme(histo,SEssion,lecon);
                    break;
                case 2:
                    lecon=new Conjugaison(langue);
                    lecon.addExercice(exo);
                    finLecon_Anonyme(histo,SEssion,lecon);
                    break;
                case 3:
                    lecon=new Orthographe(langue);
                    lecon.addExercice(exo);
                    finLecon_Anonyme(histo,SEssion,lecon);
                    break;
                case 4:
                    lecon=new Vocabulaire(langue);
                    lecon.addExercice(exo);
                    finLecon_Anonyme(histo,SEssion,lecon);
                    break;
                default:
                    break;
            }
        }while(choix!=5);
    }

    /**
     * Méthode permettant d'enregistrer l'historique après une session par un utilisateur enregistré dans la liste des utilisateurs
     * @param histo
     * @param lecon
     */
    private static void finLecon_Logged(Historique histo,Lecon lecon)
    {
        int test;
        test=histo.ContientSessionDate(session);
        if(test>=0)
        {
            histo.getHistorique().get(test).addLecon(lecon);
        }else
        {
            session.addLecon(lecon);
            histo.getHistorique().add(session);
        }

        if(list_histo.containsKey(ID_actif))
        {
            list_histo.remove(ID_actif);
            list_histo.put(ID_actif,histo);
        }else
        {
            list_histo.put(ID_actif,histo);
        }
    }

    /**
     * Méthode permettant d'enregistrer l'historique après une session par un utilisateur anonyme
     * @param histo
     * @param SEssion
     * @param lecon
     */
    private static void finLecon_Anonyme(Historique histo,Session SEssion,Lecon lecon)
    {
        int test;
        test=histo.ContientSessionDate(SEssion);
        if(test>=0)
        {
            histo.getHistorique().get(test).addLecon(lecon);
        }else
        {
            SEssion.addLecon(lecon);
            histo.getHistorique().add(SEssion);
        }
    }
}
