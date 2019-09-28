package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import play.i18n.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class IssueCategory extends BaseModel {

    public static final Finder<Integer, IssueCategory> FIND
            = new Finder<>(IssueCategory.class);

    @Column(nullable = false, length = 100)
    public String name;

    @Column(nullable = false, length = 50)
    public String icon;

    @Column(nullable = false, length = 50)
    public String color;

    public IssueCategory(String name, String icon, String color) {
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        return toJsonId()
                .put("name", name)
                .put("icon", icon)
                .put("color", color);
    }

}
