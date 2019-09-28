package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Controller;
import models.Authority;
import play.mvc.Result;

public class AuthorityController extends Controller {

    public Result detail(Integer id) {
        var authority = Authority.FIND.byId(id);
        if (authority == null) {
            return notFound();
        }

        return ok(authority.toJson(getMessages()));
    }

    public Result list() {
        var data = new ObjectMapper().createArrayNode();
        Authority.FIND.query().findEach(i -> data.add(i.toJson(getMessages())));
        return ok(data);
    }

}
