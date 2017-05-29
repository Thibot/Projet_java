package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thibaut on 29/05/17.
 */
public class menu_profil extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    public menu_profil()
    {
        JLabel lb_titre = new JLabel("Apprentissage des langues");
        JButton btn_connexion = new JButton("Connexion");
        JButton btn_create = new JButton("Créer un compte");
        JButton btn_anonyme=new JButton("Anonyme");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 15, 5, 15);
        getContentPane().add(lb_titre,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(5, 15, 5, 15);
        getContentPane().add(btn_connexion,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        getContentPane().add(btn_create,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets = new Insets(5, 15, 10, 15);
        getContentPane().add(btn_anonyme,gbc);

        btn_connexion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
        btn_create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        form_create_user create = new form_create_user();
                    }
                }
        );
        btn_anonyme.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        setTitle ("Apprentissage des langues") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
