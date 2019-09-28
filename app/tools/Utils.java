package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utils {

    public static final SimpleDateFormat DATE_TO_JSON_FORMATTER
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static String toJson(Date date) {
        return DATE_TO_JSON_FORMATTER.format(date);
    }

}
