
package ergasia;

import java.util.Arrays;

public class Fill {

  
  protected int Match=0;
  protected int Delete=0;
  protected int Insert=0;   
  protected int[][] F;
   
  int i, j;
  
  
  public Fill (String seq1 , String seq2 , int gp , Pam S)
  {
        
        int L1 = seq1.length() ;
        int L2 = seq2.length() ;
 
                      F = new int [L1][L2];

                      F[0][0] = 0;
                      for (i=1; i<L1; i++)	F[i][0] = i*gp;
                      for (j=1; j<L2; j++)	F[0][j] = j*gp;

              for (j=1; j<L2; j++)
              {
                      for (i=1; i<L1; i++)
                      {
                        Match=F[i-1][j-1] + S.getScore(i,j, seq1, seq2);

                        //S(Ai, Bj);//edw prepei na kalesw mia methodo pam poy na exei to arxeio ayto 
                      
                        
                        Delete= F[i-1][j] + gp;
                        Insert=F[i][j-1] + gp;
                        F[i][j]=  max(Match, Insert, Delete);
                       }
                }
              
             // System.out.println(Arrays.deepToString(F));
}

    
    

   private int max(int Match, int Insert, int Delete) {
       int max=0;
       if((Match > Insert) && (Match> Delete))
       {
           max=Match;
       }
       if(( Insert>Match ) && (Insert> Delete))
       {
           max=Insert;
       }
       if(( Delete>Match ) && (Delete> Insert))
       {
           max=Delete;
       }
       return max;
       
    }
   
   
   
   public int[][] getScore()
   {
       return F;
   }
   
   
}





  
  
  



