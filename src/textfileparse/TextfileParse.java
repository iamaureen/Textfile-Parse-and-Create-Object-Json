/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileparse;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Ishrat
 */
public class TextfileParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // create ArrayList to store the book information
        List<book> bookInfo = new ArrayList<>();
        try {
            
            FileInputStream fstream = new FileInputStream("input.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();;
            while (line!= null)   {
                
                  String[] parts = line.split(",|:");
                  String title = parts[0];
                  String author = parts[1];
                  String borrower = parts[2];
                  String date = parts[3];
                  
                  book bookObj = new book(title, author, borrower, date);
                  bookInfo.add(bookObj);                      
                
                  line = br.readLine();
                 
                }
            
            in.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
        // display booklist
        for (book b : bookInfo)
        {
            System.out.println("====================");
            System.out.println(b);
            JOptionPane.showMessageDialog(null, b);
            System.out.println();
        }
        
        createJson(bookInfo);
         System.out.println("=======reading from json file and transforming into object=============");
        readJson();
    }

    private static void createJson(List<book> bookInfo) throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       mapper.writeValue(new File("bookInfo.json"), bookInfo);
    }

    private static void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        List<book> bookInfo = Arrays.asList(mapper.readValue(new File("bookInfo.json"),  book[].class));
        for (book b : bookInfo)
        {
            System.out.println("====================");
            System.out.println(b);
            JOptionPane.showMessageDialog(null, b);
            System.out.println();
        }
    }

}
 
