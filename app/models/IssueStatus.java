package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;
import play.i18n.Messages;

public enum IssueStatus {

    NEW(1, "models.issue_status.new"),
    CANCELED(2, "models.issue_status.canceled"),
    APPROVED(3, "models.issue_status.approved"),
    PERFORMING(4, "models.issue_status.performing"),
    RESOLVED(5, "models.issue_status.resolved");

    public final int id;
    public final String name;

    IssueStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @DbEnumValue(storage = DbEnumType.INTEGER)
    public String getValue() {
        return Integer.toString(id);
    }

    public ObjectNode toJson(Messages messages) {
        return new ObjectMapper()
                .createObjectNode()
                .put("code", toString())
                .put("name", messages.at(name));
    }

}
