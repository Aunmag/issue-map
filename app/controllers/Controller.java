package controllers;

import models.BaseModel;
import play.i18n.Messages;
import play.mvc.Http;
import play.mvc.Result;

public abstract class Controller extends play.mvc.Controller {

    public String m(String key, Object... parameters) {
        return getMessages().at(key, parameters);
    }

    public Result created(BaseModel model) {
        return created(model.toJsonId());
    }

    public Messages getMessages() {
        return Http.Context.current().messages();
    }

}
