package views;

import controllers.Constant;
import static controllers.Constant.REGISTOR_FONT;
import controllers.Events;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLeft extends JPanel{
    
    public static final String INSTRUCTION = "<html><br><br>Seleccione el Departamento<br>e <tag>Ingresse el numero de Votos<br> Obtenidos<br><br></html>";
    public static final String STILL_VOTE = "<html>¿Qué porcentage<br> no voto?</html>";
    
    private JLabel jlInstruction;
    private JButton jbstillVote;

    public PanelLeft(ActionListener controller) {
        setLayout(new GridLayout(3, 1));
        
        jlInstruction = new JLabel(INSTRUCTION);
        jlInstruction.setFont( new Font("Lucida Bright", Font.BOLD, 32));
        add(jlInstruction);
        
        JPanel jp = new JPanel();
        jp.setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        add(jp);
        
        jbstillVote = new JButton(STILL_VOTE);
        jbstillVote.setFont(REGISTOR_FONT);
        jbstillVote.setFont( new Font("Lucida Bright", Font.BOLD, 32));
        jbstillVote.setBackground(Color.decode(Constant.COLOR_BACKGROUND_BUTTON));
        jbstillVote.addActionListener(controller);
        jbstillVote.setActionCommand(Events.SHOW_PEOPLE_PERCENTAGE.toString());
        add(jbstillVote);
        
        setBackground(Color.decode(Constant.COLOR_BACKGROUND));
    }
}