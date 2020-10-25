package by.levitckiy.it_project.logic;

import by.levitckiy.it_project.command.CommandFactory;
import by.levitckiy.it_project.command.ICommand;
import by.levitckiy.it_project.db.DataBaseHandler;
import com.google.protobuf.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class LoginIn implements ICommand {
    private static final Logger log =  Logger.getLogger(LoginIn.class.getName());
    @Override
    public ModelAndView execute(Model model, ModelAndView modelAndView) throws ServiceException, ServletException, IOException, SQLException, ServletException {
       modelAndView.setViewName("home");
      // String login = (String) model.getAttribute("login");
       // DataBaseHandler dataBaseHandler = new DataBaseHandler();
     //   dataBaseHandler.registration(login,"1","1","1");
        return modelAndView;
    }
}
