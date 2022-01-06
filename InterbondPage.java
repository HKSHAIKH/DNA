import javax.swing.*;
import java.util.List;

public class InterbondPage {
	JFrame interbondFrame;
	List<Node> list;
	DNASamples sample;
	
	JTextArea[] a;
	
	JButton next;
	JButton prev;
	
	int count=0;
	
	InterbondPage(DNASamples sample, List<Node> list){
		
		interbondFrame = new JFrame("Intermolecularbonds");
		this.list = list;
		this.sample = sample;
		
		a = new JTextArea[16];
		for(int i=0;i<16;i++) {
			a[i] = new JTextArea();
		}
		
		
		
		prev = new JButton("Prev");
		next = new JButton("Next");
				
		for(int i=0;i<16;i++) {
			interbondFrame.add(a[i]);
			a[i].setBounds(300*(i%4), 150*(i/4), 300, 150);
		}
		
		interbondFrame.add(prev); interbondFrame.add(next);
		
		set(count);
		
		
		
		prev.setBounds(100,630,100,30);
		next.setBounds(800,630,100,30);
		
		
		interbondFrame.setLayout(null);
		interbondFrame.setBounds(0, 0, 1400, 800);
		interbondFrame.setVisible(true);
	}
	
	public void set(int count) {
		for(int i=0;i<16 && count+i<list.size();i++) {
			
			Node Node = list.get(count+i);
			int index1 = Node.strandIndex1;
			String str1 = sample.dnaSamples.get(index1).str;
			int index2 = Node.strandIndex2;
			String str2 = sample.dnaSamples.get(index2).str;
			int diff1 = Node.startIndex1-0;
			int diff2 = str2.length()-1-Node.startIndex2;
			int diff = Math.max(diff1, diff2);
			//int mid = (Node.endIndex1+Node.endIndex2)/2;
			String strfinal = "\n\n        ";
			for(int j=0;j<diff-diff1;j++) {
				strfinal+="   ";
			}
			for(int j=0;j<str1.length()-1;j++) {
				strfinal += str1.charAt(j)+"-";
			}
			strfinal += str1.charAt(str1.length()-1);
			strfinal += "\n        ";
			for(int j=0;j<diff-Math.min(diff1, diff2);j++) {
				strfinal+="   ";
			}
			for(int j=0;j<Math.min(Node.startIndex1-1-0, str2.length()-Node.startIndex2-1 );j++) {
				strfinal+="   ";
			}
			for(int j=0;j<Math.min(Node.endIndex1-Node.startIndex1+1,Node.startIndex2-Node.endIndex2+1);j++) {
				strfinal+="|  ";
			}
			strfinal += "\n        ";
			for(int j=0;j<diff-diff2;j++) {
				strfinal+="   ";
			}
			for(int j=str2.length()-1;j>0;j--) {
				strfinal += str2.charAt(j)+"-";
			}
			strfinal += str2.charAt(0);
			strfinal += "\n\n          stand indexes:"+index1+"and"+index2;
			a[i].setText(strfinal);
		}
		
	}
}
