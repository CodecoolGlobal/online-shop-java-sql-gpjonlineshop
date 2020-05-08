package com.codecool.views;

import com.codecool.models.Displayable;
import com.jakewharton.fliptables.FlipTable;
import java.util.ArrayList;
import java.util.List;

public class View {
    private String[] commandHeaders;
    private String[] querryHeaders;
    private String[] basketHeaders;
    private List<Displayable> querryList;
    private List<Displayable> commaandList;
    private List<Displayable> basketList;

    public View(){
        this.commandHeaders = new String[]{"Key:", "Action:"};
        this.basketHeaders = new String[]{"Id", "Name", "Price", "Ammount", "Category"};
        this.querryHeaders = new String[]{"Id", "Name", "Price", "Ammount", "Category"};
        this.basketList = new ArrayList<>();
        this.querryList = new ArrayList<>();
        this.commaandList = new ArrayList<>();
    }

    public void setQuerryList(List<Displayable> querryList) {
        this.querryList = querryList;
    }
    public void setQuerryHeaders(String[] querryHeaders) {
        this.querryHeaders = querryHeaders;
    }
    public void setCommaandList(List<Displayable> commaandList) {
        this.commaandList = commaandList;
    }
    public void setBasketList(List<Displayable> basketList) { this.basketList = basketList; }

    public void displayContent() {
        String[] superHeader = {"Actions", "Output", "Basket"};
        String[][] contentContainers = {{displayTertion(commandHeaders, commaandList) ,displayTertion(querryHeaders, querryList) , displayTertion(basketHeaders, basketList)}};
        System.out.println(FlipTable.of(superHeader, contentContainers));
    }

    public String displayTertion(String[] headers, List<Displayable> rowList){
        if (rowList.isEmpty()) return "";
        String[][] screen = new String[rowList.size()][headers.length];

        for (int i=0; i<rowList.size(); i++){
            String[] line = rowList.get(i).returnStringList();
            for (int j=0; j<headers.length; j++) {
                if (line[j]!=null) screen[i][j] = line[j];
                else screen[i][j] = "null";
            }
        }
        return FlipTable.of(headers, screen);
    }
}
