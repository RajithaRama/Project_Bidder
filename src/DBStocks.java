/**
 * Created by Rama on 9/23/2015.
 */

import java.io.*;
import java.util.*;

public class DBStocks {
    private Map<String, String[]> stockList;
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
            stockList = new HashMap<String, String[]>();

	    /* read each line, getting it split by ,
	     * use the indexes to get the key and value
	     */
            String [] tokens;
            String [] tokens2 = new String[2];
            for(String line = reader.readLine();
                line != null;
                line = reader.readLine()) {
                tokens = line.split(",");
                tokens2[0] = tokens[val1Index];
                tokens2[1] = tokens[val2Index];
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
        String[] arr = stockList.get(key);
        return arr[0];
    }
}
