package by.levitckiy.it_project.controller;


import by.levitckiy.it_project.command.CommandFactory;
import by.levitckiy.it_project.command.ICommand;
import com.google.protobuf.ServiceException;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;


@org.springframework.stereotype.Controller
public class Controller {
    @Value("${welcome.message}")
    private String message;
    @GetMapping("/")
    public ModelAndView comm(Model model,  @RequestParam(name = "k",required = false, defaultValue = "start")
            String command) throws ServiceException, SQLException, ServletException, IOException {
        ICommand action = CommandFactory.create(command);
        ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("index");
//      model.addAttribute("message", message);
        return action.execute(model,modelAndView);
    } @PostMapping("/")
    public ModelAndView com(Model model,  @RequestParam(name = "login",required = false, defaultValue = "")
            String login,@RequestParam(name = "password",required = false, defaultValue = "")
            String password,@RequestParam(name = "name",required = false, defaultValue = "")
            String name,@RequestParam(name = "privilege",required = false, defaultValue = "")
            String privilege,@RequestParam(name = "k",required = false, defaultValue = "login_in")
            String command) throws ServiceException, SQLException, ServletException, IOException {
        ICommand action = CommandFactory.create(command);
        ModelAndView modelAndView = new ModelAndView();
      model.addAttribute("login", login);
      model.addAttribute("password", password);
      model.addAttribute("name", name);
      model.addAttribute("privilege", privilege);
        return action.execute(model,modelAndView);
    }
}
