package src.metier;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import src.Controleur;

public class JeuDeLaVie 
{
    private char[][] tabColor;
    private Controleur ctrl;

    public JeuDeLaVie(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.tabColor = new char[ctrl.getTaille() + 2][ctrl.getTaille() + 2 ];
        this.initTabColor();
    }

    public void initTabColor()
    {
        for (int i = 1; i < tabColor.length - 1; i++) 
        {
            for (int j = 1; j < tabColor.length - 1; j++) 
            {
                if (this.ctrl.getCouleur(i - 1, j - 1) == Color.BLACK)
                {
                    tabColor[i][j] = 'V';
                }
                else
                {
                    tabColor[i][j] = 'M';
                }
            }
        }
        for (int i = 0; i < tabColor.length; i++) {
            for (int j = 0; j < tabColor.length; j++) {
                if(i == 0 || j == 0 || i == tabColor.length - 1 || j == tabColor.length - 1)
                {
                    tabColor[i][j] = 'O';
                }
            }
        }
        tabColor[2][3] = 'V';
        tabColor[2][4] = 'V';
        tabColor[3][4] = 'V';
        tabColor[3][5] = 'V';
        tabColor[4][5] = 'V';
        tabColor[4][6] = 'V';

    }

    public int getNbCellsVivante(int i, int j)
    {
        int cpt = 0;

        if (tabColor[i + 1][j + 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i - 1][j - 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i + 1][j - 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i - 1][j + 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i][j + 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i][j - 1] == 'V')
        {
            cpt++;
        }

        if (tabColor[i + 1][j] == 'V')
        {
            cpt++;
        }

        if (tabColor[i - 1][j] == 'V')
        {
            cpt++;
        }

        return cpt;
    }

    public String toString()
    {
        String c = "";
        for (int i = 0; i < tabColor.length; i++) 
        {
            for (int j = 0; j < tabColor.length; j++) 
            {
                c += tabColor[i][j] + " ";
            }
            c += "\n";
        }
        return c;
    }

    public char[][] getTabColor() {
        return this.tabColor;
    }

    public void setTabColor(int i, int j, char val) {
        this.tabColor[i][j] = val;
    }

    public char getValue(int i, int j)
    {
        return this.tabColor[i][j];
    }
    
}