package Actions;


import Elements.FileOperations;
import Elements.InvoiceTable;
import Elements.LineTable;
import Elements.TableHeaders;
import Elements.TableItems;
import UI_Invoice.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import UI_Invoice.add_Invoice;
import UI_Invoice.add_Line;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InvoiceActions implements ActionListener, ListSelectionListener {

    private GUI UI;
    private add_Invoice addInvoice;
    private add_Line addItem;

    public InvoiceActions(GUI UI) {
        this.UI = UI;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Create Invoice":
                CreateInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Create Line":
                CreateLine();
                break;
            case "Cancel line":
                CancelLine();
                break;
            case "createInvoice":
                addInvoice();
                break;
            case "cancelInvoice":
                cancelInvoice();
                break;
            case "createLine":
                createLine();
                break;


            case "Open File":

                UI.setInvoices(null);
                FileOperations Actions = new FileOperations(UI);
                ArrayList<TableHeaders> inv= Actions.ReadFile();
                UI.setInvoices(inv);
                InvoiceTable invoiceTable = new InvoiceTable(inv);
                UI.setHeaderTable(invoiceTable);
                UI.getTableInvoiceHeader().setModel(invoiceTable);
                UI.getHeaderTable().fireTableDataChanged();
                break;

            case "Save File":
                FileOperations Actions1 = new FileOperations(UI);
                Actions1.saveFile(UI.getInvoicesList());
                break;


        }
    }

    private void CancelLine() {
        int invoiceSelected= UI.getTableInvoiceHeader().getSelectedRow();
        int row = UI.getTableInvoiceLines().getSelectedRow();
        if((invoiceSelected!=-1) && (row!= -1)){
            TableHeaders invoice = UI.getInvoicesList().get(invoiceSelected);
            invoice.getItems().remove(row);
            UI.getHeaderTable().fireTableDataChanged();
            LineTable line = new LineTable(invoice.getItems());
            UI.getTableInvoiceLines().setModel(line);
            line.fireTableDataChanged();
        }
    }



    private void CreateLine() {
        addItem = new add_Line(UI);
        addItem.setVisible(true);
    }
    private void deleteInvoice() {
        int row = UI.getTableInvoiceHeader().getSelectedRow();
        if(row!= -1){
            UI.getInvoicesList().remove(row);
            UI.getHeaderTable().fireTableDataChanged();

        }
    }

    public void addInvoice() {
        String date= addInvoice.getInvoiceDate().getText();
        String customer = addInvoice.getCustomerName().getText();
        int number= UI.getTotalInvoicesNumbers();
        number++;
        TableHeaders newInvoice = new TableHeaders(number,customer,date);
        UI.getInvoicesList().add(newInvoice);
        UI.getHeaderTable().fireTableDataChanged();
        addInvoice.setVisible(false);
        addInvoice.dispose();
        addInvoice=null;

    }
    private void CreateInvoice() {
        addInvoice = new add_Invoice(UI);
        addInvoice.setVisible(true);

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    private void cancelInvoice() {
        addInvoice.setVisible(false);
        addInvoice.dispose();
        addInvoice=null;
    }

    private void createLine() {

        int invoiceSelected= UI.getTableInvoiceHeader().getSelectedRow();
        if(invoiceSelected!=-1){
            TableHeaders invoice = UI.getInvoicesList().get(invoiceSelected);
            String item= addItem.getItemName().getText();
            String unitPrice = addItem.getUnitPrice().getText();
            String quantity = addItem.getQuantity().getText();
            double itemUnitPrice = Double.parseDouble(unitPrice);
            int itemQuantity = Integer.parseInt(quantity);
            TableItems newLine = new TableItems(item,itemQuantity,itemUnitPrice,invoice);
            invoice.getItems().add(newLine);
            LineTable line = new LineTable(invoice.getItems());
            UI.getHeaderTable().fireTableDataChanged();
            UI.getTableInvoiceLines().setModel(line);
            line.fireTableDataChanged();

        }
        addItem.setVisible(false);
        addItem.dispose();
        addItem=null;

    }

}



