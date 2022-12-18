package Actions;

import UI_Invoice.GUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Elements.LineTable;
import Elements.TableHeaders;
import Elements.TableItems;
import java.util.ArrayList;


public class TableElements implements ListSelectionListener {
    private GUI UI;

    public TableElements(GUI frame) {
        this.UI = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int invoiceIndex = UI.getTableInvoiceHeader().getSelectedRow();
        if(invoiceIndex!= -1){
            TableHeaders Row = UI.getInvoicesList().get(invoiceIndex);
            ArrayList<TableItems> tableItems = Row.getItems();
            UI.getLabelCustomerName().setText(Row.getName());
            UI.getLabelInvoiceNum().setText(""+Row.getNumber());
            UI.getLabelInvoiceDate().setText(Row.getDate());
            UI.getLabelTotalCost().setText(""+Row.getTotalCost());
            LineTable lineTable = new LineTable(tableItems);
            UI.getTableInvoiceLines().setModel(lineTable);
            lineTable.fireTableDataChanged();

        }
    }

}
