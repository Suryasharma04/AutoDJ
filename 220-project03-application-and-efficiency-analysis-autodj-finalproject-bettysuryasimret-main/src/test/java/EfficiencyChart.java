

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Borrowed largely from: https://www.tutorialspoint.com/jfreechart/jfreechart_line_chart.htm
 */
public class EfficiencyChart extends ApplicationFrame{
    public EfficiencyChart(String string, String string2, String string3, DefaultCategoryDataset dataset ) {
        super(string);
        JFreeChart lineChart = ChartFactory.createLineChart(
           string,
           "Amount of Data","Time",
           dataset,
           PlotOrientation.VERTICAL,
           true,true,false);
           
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1200 , 900 ) );
        setContentPane( chartPanel );
        this.pack( );
        this.setVisible( true );
    }

    public static void main(String[] args) {
        
    }
}
