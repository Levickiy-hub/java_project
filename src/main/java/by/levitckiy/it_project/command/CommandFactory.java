package by.levitckiy.it_project.command;

import by.levitckiy.it_project.logic.LoginPage;

import java.util.logging.Logger;

public class CommandFactory {
    private static final Logger log =  Logger.getLogger(CommandFactory.class.getName());
    public static ICommand create(String command){
        ICommand result=null;
        if(command.equals("start")){
            log.info("Login page start");
            result =new LoginPage();
        }
        return result;
    }
}
