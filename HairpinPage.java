import javax.swing.*;
import java.util.List;

public class HairpinPage {
	JFrame hairpinFrame;
	List<Node> list;
	DNASamples sample;
	
	JTextArea[] a;
	
	JButton next;
	JButton prev;
	
	int count=0;
	
	HairpinPage(DNASamples sample, List<Node> list){
		
		hairpinFrame = new JFrame("Hairpins");
		this.list = list;
		this.sample = sample;
		
		a = new JTextArea[16];
		for(int i=0;i<16;i++) {
			a[i] = new JTextArea();
		}
		
		
		
		prev = new JButton("Prev");
		next = new JButton("Next");
				
		for(int i=0;i<16;i++) {
			hairpinFrame.add(a[i]);
			a[i].setBounds(300*(i%4), 150*(i/4), 300, 150);
		}
		
		hairpinFrame.add(prev); hairpinFrame.add(next);
		
		set(count);
		
		
		
		prev.setBounds(100,630,100,30);
		next.setBounds(800,630,100,30);
		
		
		hairpinFrame.setLayout(null);
		hairpinFrame.setBounds(0, 0, 1400, 800);
		hairpinFrame.setVisible(true);
	}
	
	public void set(int count) {
		for(int i=0;i<16 && count+i<list.size();i++) {
			
			Node Node = list.get(count+i);
			int index =Node.strandIndex1;
			String str = sample.dnaSamples.get(index).str;
			int diff1 = Node.startIndex1-0;
			int diff2 = str.length()-1-Node.startIndex2;
			int diff = Math.max(diff1, diff2);
			int mid = (Node.endIndex1+Node.endIndex2)/2;
			String strfinal = "\n\n        ";
			for(int j=0;j<diff-diff1;j++) {
				strfinal+="   ";
			}
			for(int j=0;j<mid;j++) {
				strfinal += str.charAt(j)+"-";
			}
			strfinal += str.charAt(mid);
			strfinal += "\n        ";
			for(int j=0;j<diff-Math.min(diff1, diff2);j++) {
				strfinal+="   ";
			}
			for(int j=0;j<Math.min(Node.startIndex1-1-0, str.length()-Node.startIndex2-1 );j++) {
				strfinal+="   ";
			}
			for(int j=0;j<Math.min(mid+2-Node.startIndex1,Node.startIndex2-mid);j++) {
				strfinal+="|  ";
			}
			strfinal += "\n        ";
			for(int j=0;j<diff-diff2;j++) {
				strfinal+="   ";
			}
			for(int j=str.length()-1;j>mid+1;j--) {
				strfinal += str.charAt(j)+"-";
			}
			strfinal += str.charAt(mid+1);
			strfinal += "\n\n            stand index:"+index;
			a[i].setText(strfinal);
		}
		
	}
}
