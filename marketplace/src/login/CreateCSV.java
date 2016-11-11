package login;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.*;

public class CreateCSV extends files.file {
	static Date dNow = new Date( );
    static SimpleDateFormat ft = 
    new SimpleDateFormat ("MMddMMhhmmss");
    private static final char SEPARATOR = ',';
    
    
    public static void create_csv_for_joinseller() throws IOException {
    	
    	String source = source_csv_for_joinseller;
        String destiantion= destiantion_csv_for_joinseller;
        String seller ="seller"+ft.format(dNow)+"@example.com" ;
        CreateCSV.updateCSV(source, destiantion, seller, 1, 2);
       

    }
    
    public static void updateCSV(String input, String output, String  replace, int row, int col) throws IOException {   
    	CSVReader reader = new CSVReader(new FileReader(input),',');

            List<String[]> csvBody = reader.readAll();
            csvBody.get(row)[col]=replace;
            reader.close();

            CSVWriter writer = new CSVWriter(new FileWriter(output),SEPARATOR);
              
            writer.writeAll(csvBody);
            writer.flush();
            writer.close(); 
    }


     

}