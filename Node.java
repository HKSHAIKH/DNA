
public class Node{
	int strandIndex1;
	int startIndex1;
	int endIndex1;
	int strandIndex2;
	int startIndex2;
	int endIndex2;
	
	Node(int strandIndex1,int startIndex1,int endIndex1,int strandIndex2,int startIndex2,int endIndex2){
		this.strandIndex1 = strandIndex1;
		this.startIndex1  = startIndex1;
		this.endIndex1    = endIndex1;
		this.strandIndex2 = strandIndex2;
		this.startIndex2  = startIndex2;
		this.endIndex2    = endIndex2;
	} 
	
	public String toString() {
		return "{"+strandIndex1+", "+startIndex1+", "+endIndex1+", "+strandIndex2+", "+startIndex2+", "+endIndex2+" }";
	}
}