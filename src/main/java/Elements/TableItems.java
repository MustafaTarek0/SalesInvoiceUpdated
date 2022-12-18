package Elements;

public class TableItems {
    private TableHeaders invoice;
    private String itemName;
    private double unitPrice;
    private int quantity;



    public TableItems(String itemName, int quantity, double unitPrice, TableHeaders tableHeaders) {
        this.invoice= tableHeaders;
        this.quantity = quantity;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
     public double getTotalLines(){
        return unitPrice * quantity;
    }



    public TableHeaders getInvoice() {
        return invoice;
    }


    public int getQuantity() {
        return quantity;
    }


    public String getItemName() {
        return itemName;
    }


    public double getUnitPrice() {
        return unitPrice;
    }


    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
   public String getItemsFromTable(){
       return invoice.getNumber() + "," + itemName + "," + unitPrice + "," +quantity;
   }

   
    
}
