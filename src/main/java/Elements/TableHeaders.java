package Elements;

import java.util.ArrayList;

public class TableHeaders {
   private int number;
   private String date;
   private String name;
   private ArrayList<TableItems> tableItems;



    public double getTotalCost(){
        double Cost=0.0;
        for(TableItems tableItems : getItems()){
            Cost= Cost + tableItems.getTotalLines();
        }
        return Cost;
    }

    public ArrayList<TableItems> getItems() {
        if(tableItems ==null){
            tableItems =new ArrayList();
        }
        return tableItems;
    }
    public TableHeaders(int number, String name, String date) {
        this.number = number;
        this.name = name;
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "Header{" + "number=" + number + ", date=" + date + ", name=" + name  + ", items=" + tableItems + '}';
    }

    public int getNumber() {
        return number;
    }
   public String getInvoicesFromTable(){
       return number + "," + date + "," + name ;
   }

}
