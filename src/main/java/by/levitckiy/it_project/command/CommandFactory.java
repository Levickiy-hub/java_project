package by.levitckiy.it_project.command;

import by.levitckiy.it_project.logic.LoginPage;

public class CommandFactory {
    public static ICommand create(String command){
        ICommand result=null;
        if(command.equals("start")){
            result =new LoginPage();
        }
        return result;
    }
}
