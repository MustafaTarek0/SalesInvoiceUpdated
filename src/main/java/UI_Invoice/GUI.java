package UI_Invoice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Actions.InvoiceActions;
import Actions.TableElements;
import Elements.FileOperations;
import Elements.InvoiceTable;
import Elements.TableHeaders;

import javax.swing.JTable;




public class GUI extends JFrame{


    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JMenu MenuBar;
    private javax.swing.JMenuItem OpenMenuItem;
    private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JButton newInvoiceButton;
    private javax.swing.JButton newLineButton;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel TotalCost;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCustomerName;
    private javax.swing.JLabel labelInvoiceDate;
    private javax.swing.JLabel labelInvoiceNum;
    private javax.swing.JLabel labelTotalCost;
    private javax.swing.JTable tableInvoiceHeader;
    private javax.swing.JTable tableInvoiceLines;
    private InvoiceActions controller = new InvoiceActions( this);
    private TableElements tableAction = new TableElements(this);

    private ArrayList<TableHeaders> invoicesList;



    public GUI() throws InterruptedException {
        super (" Sales Invoice");
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoiceHeader = new javax.swing.JTable();
        tableInvoiceHeader.getSelectionModel().addListSelectionListener(tableAction);
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInvoiceLines = new javax.swing.JTable();
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        TotalCost = new javax.swing.JLabel();
        labelCustomerName = new javax.swing.JLabel();
        labelTotalCost = new javax.swing.JLabel();
        labelInvoiceDate = new javax.swing.JLabel();
        labelInvoiceNum = new javax.swing.JLabel();
        newInvoiceButton = new javax.swing.JButton();
        newInvoiceButton.addActionListener(controller);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(controller);
        newLineButton = new javax.swing.JButton();
        newLineButton.addActionListener(controller);
        deleteLineButton = new javax.swing.JButton();
        deleteLineButton.addActionListener(controller);
        JMenuBar = new javax.swing.JMenuBar();
        MenuBar = new javax.swing.JMenu();
        OpenMenuItem = new javax.swing.JMenuItem();
        OpenMenuItem.addActionListener(controller);
        SaveMenuItem = new javax.swing.JMenuItem();
        SaveMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableInvoiceHeader.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceHeader.setShowGrid(true);
        jScrollPane1.setViewportView(tableInvoiceHeader);

        tableInvoiceLines.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceLines.setShowGrid(true);
        jScrollPane2.setViewportView(tableInvoiceLines);
        tableInvoiceLines.getAccessibleContext().setAccessibleName("");

        invoiceNumber.setText("Invoice No:");

        invoiceDate.setText("Invoice Date:");

        clientName.setText("Client Name:");

        TotalCost.setText("Total Cost:");

        labelCustomerName.setText("-");

        labelTotalCost.setText("-");

        labelInvoiceDate.setText("-");

        labelInvoiceNum.setText("-");

        newInvoiceButton.setText("Create Invoice");

        deleteInvoiceButton.setText("Delete Invoice");

        newLineButton.setText("Create Line");

        deleteLineButton.setText("Cancel line");

        MenuBar.setText("File");

        OpenMenuItem.setText("Load File");
        OpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        MenuBar.add(OpenMenuItem);

        SaveMenuItem.setText("Save File");
        MenuBar.add(SaveMenuItem);

        JMenuBar.add(MenuBar);

        setJMenuBar(JMenuBar);
        JMenuBar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(invoiceNumber))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(TotalCost)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(labelTotalCost))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(clientName)
                                                                                        .addComponent(invoiceDate))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(labelInvoiceDate)
                                                                                        .addComponent(labelCustomerName)
                                                                                        .addComponent(labelInvoiceNum)))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(newInvoiceButton)
                                                .addGap(37, 37, 37)
                                                .addComponent(deleteInvoiceButton)
                                                .addGap(68, 68, 68)
                                                .addComponent(newLineButton)
                                                .addGap(118, 118, 118)
                                                .addComponent(deleteLineButton)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceNumber)
                                                        .addComponent(labelInvoiceNum))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceDate)
                                                        .addComponent(labelInvoiceDate))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(clientName)
                                                        .addComponent(labelCustomerName))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TotalCost)
                                                        .addComponent(labelTotalCost))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newInvoiceButton)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(deleteInvoiceButton)
                                                .addComponent(newLineButton)
                                                .addComponent(deleteLineButton)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );


        invoiceDate.getAccessibleContext().setAccessibleName("jLabel2");

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }






    public JLabel getLabelInvoiceDate() {
        return labelInvoiceDate;
    }

    public InvoiceActions getController() {
        return controller;
    }



    public JLabel getLabelInvoiceNum() {
        return labelInvoiceNum;
    }




    private InvoiceTable headerTable;

    public InvoiceTable getHeaderTable() {
        return headerTable;
    }
    public void setHeaderTable(InvoiceTable headerTable){
        this.headerTable= headerTable;
    }

    public ArrayList<TableHeaders> getInvoicesList(){
        if(invoicesList==null){
            invoicesList= new ArrayList<>();
        }
        return invoicesList;
    }

    public void setInvoices(ArrayList<TableHeaders> invoices) {
        this.invoicesList= invoices;
    }


    public void executeUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI frame= null;
                try {
                    frame = new GUI();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                frame.setVisible(true);
                FileOperations fileOperations = new FileOperations(frame);
                ArrayList<TableHeaders> inv= fileOperations.ReadFile();
                frame.setInvoices(inv);
                InvoiceTable invoiceTable = new InvoiceTable(inv);
                frame.setHeaderTable(invoiceTable);
                frame.getTableInvoiceHeader().setModel(invoiceTable);
                frame.getHeaderTable().fireTableDataChanged();

            }
        });
    }

    public JLabel getLabelCustomerName() {
        return labelCustomerName;
    }

    public JLabel getLabelTotalCost() {
        return labelTotalCost;
    }

    public JTable getTableInvoiceHeader() {
        return tableInvoiceHeader;
    }

    public JTable getTableInvoiceLines() {
        return tableInvoiceLines;
    }
    public int getTotalInvoicesNumbers(){
        int num=0;
        for(TableHeaders invoice: invoicesList){
            if(invoice.getNumber()>num){
                num= invoice.getNumber();
            }
        }

        return num;
    }
}


