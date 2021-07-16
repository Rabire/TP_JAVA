import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SecurityException, IllegalArgumentException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Exception file : ");

        String exceptionFileName = scanner.nextLine();
        if (exceptionFileName == null || exceptionFileName.isEmpty()) {
            exceptionFileName = "resources/Exceptions.log";
        }

        System.out.println("Entries file : ");
        String entriesFileName = scanner.nextLine();
        if (entriesFileName == null || entriesFileName.isEmpty()) {
            entriesFileName = "resources/Entries.txt";
        }

        EventsManager eventsManager = new EventsManager(exceptionFileName, entriesFileName);
        eventsManager.sendToDatabase();
        eventsManager.readFromDatabase();
        eventsManager.displayInformations();
    }
}
