package watch.store.mnm.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import watch.store.mnm.domain.User;
import watch.store.mnm.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/"})
    public String home2(){
        return "index1";
    }

    @GetMapping(value = {"/login"})
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }


    @RequestMapping(value = {"/admin", "/cashier", "accountant"})
    public String home(Model model) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("image", Base64.encodeBase64String(user.getImage()));
        return "index";
    }

    @RequestMapping(value = {"/employee"})
    public String home1(Model model) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("image", Base64.encodeBase64String(user.getImage()));
        return "index1";
    }
}

