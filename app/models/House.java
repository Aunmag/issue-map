package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.annotation.Index;
import play.i18n.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Index(columnNames = {"lat", "lon"})
public class House extends BaseModel {

    public static final Finder<Integer, House> FIND = new Finder<>(House.class);

    @Column(length = 100)
    public String name;

    @Column(length = 100)
    public String street;

    @Column(nullable = false)
    public Double lat;

    @Column(nullable = false)
    public Double lon;

    @Column(columnDefinition = "text")
    public String polygon;

    public House(
            String name,
            String street,
            Double lat,
            Double lon,
            String polygon
    ) {
        this.name = name;
        this.street = street;
        this.lat = lat;
        this.lon = lon;
        this.polygon = polygon;
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        return toJsonId()
                .put("name", name)
                .put("street", street)
                .put("lat", lat)
                .put("lon", lon)
                .put("polygon", polygon);
    }

}
