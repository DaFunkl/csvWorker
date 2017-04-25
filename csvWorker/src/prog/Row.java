package prog;

public class Row {
	String[] r;
	
	public Row(String[] x){
		r = x;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r.length; i++){
			sb.append(r[i]+((i+1)<r.length ? ";" : ""));
		}
		return sb.toString();
	}
}
