package JeuDeLaVie_V1;

import java.awt.Color;

import JeuDeLaVie_V1.ihm.FrameMap;
import JeuDeLaVie_V1.metier.JeuDeLaVie;

public class Controleur 
{
    private int nbTour;
    private FrameMap frame;
    private JeuDeLaVie metier;


    private final int TAILLE = 64;


    public Controleur()
    {
        this.frame = new FrameMap(this);
        this.metier = new JeuDeLaVie(this);
        this.jouer();
    }    

    public int getTaille() 
    {
        return this.TAILLE;
    }

    public Color getCouleur(int i, int j)
    {
        return this.frame.getCouleur(i, j);
    } 

    public char getValue(int i, int j)
    {
        return this.metier.getValue(i, j);
    }

    public int getNbTour()
    {
        return this.nbTour;
    }

    public void jouer()
    {
        while (true) 
        {
            this.frame.majIhm();   
            this.frame.majCount();
            int taille = this.getTaille() + 2;
            for (int i = 1; i < taille - 1; i++)
            {
                for (int j = 1; j < taille - 1; j++)
                {
                    if (this.metier.getNbCellsVivante(i, j) == 3 && this.metier.getValue(i, j) == 'M')
                    {
                        this.metier.setTabColor(i, j, 'V');
                    }    
    
                    if (this.metier.getNbCellsVivante(i, j) < 2 || this.metier.getNbCellsVivante(i, j) > 3 && this.metier.getValue(i, j) == 'V')
                    {
                        this.metier.setTabColor(i, j, 'M');
                    }

                    if (this.metier.getNbCellsVivante(i, j) == 2 && this.getValue(i, j) == 'V')
                    {
                        this.metier.setTabColor(i, j, 'V');
                    }
                }
            } 
            try 
            {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.nbTour ++;
        }
    }

    public static void main(String[] args) {
        new Controleur();
    }
}
