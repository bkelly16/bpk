
import java.util.ArrayList;



public class DataSet {
  
    public String filePath = "F:\\Work\\Log Files\\daemon.properJSON.plf"; 
    // Headers
    long dateStamp = 0;
    String machineID = "Null";
    double totalCPU = 0;
    //totalCPU is 100.0 * the number of CPUs. If hyperthreading is present then the value is 100.0 * the number of hyperthreads
    long totalRAM = 0;

    //Thresholds
    long iniTimeStamp = 0;
    long thresholdcpu = 0;
    long thresholdram = 0;
    long thresholdDataBus = 0;
    long thresholdNetwork = 0;

    int maxSamples = 10000;
    //long[] timeStamp; //= new long[numSamples];
    //double[] cpuLoad; // = new double[numSamples];
    //long[] memLoad; // = new long[numSamples];
    //long[] dataBus; // = new long[numSamples];
    //long[] networkBus;// = new long[numSamples];
    
    public ArrayList<Long> timeStamp = new ArrayList<>(maxSamples);
    public ArrayList<Double> cpuLoad = new ArrayList<>(maxSamples);
    public ArrayList<Long> memLoad = new ArrayList<>(maxSamples);
    public ArrayList<Long> dataBus = new ArrayList<>(maxSamples);
    public ArrayList<Long> networkBus = new ArrayList<>(maxSamples);
    
    public void debugSet() {
        for (int i =0 ; i<timeStamp.size();i++){
            System.out.println(Long.toString(timeStamp.get(i)));
            System.out.println(Double.toString(cpuLoad.get(i)));
            System.out.println(Long.toString(memLoad.get(i)));
            System.out.println(Long.toString(dataBus.get(i)));
            System.out.println(Long.toString(networkBus.get(i)));
            
        }

    }

}



