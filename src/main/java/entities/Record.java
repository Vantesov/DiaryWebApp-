package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Record {

    private int id;
    private int user_id;
    private String text;

    public Record(){

    }
    public Record(int id, int user_id, String text){
        this.id = id;
        this.user_id = user_id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
