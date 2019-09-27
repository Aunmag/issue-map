package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.annotation.Index;
import play.i18n.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Index(columnNames = {"lat", "lon"})
public class Issue extends BaseModel {

    public static final Finder<Integer, Issue> FIND = new Finder<>(Issue.class);

    @Column(nullable = false, length = 100)
    public String title;

    @Column(nullable = false, length = 1000, columnDefinition = "text")
    public String description;

    @Column(nullable = false)
    public Double lat;

    @Column(nullable = false)
    public Double lon;

    @Column(nullable = false)
    public IssueStatus status;

    public Issue(
            String title,
            String description,
            Double lat,
            Double lon
    ) {
        this.title = title;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.status = IssueStatus.NEW;
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        return toJsonId()
                .put("title", title)
                .put("description", description)
                .put("lat", lat)
                .put("lon", lon)
                // TODO: Return nested JSON object for status
                .put("status", status.toString())
                .put("status_l", messages.at(status.name));
    }

}
