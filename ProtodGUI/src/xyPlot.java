import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 

public class xyPlot extends JFrame 
{
    public xyPlot( String applicationTitle, String chartTitle, String yAxisLabel, ArrayList<Long> set, ArrayList<Long> timeSet) 
   {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
               chartTitle ,
               "Time (seconds)" ,
               yAxisLabel ,
               createDataset(chartTitle,set,timeSet),
               PlotOrientation.VERTICAL ,
               true , true , false);
         
      xylineChart.setBorderVisible(rootPaneCheckingEnabled);
      
      //Paint p = new GradientPaint(0, 250, Color.white, 500, 0, Color.red);
      //xylineChart.setBackgroundPaint(p);
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      
      chartPanel.setMouseZoomable( true , false );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      showChart();
      
      //final XYPlot plot = xylineChart.getXYPlot( );
      //XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      //renderer.setSeriesPaint( 0 , Color.RED );
      //renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      //plot.setRenderer( renderer ); 

   }

    private XYDataset createDataset(String title, ArrayList<Long> set, ArrayList<Long> timeSet)
   {
      XYSeries series = new XYSeries(title);
      for(int i = 0;i<timeSet.size();i++){
          series.add(timeSet.get(i),set.get(i)); 
      }
      XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( series );
     
      return dataset;
   }

    private void showChart() {
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }
}