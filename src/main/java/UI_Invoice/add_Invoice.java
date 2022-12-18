package UI_Invoice;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class add_Invoice extends JDialog {
    private JLabel dateLabel;
    private JButton ok;
    private JButton cancel;
    private JTextField clientName;
    private JTextField Date;
    private JLabel clientNameLabel;
    public JTextField getCustomerName() {
        return clientName;
    }

    public JTextField getInvoiceDate() {
        return Date;
    }

    public add_Invoice(GUI frame) {
        clientNameLabel= new JLabel("Client Name:");
        clientName = new JTextField(30);
        dateLabel = new JLabel("Date:");
        Date = new JTextField(30);
        getContentPane().setBackground(Color.white);
        ok= new JButton("OK");
        cancel = new JButton("Cancel");
        ok.setActionCommand("createInvoice");
        cancel.setActionCommand("cancelInvoice");
        ok.addActionListener(frame.getController());
        cancel.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 4));
        add(clientNameLabel);
        add(clientName);
        add(dateLabel);
        add(Date);
        add(ok);
        add(cancel);


        pack();


    }


}
