package by.levitckiy.it_project.command;

import com.google.protobuf.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public interface ICommand {
    public ModelAndView execute(Model model, ModelAndView modelAndView) throws ServiceException, ServletException, IOException, SQLException, ServletException;
}
