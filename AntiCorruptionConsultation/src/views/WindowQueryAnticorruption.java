package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WindowQueryAnticorruption extends JFrame {

    private static final String TITLE = "Consulta Anticorrupcion";
    private static final String ICON = "/data/Icon.png";
    
    private PanelHeader panelHeader;
    private PanelFooter panelFooter;
    private PanelContainer panelContainer;

    public WindowQueryAnticorruption(ActionListener listener, ArrayList<String> departaments){
        setTitle(TITLE);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panelHeader = new PanelHeader(listener);
        add(panelHeader,BorderLayout.NORTH);
        
        panelContainer = new PanelContainer(departaments,listener);
        add(panelContainer);
        
        panelFooter = new PanelFooter();
        add(panelFooter,BorderLayout.SOUTH);
        
        setVisible(Boolean.TRUE);
    }

    public int getVotesNumber() {
        return panelContainer.getVotesNumber();
    }

    public String getDepartament() {
        return panelContainer.getDepartament();
    }

    public void registorVotes(String votes) {
        panelContainer.cleanSpinn();
        panelContainer.registorVotes(votes);
    }

    public void goalSucessfull() {
        panelContainer.goalSucessfull();
    }

    public void sayFail() {
       panelContainer.sayFail();
    }
}