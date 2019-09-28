package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Controller;
import models.IssueCategory;
import play.mvc.Result;

public class IssueCategoryController extends Controller {

    public Result detail(Integer id) {
        var category = IssueCategory.FIND.byId(id);
        if (category == null) {
            return notFound();
        }

        return ok(category.toJson(getMessages()));
    }

    public Result list() {
        var data = new ObjectMapper().createArrayNode();
        IssueCategory.FIND.query().findEach(i -> data.add(i.toJson(getMessages())));
        return ok(data);
    }

}
