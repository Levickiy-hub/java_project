package by.levitckiy.it_project.command;

import com.google.protobuf.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException, SQLException;
}
