package controllers;

import models.BaseModel;
import play.mvc.Http;
import play.mvc.Result;

public abstract class Controller extends play.mvc.Controller {

    public String m(String key, Object... parameters) {
        return Http.Context.current().messages().at(key, parameters);
    }

    public Result created(BaseModel model) {
        return created(model.toJsonId());
    }

}
