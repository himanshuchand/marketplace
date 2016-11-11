package login;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.*;

public class CreateCSV {
	static Date dNow = new Date( );
    static SimpleDateFormat ft = 
    new SimpleDateFormat ("MMddMMhhmmss");

    
    private static final char SEPARATOR = ',';

    public static void updateCSV(String input, String output, String  replace, int row, int col) throws IOException {   
    	CSVReader reader = new CSVReader(new FileReader(input),',');
//        String [] nextLine;
//        while ((nextLine = reader.readNext()) != null) {
//           // nextLine[] is an array of values from the line
//           System.out.println(nextLine[0] + nextLine[1] + "etc...");
//        }
//          CSVReader reader = new CSVReader(new FileReader(input), SEPARATOR);
            List<String[]> csvBody = reader.readAll();
            csvBody.get(row)[col]=replace;
            reader.close();

            CSVWriter writer = new CSVWriter(new FileWriter(output),SEPARATOR);
              
            writer.writeAll(csvBody);
            writer.flush();
            writer.close(); 
    }


     static void create_csv_for_joinseller() throws IOException {

        String source = "/home/users/himanshu.chand/Documents/marketplace/joinseller1.csv";
        String destiantion="/home/users/himanshu.chand/Documents/marketplace/joinseller.csv";
        String seller ="seller"+ft.format(dNow)+"@example.com" ;
        CreateCSV.updateCSV(source, destiantion, seller, 1, 2);
       

    }

}