import java.util.*;
import java.lang.String;

public class DNAStrand{
	int index;
	String str;
	
	DNAStrand(int index,String arr){
		this.index = index;
		this.str   = arr;
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
		int found = 0;
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
						ans.add(new Node(index,i,m-1,index,j,n+1));
						found = 1;
						break;
					}
				}
			
			}
			if(found == 1) {
				break;
			}
		}
		return ans;
	}
	
	
	
	
}