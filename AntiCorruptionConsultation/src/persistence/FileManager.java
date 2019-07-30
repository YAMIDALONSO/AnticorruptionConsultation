package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static final File FILE = new File("./files/Departamentos.txt");
    private static final String SEPARATOR = ",";

    public ArrayList<String> readDepartaments() throws FileNotFoundException, IOException {
        ArrayList<String> goals = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        String data = "";
        data = bufferedReader.readLine();
        while ((data = bufferedReader.readLine()) != null) {
            String[] departament = data.split(SEPARATOR);
            goals.add(departament[1]);
        }
        bufferedReader.close();
        return goals;
    }
}