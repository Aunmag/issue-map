package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Model;
import play.i18n.Messages;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel extends Model {

    @Id
    public Integer id;

    public abstract ObjectNode toJson(Messages messages);

    public ObjectNode toJsonId() {
        return new ObjectMapper().createObjectNode().put("id", id);
    }

}
