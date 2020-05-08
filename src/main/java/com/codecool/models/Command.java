package com.codecool.modules;

public class Command implements Displayable {
    int id;
    String action;
    public Command(int id, String action){
        this.id = id;
        this.action = action;
    }

    @Override
    public String[] returnStringList(){
        String[] userList = new String[]{Integer.toString(id), action};
        return userList;
    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }

}


