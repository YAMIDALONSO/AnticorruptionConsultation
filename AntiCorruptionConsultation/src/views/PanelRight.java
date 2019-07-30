package views;

import controllers.Constant;
import static controllers.Constant.COLOR_BACKGROUND_BUTTON;
import static controllers.Constant.REGISTOR_FONT;
import controllers.Events;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class PanelRight extends JPanel{
    
    public static final String REGISTOR_VOTES = "Registrar Votos";
    
    private JComboBox jcbDepartment;
    private JSpinner jsVotesNumber;
    private JButton jbRegistor;

    public PanelRight(ArrayList<String> departaments, ActionListener controller) {
        setLayout(new GridLayout(3, 1));
        jcbDepartment = new JComboBox(departaments.toArray());
        jcbDepartment.setBackground(Color.decode(COLOR_BACKGROUND_BUTTON));
        jcbDepartment.setFont(REGISTOR_FONT);
        add(jcbDepartment);
        
        jsVotesNumber = new JSpinner();
        jsVotesNumber.setFont(REGISTOR_FONT);
        add(jsVotesNumber);
        
        jbRegistor = new JButton(REGISTOR_VOTES);
        jbRegistor.setBackground(Color.decode(Constant.COLOR_BACKGROUND_BUTTON));
        jbRegistor.setFont(REGISTOR_FONT);
        jbRegistor.addActionListener(controller);
        jbRegistor.setActionCommand(Events.REGISTOR_VOTES.toString());
        add(jbRegistor);
    }   

    public int getVotesNumber() {
        return (Integer)jsVotesNumber.getValue();
    }

    public String getDepartament() {
        return jcbDepartment.getSelectedItem().toString();
    }

    public void cleanSpinn() {
        jsVotesNumber.setValue(0);
    }
}