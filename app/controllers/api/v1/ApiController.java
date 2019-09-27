package controllers.api.v1;

import controllers.Controller;
import play.mvc.Result;

public class ApiController extends Controller {

    public Result setLanguage(String language) {
        ctx().changeLang(language);
        return ok();
    }

}
