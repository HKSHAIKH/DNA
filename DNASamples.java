import java.util.*;

class DNASamples{
	List<DNAStrand> dnaSamples;
	
	DNASamples(){
		dnaSamples = new ArrayList<DNAStrand>();
	}
	
	public void add(int index,String str){
		dnaSamples.add(new DNAStrand(index,str));
	}
	
	public char theta(char ch){
		switch(ch){
			case 'A':
					ch='T';
					break;
			case 'T':
					ch='A';
					break;
			case 'C':
					ch='G';
					break;
			case 'G':
					ch='C';
					break;
		}
		return ch;
	}
	
	
	public List<Node> checkThetaKbond (int index1,int index2,int k) {
		String str1 = dnaSamples.get(index1).str;
		String str2 = dnaSamples.get(index2).str;
		List<Node> ans = new ArrayList<Node>();
		
		for(int i=0;i<str1.length()-k;i++) {
			for(int j=str2.length()-1;j>=k;j--) {
				if(str1.charAt(i) == theta(str2.charAt(j))) {
					int count = 0;
					int m=i,n=j;
					for(;m<str1.length() && n>=0;m++,n--) {
						if(str1.charAt(m) == theta(str2.charAt(n))) {
							count++;
						}
						else {
							break;
						}
					}
					if(count >= k) {
						ans.add(new Node(index1,i,m-1,index2,j,n+1));
					}
				}
			}
		}
		return ans;
	}
	
	public List<Node> checkinterbonds(int k){
		int size = dnaSamples.size();
		List<Node> list = new ArrayList<Node>(size);
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++){
				list.addAll(this.checkThetaKbond(i,j,k));
			}
		}
		return list;
	}
}