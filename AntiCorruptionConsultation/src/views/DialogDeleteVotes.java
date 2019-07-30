package views;

import controllers.Constant;
import static controllers.Constant.FONT_DELETE;
import controllers.Events;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class DialogDeleteVotes extends JDialog {

    public static final String VOTES_TO_DELETE = "Ingrese la cantidad de votos ANULADOS";
    public static final String TITTLE = "OJO va a anular votos";
    public static final String DELETE = "¡ANULAR VOTOS!";

    private JSpinner jsVotesToDelete;
    private JLabel jlWarning;
    private JButton jbDelete;
    public static final String VOTES = "Votos";

    public DialogDeleteVotes(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(TITTLE);
        setSize(600, 600);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.decode(Constant.COLOR_BACKGROUND));

        jlWarning = new JLabel(VOTES_TO_DELETE);
        jlWarning.setFont(new Font("Lucida Bright", Font.BOLD, 26));
        jlWarning.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlWarning);
        
        JPanel jp = new JPanel();
        jp.setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        add(jp);

        jsVotesToDelete = new JSpinner();
        jsVotesToDelete.setBorder(BorderFactory.createTitledBorder(VOTES));
        add(jsVotesToDelete);

        JPanel jp1 = new JPanel();
        jp1.setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        add(jp1);
        
        jbDelete = new JButton(DELETE);
        jbDelete.setFont(FONT_DELETE);
        jbDelete.setBackground(Color.decode(Constant.COLOR_BACKGROUND_BUTTON));
        jbDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbDelete.addActionListener(controller);
        jbDelete.setActionCommand(Events.DELETE_VOTES.toString());
        add(jbDelete);
    }

    public int deleteVotes() {
        int votes = (Integer)jsVotesToDelete.getValue();
        jsVotesToDelete.setValue(0);
        return votes;
    }
}