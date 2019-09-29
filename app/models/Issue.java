package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.annotation.Index;
import play.i18n.Messages;
import tools.UtilsJson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
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
                .put("created", UtilsJson.format(created));

        json.set("status", status.toJson(messages));
        json.set("categories", UtilsJson.toArray(categories, messages));
        json.set("authorities", UtilsJson.toArray(authorities, messages));

        return json;
    }

    public void apply(JsonNode data) {
        if (data.has("title")) {
            title = data.get("title").asText();
        }

        if (data.has("description")) {
            description = data.get("description").asText();
        }

        if (data.has("lat")) {
            lat = data.get("lat").asDouble();
        }

        if (data.has("lon")) {
            lon = data.get("lon").asDouble();
        }

        if (data.has("categories")) {
            categories = new ArrayList<>();

            UtilsJson.eachInt(data, "categories", id -> {
                // TODO: Optimize - fetch ID only
                categories.add(IssueCategory.FIND.byId(id));
            });
        }

        if (data.has("authorities")) {
            authorities = new ArrayList<>();

            UtilsJson.eachInt(data, "authorities", id -> {
                // TODO: Optimize - fetch ID only
                authorities.add(Authority.FIND.byId(id));
            });
        }

        if (data.has("status")) {
            status = IssueStatus.valueOf(data.get("status").asText());
        }
    }

}
