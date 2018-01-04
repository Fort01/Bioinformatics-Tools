
package ergasia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Seq {
    
    private String seqff ;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public String getSeqff() {
        return seqff;
    }
    
    
    
    public Seq( )
    {
      this.seqff="";
        
        
    }
    
    private String uniname()
    {
        System.out.println("Give Uniprot   <file name>   for the protein ");
        Scanner in = new Scanner( System.in );
        return in.next();
        
    }
    
    private String fname()
    {
        System.out.println("Give FASTA   <file name>   for the protein number");
        Scanner in = new Scanner( System.in );
        return in.next();
        
        
    }
    
    public  String papar()
    {
        String safe="";
        System.out.println("What type of file do you have?" );
        System.out.println("Press 1 for FASTA format or 2 for Uniprot format file");
        Scanner input =new Scanner( System.in);
        
        if (input.nextInt()== 1)
        {
            safe = getSeq();
        }
        else
        {
            safe =  getSeq2();
        }
        return safe;
    }    
     
    private  String getSeq()
    {
        try {
            
            Scanner sc = new Scanner( new  File ( fname() )  );
            
            desc = sc.nextLine();
            
            while ( sc.hasNext() )
            {
                seqff += sc.nextLine();
                //System.out.println(sc.nextLine().length());
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seq.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return seqff;
    }
    
    
        private  String getSeq2()
    {
        try {
            
            String fixme="";
            String line;
            Scanner scan = new Scanner( new  File ( uniname() )  );
            int br=0;      
            int k;
            
            while ( scan.hasNextLine() && br==0)
            {
                line = scan.nextLine();
                if( line.charAt(0)== 'S' && line.charAt(1)=='Q')
                    {   
                        desc=line;
                        br=1;
                        
                        while(scan.hasNext())
                        {
                            fixme += scan.nextLine();
                            
                            
                        }
                        System.out.println(fixme);
                        seqff = fixme.replaceAll(" ", "");
                        System.out.println("\n\n\n");
                        System.out.println(seqff);
                        
                        k=seqff.length()-2;
                        seqff = seqff.substring(0, k);
                             
                        System.out.println(seqff);
                    }
            }
            

        } catch (FileNotFoundException e) {
            Logger.getLogger(Seq.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return seqff;
    }
  



}
