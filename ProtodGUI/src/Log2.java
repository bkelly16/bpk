//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class Log2 {
//
//    static Object log = new Object();
//    static JSONObject lineObject = new JSONObject();
//    static JSONArray logArray = new JSONArray();
//
//    //IMPORT
//    public static void importLog(DataSet dataSet) throws IOException, ParseException {
//        importFile(dataSet.filePath); // imports log as an JSON Object and its corresponing Value of Arrays
//        getHeaderValues(dataSet);
//        getThresholdValues(dataSet);
//        getMeasurementValues(dataSet);
//    }
//
//    private static void importFile(String file) throws IOException, ParseException {
//        JSONParser parser = new JSONParser();
//        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
//            for(String line; (line = br.readLine()) != null;){
//                System.out.println(line);
//                //Object temp = parser.parse(line);
//                //lineObject = (JSONObject) temp;
//                //printJSONObject(lineObject);
//            }
//        }
//        //log = parser.parse(new FileReader(file));
//
//        //logArray = (JSONArray) logObject.get("Log");
//    }
//
//    ////GET & SET Header, Threshold & Measurement Values 
//    public static void getHeaderValues(DataSet dataSet) {
//        JSONObject header = ArrayToObject(0, logArray);
//        JSONArray headerArray = ObjectToArray("header", header);
//
//        JSONObject headerValues = (JSONObject) headerArray.get(0);
//        dataSet.header.dateStamp = (long) headerValues.get("date");
//        dataSet.header.machineID = (String) headerValues.get("id");
//        dataSet.header.totalCPU = (double) headerValues.get("totalcpu");
//        dataSet.header.totalRAM = (long) headerValues.get("totalram");
//
//        //printJSONObject(header);
//        printJSONArray(headerArray);
//    }
//
//    public static void getThresholdValues(DataSet dataSet) {
//        JSONObject threshold = ArrayToObject(1, logArray);
//        JSONArray thresholdArray = ObjectToArray("threshold", threshold);
//
//        JSONObject thresholdValues = (JSONObject) thresholdArray.get(0);
//        dataSet.threshold.iniTimeStamp = (long) thresholdValues.get("timestamp");
//        dataSet.threshold.thresholdcpu = (long) thresholdValues.get("thresholdcpu");
//        dataSet.threshold.thresholdram = (long) thresholdValues.get("thresholdram");
//        dataSet.threshold.thresholdDataBus = (long) thresholdValues.get("thresholddatabus");
//        dataSet.threshold.thresholdNetwork = (long) thresholdValues.get("thresholdnetwork");
//
//        printJSONArray(thresholdArray);
//
//    }
//
//    public static void getMeasurementValues(DataSet dataSet) {
//        JSONObject values = ArrayToObject(2, logArray);
//        JSONArray valuesArray = (JSONArray) values.get("values");
//
//        ArrayList<JSONArray> listofMeasurements = new ArrayList<>(values.size());
//
//        for (int i = 0; i < valuesArray.size(); i++) { //Loop through valuesArray, get measureObject[i] enter into MeasurementList
//            JSONObject measureObject = (JSONObject) valuesArray.get(i);
//            JSONArray measureArray = (JSONArray) measureObject.get("m");
//            listofMeasurements.add(measureArray);
//        }
//        int cpuCount = getCpuCount(listofMeasurements);
//        int devCount = getDevCount(listofMeasurements);
//
//        for (int n = 0; n < listofMeasurements.size(); n++) { // Loop through the List of measurements
//            JSONArray valueArray = (JSONArray) listofMeasurements.get(n); // create JSONArray out of current line
//            JSONObject valueObject = (JSONObject) valueArray.get(0); // grab first entry in Array
//            //printJSONObject(valueObject);
//            getTimeStamp(dataSet, valueObject);
//            getCpuLoad(dataSet, valueObject, cpuCount);
//            getMemLoad(dataSet, valueObject);
//            getDeviceStat(dataSet, valueObject, devCount);
//            //set.dataBus.add((long) valueObject.get("d"));
//            //set.networkBus.add((long) valueObject.get("n"));
//        }
//    }
//
//    //Measurement Values
//    //TIME
//    private static void getTimeStamp(DataSet dataSet, JSONObject obj) {
//        dataSet.timeStamp.timeStamp.add((long) obj.get("t"));
//    }
//
//    //CPU
//    private static int getCpuCount(ArrayList array) {
//        JSONArray valueArray = (JSONArray) array.get(0);
//        JSONObject valueObject = (JSONObject) valueArray.get(0);
//
//        JSONArray cpuArray = (JSONArray) valueObject.get("c");
//        JSONObject cpuValues = (JSONObject) cpuArray.get(0);
//
//        int count = cpuValues.size() / 2;
//        //System.out.println(count);
//        return count;
//    }
//
//    private static void getCpuLoad(DataSet dataSet, JSONObject obj, int cpuCount) {
//        JSONArray cpuArray = (JSONArray) obj.get("c");
//        JSONObject cpuValues = (JSONObject) cpuArray.get(0);
//
//        //printJSONObject(cpuValues);
//        //System.out.println(cpuCount);
//        for (int i = 0; i < cpuCount; i++) {//Dynamically fill cpuS List based on cpu count
//            dataSet.cpu.uCPU.add(setCpuLoad(cpuValues, "u" + i));
//            //System.out.println(dataSet.cpu.uCPU.get(i));
//            //dataSet.userCPUs.add(dataSet.cpu.uCPU.get(i));
//
//            dataSet.cpu.sCPU.add(setCpuLoad(cpuValues, "s" + i));
//            //dataSet.sysCPUs.add(dataSet.cpu.sysCPU.get(i));
//
//        }
//        //printUserCPU(dataSet);
//        //printSysCPU(dataSet);
//    }
//
//    private static Double setCpuLoad(JSONObject obj, String key) {
//        Double cpuLoad = 0.0;
//        if (obj.containsKey(key)) {
//            cpuLoad = (Double) obj.get(key);
//        }
//        return cpuLoad;
//    }
//
//    //MEMORY    
//    private static void getMemLoad(DataSet dataSet, JSONObject obj) {
//        JSONArray memArray = (JSONArray) obj.get("r");
//        JSONObject memValues = (JSONObject) memArray.get(0);
//        //printJSONObject(memValues);
//
//        dataSet.ram.usedMem.add(setMemLoad(memValues, "u"));
//        dataSet.ram.sharedMem.add(setMemLoad(memValues, "s"));
//        dataSet.ram.buffMem.add(setMemLoad(memValues, "b"));
//        dataSet.ram.cacheMem.add(setMemLoad(memValues, "c"));
//        dataSet.ram.totalSwapMem.add(setMemLoad(memValues, "st"));
//        dataSet.ram.usedSwapMem.add(setMemLoad(memValues, "su"));
//        //printArrayList(set.ram.usedSwapMem);
//
//    }
//
//    private static long setMemLoad(JSONObject obj, String key) {
//        long memLoad = 0;
//        if (obj.containsKey(key)) {
//            memLoad = (long) obj.get(key);
//        }
//        return memLoad;
//    }
//
//    //DEVICE
//    private static void getDeviceStat(DataSet dataSet, JSONObject obj, int devCount) {
//        JSONArray devArray = (JSONArray) obj.get("d");
//        JSONObject devObject = (JSONObject) devArray.get(0);
//
//        //printDevName(dataSet);
//        for (int i = 0; i < devCount; i++) {
//            dataSet.dev.rds.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_rds"));
//
//            dataSet.dev.wrs.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_wrs"));
//
//            dataSet.dev.rdi.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_rdi"));
//
//            dataSet.dev.rdm.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_rdm"));
//
//            dataSet.dev.rdt.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_rdt"));
//
//            dataSet.dev.wri.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_wri"));
//
//            dataSet.dev.wrm.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_wrm"));
//
//            dataSet.dev.wrt.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_wrt"));
//
//            dataSet.dev.iop.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_iop"));
//
//            dataSet.dev.tot.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_tot"));
//
//            dataSet.dev.rqt.add(setDevStat(devObject, dataSet.devName.devNames[i] + "_rqt"));
//
//        }
//        printDiskStat(dataSet);
//
//    }
//
//    private static long setDevStat(JSONObject obj, String key) {
//        long devStat = 0;
//        if (obj.containsKey(key)) {
//            devStat = (long) obj.get(key);
//        }
//        return devStat;
//    }
//
//    private static int getDevCount(ArrayList array) {
//        JSONArray valueArray = (JSONArray) array.get(0);
//        JSONObject valueObject = (JSONObject) valueArray.get(0);
//
//        JSONArray devArray = (JSONArray) valueObject.get("d");
//        JSONObject devValues = (JSONObject) devArray.get(0);
//
//        int count = (devValues.size() / 11);
//        System.out.println(count);
//        return count;
//
//    }
//
//    //JSON convert
//    private static JSONArray ObjectToArray(String id, JSONObject jsonObject) {
//        JSONArray jsonArray = (JSONArray) jsonObject.get(id);
//        return jsonArray;
//    }
//
//    private static JSONObject ArrayToObject(int index, JSONArray jsonArray) {
//        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
//        return jsonObject;
//    }
//
//    //Debug
//    public static void printJSONArray(JSONArray ja) {
//        Iterator itr = ja.iterator();
//        //Iterator itr2 = logObject.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
//    }
//
//    public static void printJSONObject(JSONObject ja) {
//        //Iterator itr = jr.iterator();
//        String test = ja.toString();
//        //Iterator itr2 = logObject.iterator();
//
//        System.out.println(test);
//    }
//
//    public static void printArrayList(ArrayList list) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }
//
//    public static void printRAMSet(DataSet dataSet) {
//        for (int i = 0; i < dataSet.ram.usedMem.size(); i++) {
//            System.out.println(Long.toString(dataSet.ram.usedMem.get(i)));
//        }
//    }
//
//    public static void printUserCPU(DataSet dataSet) {
//        for (int i = 0; i < dataSet.cpu.uCPU.size(); i++) {
//            System.out.println(dataSet.cpu.uCPU.get(i));
//        }
//    }
//
//    public static void printSysCPU(DataSet dataSet) {
//        for (int i = 0; i < dataSet.cpu.sCPU.size(); i++) {
//            System.out.println(dataSet.cpu.sCPU.get(i));
//        }
//    }
//
//    public static void printDevName(DataSet dataSet) {
//        for (int i = 0; i < dataSet.devName.devNames.length; i++) {
//            System.out.println(dataSet.devName.devNames[i]);
//        }
//    }
//
//    public static void printDiskStat(DataSet dataSet) {
//        for (int i = 0; i < dataSet.dev.rds.size(); i++) {
//            System.out.println(dataSet.dev.rds.get(i));
//            System.out.println(dataSet.dev.wrs.get(i));
//            System.out.println(dataSet.dev.rdi.get(i));
//            System.out.println(dataSet.dev.rdm.get(i));
//            System.out.println(dataSet.dev.rdt.get(i));
//            System.out.println(dataSet.dev.wri.get(i));
//            System.out.println(dataSet.dev.wrm.get(i));
//            System.out.println(dataSet.dev.wrt.get(i));
//            System.out.println(dataSet.dev.iop.get(i));
//            System.out.println(dataSet.dev.tot.get(i));
//            System.out.println(dataSet.dev.rqt.get(i));
//
//        }
//    }
//
//}
