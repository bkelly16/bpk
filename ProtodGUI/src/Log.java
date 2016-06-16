
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.java2d.pipe.ValidatePipe;

public class Log {
    
    static Object log = new Object();
    static JSONObject logObject = new JSONObject();
    static JSONArray logArray = new JSONArray();
    static DataSet workingSet = new DataSet();

    //IMPORT
    public static void importLog(DataSet dataSet) throws IOException, ParseException {
        importFile(dataSet.filePath); // imports log as an JSON Object and its corresponing Value of Arrays
        getHeaderValues(dataSet);
        getThresholdValues(dataSet);
        getMeasurementValues(dataSet);
    }
    
    private static void importFile(String file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        log = parser.parse(new FileReader(file));
        logObject = (JSONObject) log;
        logArray = (JSONArray) logObject.get("log");
    }

    ////GET & SET Header, Threshold & Measurement Values 
    public static void getHeaderValues(DataSet dataSet) {
        JSONObject header = ArrayToObject(0, logArray);
        JSONArray headerArray = ObjectToArray("header", header);
        
        JSONObject headerValues = (JSONObject) headerArray.get(0);
        dataSet.header.dateStamp = (long) headerValues.get("date");
        dataSet.header.machineID = (String) headerValues.get("id");
        dataSet.header.totalCPU = (double) headerValues.get("totalcpu");
        dataSet.header.totalRAM = (long) headerValues.get("totalram");

        //printJSONObject(header);
        printJSONArray(headerArray);
    }
    
    public static void getThresholdValues(DataSet dataSet) {
        JSONObject threshold = ArrayToObject(1, logArray);
        JSONArray thresholdArray = ObjectToArray("threshold", threshold);
        
        JSONObject thresholdValues = (JSONObject) thresholdArray.get(0);
        dataSet.threshold.iniTimeStamp = (long) thresholdValues.get("timestamp");
        dataSet.threshold.thresholdcpu = (long) thresholdValues.get("thresholdcpu");
        dataSet.threshold.thresholdram = (long) thresholdValues.get("thresholdram");
        dataSet.threshold.thresholdDataBus = (long) thresholdValues.get("thresholddatabus");
        dataSet.threshold.thresholdNetwork = (long) thresholdValues.get("thresholdnetwork");
        
        printJSONArray(thresholdArray);
        
    }
    
    public static void getMeasurementValues(DataSet dataSet) {
        JSONObject values = ArrayToObject(2, logArray);
        JSONArray valuesArray = (JSONArray) values.get("values");
        
        ArrayList<JSONArray> listofMeasurements = new ArrayList<>();
        
        for (int i = 0; i < valuesArray.size(); i++) { //Loop through valuesArray, get measureObject[i] enter into MeasurementList
            JSONObject measureObject = (JSONObject) valuesArray.get(i);
            JSONArray measureArray = (JSONArray) measureObject.get("m");
            listofMeasurements.add(measureArray);
        }
        getCpuCount(dataSet, listofMeasurements);
        //System.out.println(String.valueOf(dataSet.cpuCount));
        getDevNames(dataSet, listofMeasurements);
        getNICNames(dataSet, listofMeasurements);
        //System.out.println(listofMeasurements.size());
        
        for (int i = 0;i<dataSet.cpuCount;i++){
            DataSet.CPUValues temp = workingSet.new CPUValues();
            for(int n= 0; n < listofMeasurements.size(); n++){
                JSONArray valueArray = (JSONArray) listofMeasurements.get(n); // create JSONArray out of current line
                JSONObject valueObject = (JSONObject) valueArray.get(0); // grab first entry in Array
                dataSet.cpuCores.add(getCpuLoad(temp, valueObject, i));
            }
            dataSet.cpuCores.add(dataSet.cpu);
            
        }
        System.out.println(dataSet.cpuCores.size());
        System.out.println(dataSet.cpuCores.get(0).uCPU.get(0));
        System.out.println(dataSet.cpuCores.get(0).uCPU.get(99));
        for (int n = 0; n < listofMeasurements.size(); n++) { // Loop through the List of measurements
            JSONArray valueArray = (JSONArray) listofMeasurements.get(n); // create JSONArray out of current line
            JSONObject valueObject = (JSONObject) valueArray.get(0); // grab first entry in Array

            getTimeStamp(dataSet, valueObject);
            getMemLoad(dataSet, valueObject);

            getDeviceStat(dataSet, valueObject, dataSet.devCount);
            getNetworkLoad(dataSet, valueObject, dataSet.nicCount);
        }
        
//        System.out.println(dataSet.devList.size());
//        System.out.println(dataSet.nicList.size());
//        System.out.println(dataSet.ram.usedMem.size());
//        System.out.println(dataSet.timeStamp.timeStamp.size());
   
//        System.out.println(dataSet.nicList.get(0).tx.size());
//        System.out.println(dataSet.devList.get(0).iop.size());
        //System.out.println(dataSet.cpuCores.size());
        //System.out.println(dataSet.cpuCores.get(0).uCPU.size());
    }

    //Measurement Values
    //TIME
    private static void getTimeStamp(DataSet dataSet, JSONObject obj) {
        dataSet.timeStamp.timeStamp.add((long) obj.get("t"));
    }

    //CPU
    private static void getCpuCount(DataSet dataSet, ArrayList array) {
        JSONArray valueArray = (JSONArray) array.get(0);
        JSONObject valueObject = (JSONObject) valueArray.get(0);
         
        JSONArray cpuArray = (JSONArray) valueObject.get("c");
        JSONObject cpuValues = (JSONObject) cpuArray.get(0);
        
        workingSet.cpuNames = new LinkedList<>(cpuValues.keySet());
        Collections.sort(workingSet.cpuNames);

        for (int i=0;i<workingSet.cpuNames.size();i++){
            dataSet.cpuNames.add("cpu_"+workingSet.cpuNames.get(i).substring(1));
        }
        
         dataSet.cpuCount = cpuValues.size() / 2;
    }
    
    public static DataSet.CPUValues getCpuLoad(DataSet.CPUValues temp, JSONObject obj, int i) {
        JSONArray cpuArray = (JSONArray) obj.get("c");
        JSONObject cpuValues = (JSONObject) cpuArray.get(0);
        temp.uCPU.add((Double) cpuValues.get("u"+i));
        temp.sCPU.add((Double) cpuValues.get("s"+i));
        return temp;
    }

    private static Double setCpuLoad(JSONObject obj, String key) {
        Double cpuLoad = 0.0;
        
        if (obj.containsKey(key)) {
            cpuLoad = (Double) obj.get(key);
        }
        return cpuLoad;
    }

    //MEMORY  
    private static void getMemLoad(DataSet dataSet, JSONObject obj) {
        JSONArray memArray = (JSONArray) obj.get("r");
        JSONObject memValues = (JSONObject) memArray.get(0);
        //printJSONObject(memValues);

        dataSet.ram.usedMem.add(setMemLoad(memValues, "u"));
        dataSet.ram.sharedMem.add(setMemLoad(memValues, "s"));
        dataSet.ram.buffMem.add(setMemLoad(memValues, "b"));
        dataSet.ram.cacheMem.add(setMemLoad(memValues, "c"));
        dataSet.ram.totalSwapMem.add(setMemLoad(memValues, "st"));
        dataSet.ram.usedSwapMem.add(setMemLoad(memValues, "su"));
        //printArrayList(set.ram.usedSwapMem);

    }
    
    private static long setMemLoad(JSONObject obj, String key) {
        long memLoad = 0;
        if (obj.containsKey(key)) {
            memLoad = (long) obj.get(key);
        }
        return memLoad;
    }

    //DEVICE
    private static void getDeviceStat(DataSet dataSet, JSONObject obj, int devCount) {
        JSONArray devArray = (JSONArray) obj.get("d");
        JSONObject devObject = (JSONObject) devArray.get(0);

        for (int i = 0; i < devCount; i++) {
            workingSet.dev.rds.add(setDevStat(devObject, dataSet.devNames.get(i)+"_rds"));
            workingSet.dev.wrs.add(setDevStat(devObject, dataSet.devNames.get(i)+"_wrs"));
            workingSet.dev.rdi.add(setDevStat(devObject, dataSet.devNames.get(i)+"_rdi"));
            workingSet.dev.rdm.add(setDevStat(devObject, dataSet.devNames.get(i)+"_rdm"));
            workingSet.dev.rdt.add(setDevStat(devObject, dataSet.devNames.get(i)+"_rdt"));
            workingSet.dev.wri.add(setDevStat(devObject, dataSet.devNames.get(i)+"_wri"));
            workingSet.dev.wrm.add(setDevStat(devObject, dataSet.devNames.get(i)+"_wrm"));
            workingSet.dev.wrt.add(setDevStat(devObject, dataSet.devNames.get(i)+"_wrt"));
            workingSet.dev.iop.add(setDevStat(devObject, dataSet.devNames.get(i)+"_iop"));
            workingSet.dev.tot.add(setDevStat(devObject, dataSet.devNames.get(i)+"_tot"));
            workingSet.dev.rqt.add(setDevStat(devObject, dataSet.devNames.get(i)+"_rqt"));
        }
        dataSet.devList.add(workingSet.dev);
    }
    
    private static long setDevStat(JSONObject obj, String key) {
        long devStat = 0;
        if (obj.containsKey(key)) {
            devStat = (long) obj.get(key);
        }
        return devStat;
    }
    
    private static void getDevNames(DataSet dataSet, ArrayList array) {
        JSONArray valueArray = (JSONArray) array.get(0);
        JSONObject valueObject = (JSONObject) valueArray.get(0);
        
        JSONArray devArray = (JSONArray) valueObject.get("d");
        JSONObject devValues = (JSONObject) devArray.get(0);
        
        workingSet.devNames = new LinkedList<>(devValues.keySet());
        Collections.sort(workingSet.devNames);
        
        for (int i=0;i<workingSet.devNames.size();i++) {
            if(i % 11 == 0) dataSet.devNames.add(workingSet.devNames.get(i).split("_")[0]);
        }     
        dataSet.devCount = (devValues.size() / 11);
    }

    //NETWORK
    private static void getNICNames(DataSet dataSet, ArrayList array) {
        JSONArray valueArray = (JSONArray) array.get(0);
        JSONObject valueObject = (JSONObject) valueArray.get(0);
        
        JSONArray nicArray = (JSONArray) valueObject.get("n");
        JSONObject nicValues = (JSONObject) nicArray.get(0);
        
        workingSet.nicNames = new LinkedList<>(nicValues.keySet());
        Collections.sort(workingSet.nicNames);
        
        for (int i=0;i<workingSet.nicNames.size();i++){
            if(i % 2 == 0) dataSet.nicNames.add(workingSet.nicNames.get(i).split("_")[0]);
        }
        dataSet.nicCount = (nicValues.size() / 2);
    }
    
    private static void getNetworkLoad(DataSet dataSet, JSONObject obj, int nicCount) {
        JSONArray nicArray = (JSONArray) obj.get("n");
        JSONObject nicValues = (JSONObject) nicArray.get(0);
        
        for (int i = 0; i < nicCount; i++) {//Dynamically fill cpuS List based on cpu count
            workingSet.nic.rx.add(setDevStat(nicValues, dataSet.nicNames.get(i)+"_rx"));
            workingSet.nic.tx.add(setDevStat(nicValues, dataSet.nicNames.get(i)+"_tx"));
        }
        dataSet.nicList.add(workingSet.nic);
    }

    //JSON convert
    private static JSONArray ObjectToArray(String id, JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get(id);
        return jsonArray;
    }
    
    private static JSONObject ArrayToObject(int index, JSONArray jsonArray) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        return jsonObject;
    }

    //Debug
    public static void printJSONArray(JSONArray ja) {
        Iterator itr = ja.iterator();
        //Iterator itr2 = logObject.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
    public static void printJSONObject(JSONObject ja) {
        //Iterator itr = jr.iterator();
        String test = ja.toString();
        //Iterator itr2 = logObject.iterator();

        System.out.println(test);
    }
    
    public static void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
    public static void printRAMSet(DataSet dataSet) {
        for (int i = 0; i < dataSet.ram.usedMem.size(); i++) {
            System.out.println(Long.toString(dataSet.ram.usedMem.get(i)));
        }
    }
    
    public static void printDevName(DataSet dataSet) {
        for (int i = 0; i < dataSet.devNames.size(); i++) {
            System.out.println(dataSet.devNames.get(i));
        }
    }
    
    public static void printNICName(DataSet dataSet) {
        for (int i = 0; i < dataSet.nicNames.size(); i++) {
            System.out.println(dataSet.nicNames.get(i));
        }
    }
    
    public static void printDiskStat(List<DataSet.DevValues> devList) {
        for (int i = 0; i < devList.size(); i++) {
            DataSet.DevValues dev = devList.get(i);
            System.out.println(dev.rds.get(i));
            System.out.println(dev.wrs.get(i));
            System.out.println(dev.rdi.get(i));
            System.out.println(dev.rdm.get(i));
            System.out.println(dev.rdt.get(i));
            System.out.println(dev.wri.get(i));
            System.out.println(dev.wrm.get(i));
            System.out.println(dev.wrt.get(i));
            System.out.println(dev.iop.get(i));
            System.out.println(dev.tot.get(i));
            System.out.println(dev.rqt.get(i));
            
        }
    }
    
    public static void printCPUSet(List<DataSet.CPUValues> cpuCores) {
        for (int i = 0; i < cpuCores.size(); i++) {
            DataSet.CPUValues cpu = cpuCores.get(i);
            System.out.println(cpu.uCPU.get(i));
            System.out.println(cpu.sCPU.get(i));
        }
    }
    
    public static void printNicStats(List<DataSet.NICValues> nics) {
        for (int i = 0; i < nics.size(); i++) {
            DataSet.NICValues nic = nics.get(i);
            System.out.println(nic.rx.get(i));
            System.out.println(nic.tx.get(i));
        }
    }
    
    public static void printCPUName(DataSet dataSet) {
        for (int i = 0; i < dataSet.cpuNames.size(); i++) {
            System.out.println(dataSet.cpuNames.get(i));
        }
    }


}
