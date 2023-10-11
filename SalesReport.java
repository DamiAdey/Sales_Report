// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

/*
Write a program that reads the sales amount in millions for 10 division (row) 
for all 12 months (col) of the year for a XYZ Company. 
*/

import java.util.Scanner;  // Needed for the Scanner class.
import java.io.*;         // Needed for the File class.

public class SalesReport 
{
   
   public static void main(String[] args) throws IOException // Executes methods.
   { 
      int n = 0;
      int division;
   
      double[][] salesFigures = salesFigures();  
      
      double totalSalesForYear = totalSalesForYear(salesFigures);
      averageSalesForYear(salesFigures, totalSalesForYear);
      
      totalSalesPerDivision(salesFigures);
      totalSalesPerMonth(salesFigures);
      
      averageSalesPerDivision(salesFigures);      
      averageSalesPerMonth(salesFigures);
     
      System.out.println("\nThe divisions with the highest and lowest sales for the year:"); 
      divisionHighestSales(salesFigures);
      divisionLowestSales(salesFigures);
      
      System.out.println("\nThe months with the highest and lowest sales for the year:");
      monthHighestSales(salesFigures);
      monthLowestSales(salesFigures);
   }
   
   
   // Method for reading file.
   private static double[][] salesFigures() throws IOException 
   {
      double[][] salesPerMonth = new double[10][12];
   
      // Creates a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
   
      // Gets the filename.
      System.out.print("Enter the filename: ");
      String filename = keyboard.nextLine();
   
      // Opens the file.
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
     
      System.out.println();
   
      for (int row = 0; row < salesPerMonth.length; row++)
      {      
         for (int column = 0; column < salesPerMonth[row].length; column++)
         {       
            String sales = inputFile.nextLine();
            
            double salesFigures = Double.parseDouble(sales);
            salesPerMonth[row][column] = salesFigures;
                          
            System.out.printf("%9s",sales);
         }
         
         System.out.println();
      }
      
      // Closes the file.
      inputFile.close();
      return salesPerMonth;
   }
   
   
   // This method calculates the total sales for the year. 
   private static double totalSalesForYear(double[][] salesFigures)
   {  
      double total = 0;
      for (int row = 0; row < salesFigures.length; row++)
      {
         for (int column = 0; column < salesFigures[row].length; column++)
            total = salesFigures[row][column] + total;
      }
      
      System.out.printf("\n\nThe total sales for the year is $%.2f million.", total);        
      return total;
   }
   
   
   // This method calculates the average sales for the year.
   private static double averageSalesForYear(double[][] salesFigures, double totalSalesForYear)
   {
      double averageSalesForYear = totalSalesForYear / 120;
   
      System.out.printf("\nThe average sales for the year is $%.2f million.", averageSalesForYear);
      System.out.println();
      return averageSalesForYear;
   }
   
   
   // This method calculates the total sales for each division.
   private static double totalSalesPerDivision(double[][] salesFigures)
   {
      double totalSalesForDivision = 0;
      System.out.println("\n\nThe total sales for each division: ");
      
      for (int row = 0; row < salesFigures.length; row++)
      {      
         for (int column = 0; column < salesFigures[row].length; column++)
            totalSalesForDivision = salesFigures[row][column] + totalSalesForDivision;
        
         int division = row + 1;
         System.out.printf("\nThe total sales for Division "+ division +" is $%.2f million.", totalSalesForDivision);
      } 
      
      System.out.println();
      return totalSalesForDivision;
   } 
   

   // This method calculates the total sales for each month.
   private static double totalSalesPerMonth(double[][] salesFigures)
   {
      double totalSalesForMonth = 0;
      System.out.println("\n\nThe total sales for each month: ");
      
      for (int column = 0; column < 12; column++)
      {
         totalSalesForMonth = 0;
         String[] months = {"January","February","March","April","May","June","July","August", "September","October","Novermber", "December" };     
      
         for (int row = 0; row < salesFigures.length; row++)
            totalSalesForMonth += salesFigures[row][column];
               
         System.out.print("\nThe total sales for " + months[column]);               
         System.out.printf(" is $%.2f million.", totalSalesForMonth);
      }
      
      System.out.println();
      return totalSalesForMonth;
   }
   
   
   // This method calculates the average sales for each division.      
   private static double averageSalesPerDivision(double[][] salesFigures)
   {
      double averageSalesPerDivision = 0;
      double totalSalesForDivision = 0; 
      System.out.println();
      System.out.println("\nThe average sales for each division: \n");
      
      for (int row = 0; row < salesFigures.length; row++)
      {
         for (int column = 0; column < salesFigures[row].length; column++)
            totalSalesForDivision = salesFigures[row][column] + totalSalesForDivision;
         
         int division = row + 1;
         averageSalesPerDivision = totalSalesForDivision / salesFigures.length-1;  
         System.out.printf("The average sales for division " + division + " is $%.2f million.",  averageSalesPerDivision);
         System.out.println();
      } 
      
      System.out.println();
      return averageSalesPerDivision;
   }
  
  
   // This method calculates the average sales for each month.      
   private static double averageSalesPerMonth(double[][] salesFigures)
   {
      double totalSalesForMonth = 0;
      double averageSalesPerMonth = 0; 
      System.out.print("\nThe average sales for each month: \n");
    
      for (int column = 0; column < 12; column++)
      {
         totalSalesForMonth = 0;
         String[] months = {"January","February","March","April","May","June","July","August", "September","October","Novermber", "December" };     
      
         for (int row = 0; row < salesFigures.length; row++)
            totalSalesForMonth += salesFigures[row][column];
            
         averageSalesPerMonth = totalSalesForMonth/ 12;
         System.out.print("\nThe average sales for " + months[column]);      
         System.out.printf(" is $%.2f million.", averageSalesPerMonth);
      }
      
      System.out.println();
      return averageSalesPerMonth;
   }

   
   // This method gets the highest sales for the year. 
   private static int divisionHighestSales(double[][] salesFigures)
   {         
      double n = 0; 
      int i = 0 ;
   
      for (int row = 0; row < salesFigures.length; row++)
      {      
         for (int column = 0; column < salesFigures[row].length; column++)
         {
            if (salesFigures[row][column] > n)
            {
               n = salesFigures[row][column];
               i = row; // To store division number.
            }
         }
      }
      
      System.out.println("Highest sales for the year is in Division " + i + ".");  
      return i;
   }


   // This method gets the lowest sales for the division.  
   private static int divisionLowestSales(double[][] salesFigures)
   {
      double n = 1000; 
      int i = 0;
   
      for (int row = 0; row < salesFigures.length; row++)
      {      
         for (int column = 0; column < salesFigures[row].length; column++)
         {
            if (salesFigures[row][column] < n)
            {
               n = salesFigures[row][column];
               i = row; // To store division number.
            }
         }
      }
      
      System.out.println("Lowest sales for the year is in Division " + i + ".");  
      return i;
   }    
   
   
   // This method gets the highest sales for the month.  
   private static double monthHighestSales(double[][] salesFigures) 
   {
      double n = 0; 
      int i = 0; 
      String[] months = {"January","February","March","April","May","June","July","August", "September","October","Novermber", "December" };     
       
      for (int row = 0; row < salesFigures.length; row++)
      {
         for (int column = 0; column < salesFigures[row].length; column++)
         {
            if (salesFigures[row][column] > n)
            {
               n = salesFigures[row][column];
               i = column; // To store division number.
            }
               
         } 
      }
              
      System.out.print("The month of " + months[i]);               
      System.out.println(" has the highest sales.");
      return i;
   }
   
   
   // This method gets the lowest sales for the month.  
   private static int monthLowestSales(double[][] salesFigures)
   {
      double n = 1000; 
      int i = 0; 
      String[] months = {"January","February","March","April","May","June","July","August", "September","October","Novermber", "December" };     
   
      for (int row = 0; row < salesFigures.length; row++)
      {
         for (int column = 0; column < salesFigures[row].length; column++)
         {
            if (salesFigures[row][column] < n)
            {
               n = salesFigures[row][column];
               i = column; // To store division number.
            }
               
         } 
      }
              
      System.out.print("The month of " + months[i]);      
      System.out.println(" has the lowest sales.");
      return i;
   } 
   
   
}