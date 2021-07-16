import model.AbstractEvent;
import model.Live;
import model.OST;

import java.security.InvalidParameterException;

public class EventFactory {

    private static final String DELIMITER = ";";

    public static AbstractEvent createEvent(String s1, String s2, String s3, int year, String s4) throws InvalidParameterException {

        if ("BO".equalsIgnoreCase(s1)) {
            return new OST(s2, s3, year, s4);

        } else if ("Live".equalsIgnoreCase(s1)) {
            return new Live(s2, s3, year, s4);
        }

        throw new InvalidParameterException();
    }


    public static AbstractEvent createEvent(String[] params) throws InvalidParameterException {
        if (params == null || params.length != 5) {
            throw new InvalidParameterException();
        }

        for (String param : params) {
            if (param == null || param.isEmpty()) {
                throw new InvalidParameterException();
            }
        }

        int year;
        try {
            year = Integer.parseInt(params[3]);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException();
        }


        return createEvent(params[0], params[1], params[2], year, params[4]);
    }

    public static AbstractEvent createEvent(String entry) throws InvalidParameterException {
        if (entry == null || entry.isEmpty()) {
            throw new InvalidParameterException();
        }
        return createEvent(entry.split(DELIMITER));
    }

}
