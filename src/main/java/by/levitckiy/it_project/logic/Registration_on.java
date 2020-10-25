package by.levitckiy.it_project.logic;

import by.levitckiy.it_project.command.ICommand;
import by.levitckiy.it_project.db.DataBaseHandler;
import com.google.protobuf.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class Registration_on implements ICommand {
    @Override
    public ModelAndView execute(Model model, ModelAndView modelAndView) throws ServiceException, ServletException, IOException, SQLException, ServletException {
         String login = (String) model.getAttribute("login");
         String password = (String) model.getAttribute("password");
         String name = (String) model.getAttribute("name");
         String privilege = (String) model.getAttribute("privilege");
         DataBaseHandler dataBaseHandler = new DataBaseHandler();
         if(dataBaseHandler.registration(login,password,name,privilege)){
             modelAndView.setViewName("login");
         }
         else{
             modelAndView.setViewName("registration");
         }
        return modelAndView;
    }
}
