import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class InputPage {
	JFrame inputFrame;
	int N,K;
	String[] str;
	
	InputPage(int n,int k){
		this.N = n;
		this.K = k;
		this.str = new String[N];
		this.inputFrame = new JFrame("DNA Hybridization Recognizer");
		JLabel[]  labels = new JLabel[this.N];
		JTextField[] tfs = new JTextField[this.N];
		for(int i=0 ;i<N ;i++) {
			String string = "Enter DNAStrand "+(i+1);
			labels[i] = new JLabel(string);
			tfs[i] = new JTextField();
			inputFrame.add(labels[i]);inputFrame.add(tfs[i]);
			labels[i].setBounds(20, 50*(i+1), 200, 30);
			tfs[i].setBounds(230, 50*(i+1), 300, 30);
		}
		
		JButton b1 = new JButton("Check Hairpins");
		JButton b2 = new JButton("Check Interbonds");
		inputFrame.add(b1);inputFrame.add(b2);
		b1.setBounds(20, 100+50*N, 150, 30);
		b2.setBounds(220,100+50*N, 200, 30);
		JLabel la = new JLabel();
		la.setBounds(20, 150+50*N, 400, 30);
		inputFrame.add(la);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(int i=0;i<N;i++) {
						str[i] = tfs[i].getText();
						for(int j =0;j<str[i].length();j++) {
							if(str[i].charAt(j) != 'A' && str[i].charAt(j) != 'T' && str[i].charAt(j) != 'C' && str[i].charAt(j) != 'G') {
								throw new NumberFormatException();
							}
						}
					}
				
					DNASamples samples = new DNASamples(str);
					List<Node> list = new ArrayList<Node>();
					list = samples.checkHairpins(K);
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(inputFrame, "Hairpin does not exist.");
					}
					else {
						HairpinPage hairpinPage = new HairpinPage(samples,list);
					}
					
					la.setText("selected Button : Check Hairpins");
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(inputFrame, "Enter valid DNA.","Alert",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(int i=0;i<N;i++) {
						str[i] = tfs[i].getText();
						for(int j =0;j<str[i].length();j++) {
							if(str[i].charAt(j) != 'A' && str[i].charAt(j) != 'T' && str[i].charAt(j) != 'C' && str[i].charAt(j) != 'G') {
								throw new NumberFormatException();
							}
						}
					}
				
					DNASamples samples = new DNASamples(str);
					List<Node> list = new ArrayList<Node>();
					list = samples.checkinterbonds(K);
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(inputFrame, "Intermolecular bonds do not exist.");
					}
					else {
						InterbondPage interbondPage = new InterbondPage(samples,list);
					}
					
					la.setText("selected Button : Check Interbonds");
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(inputFrame, "Enter valid DNA.","Alert",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		});
		
		inputFrame.setLayout(null);
		inputFrame.setBounds(200,100,800,300+50*N);
		inputFrame.setVisible(true);
		//inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
