package Utils;

import entities.Record;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRecordsService {

    public static int createRecord(int userId,String text){

        String SQL = "insert into records(user_id,record) values('" + userId + "','" + text + "');";

        return DBService.insert(SQL);
    }

    public static ResultSet selectRecordsByUeserId(int userId){

        String SQL = "select * from records where user_id = "+userId+" order by id desc;";

        return DBService.select(SQL);
    }

    public static ResultSet selectRecordById(int recordId){

        String SQL = "select * from records where id = "+recordId+";";

        return DBService.select(SQL);
    }

    public static int updateRecordById(int id, String text){

        String SQL = "update records set record = '" + text + "' where id = " + id +";";

        return  DBService.update(SQL);
    }

    public static int deleteRecordById(int id){
        String SQL = "delete from records where id = " + id + ";";

        return DBService.delete(SQL);
    }

    public static Record getRecordObjectById(int id){
        ResultSet rs = selectRecordById(id);
        Record record = new Record();

        try {
            while (rs.next()){
                record.setId(rs.getInt(1));
                record.setUser_id(rs.getInt(2));
                record.setText(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return record;
    }
}
