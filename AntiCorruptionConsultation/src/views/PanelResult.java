package views;

import controllers.Constant;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResult extends JPanel{
    
    public static final String VOTES_COUNT = "<html>No hay votos registrados<br> hasta ahora</html>";
    public static final String DEFAULT_STATUS = "Aun no alcanzamos el objetivo";
    public static final String NOT_CORRUPTION = "Meta lograda CHAO CORRUPCION";
    
    private JLabel jlVotes;
    private JLabel jlGoalStatus;

    public PanelResult() {
        setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        setLayout(new GridLayout(2,0));
        jlVotes = new JLabel(VOTES_COUNT);
        jlVotes.setFont(Constant.FONT_DELETE);
        add(jlVotes);
        
        JPanel jp = new JPanel();
        jp.setBackground(Color.decode(Constant.COLOR_BACKGROUND));
        
        jlGoalStatus = new JLabel(DEFAULT_STATUS);
        jlGoalStatus.setForeground(Color.red);
        jlGoalStatus.setFont(Constant.FONT_DELETE);
        add(jlGoalStatus);
    }

    public void registorVotes(String votes) {
        jlVotes.setText("<html> Hasta ahora se han<br> registrado "+ votes +" Votos en total</html>");
    }

    public void goalSucessFull() {
        jlGoalStatus.setForeground(Color.GREEN);
        jlGoalStatus.setText(NOT_CORRUPTION );
    }

    public void sayFail() {
        jlGoalStatus.setText(DEFAULT_STATUS);
        jlGoalStatus.setForeground(Color.red);
    }
}