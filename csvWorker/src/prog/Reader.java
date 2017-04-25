package prog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	public static ArrayList<Row> read(String file) {
		ArrayList<Row> ret = new ArrayList<Row>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		try {

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(cvsSplitBy);
				ret.add(new Row(row));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}
