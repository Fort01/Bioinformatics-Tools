
package ch;

import static ch.ChouFasmanAlgorithm.loadSequences;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChouFasmanAlgorithmImplementation {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
       try{
           
            Scanner sequenceInput  = new Scanner(System.in);
            System.out.println("Give the sequence filename in FASTA format ");
            String inputSeq = sequenceInput.next();
            
            BufferedReader seqInsterted = new BufferedReader(new FileReader(inputSeq));
            PrintWriter outputStream = new PrintWriter(new FileWriter("ChouFasmanPred.txt"));
            
            String chouFasmanSequence = loadSequences(seqInsterted);
            seqInsterted.close();
            
            ChouFasmanAlgorithm ch = new ChouFasmanAlgorithm(chouFasmanSequence);
            outputStream.println(ch.getSequence());
            ch.printHelix(outputStream);
            ch.printBeta(outputStream);
            ch.printTurn(outputStream);
            ch.printStatisticResults(outputStream);
            outputStream.close();
            
            System.out.println("The results have been written in ChouFasmanPred.txt ");
            System.out.println("Check your ChouFasmanPredictionGraph.png!! ");
            
            DrawLineChart chart = new DrawLineChart(ch);
            //chart.pack( );          
            //RefineryUtilities.centerFrameOnScreen( chart );          
            //chart.setVisible( true ); 
            
        }
       catch(FileNotFoundException e)
        {
            System.out.println("in main method " + e.getMessage());
        }
       catch(IOException e)
        {
            System.out.println("in main method " + e.getMessage());
        }
    }
}
