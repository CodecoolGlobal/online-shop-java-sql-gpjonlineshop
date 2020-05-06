package com.codecool.views;

import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;

// pozniej bedzie abstrack  abstract //

public class View {
    String[][] screen;

    public View(){

    }

    public void displayContent(String[][] screen, String[] headers){
        String[][] data =  screen;
        System.out.println(FlipTable.of(headers, data));
    }

}
