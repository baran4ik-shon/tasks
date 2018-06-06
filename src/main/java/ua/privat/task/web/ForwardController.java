package ua.privat.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping(value = "/{[task:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }

}
