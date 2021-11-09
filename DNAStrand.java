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
					}
				}
			
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception{
		DNASamples sample = new DNASamples();
		System.out.print("How many DNA strands do you want to enter:");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.print("Enter value of k:");
		int k = sc.nextInt();
		
		System.out.println("Enter DNA strands.");
		
			for (int i=-1;i<N;i++) {
				if(i>=0) {
					System.out.print((i+1)+") ");
					String str = sc.nextLine();
					sample.add(i,str);
				}
				else {
					String str =sc.nextLine();
				}
			}
		
		List<Node> hairpins = sample.checkHairpins(k);
		List<Node> interbonds = sample.checkinterbonds(k);
		
		System.out.println("List of possible hairpin structures in given sample.");
		for(int i=0;i<hairpins.size();i++){
			System.out.println(i+1+") strand index:"+hairpins.get(i).strandIndex1+" indexes of hairpinbond "+hairpins.get(i).startIndex1+"-"+hairpins.get(i).endIndex1+", "+hairpins.get(i).startIndex2+"-"+hairpins.get(i).endIndex2+".");	
		}
		
		System.out.println("List of possible interbonds in given sample.");
		for(int i=0;i<interbonds.size();i++){
			System.out.println(i+1+") 1st strand index:"+interbonds.get(i).strandIndex1+", 2nd strand index:"+interbonds.get(i).strandIndex2+", indexes of interbond: 1) "+interbonds.get(i).startIndex1+"-"+interbonds.get(i).endIndex1+", 2) "+interbonds.get(i).startIndex2+"-"+interbonds.get(i).endIndex2+".");	
		}
		sc.close();
	}
	
	
}