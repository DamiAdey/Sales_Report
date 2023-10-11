// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

/*
Write a program that reads the sales amount in millions for 10 division (row) 
for all 12 months (col) of the year for a XYZ Company. 
*/

import java.util.Scanner;  // Needed for the Scanner class.
import java.io.*;         // Needed for the File class.

public class SalesFigures 
{
   public static void main(String[] args) // Executes methods.
   {
      double[] A = new double[120];  
   
      for (int i = 0; i< A.length; i++)
      {
         A[i]= (double)(Math.random()*100);
         if (A[i] < 1)
            A[i]= (double)(Math.random()*100);
      
         System.out.printf("\n%.2f ", A[i]);  
      }  
   
   }
   
}