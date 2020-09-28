package issuemap.controller;

import com.fizzed.rocker.RockerModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    @ResponseBody
    public RockerModel index() {
        return templates.index.template("Welcome", "Hi, Welcome!");
    }

}
