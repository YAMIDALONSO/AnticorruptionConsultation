package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelContainer extends JPanel{
    
    private PanelLeft panelLeft;
    private PanelRight panelRight;
    private PanelResult panelResult;

    public PanelContainer(ArrayList<String> departaments, ActionListener controller) {
        setLayout(new GridLayout(0, 3));
        panelLeft = new PanelLeft(controller);
        add(panelLeft);
        
        panelResult = new PanelResult();
        add(panelResult);
        
        panelRight = new PanelRight(departaments,controller);
        add(panelRight);
    }

    public int getVotesNumber() {
        return panelRight.getVotesNumber();
    }

    public String getDepartament() {
        return panelRight.getDepartament();
    }

    public void registorVotes(String votes) {
        panelResult.registorVotes(votes);
    }

    public void cleanSpinn() {
        panelRight.cleanSpinn();
    }

    public void goalSucessfull() {
        panelResult.goalSucessFull();
    }

    public void sayFail() {
        panelResult.sayFail();
    }
}