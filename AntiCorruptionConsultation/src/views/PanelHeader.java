package views;

import static controllers.Constant.COLOR_BACKGROUND;
import static controllers.Constant.REGISTOR_FONT;
import controllers.Events;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHeader extends JPanel {

    public static final String DELETE_VOTES = "ANULAR VOTOS       ";
    public static final String ICON_REGISTOR = "/data/Registor.png";
    public static final String ICON_ANTICORRUPTION = "/data/AntiCorruption.png";

    private JLabel jlRegistorIcon;
    private JLabel jlAntiCorruptionIcon;
    private JButton jbDeleteVotes;

    public PanelHeader(ActionListener controller) {
        setLayout(new BorderLayout());
        jlRegistorIcon = new JLabel(new ImageIcon(getClass().getResource(ICON_REGISTOR)));
        add(jlRegistorIcon, BorderLayout.LINE_START);

        jlAntiCorruptionIcon = new JLabel(new ImageIcon(getClass().getResource(ICON_ANTICORRUPTION)));
        add(jlAntiCorruptionIcon, BorderLayout.CENTER);

        jbDeleteVotes = new JButton(DELETE_VOTES);
        jbDeleteVotes.addActionListener(controller);
        jbDeleteVotes.setActionCommand(Events.SHOW_DELETE_VOTES_DIALOG.toString());
        jbDeleteVotes.setBackground(Color.decode(COLOR_BACKGROUND));
        jbDeleteVotes.setFont(REGISTOR_FONT);
        add(jbDeleteVotes, BorderLayout.LINE_END);

        setBackground(Color.decode(COLOR_BACKGROUND));
    }
}
