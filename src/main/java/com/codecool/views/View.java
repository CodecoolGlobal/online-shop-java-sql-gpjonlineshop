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
        for (int i=0; i<objectList.size(); i++){
            String[] line = objectList.get(i).returnStringList();
            for (int j=0; j<headers.length; j++) {
                if (line[j]!=null) screen[i][j] = line[j];
                else screen[i][j] = "null";
            }
        }

        System.out.println(FlipTable.of(this.headers, screen));
    }
}
