package Elements;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvoiceTable extends AbstractTableModel {

    private ArrayList<TableHeaders> invoices;
    private String[] columns = {"Number", "Date", "Client", "Total"};


    @Override
    public Object getValueAt(int indexRow, int indexColumn) {

        TableHeaders Inv = invoices.get(indexRow);
        switch(indexColumn){
            case 0:
                return Inv.getNumber();
                
            case 1:
                return Inv.getDate();
                
            case 2:
                return Inv.getName();
                
            case 3: 
                return Inv.getTotalCost();
            
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }
    public InvoiceTable(ArrayList<TableHeaders> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }


}
