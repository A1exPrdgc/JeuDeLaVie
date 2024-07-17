package JeuDeLaVie_V1.ihm;

import javax.swing.*;
import java.awt.*;

import JeuDeLaVie_V1.Controleur;

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

    @Override
    public void majCount()
    {
        this.count.setText(this.ctrl.getNbTour()+"");
    }
}
