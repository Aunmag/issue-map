package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Controller;
import models.Issue;
import models.IssueCategory;
import play.mvc.Result;

public class IssueController extends Controller {

    public Result create() {
        var data = request().body().asJson();
        var issue = new Issue(
                data.get("title").asText(),
                data.get("description").asText(),
                data.get("lat").asDouble(),
                data.get("lon").asDouble()
        );

        if (data.has("category")) {
            issue.categories.add(IssueCategory.FIND.byId(data.get("category").asInt()));
        }

        issue.save();
        return created(issue);
    }

    public Result update(Integer id) {
        var data = request().body().asJson();

        if (isAdmin()) {
            var issue = Issue.FIND.byId(id);

            if (issue == null) {
                return notFound();
            } else {
                issue.apply(data);
                issue.update();
                return ok();
            }
        } else {
            return forbidden();
        }
    }

    public Result detail(Integer id) {
        var issue = Issue.FIND.byId(id);
        if (issue == null) {
            return notFound();
        }

        return ok(issue.toJson(getMessages()));
    }

    public Result list() {
        var data = new ObjectMapper().createArrayNode();
        Issue.FIND.query().findEach(i -> data.add(i.toJson(getMessages())));
        return ok(data);
    }

}
