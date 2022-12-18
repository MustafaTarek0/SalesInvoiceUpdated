
package Elements;

import UI_Invoice.GUI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileOperations {
    private GUI UI;
    public FileOperations(GUI UI) {
        this.UI = UI;
    }



    public void saveFile(ArrayList<TableHeaders> tableHeaders) {
        File headerF;
        File lineF;
        String invoices = "";
        String Item = "";
        int result;
        for(TableHeaders tableHeader : tableHeaders){
            String headerLines = tableHeader.getInvoicesFromTable();
            invoices=invoices+headerLines;
            invoices=invoices+"\n";

            for(TableItems tableItems : tableHeader.getItems()){
                String itemFile = tableItems.getItemsFromTable();
                Item = Item+itemFile;
                Item = Item+"\n";
            }
        }

        JOptionPane.showMessageDialog(UI, "Please select the Headers file then Lines file");
        JFileChooser f = new  JFileChooser();
        do{
            result = f.showSaveDialog(UI);
            if(result == JFileChooser.APPROVE_OPTION){
                headerF = f.getSelectedFile();
                if(headerF.getName().contains(".csv")){
                    FileWriter headFileWriter = null;
                    try {
                        headFileWriter = new FileWriter(headerF);
                        headFileWriter.write(invoices);
                        headFileWriter.flush();
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            headFileWriter.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else{
                    System.out.println("Wrong Lines File Format");
                    JOptionPane.showMessageDialog(UI, "Wrong Headers File Format");
                }
            }
        }while(true);


        do{
            result = f.showSaveDialog(UI);
            if(result == JFileChooser.APPROVE_OPTION){
                lineF= f.getSelectedFile();
                if(lineF.getName().contains(".csv")){
                    FileWriter lineFileWriter = null;
                    try {
                        lineFileWriter = new FileWriter(lineF);
                        lineFileWriter.write(Item);
                        lineFileWriter.flush();
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            lineFileWriter.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else{

                JOptionPane.showMessageDialog(UI, "Wrong Lines File Format");
            }
        }while(true);
    }
    public TableHeaders getInvByNumber(int num){

        for(TableHeaders inv : UI.getInvoicesList()){
            if(inv.getNumber()==num){
                return inv;
            }
        }
        return null;
    }



 public ArrayList<TableHeaders> ReadFile(){

        List<String> headerLines=null;
        String headerPath;
        String itemPath;
        List<String> itemLines=null;
        File headerFile ;
        File itemFile;
        int result;
        ArrayList<TableHeaders> invoiceArray = new ArrayList<>();
  
            JOptionPane.showMessageDialog(UI, "Select Headers File then Lines File");

            JFileChooser f = new JFileChooser();
            do{
               result = f.showOpenDialog(UI);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = f.getSelectedFile();
                if(headerFile.getName().contains(".csv")){
                    headerPath=headerFile.getAbsolutePath();
                    break;
                }
                else{
                    System.out.println("Wrong Headers File Format");
                    JOptionPane.showMessageDialog(UI, "Wrong Headers File Format please select the headers file again");
                }
            }
            }while(true);
            do{
                result = f.showOpenDialog(UI);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemFile = f.getSelectedFile();
                    if(itemFile.getName().contains(".csv")){
                        itemPath= itemFile.getAbsolutePath();
                        break;
                    }
                    else{
                        System.out.println("Wrong Items File Format");
                        JOptionPane.showMessageDialog(UI, "Wrong Items File Format");
                }

                }
            }while(true);

            System.out.println(headerPath);
            System.out.println(itemPath);


            try {
                headerLines = Files.lines(Paths.get(headerPath)).collect(Collectors.toList());
            } catch (IOException ex) {

                System.out.println("Wrong Headers File Path");
                JOptionPane.showMessageDialog(UI, "Wrong Headers File Path");
            }

                
            try {
                itemLines = Files.lines(Paths.get(itemPath)).collect(Collectors.toList());
            } catch (IOException ex) {
                System.out.println("Wrong Items File Path");
                 JOptionPane.showMessageDialog(UI, "Wrong Items File Path");
            }
            
               
                
                if(headerLines!=null && itemLines !=null){
                for (String headerLine : headerLines) {
                    String[] array = headerLine.split(",");
                    String numberString = array[0];
                    String date = array[1];
                    String clientName = array[2];
                    int number = Integer.parseInt(numberString);
                    TableHeaders invoice = new TableHeaders(number, clientName, date);
                    invoiceArray.add(invoice);
                    UI.getInvoicesList().add(invoice);
                   
                }
                for (String itemLine : itemLines) {
                    String[] arr = itemLine.split(",");
                    int number = Integer.parseInt(arr[0]);
                    String name1 = arr[1];
                    double unitPrice = Double.parseDouble(arr[2]);
                    int quantity = Integer.parseInt(arr[3]);
                    TableHeaders invoice=getInvByNumber(number);
                    TableItems line = new TableItems(name1,quantity,unitPrice,invoice);
                    invoice.getItems().add(line);

                }
                }

                return invoiceArray;
            }




}