package controllers;

import play.mvc.Http;

public abstract class Controller extends play.mvc.Controller {

    public String m(String key, Object... parameters) {
        return Http.Context.current().messages().at(key, parameters);
    }

}
