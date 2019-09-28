package controllers;

import models.BaseModel;
import play.i18n.Messages;
import play.mvc.Http;
import play.mvc.Result;

public abstract class Controller extends play.mvc.Controller {

    public static String SESSION_VALUE_TRUE = "1";
    public static String SESSION_VALUE_FALSE = "0";
    public static String SESSION_KEY_IS_ADMIN = "is_admin";

    public String m(String key, Object... parameters) {
        return getMessages().at(key, parameters);
    }

    public Result created(BaseModel model) {
        return created(model.toJsonId());
    }

    public Messages getMessages() {
        return Http.Context.current().messages();
    }

    protected boolean isAdmin() {
        return SESSION_VALUE_TRUE.equals(session(SESSION_KEY_IS_ADMIN));
    }

}
