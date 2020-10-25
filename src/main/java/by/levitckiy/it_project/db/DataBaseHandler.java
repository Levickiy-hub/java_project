package by.levitckiy.it_project.db;

import by.levitckiy.it_project.model.User;

import java.sql.*;

public class DataBaseHandler extends DbConfig{
    private Connection connection =null;
    public Connection getConnection() throws SQLException
    {
        if(connection==null) {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
        return connection;
    }
    public boolean registration(String login, String password,String name, String privilege) throws SQLException {
        String idUser="2";
        User user =  new User();
        boolean proof=true;
        connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * from itproject.user");
        while (result.next()) {
          if(login.equals(result.getString("login"))){
              proof=false;
              return false;
          }else{
              user.setId(result.getInt("idUser"));
          }
        }
        if(proof){
            String command = "Insert into itproject.user values("+(user.getId()+1)+","+login+","+password+","+name+","+privilege+");";

            statement.execute(command);
        }
        connection.close();
        return true;
    }

}
