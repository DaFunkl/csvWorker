package prog;

import java.util.ArrayList;
import java.util.HashMap;

public class Analyze {
	HashMap<Integer, Integer> RowSizes = new HashMap<Integer, Integer>();
	int[] columnMax = new int[123];
	ArrayList<String> failedRows = new ArrayList<String>();

	public Analyze(ArrayList<Row> r){
		countRowSizes(r);
	}
	
	public void countRowSizes(ArrayList<Row> ar) {
		int i = 0;
		for (Row r : ar) {
			incHM(RowSizes, r.r.length, 1);
			if (r.r.length == 123)
				checkColumnMax(r.r);
			else
				addFailedRow(r.toString(), i);
			i++;
		}
	}

	public void addFailedRow(String string, int i) {
		failedRows.add("Row:"+i+";"+string);
	}

	public void checkColumnMax(String[] r) {
		for (int i = 0; i < r.length; i++) {
			if (columnMax[i] < r[i].length())
				columnMax[i] = r[i].length();
		}
	}

	public void incHM(HashMap<Integer, Integer> hm, int key, int amt) {
		int a = amt;
		if (hm.keySet().contains(key)) {
			a += hm.get(key);
		}
		hm.put(key, a);
	}
}
