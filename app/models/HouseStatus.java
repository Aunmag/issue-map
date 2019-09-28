package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;
import play.i18n.Messages;

public enum HouseStatus {

    VERY_BAD(1, "models.house_status.very_bad"),
    BAD(2, "models.house_status.bad"),
    POOR(3, "models.house_status.poor"),
    GOOD(4, "models.house_status.good"),
    VERY_GOOD(5, "models.house_status.very_good");

    public final int grade;
    public final String name;

    HouseStatus(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    @DbEnumValue(storage = DbEnumType.INTEGER)
    public String getValue() {
        return Integer.toString(grade);
    }

    public ObjectNode toJson(Messages messages) {
        return new ObjectMapper()
                .createObjectNode()
                .put("grade", grade)
                .put("code", toString())
                .put("name", messages.at(name));
    }

}
