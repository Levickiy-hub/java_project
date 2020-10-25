package by.levitckiy.it_project.command;

import by.levitckiy.it_project.logic.LoginIn;
import by.levitckiy.it_project.logic.LoginPage;
import by.levitckiy.it_project.logic.Registration;
import by.levitckiy.it_project.logic.Registration_on;

import java.util.logging.Logger;

public class CommandFactory {
    private static final Logger log =  Logger.getLogger(CommandFactory.class.getName());
    public static ICommand create(String command){
        ICommand result=null;
        if(command.equals("start")){
            log.info("Login page start");
            result =new LoginPage();
        }
        else if(command.equals("login_in")){
            log.info("Login page in");
            result = new LoginIn();
        }else if(command.equals("registration")){
            log.info("Registration page");
            result = new Registration();
        } else if(command.equals("reg_in")){
        log.info("Registration start");
        result = new Registration_on();
    }

        return result;
    }
}
