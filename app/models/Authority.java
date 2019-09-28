package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import play.i18n.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Authority extends BaseModel {

    public static final Finder<Integer, Authority> FIND = new Finder<>(Authority.class);

    @Column(length = 100)
    public String name;

    @Column(length = 100)
    public String phone;

    @Column(length = 100)
    public String email;

    @Column(length = 100)
    public String url;

    @Column(length = 100)
    public String address;


    public Authority(String name, String phone, String email, String url, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.url = url;
        this.address = address;
    }

    @Override
    public ObjectNode toJson(Messages messages) {
        return toJsonId()
            .put("name", name)
            .put("phone", phone)
            .put("email", email)
            .put("url", url)
            .put("address", address);
    }

}