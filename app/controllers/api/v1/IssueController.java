package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Controller;
import models.Issue;
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

        issue.save();
        return created(issue);
    }

    public Result detail(Integer id) {
        var issue = Issue.FIND.byId(id);
        if (issue == null) {
            return notFound();
        }

        return ok(issue.toJson());
    }

    public Result list() {
        var data = new ObjectMapper().createArrayNode();
        Issue.FIND.query().findEach(i -> data.add(i.toJson()));
        return ok(data);
    }

}
