package com.codecool.views;

import com.codecool.modules.Displayable;
import com.codecool.modules.Product;
import com.jakewharton.fliptables.FlipTable;

import java.util.HashMap;
import java.util.List;

// pozniej bedzie abstrack  abstract //

public class View {
    private String[] headers;
    private List<Displayable> objectList;

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public List<Displayable> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Displayable> objectList) {
        this.objectList = objectList;
    }

    public View(){

    }

    public void displayContent(){
        String[][] screen = new String[objectList.size()][headers.length];
        String[] line = new String[headers.length];
        for (int i=0; i<objectList.size(); i++){
            screen[i] = objectList.get(i).returnStringList();
        }
        System.out.println(FlipTable.of(this.headers, screen));
    }

}
