package View;

import Model.Langue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thibaut on 29/05/17.
 */
public class form_create_user extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    public form_create_user()
    {
        JLabel lb_nom = new JLabel("Nom : ");
        JLabel lb_prenom = new JLabel("Prénom : ");
        JLabel lb_id = new JLabel("ID : ");
        JLabel lb_mdp = new JLabel("Mot de passe : ");
        JLabel lb_age = new JLabel("Age : ");
        JLabel lb_genre = new JLabel("Genre (H/F) : ");
        JLabel lb_langue = new JLabel("Langue : ");
        JTextField tf_nom = new JTextField("",10);
        JTextField tf_prenom = new JTextField("",10);
        JTextField tf_id = new JTextField("",10);
        JPasswordField pf_mdp = new JPasswordField("",10);
        JTextField tf_age = new JTextField("",10);
        JTextField tf_genre = new JTextField("",10);
        JComboBox cb_langue = new JComboBox();
        for(Langue lang : Langue.values()){
            cb_langue.addItem(lang.toString());
        }

        JButton btn_retour = new JButton("Retour");
        JButton btn_valider = new JButton("Valider");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        //colonne gauche
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(20, 20, 5, 5);
        getContentPane().add(lb_nom,gbc);
        gbc.gridy=1;
        gbc.insets = new Insets(5, 20, 5, 5);
        getContentPane().add(lb_prenom,gbc);
        gbc.gridy=2;
        getContentPane().add(lb_id,gbc);
        gbc.gridy=3;
        getContentPane().add(lb_mdp,gbc);
        gbc.gridy=4;
        getContentPane().add(lb_age,gbc);
        gbc.gridy=5;
        getContentPane().add(lb_genre,gbc);
        gbc.gridy=6;
        getContentPane().add(lb_langue,gbc);
        gbc.gridy=7;
        gbc.insets = new Insets(5, 20, 20, 5);
        getContentPane().add(btn_retour,gbc);

        //Colonne droite
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 5, 5, 20);
        getContentPane().add(tf_nom,gbc);
        gbc.gridy=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 20);
        getContentPane().add(tf_prenom,gbc);
        gbc.gridy=2;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        getContentPane().add(tf_id,gbc);
        gbc.gridy=3;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        getContentPane().add(pf_mdp,gbc);
        gbc.gridy=4;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        getContentPane().add(tf_age,gbc);
        gbc.gridy=5;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        getContentPane().add(tf_genre,gbc);
        gbc.gridy=6;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        getContentPane().add(cb_langue,gbc);
        gbc.gridy=7;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 20, 20);
        getContentPane().add(btn_valider,gbc);


        //Listener
        btn_retour.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        menu_profil f = new menu_profil();
                    }
                }
        );
        btn_valider.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();

                    }
                }
        );
        setTitle ("Création d'un compte") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
