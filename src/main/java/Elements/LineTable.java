

package Elements;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LineTable extends AbstractTableModel {

    private String[] columns = {"Number", "Item", "Unit Price", "Quantity", "Total"};
    private ArrayList<TableItems> tableElements;

    public LineTable(ArrayList<TableItems> tableItems) {
        this.tableElements = tableItems;
    }

    @Override
    public int getRowCount() {
        return tableElements.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableItems tableItems = this.tableElements.get(rowIndex);
        switch(columnIndex){
            case 0:
                return tableItems.getInvoice().getNumber();
                
            case 1:
                return tableItems.getItemName();
                
            case 2:
                return tableItems.getUnitPrice();
                
            case 3: 
                return tableItems.getQuantity();
            
            case 4: 
                return tableItems.getTotalLines();
            
        }
        
        return null;

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
