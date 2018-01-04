package ch;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries; 
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class DrawLineChart extends ApplicationFrame {
 
    public DrawLineChart(ChouFasmanAlgorithm cf) throws FileNotFoundException, IOException {
        super("ChouFasman Algorith Prediction Results");
        try{
        JPanel chartPanel = createChartPanel(cf);
        add(chartPanel, BorderLayout.CENTER);
       
        setSize(1840, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("In DrawLineChart " + e.getMessage());
        }
        catch(IOException io)
        {
            System.out.println("In DrawLineChart " + io.getMessage());
        }
    }
 
    private JPanel createChartPanel(ChouFasmanAlgorithm cf) throws FileNotFoundException, IOException {
        String chartTitle = "Aminoacid Secondary Structure Prediction";
        String valueAxisLabel = "Predicted Values";
        
        try{
            String categoryAxisLabel = cf.getSequence();
            
            XYDataset  dataset = createDataset(cf);
 
            JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                        categoryAxisLabel, valueAxisLabel, dataset);
 
            chart.setBackgroundPaint(Color.CYAN);
            XYLineAndShapeRenderer  renderer = new XYLineAndShapeRenderer();

            // sets paint color for each series
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesLinesVisible(0, true);
            renderer.setSeriesLinesVisible(1, true);
            renderer.setSeriesShapesVisible(0, false);
            renderer.setSeriesShapesVisible(1, false);
 
            // sets thickness for series (using strokes)
            renderer.setSeriesStroke(0, new BasicStroke(1.0f));
            renderer.setSeriesStroke(1, new BasicStroke(1.0f));

            XYPlot plot = chart.getXYPlot( );
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainCrosshairVisible(true);
            plot.setRangeCrosshairVisible(true);
            plot.setRenderer(renderer);
            int width = 1600; /* Width of the image */
            int height = 480; /* Height of the image */ 
            File graph = new File( "ChouFasmanPredictionGraph.png" ); 
            ChartUtilities.saveChartAsPNG( graph, chart, width, height);
            //final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            return new ChartPanel(chart);
         }
        catch(IOException io)
        {
            System.out.println("In createChartPanel " + io.getMessage());
            return null;
        }
    }
 
    private XYDataset createDataset(ChouFasmanAlgorithm cf)
    {
        final XYSeries series1 = new XYSeries("Helix");
        final XYSeries series2 = new XYSeries("Beta");
        
        for(int i=0;i<cf.getSequence().length();i++)
        {
            series1.add(i , cf.getHelix()[i]);
            series2.add(i, cf.getBeta()[i]);
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );  
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
}

