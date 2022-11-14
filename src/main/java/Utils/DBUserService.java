package Utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserService {

    public static int createUser(String login,String password){

        password = DigestUtils.md5Hex(password);

        String SQL = "insert into users(login,password) values('" + login + "','" + password + "');";

        return DBService.insert(SQL);
    }


    public static boolean isLoginUsed(String login){
        int rows = 0;

        String SQL = "select * from users  where (login = '" + login + "');";

        ResultSet resultSet = DBService.select(SQL);

        try {
            while (resultSet.next()){
                rows+=1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(rows > 0){
            return true;
        } else {return false;}

    }



    public static int logIn(String login,String password){
        int rows = 0;
        int id = 0;

        password = DigestUtils.md5Hex(password);

        String SQL = "select * from users  where (login = '" + login + "') and ( password ='" + password + "');";
        ResultSet resultSet = DBService.select(SQL);

        try {
            while (resultSet.next()) {
                rows += 1;
                id = resultSet.getInt(1);

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        if (rows > 0) {
            return id;
        } else { return 0; }
    }
}
