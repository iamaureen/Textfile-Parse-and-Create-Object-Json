/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileparse;

/**
 *
 * @author Ishrat
 */
public class book {
    String title;
    String author;
    String borrower;
    String date;
    
    //this constructor was added for deserialization of the json array
    public book(){} 

    public book(String title, String author, String borrower, String date) {
        this.title = title;
        this.author = author;
        this.borrower = borrower;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    //Returns a string representation of the object.
    public String toString()
    {
        return "Title: " + title + "\n" + "Author: " + author + "\n"  + "Borrower: " + borrower + "\n" + "Borrowed Date: " + date;
    }
}
