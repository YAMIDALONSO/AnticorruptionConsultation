package views;

import controllers.Constant;
import static controllers.Constant.REGISTOR_FONT;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFooter extends JPanel{
    
    public static final String WE_ARE = "Somos 36,421,026";
    public static final String OBJECTIVE = "La meta son: 12,140,342 de votos";
    
    private JLabel jlWeAre;
    private JLabel jlobjective;

    public PanelFooter() {
        setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        setLayout(new GridLayout());
        
        jlWeAre = new JLabel(WE_ARE);
        jlWeAre.setFont(REGISTOR_FONT);
        add(jlWeAre,BorderLayout.LINE_START);
        
        jlobjective = new JLabel(OBJECTIVE);
        jlobjective.setFont(REGISTOR_FONT);
        add(jlobjective, BorderLayout.LINE_END);
    }
}