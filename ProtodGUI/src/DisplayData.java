
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brett
 */
public class DisplayData {
    
    public static void cpuPlot(ArrayList<Double> cpuSet, ArrayList<Long> timeSet, String title){
        ArrayList<Long> longCpuSet = new ArrayList<>(cpuSet.size());
        for(int i =0;i<cpuSet.size();i++){
            longCpuSet.add(cpuSet.get(i).longValue());
        }
        timePlot graph = new timePlot("Resource Usage", title, "Utiliztaion (%)", longCpuSet , timeSet);
        graph.showChart();
    }

    public static void ramPlot(ArrayList<Long> ramSet, ArrayList<Long> timeSet, String title){
        //xyPlot graph = new xyPlot("Resource Usage", "RAM Load", "RAM (Bytes)", ramSet , timeSet);
        timePlot graph = new timePlot("Resource Usage", title, "RAM (kiloBytes)", ramSet , timeSet);
        graph.showChart();
    }
    
    public static void dataPlot(ArrayList<Long> dataSet, ArrayList<Long> timeSet, String title){
        timePlot graph = new timePlot("Resource Usage", title, "Data IO (Bytes)", dataSet , timeSet);
        graph.showChart();
    }
    
    public static void networkPlot(ArrayList<Long> networkSet, ArrayList<Long> timeSet){
        timePlot graph = new timePlot("Resource Usage", "Network Transfer", "Data IO (Bytes)", networkSet , timeSet);
        graph.showChart();
    }    
}
