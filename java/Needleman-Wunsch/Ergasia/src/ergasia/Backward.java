
package ergasia;

public class Backward {
    
    private String AlignmentA = "";
    private String AlignmentB = "";
    private final int d;
    
    Backward(String seq1, String seq2, int F[][])
    {
        this.d = -8;
        int i = seq1.length() - 1;
        int j = seq2.length() - 1;
        
            while ((i > 0) || (j > 0))
            {
                              
              if ((j > 0) && (F[i][j] == F[i][j-1] + d) )
              {
                   AlignmentA = "-" + AlignmentA;
                AlignmentB = seq2.charAt(j) + AlignmentB;
                j = j - 1;
                
              }
              else if ( (i > 0) && (F[i][j] == F[i-1][j] + d) )
              {
                AlignmentA = seq1.charAt(i) + AlignmentA;
                AlignmentB = "-" + AlignmentB;
                i = i - 1;
              }
              else //S[ai][bj]))
              {
               AlignmentA += seq1.charAt(i);
                AlignmentB += seq2.charAt(j);
                i = i - 1;
                j = j - 1;
              }
                     
            }
    }
    
    
    
    public String getAligment1()
            {
                return AlignmentA;
            }

    public String getAligment2()
            {
                return AlignmentB;
            }
}
