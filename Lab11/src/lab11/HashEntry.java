package lab11;

public class HashEntry {
	public int element;
	public boolean isActive;
	
	public HashEntry(){
		element = 0;
		isActive = true;
	}
	
	public HashEntry(int v){
		element = v;
		isActive = true;
	}
	
	public HashEntry(int v, boolean b){
		element = v;
		isActive = b;
	}
	
}
