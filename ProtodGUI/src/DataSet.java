
import java.util.ArrayList;

public class DataSet {
  
    public class Header {
        public long dateStamp = 0;
        public String machineID = "";
        public double totalCPU = 0;//totalCPU is 100.0 * the number of CPUs. If hyperthreading is present then the value is 100.0 * the number of hyperthreads
        public long totalRAM = 0;        
    }
    public class Threshold {
        public long iniTimeStamp = 0;
        public long thresholdcpu = 0;
        public long thresholdram = 0;
        public long thresholdDataBus = 0;
        public long thresholdNetwork = 0;        
    }
    public class TimeStamp {
        public ArrayList<Long> timeStamp = new ArrayList<>();
    }
    public class CPUValues {
        public ArrayList<Double> uCPU = new ArrayList<>();
        public ArrayList<Double> sysCPU = new ArrayList<>();
    }
    public class RAMValues {
        public ArrayList<Long> usedMem = new ArrayList<>();
        public ArrayList<Long> sharedMem = new ArrayList<>();
        public ArrayList<Long> buffMem = new ArrayList<>();
        public ArrayList<Long> cacheMem = new ArrayList<>();
        public ArrayList<Long> totalSwapMem = new ArrayList<>();
        public ArrayList<Long> usedSwapMem = new ArrayList<>();    
    }
    public class DiskNames{
        public String[] devNames = {"sda", "sdb", "sdc", "sdd", "sde","sdf","sdg","sdh","sdi","sdj","sdk","sdl","sdm","sdn","sdo","sdp","sdq","sdr","sds","sdt","sdu","sdv","sdw","sdx","sdy","sdz","sdaa","sdab","sdac","sdad","sdae","sdaf","sdag","sdah","sdai","sdaj","sdak","sdl","sdam","sdan","sdao","sdap","sdaq","sdar","sdas","sdat","sdau","md126","md127"};   
    }
    public class DiskValues {
        public ArrayList<Long> rds = new ArrayList<>();
        public ArrayList<Long> wrs = new ArrayList<>();
        public ArrayList<Long> rdi = new ArrayList<>();
        public ArrayList<Long> rdm = new ArrayList<>();
        public ArrayList<Long> rdt = new ArrayList<>();
        public ArrayList<Long> wri = new ArrayList<>();
        public ArrayList<Long> wrm = new ArrayList<>();
        public ArrayList<Long> wrt = new ArrayList<>();
        public ArrayList<Long> iop = new ArrayList<>();
        public ArrayList<Long> tot = new ArrayList<>();
        public ArrayList<Long> rqt = new ArrayList<>();
    }
    public class NetworkNames{
        
    }
    public class NetworkValues {
        public ArrayList<Long> rx = new ArrayList<>();
        public ArrayList<Long> tx = new ArrayList<>();
    }

    
    public String filePath = "F:\\Work\\Log Files\\v.012_test.plf"; 

    Header header = new Header();
    
    Threshold threshold = new Threshold();
    
    TimeStamp timeStamp = new TimeStamp();
    
    CPUValues cpu = new CPUValues();
    
    RAMValues ram = new RAMValues();
    
    DiskNames devName = new DiskNames();
    
    DiskValues dev = new DiskValues();
    
    NetworkValues nic = new  NetworkValues();


}



