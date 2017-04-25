package prog;

import java.util.ArrayList;
import java.util.HashMap;

public class Container {
	ArrayList<Row> rows;
	String file;
	String path;
	int num;
	
	public Container(String file, String path, int num){
		this.file = file;
		this.path = path;
		this.num = num;
		System.out.println("Reading file:");
		rows = Reader.read(file);
		System.out.println("Reading done");
		Timer.now();
		System.out.println("Starting Analysis:");
		Analyze a = new Analyze(rows);
		System.out.println("Analysis finished:");
		Timer.now();
		System.out.println("Starting FileWriter:");
		writeFile(a);
		System.out.println("Finished Writing");
		Timer.now();
	}
	
	public void writeFile(Analyze a){
		Writer.write(path+"ColumnLength"+num+".txt", prepareColumnLengths(a.columnMax));
		Writer.write(path+"RowAmt"+num+".txt", prepareRowAmt(a.RowSizes));
		Writer.write(path+"FailedRows"+num+".txt", a.failedRows);
	}
	
	public ArrayList<String> prepareRowAmt(HashMap<Integer,Integer> hm){
		ArrayList<String> ret = new ArrayList<String>();
		for(int i : hm.keySet()){
			ret.add("RowSize["+i+"] -> amt: "+hm.get(i));
		}
		return ret;
	}

	public ArrayList<String> prepareColumnLengths(int[] a){
		ArrayList<String> ret = new ArrayList<String>();
		for(int i = 0; i < a.length; i++){
			ret.add("Row["+i+"] <-> MaxWidth[" + a[i] + "]");
		}
		return ret;
	}
	
}
