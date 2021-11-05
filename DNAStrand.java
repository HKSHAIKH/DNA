import java.util.*;
import java.lang.String;

class DNAStrand{
	String str;
	
	DNAStrand(String arr){
		str=arr;
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
	
	public List<Node> checkhairpin(int k){
		List<Node> ans=new ArrayList<Node>();
		int N = str.length();
		for(int i=0;i<N-k;i++){
			for(int j=N-1;j>=i+k;j--){
				if(str.charAt(i)==this.theta(str.charAt(j))){
					int count=0;
					int m=i,n=j;
					for(;m<n;m++,n--){
						if(str.charAt(m)==this.theta(str.charAt(n))){
							count++;
						}
						else{
							break;
						}
					}
					if(count>=k){
						ans.add(new Node(i,m-1,j,n+1));
					}
				}
			
			}
		}
		return ans;
	}
	
	public static void main(String[] args){
		DNAStrand	dnaStrand = new DNAStrand("ATCGACTGGCTAACGTTACG");
		List<Node> ans = dnaStrand.checkhairpin(4);
		for(int i=0;i<ans.size();i++){
			System.out.println("1) "+ans.get(i).startIndex1+"-"+ans.get(i).endIndex1+", "+ans.get(i).startIndex2+"-"+ans.get(i).endIndex2+".");	
		}
		
	}
	
	
}
