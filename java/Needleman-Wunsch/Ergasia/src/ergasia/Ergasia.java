
package ergasia;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;


public class Ergasia 
{

    
    public static void main(String[] args) throws IOException
    {     
           System.out.println("To use the defult files and test this program you should type: ");
           System.out.println(" query.txt , for the first protein and ");
           System.out.println(" target.txt , for the second fasta file.");
           System.out.println("use your files insted of these to run.");
           System.out.println("The results is always saved to a file named results.txt");
           
            
           //Create PAM
           Pam s = new Pam();
           
           //create the two sequenses
           Seq r1 = new Seq();
           String query = r1.papar();
           Seq r2 = new Seq();
           String target = r2.papar();
          
           //fill matrix for given sequence (through PAM)
           Fill test = new Fill(query , target, -8, s);
            
           //get the previous matrix
           int[][] matrixed = test.getScore();
           // System.out.print(Arrays.deepToString(matrixed));
           
           //get the best path
           Backward back;
           back = new Backward(query , target, matrixed);
           
           //get sequense for previous path
           String aa = back.getAligment1();
           String bb = back.getAligment2();
           //System.out.println(back.getAligment1());
           
           System.out.println( aa );
           System.out.println( bb );
           
           
           
           //write results to logfile (txt)
           PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
   
           String cc = bb;
           if ( aa.length() < bb.length()) {cc=bb;}
           
          
           int k=0;
           int platos =80;
           
           int poses = ( cc.length() ) /platos;
           System.out.println(poses);
           
           for(int j=0; j<=poses;j++)
           {    
            if ( poses == j )
            {
                writer.println( r1.getDesc() );
                writer.println( aa.substring(platos*k) );
                writer.println( bb.substring(platos*k) );
                writer.println( r2.getDesc() );
            }
            else 
            {
            
                writer.println( aa.substring(platos*k, platos*(k+1)) );
                writer.println( bb.substring(platos*k, platos*(k+1)) );
                writer.println( " " );
            }
            
                 k++;
           }   
           
           writer.close();
           
           
    }
    
}
