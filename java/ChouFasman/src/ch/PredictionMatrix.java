package ch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class PredictionMatrix {
    private char[] aminoacids = {'A','R','D','N','C','E','Q','G','H','I','L','K','M','F','P','S','T','W','Y','V'};
    private double[][] aminoPredictions;   
    
    public PredictionMatrix()
    {
    }

    public char[] getAminoacids() {
        return aminoacids;
    }

    public double[][] getAminoPredictions() {
        return aminoPredictions;
    }

    public void setAminoacids(char[] aminoacids) {
        this.aminoacids = aminoacids;
    }

    public void setAminoPredictions(double[][] aminoPredictions) {
        this.aminoPredictions = aminoPredictions;
    }
    //method that reads and returns the matrix with the aminoacids probabilities in helix,beta or turn secondary structure
    public double[][] storePredictionMatrix()throws FileNotFoundException 
    {
        double[][] matrix = new double[20][7];
        try{
            Scanner predictions = new Scanner(new File("predictions2.txt"));
            predictions.useLocale(Locale.US);
       
            while(predictions.hasNextLine())
            {
             //20 rows for the aminoacids and 8 columns for the possible structures
                for(int row=0;row<20;row++)
                {
                    for(int col=0;col<7;col++)
                    {
                        matrix[row][col] = predictions.nextDouble();
                    }
                }
            }
                setAminoPredictions(matrix);
            }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening file: " + e.getMessage());
        }
        return matrix;   
    }
    //method that returns the predicted value in Helix given an aminoacid from the input sequence
    public double getHelixAminoPrediction(char a) throws FileNotFoundException
    {
        double prob = 0.0;
        try{
            double[][] matrix =  storePredictionMatrix();
            char[] amino  = getAminoacids();
        
            for(int i=0;i<20;i++)
            {
                if(a == amino[i])
                {
                    prob = matrix[i][0];
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("In getHelixAminoPrediction" + e.getMessage());
        }
        
        return prob;
    }
    //method that returns the predicted value in Beta given an aminoacid from the input sequence
     public double getBetaAminoPrediction(char a) throws FileNotFoundException
    {
        double prob = 0.0;
        try{
            double[][] matrix =  storePredictionMatrix();
        char[] amino  = getAminoacids();
        
        for(int i=0;i<20;i++)
        {
            if(a == amino[i])
                prob = matrix[i][1];
        }
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("In getBetaAminoPrediction "+ e.getMessage());
        }
        return prob;
    }
     //method that returns the predicted value in Beta given an aminoacid from the input sequence
     public double getTurnAminoPrediction(char a) throws FileNotFoundException
    {
        double prob = 0.0;
        try 
        {
            double[][] matrix =  storePredictionMatrix();
            
            char[] amino  = getAminoacids();
  
            for(int i=0;i<20;i++)
            {
                if(a == amino[i])
                 prob = matrix[i][2];
            }
        }
        catch(Exception e)
        {
            System.out.println("Cound not open file" + e.getMessage());
        }
        return prob;
    }
     public double getTotalFAminoPrediction(char a,char b,char c,char d) throws FileNotFoundException
    {
        double[] prob = new double[4];
        double sum = 0.0;
        try {
            double[][] matrix =  storePredictionMatrix();
        
            char[] amino  = getAminoacids();
  
            for(int i=0;i<20;i++)
            {
                if(a == amino[i])
                    prob[0] = matrix[i][3];
                if(a == amino[i])
                    prob[1] = matrix[i][4];
                if(a == amino[i])
                    prob[2] = matrix[i][5];
                if(d == amino[i])
                    prob[3] = matrix[i][6];
            }
            for (int i=0;i<4;i++)
            {
                sum += prob[i];
            }
        }
        catch(Exception e)
        {
            System.out.println("Cound not open file" + e.getMessage());
        }
         return sum;
    }
}