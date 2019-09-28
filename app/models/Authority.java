package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import play.i18n.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Authority extends BaseModel {

    public static final Finder<Integer, Authority> FIND = new Finder<>(Authority.class);

    @Column(nullable = false, length = 100)
    public String name;

    public Authority(String name) {
        this.name = name;
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        return toJsonId().put("name", name);
    }

}
