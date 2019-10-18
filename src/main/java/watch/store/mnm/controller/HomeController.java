package watch.store.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value= {"/","/login"})
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "index";
    }

    @RequestMapping(value = "/profile")
    public String profile(){ return "profile";}

    @RequestMapping(value = "/manufacturer")
    public String manu(){ return "manufacturer";}

    @RequestMapping(value = "/manufacturer_create")
    public String manu_create(){ return "manufacturer_create";}
}

