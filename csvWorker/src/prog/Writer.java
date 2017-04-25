package prog;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Writer {

	public static void write(String file, ArrayList<String> ar){
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(file), "utf-8"));
		    for(String s : ar){
		    	writer.write(s+"\n");
		    }
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
}
