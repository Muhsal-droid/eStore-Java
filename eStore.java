/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package eStoreSearch;
import java.util.Scanner;
import java.util.*;

public class eStore{
/**
 * 
 * @param args taking in input to compare the what options the user wants
 */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        int i = 0;
        int out= 0;
        //Array list for storing the made books and electronics
        ArrayList <Book> BookList = new ArrayList<Book>();
        ArrayList <Electronics> electronicsList = new ArrayList<Electronics>();
        //Array list for searches
        ArrayList <EStoreSearch> searchList = new ArrayList<EStoreSearch>();
        String arg1,arg2 ;
        int out2 = 0;
        do {
            System.out.println("Choose the option you want for eStoreSearch : add  ,  search  ,  quit .");
            arg1 = keyboard.nextLine();
            if (arg1.equals("add")){
                System.out.println("For adding : "+"\n"+"(1) type (Book) or (b) for adding book "+"\n"+"(2) type (electronic) or (e) for adding electronic"+"\n"+"(3) type (back) for previous option");
                arg2 = keyboard2.nextLine();
              
                    if(arg2.equalsIgnoreCase("Book") || arg2.equalsIgnoreCase("b")){
                        /*add Book here*/ 
                        Book retBook = new Book();
                        BookList.add(retBook);
                        // detection for duplicate when adding
                        for ( i = 0; i < BookList.size(); i++) {
                            for (int j = i + 1 ; j < BookList.size() && j < electronicsList.size(); j++) { 
                                if (BookList.get(i).getproductid().equalsIgnoreCase(BookList.get(j).getproductid())) { 
                                    //removes the duplicate entered
                                    BookList.remove(j);
                                    System.out.println( "\n" + "Duplicate product id found : add rejected " + "\n" );
                                }
                            }
                        } 
                        // new way here to delete the duplicate when compared the array to book list
                        for(i=0;i<BookList.size();i++){
                            for(int j =0; j <electronicsList.size();j++){
                                if(BookList.get(i).getproductid().equalsIgnoreCase(electronicsList.get(j).getproductid())){
                                    BookList.remove(j);
                                System.out.println( "\n" + "Duplicate product id found : add rejected " + "\n" );
                                }

                            }
                        }                        
                    } else if (arg2.equalsIgnoreCase("electronic")|| arg2.equalsIgnoreCase("e")){
                        /* add electronic here */
                        Electronics retElec = new Electronics();
                        electronicsList.add(retElec);  
                        // detection for duplicate when adding
                        for ( i = 0; i < electronicsList.size(); i++) {
                            for (int j = i + 1 ; j < electronicsList.size() && j <BookList.size() ; j++) { 
                            if (electronicsList.get(i).getproductid().equalsIgnoreCase(electronicsList.get(j).getproductid()) ) { 
                                electronicsList.remove(j);
                                System.out.println( "\n" + "Duplicate product id found : add rejected " + "\n" );
                                }
                            }
                        }
                        // new way here to delete the duplicate when compared the array to book list
                        for(i=0;i<electronicsList.size();i++){
                            for(int j =0; j <BookList.size();j++){
                                if(electronicsList.get(i).getproductid().equalsIgnoreCase(BookList.get(j).getproductid())){
                                    electronicsList.remove(j);
                                System.out.println( "\n" + "Duplicate product id found : add rejected " + "\n" );
                                }

                            }
                        }
                    }
            }else if (arg1.equals("search")){
                // if we want to store then make an add for storing the result for searches  
                EStoreSearch system = new EStoreSearch(BookList,electronicsList);
                searchList.add(system);

            }else if (arg1.equalsIgnoreCase("quit") || arg1.equalsIgnoreCase("q")){
                out = 1;
            }
            i++;
        } while (out != 1);
        // the loop ends here and so does the program
        
    }
}