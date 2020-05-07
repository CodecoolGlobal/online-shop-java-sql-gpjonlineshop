package com.codecool.views;

import com.codecool.modules.Displayable;
import com.codecool.modules.Product;
import com.jakewharton.fliptables.FlipTable;

import java.util.HashMap;
import java.util.List;

// pozniej bedzie abstrack  abstract //

public class View {
    private String[][] screen;

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    private String[] headers;
    private List<Displayable> objectList;

    public List<Displayable> getObjectList() {
        return objectList;
    }

    public  void  setObjectList(HashMap<Integer, String> actionKeyMap){

    }

    public void setObjectList(List<Displayable> objectList) {
        this.objectList = objectList;
    }

    public View(){

    }

    public void displayContent(){
        String[][] data =  screen;
        for (Displayable product: objectList)
        System.out.println(FlipTable.of(headers, data));
    }

}
