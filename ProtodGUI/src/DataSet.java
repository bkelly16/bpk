
import java.util.List;
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

        public List<Long> timeStamp = new ArrayList<>();
    }

    public class CPUValues {

        public List<Double> uCPU = new ArrayList<>();
        public List<Double> sCPU = new ArrayList<>();

    }

    public class RAMValues {

        public List<Long> usedMem = new ArrayList<>();
        public List<Long> sharedMem = new ArrayList<>();
        public List<Long> buffMem = new ArrayList<>();
        public List<Long> cacheMem = new ArrayList<>();
        public List<Long> totalSwapMem = new ArrayList<>();
        public List<Long> usedSwapMem = new ArrayList<>();
    }

    public class DevValues {

        public List<Long> rds = new ArrayList<>();
        public List<Long> wrs = new ArrayList<>();
        public List<Long> rdi = new ArrayList<>();
        public List<Long> rdm = new ArrayList<>();
        public List<Long> rdt = new ArrayList<>();
        public List<Long> wri = new ArrayList<>();
        public List<Long> wrm = new ArrayList<>();
        public List<Long> wrt = new ArrayList<>();
        public List<Long> iop = new ArrayList<>();
        public List<Long> tot = new ArrayList<>();
        public List<Long> rqt = new ArrayList<>();
    }

    public class NICValues {

        public List<Long> rx = new ArrayList<>();
        public List<Long> tx = new ArrayList<>();
    }
    
    public String filePath = "F:\\Work\\Log Files\\v13.testjson.20160614.plf";

    Header header = new Header();

    Threshold threshold = new Threshold();

    TimeStamp timeStamp = new TimeStamp();

    CPUValues cpu = new CPUValues();
    List<CPUValues> cpuCores = new ArrayList<>();
    int cpuCount = 0;

    RAMValues ram = new RAMValues();

    DevValues dev = new DevValues();
    List<DevValues> devList = new ArrayList<>();
    List<String> devNames = new ArrayList<>();
    int devCount = 0;
    
    NICValues nic = new NICValues();
    List<NICValues> nicList = new ArrayList<>();
    List<String> nicNames = new ArrayList<>();
    int nicCount = 0;
}
