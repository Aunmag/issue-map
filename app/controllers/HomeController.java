package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result setLanguage(String language) {
        ctx().changeLang(language);
        return redirect(routes.HomeController.index());
    }

}
