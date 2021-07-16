import model.AbstractEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventsManager {
    private final List<AbstractEvent> events = new ArrayList<>();

    private final String exceptionFileName;

    public EventsManager(String exceptionFileName, String entriesFileName) {
        this.exceptionFileName = exceptionFileName;
        try {
            initFromFile(entriesFileName);
        } catch (IOException e) {
            logException("Error : Could not read file " + entriesFileName);
        }
    }

    private void initFromFile(String entriesFileName) throws IOException {
        File file = new File(entriesFileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        if (!file.exists()) {
            logException("Entries file not found : " + file.getAbsolutePath());
            return;
        }

        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            try {
                AbstractEvent event = EventFactory.createEvent(line);
                events.add(event);
            } catch (Exception e) {
                logException("Could not create event from line " + i + " : " + line);
            }
            i++;
        }
    }

    private void logException(String exception) {
        try {
            Writer output = new BufferedWriter(new FileWriter(exceptionFileName, true));
            output.append(exception).append("\n");
            output.close();
        } catch (IOException e) {
            System.err.println("Error : Could not log into file " + exceptionFileName);
            System.err.println(exception);
        }
    }

    public void sendToDatabase() {
        if (events.isEmpty()) {
            return;
        }

        TODO: 
    }

    public void readFromDatabase() {
        TODO:
        //events.clear();

        //fetch database
        String s1 = "";
        String s2 = "";
        String s3 = "";
        int year = 0;
        String s4 = "";

        try {
            AbstractEvent event = EventFactory.createEvent(s1, s2, s3, year, s4);
            events.add(event);
        } catch (Exception e) {
            logException("Could not create event from database");
        }
    }

    public void displayInformations() {
        StringBuilder builder = new StringBuilder();
        builder.append("Number of events : ").append(events.size());

        for (AbstractEvent event : events) {
            builder.append("\n").append(event.toString());
        }

        System.out.println(builder.toString());
    }

}
