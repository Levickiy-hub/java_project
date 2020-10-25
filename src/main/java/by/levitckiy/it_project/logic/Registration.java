package by.levitckiy.it_project.logic;

import by.levitckiy.it_project.command.ICommand;
import com.google.protobuf.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class Registration implements ICommand {

    @Override
    public ModelAndView execute(Model model, ModelAndView modelAndView) throws ServiceException, ServletException, IOException, SQLException, ServletException {
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
