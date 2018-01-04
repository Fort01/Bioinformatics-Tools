
package ergasia;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Pam {
    
    public static int[][] multi = new int[21][21];    
    String alfabitika = "ARNDCQEGHILKMFPSTWYV";
         
    public int getScore(int i, int j, String seq1, String seq2)
       {
           int x,y ;
           
          y = getColum ( seq1.charAt(i-1));
          x = getColum ( seq2.charAt(j-1));
           
           return multi[x][y];
           
       }   
           
           
        
       public Pam() throws FileNotFoundException {
        
        Scanner sc = new Scanner(new File("PAM.txt"));
        
        for (int i=0 ;i<21; i++)
            {
                for (int j=0;j<21 ; j++)
                {
                   
                    multi [i][j] = sc.nextInt();}
                }
               
            }
       
        
        private int getColum( char a)
        {
            for( int i = 0 ; i < alfabitika.length() ; i++ )
            {
                if ( (alfabitika.charAt(i) == a)  )
                {
                   // System.out.println(i);
                    return i;
                    
                }
            }
            return 1;
        }
 
       
}
            
            
       //System.out.print(Arrays.deepToString(multi));

    



