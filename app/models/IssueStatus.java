package models;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

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

}
