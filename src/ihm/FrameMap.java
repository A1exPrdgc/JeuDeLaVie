package src.ihm;

import java.awt.*;
import javax.swing.*;

import src.Controleur;
import src.ihm.PanelCount;
import src.metier.JeuDeLaVie;


public class FrameMap extends JFrame{

    private PanelMap panel;
    private PanelCount panel2;
    private Controleur ctrl;

    public FrameMap(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setLayout(new BorderLayout());
        this.setTitle("Jeu de la vie");
        this.setSize(ctrl.getTaille() * 5, ctrl.getTaille() * 5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new PanelMap(ctrl);
        this.panel2 = new PanelCount(ctrl);
        this.add(this.panel, BorderLayout.CENTER);
        this.add(this.panel2, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public Color getCouleur(int i, int j)
    {
        return this.panel.getCouleur(i, j);
    }

    public void majIhm()
    {
        this.panel.majIhm();
    }

    public void majCount()
    {
        this.panel2.majCount();
    }
}