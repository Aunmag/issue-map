package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.annotation.Index;
import play.i18n.Messages;
import tools.Utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

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

    @Column(nullable = false)
    public Date created;

    @ManyToMany
    public List<IssueCategory> categories;

    @ManyToMany
    public List<Authority> authorities;

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
        this.created = new Date();
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        var json = toJsonId()
                .put("title", title)
                .put("description", description)
                .put("lat", lat)
                .put("lon", lon)
                .put("crated", Utils.toJson(created))
                // TODO: Return nested JSON object for status
                .put("status", status.toString())
                .put("status_l", messages.at(status.name));

        json.set("categories", Utils.toJsonArray(categories, messages));
        json.set("authorities", Utils.toJsonArray(authorities, messages));

        return json;
    }

}
