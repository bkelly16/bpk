import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Log {

    static Object log = new Object();
    static JSONObject logObject = new JSONObject();
    static JSONArray logArray = new JSONArray();
    
    public static void  importLog(String file, DataSet set) throws IOException, ParseException
    {
        importFile(file); // imports log as an JSON Object and its corresponing Value of Arrays
        getHeaderValues(set);
        getThresholdValues(set);
        getMeasurementValues(set);
    }
    
    private static void importFile(String file) throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        log = parser.parse(new FileReader(file));
        logObject = (JSONObject) log;
        logArray = (JSONArray) logObject.get("log");  
    }
    private static void getHeaderValues(DataSet set)
    {
        JSONObject header = ArrayToObject(0, logArray);
        JSONArray headerArray = ObjectToArray("header", header);
        
        JSONObject headerValues = (JSONObject) headerArray.get(0);
        set.dateStamp = (long) headerValues.get("date");
        set.machineID = (String) headerValues.get("id");
        set.totalCPU = (double) headerValues.get("totalcpu");
        set.totalRAM = (long) headerValues.get("totalram");
        
        //printJSONObject(header);
        printJSONArray(headerArray);        
    }
    private static void getThresholdValues(DataSet set)
    {
        JSONObject threshold = ArrayToObject(1, logArray);
        JSONArray thresholdArray = ObjectToArray("threshold", threshold);
                
        JSONObject thresholdValues = (JSONObject) thresholdArray.get(0);
        set.iniTimeStamp = (long) thresholdValues.get("timestamp");
        set.thresholdcpu = (long) thresholdValues.get("thresholdcpu");
        set.thresholdram = (long) thresholdValues.get("thresholdram");
        set.thresholdDataBus = (long) thresholdValues.get("thresholddatabus");
        set.thresholdNetwork = (long) thresholdValues.get("thresholdnetwork");
        
        
        printJSONArray(thresholdArray);
        
    }        
    private static void getMeasurementValues(DataSet set)
    {
        JSONObject values = ArrayToObject(2, logArray);
        JSONArray valuesArray = (JSONArray) values.get("values");
        
        ArrayList<JSONArray> listofMeasurements = new ArrayList<>(values.size());
        
        for (int i=0; i<valuesArray.size();i++){ //Loop through valuesArray, get measureObject[i] enter into MeasurementList
            JSONObject measureObject = (JSONObject) valuesArray.get(i);
            JSONArray measureArray = (JSONArray) measureObject.get("m");
            listofMeasurements.add(measureArray);
        }
        
        for (int n = 0;n<listofMeasurements.size(); n++) { // Loop through the List of measurements
            JSONArray valueArray = (JSONArray) listofMeasurements.get(n); // create JSONArray out of current line
            JSONObject valueObject = (JSONObject) valueArray.get(0); // grab first entry in Array
            printJSONObject(valueObject);
            set.timeStamp.add((long) valueObject.get("t"));
            set.cpuLoad.add((double) valueObject.get("c"));
            set.memLoad.add((long) valueObject.get("r"));
            set.dataBus.add((long) valueObject.get("d"));
            set.networkBus.add((long) valueObject.get("n"));
        }  
    }
 
    private static JSONArray ObjectToArray(String id, JSONObject jsonObject)
    {
        JSONArray jsonArray = (JSONArray) jsonObject.get(id);
        return jsonArray;
    }
    private static JSONObject ArrayToObject(int index, JSONArray jsonArray)
    {
        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        return jsonObject;
    }
    
    //Debug
    public static void printJSONArray(JSONArray ja)
    {
        Iterator itr = ja.iterator();
        //Iterator itr2 = logObject.iterator();
        while(itr.hasNext()){    
            System.out.println(itr.next());
        }
    }  
    public static void printJSONObject(JSONObject ja)
    {
        //Iterator itr = jr.iterator();
        String test = ja.toString();
        //Iterator itr2 = logObject.iterator();
            
        System.out.println(test);
    }
    
    
}