package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Controller;
import play.mvc.Result;

public class ApiController extends Controller {

    public Result setLanguage(String language) {
        ctx().changeLang(language);
        return ok();
    }

    public Result access() {
        return ok(new ObjectMapper().createObjectNode().put("is_admin", isAdmin()));
    }

    public Result loginAsUser() {
        session(SESSION_KEY_IS_ADMIN, SESSION_VALUE_FALSE);
        return ok();
    }

    public Result loginAsAdmin() {
        session(SESSION_KEY_IS_ADMIN, SESSION_VALUE_TRUE);
        return ok();
    }

}
