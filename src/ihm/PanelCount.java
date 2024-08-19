package src.ihm;

import javax.swing.*;
import java.awt.*;

import src.Controleur;

public class PanelCount extends JPanel{
    
    private JLabel count;
    private Controleur ctrl;

    public PanelCount(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.count = new JLabel(this.ctrl.getNbTour()+"");
        this.add(this.count);
    }

    public void majCount()
    {
        this.count.setText(this.ctrl.getNbTour()+"");
    }
}
