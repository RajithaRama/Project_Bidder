/**
 * Created by Rama on 9/23/2015.
 */

import oracle.jrockit.jfr.StringConstantPool;

import java.io.*;
import java.util.*;

public class DBStocks {
    private static Map<String, Tuple<String, Double>> stockList;
    private String [] fields;

    public DBStocks(String cvsFile, String key, String value1,String value2) {
        FileReader fileRd=null;
        BufferedReader reader=null;

        try {
            fileRd = new FileReader(cvsFile);
            reader = new BufferedReader(fileRd);

	    /* read the CSV file's first line which has
	     * the names of fields.
	     */
            String header = reader.readLine();
            fields = header.split(",");// keep field names

            // find where the key and the value are
            int keyIndex = findIndex(key);
            int val1Index = findIndex(value1);
            int val2Index = findIndex(value2);

            if(keyIndex == -1 || val1Index == -1 || val2Index == -1)
                throw new IOException("CVS file does not have data");
            // note how you can throw a new exception

            // get a new hash map
            stockList = new HashMap<String, Tuple<String,Double>>();

	    /* read each line, getting it split by ,
	     * use the indexes to get the key and value
	     */
            String [] tokens;
            Tuple<String, Double> tokens2;
            for(String line = reader.readLine();
                line != null;
                line = reader.readLine()) {
                tokens = line.split(",");
                try {
                    tokens2 = new Tuple<String, Double>(tokens[val1Index], Double.parseDouble(tokens[val2Index]));
                }catch(java.lang.NumberFormatException e){
                    tokens2 = new Tuple<String, Double>(tokens[val1Index], 0.00);
                }
                    stockList.put(tokens[keyIndex], tokens2);
            }

            if(fileRd != null) fileRd.close();
            if(reader != null) reader.close();

            // I can catch more than one exceptions
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Malformed CSV file");
            System.out.println(e);
        }
    }

    private int findIndex(String key) {
        for(int i=0; i < fields.length; i++)
            if(fields[i].equals(key)) return i;
        return -1;
    }

    public String findName(String key) {
        Tuple<String,Double> arr = stockList.get(key);
        return arr.x;
    }
    public boolean isin(String key){
        return stockList.containsKey(key);
    }

    public double findPrice(String key) {
        Tuple<String, Double> arr = stockList.get(key);
        return arr.y;
    }

    public int updatePrice(String key, String line) {
        try {
            Tuple<String, Double> arr = stockList.get(key);
            arr.y = Double.parseDouble(line);
            stockList.replace(key, arr);
        }catch (java.lang.NumberFormatException e){
            return -1;
        }
        return 0;

    }
}
