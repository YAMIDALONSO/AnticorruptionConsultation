package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import models.Query;
import persistence.FileManager;
import views.DialogDeleteVotes;
import views.WindowQueryAnticorruption;

public class Controller implements ActionListener {

    private Query query;
    private WindowQueryAnticorruption windowQueryAnticorruption;
    private FileManager fileManager;
    private DialogDeleteVotes dialogDeleteVotes;

    public Controller() {
        fileManager = new FileManager();
        query = new Query();
        try {
            windowQueryAnticorruption = new WindowQueryAnticorruption(this, fileManager.readDepartaments());
            dialogDeleteVotes = new DialogDeleteVotes(windowQueryAnticorruption, this);
        } catch (IOException ex) {
            System.err.println("No se pudo leer el archivo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case SHOW_DELETE_VOTES_DIALOG:
                showDeleteVotesDialog();
                break;
            case REGISTOR_VOTES:
                registorVotes();
                break;
            case DELETE_VOTES:
                deleteVotes();
                break;
            case SHOW_PEOPLE_PERCENTAGE:
                showPeoplePercentage();
                break;
        }
    }

    private void showDeleteVotesDialog() {
        dialogDeleteVotes.setVisible(true);
    }

    private void registorVotes() {
        query.recordVotesObtained(windowQueryAnticorruption.getVotesNumber(), windowQueryAnticorruption.getDepartament());
        windowQueryAnticorruption.registorVotes(query.getVotesNumber());
        if (query.theTresholdVotesWasReached()) {
            windowQueryAnticorruption.goalSucessfull();
        }
    }

    private void deleteVotes() {
        query.deleteVotes(dialogDeleteVotes.deleteVotes());
        windowQueryAnticorruption.registorVotes(query.getVotesNumber());
        if (!query.theTresholdVotesWasReached()) {
            windowQueryAnticorruption.sayFail();
        }
        dialogDeleteVotes.setVisible(false);
    }

    private void showPeoplePercentage() {
        JOptionPane.showMessageDialog(windowQueryAnticorruption, "No votaron el " + query.countHowManyPeopleDidNotVote() + "% de personas");
    }
}
