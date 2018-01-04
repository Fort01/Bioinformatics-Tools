
package ch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ChouFasmanAlgorithm {
    private String sequence;
    private double[] helix;
    private double[] beta;
    private double[] turn;
    private double countHelix;
    private double countBeta;
    private double countTurn;

    public ChouFasmanAlgorithm(String seq)
    {
            this.sequence = seq;
    }
    public ChouFasmanAlgorithm()
    {
    }
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    public void setCountHelix(double countHelix) {
        this.countHelix = countHelix;
    }

    public void setCountBeta(double countBeta) {
        this.countBeta = countBeta;
    }

    public void setCountTurn(double countTurn) {
        this.countTurn = countTurn;
    }
    
    public void setHelix(double[] helix) {
        this.helix = helix;
    }

    public void setBeta(double[] beta) {
        this.beta = beta;
    }

    public void setTurn(double[] turn) {
        this.turn = turn;
    }

    public double[] getHelix() {
        return helix;
    }

    public double[] getBeta() {
        return beta;
    }

    public double[] getTurn() {
        return turn;
    }
    public double getCountHelix() {
        return (countHelix/sequence.length())*100;
    }

    public double getCountBeta() {
        return (countBeta/sequence.length()*100);
    }

    public double getCountTurn() {
        return (countTurn/sequence.length()*100);
    }
    
    
    //Scan through the peptide and identify regions where 4 out of 6 contiguous residues have P(a-helix) > 1.03.
    //That region is declared an alpha-helix. Extend the helix in both directions until a set of four contiguous residues that have an average P(a-helix) < 1.00 is reached.
    //That is declared the end of the helix. 
    public void calculateHelixPa(String seqHelix) throws FileNotFoundException
    {
        PredictionMatrix m = new PredictionMatrix();
        try{
            double [] seqHPa = new double[seqHelix.length()];
            boolean helixExtended = false;
            int stopPoint = 0;
            int helixStopPoint = 0;
            boolean startExtension =false;
            boolean startBackExtension = false;
            boolean helixFound = false;
            for(int j=0;j<seqHelix.length()-5;j++)
            {
                for(int i=0;i<3;i++)
                {
                    double HPa  = m.getHelixAminoPrediction(seqHelix.charAt(j+i))*m.getHelixAminoPrediction(seqHelix.charAt(j+i+1))*m.getHelixAminoPrediction(seqHelix.charAt(j+i+2))*
                    m.getHelixAminoPrediction(seqHelix.charAt(j+i+3));
                    
                    if(HPa >= 1.03)
                    {
                        helixFound = true;
                        startExtension = true;
                        startBackExtension = true;
                        int helixStartPoint = j+i;
                        //this region of 6 residues form a-helix
                        for(int k=j;k<j+6;k++)
                        {
                            seqHPa[k] = HPa;
                            stopPoint = k;
                        }
                        int hForward=stopPoint+1;
                        if(hForward > seqHelix.length()-4)
                        {
                            helixStopPoint = hForward-1;
                            break; 
                        }
                        while(startExtension)
                        {
                            double paExtendForward = m.getHelixAminoPrediction(seqHelix.charAt(hForward))*m.getHelixAminoPrediction(seqHelix.charAt(hForward+1))*m.getHelixAminoPrediction(seqHelix.charAt(hForward+2))*
                                     m.getHelixAminoPrediction(seqHelix.charAt(hForward+3));
                            if(paExtendForward >= 1.00)
                            {
                                helixExtended = true;
                                seqHPa[hForward] = seqHPa[hForward+1] = seqHPa[hForward+2]= seqHPa[hForward+3]= paExtendForward;
                                 hForward+=4;
                            }
                            else
                            {
                                helixStopPoint = hForward-1; 
                                startExtension = false;
                            }
                        }
                        if(helixStartPoint>=4)
                        {
                            int hBack=helixStartPoint;
                            while(startBackExtension && hBack>4)
                            {
                                 double paExtendBackward = m.getHelixAminoPrediction(seqHelix.charAt(hBack-1))*m.getHelixAminoPrediction(seqHelix.charAt(hBack-2))*m.getHelixAminoPrediction(seqHelix.charAt(hBack-3))*
                                        m.getHelixAminoPrediction(seqHelix.charAt(hBack-4));
                                if(paExtendBackward >= 1.00)
                                {
                                    seqHPa[hBack-1] = seqHPa[hBack-2]= seqHPa[hBack-3]= seqHPa[hBack-4]= paExtendBackward;
                                    hBack-=4;
                                }
                                else
                                    startBackExtension = false;           
                            }
                        }
                        if(helixExtended)
                            j=helixStopPoint;
                        else if(helixFound)
                            j = stopPoint;
                        i=3;
                    }
                    else
                    {
                        seqHPa[j+i] = HPa;
                    }
                       
                }
            }
             setHelix(seqHPa);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("In calculateHelixPa(): " + e.getMessage());
        }
    }
     //Scan through the peptide and identify regions where 3 out of 5 contiguous residues have P(betaSheet) > 1.05.
    //That region is declared a betaSheet Extend the betasheet in both directions until a set of four contiguous residues that have an average P(betaSheet) < 1.00 is reached.
    //That is declared the end of the betasheet. 
    public void calculateBetaPb(String seqBeta) throws FileNotFoundException
    {
       
        try{
            PredictionMatrix m = new PredictionMatrix();
       
            double [] seqBPb = new double[seqBeta.length()];
            boolean betaExtended = false;
            int stopPoint = 0;
            int beta = 0;
            int betaStopPoint = 0;
            boolean startExtension =false;
            boolean startBackExtension = false;
            boolean betaFound = false;
            for(int j=0;j<seqBeta.length()-4;j++)
            {
                for(int i=0;i<3;i++)
                {  
                    double HPb  = m.getBetaAminoPrediction(seqBeta.charAt(j+i))*m.getBetaAminoPrediction(seqBeta.charAt(j+i+1))*m.getBetaAminoPrediction(seqBeta.charAt(j+i+2));
            
                    if(HPb >= 1.05)
                    {
                        betaFound = true;
                        startExtension = true;
                        startBackExtension = true;
                        //this region of 5 residues form b-sheet
                        for(int k=j;k<j+5;k++)
                        {
                            seqBPb[k] = HPb;
                            stopPoint = k;
                        }
                        int bForward=stopPoint+1;
                        while(startExtension)
                        {
                            if(bForward > seqBeta.length()-4)
                            {
                                betaStopPoint = bForward-1;
                                break; 
                            }
                            double  pbExtendForward = m.getBetaAminoPrediction(seqBeta.charAt(bForward))*m.getBetaAminoPrediction(seqBeta.charAt(bForward+1))*m.getBetaAminoPrediction(seqBeta.charAt(bForward+2))*
                                m.getBetaAminoPrediction(seqBeta.charAt(bForward+3));
                            //check the next 4 residues,extend forward
                            if(pbExtendForward >= 1.00 )
                            {
                                betaExtended = true;
                                seqBPb[bForward] = seqBPb[bForward+1] = seqBPb[bForward+2]= seqBPb[bForward+3]= pbExtendForward;
                                bForward+=4;     
                            }
                            else
                            {
                                betaStopPoint = bForward-1; 
                                startExtension = false;
                            }
                        }
                        if(betaStopPoint>=4)
                        {
                            int bBack=betaStopPoint;
                            while(startBackExtension && bBack>4)
                            {
                            double pbExtendBackward = m.getBetaAminoPrediction(seqBeta.charAt(bBack-1))*m.getBetaAminoPrediction(seqBeta.charAt(bBack-2))*m.getBetaAminoPrediction(seqBeta.charAt(bBack-3))*
                                m.getBetaAminoPrediction(seqBeta.charAt(bBack-4));
                                //check the 4 residues, extend backwards 
                                if(pbExtendBackward >= 1.00)
                                {
                                    seqBPb[bBack-1] = seqBPb[bBack-2]= seqBPb[bBack-3]= seqBPb[bBack-4]= pbExtendBackward;
                                    bBack-=4;
                                }
                                else
                                    startBackExtension = false;           
                            }
                        }
                    if(betaExtended)
                        j=betaStopPoint;
                    else if(betaFound)
                        j = stopPoint;
                    i=3;
                }
                else
                {
                    seqBPb[j+i] = HPb;
                }
            }
        }
        setBeta(seqBPb);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("In calculateBetaPb :  " + e.getMessage());
        }
    }
    /* To identify a bend at residue number j, calculate the following value
        p(t) = f(j)f(j+1)f(j+2)f(j+3)
        where the f(j+1) value for the j+1 residue is used, the f(j+2) value for the j+2 residue is used and the f(j+3) value for the j+3 residue is used.
        If: (1) p(t) > 0.000075; 
        (2) the average value for P(turn) > 1.00 in the tetrapeptide; and
        (3) the averages for the tetrapeptide obey the inequality P(a-helix) < P(turn) > P(b-sheet), 
        then a beta-turn is predicted at that location.    */
    public void calculateTurnPt(String seqTurn) throws FileNotFoundException
    {
        double [] seqPt = new double[seqTurn.length()];
        try{
            PredictionMatrix m = new PredictionMatrix();
            double [] helixPred= getHelix();
            double [] betaPred = getBeta();
            
            for(int i=0;i<seqTurn.length()-4;i++)
            {
                double averageTurn = m.getTurnAminoPrediction(seqTurn.charAt(i))*m.getTurnAminoPrediction(seqTurn.charAt(i+1))*
                    m.getTurnAminoPrediction(seqTurn.charAt(i+2))*m.getTurnAminoPrediction(seqTurn.charAt(i+3));
                 double pt = m.getTotalFAminoPrediction(seqTurn.charAt(i),seqTurn.charAt(i+1),seqTurn.charAt(i+2),seqTurn.charAt(i+3));
                 
                 if(pt>0.000075 && averageTurn>1.00)
                 {
                     if(averageTurn > betaPred[i] && averageTurn>helixPred[i])
                       seqPt[i] =  averageTurn; 
                 }
             }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error caught " + e.getMessage());
        }
        setTurn(seqPt);
    }
    public String printHelix(PrintWriter outputStream) throws FileNotFoundException
    {
        String seqH = new String();
        int helices = 0;
        try{
            calculateHelixPa(getSequence());
            double [] pa = getHelix();
        
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<pa.length;i++)
            {
                if(pa[i]>=1.03)
                {
                    sb.insert(i,'H');
                    helices++;
                }
                    
                else
                    sb.insert(i,'-');
            }
            seqH = sb.toString();
            setCountHelix(helices);
            outputStream.println(seqH);
        }
        catch(FileNotFoundException e)
        {
           System.out.println("In printHelix() : " + e.getMessage());
        }
        return seqH;
    }
    public String printBeta(PrintWriter outputStream) throws FileNotFoundException
    {
         String seqB = new String();
         int betas = 0;
         try{
            calculateBetaPb(getSequence());
            double [] pb = getBeta();
       
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<pb.length;i++)
            {
                if(pb[i]>=1.05)
                {
                   sb.insert(i,'E');
                   betas++;
                }
                    
                else
                    sb.insert(i,'-');
            }
            seqB = sb.toString();
            setCountBeta(betas);
            outputStream.println(seqB);
         }
         catch(FileNotFoundException e)
         {
             System.out.println("In printBeta() : " + e.getMessage());
         }
        return seqB;
    }
    public String printTurn(PrintWriter outputStream) throws FileNotFoundException
    {
        String seqT = new String();
        int turns = 0;
        try
        {
            calculateTurnPt(getSequence());
            double [] pt = getTurn();
       
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<pt.length;i++)
            {
                if(pt[i]!=0)
                {
                    sb.insert(i,'T');
                    turns++;
                }
                    
                else
                    sb.insert(i," ");
            }
            seqT = sb.toString();
            setCountTurn(turns);
            outputStream.println(seqT);
        }
        catch(Exception e)
        {
            System.out.println("In printTurn() : " + e.getMessage());
        }
        return seqT;
    }
    
    public void printStatisticResults(PrintWriter outputStream)
    {
        outputStream.println("\nResidue totals:\tH:"+"\t"+countHelix+"\tE:"+"\t"+countBeta+"\tT:"+"\t"+countTurn);
        outputStream.printf ("Percent:\t\tH:\t%.2f \tE:\t%.2f \tT:\t%.2f ",getCountHelix(),getCountBeta(),getCountTurn());
    }
    public static String loadSequences(BufferedReader s) throws IOException
    {
        String sequence = null;
        String line = null;
       
        try{
            StringBuilder sb = new StringBuilder();
            s.readLine(); //get the first line..in case of fasta.txt we need only the sequence below
            while((line = s.readLine())!=null)
            {
                sb.append(line);
            }
            sequence = sb.toString();
        }
        catch(IOException io)
        {
            System.out.println("In loadSequences "+ io.getMessage());
        }
        finally{
            s.close();
        }
        return sequence;
    }
}