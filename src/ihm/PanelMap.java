package src.ihm;

import javax.swing.*;
import java.awt.*;

import src.Controleur;

public class PanelMap extends JPanel 
{
    private Controleur ctrl;
    private JLabel[][] tabLabel;

    public PanelMap(Controleur ctrl)
    {   
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(ctrl.getTaille(), ctrl.getTaille()));

        this.tabLabel = new JLabel[ctrl.getTaille()][ctrl.getTaille()];

        for (int i = 0; i < this.tabLabel.length; i++) 
        {
            for (int j = 0; j < this.tabLabel.length; j++) {
                tabLabel[i][j] = new JLabel();
                tabLabel[i][j].setBackground(Color.WHITE);
                tabLabel[i][j].setOpaque(true);
                this.add(this.tabLabel[i][j]); 
            }            
        }

        
        this.setVisible(true);
    }

    public Color getCouleur(int i, int j)
    {
        return this.tabLabel[i][j].getBackground();
    }

    public JLabel[][] getTabLabel() {
        return this.tabLabel;
    }  

    public void majIhm()
    {
        for (int i = 0; i < tabLabel.length; i++) 
        {
            for (int j = 0; j < tabLabel.length; j++) 
            {
                if (this.ctrl.getValue(i, j) == 'V')
                {
                    this.tabLabel[i][j].setBackground(Color.BLACK);
                }
                else
                {
                    this.tabLabel[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
}
