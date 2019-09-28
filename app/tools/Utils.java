package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.BaseModel;
import play.i18n.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class Utils {

    public static final SimpleDateFormat DATE_TO_JSON_FORMATTER
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static String toJson(Date date) {
        return DATE_TO_JSON_FORMATTER.format(date);
    }

    public static ArrayNode toJsonArray(List<? extends BaseModel> models, Messages messages) {
        var data = new ObjectMapper().createArrayNode();

        for (var model : models) {
            data.add(model.toJson(messages));
        }

        return data;
    }

}
