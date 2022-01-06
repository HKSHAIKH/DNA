import javax.swing.*;
import java.awt.event.*;

public class Index {
	JFrame frame;
	int N,K;
	
	Index(){
		frame = new JFrame("DNA Hybridization Recognizer");
		JButton b = new JButton("Next");
		JLabel l1 = new JLabel("How many Strand do you want to Enter? ");
		JLabel l2 = new JLabel("Enter value of k");
		JLabel l3 = new JLabel();
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		frame.add(l1);frame.add(tf1);frame.add(l2);frame.add(tf2);frame.add(b);frame.add(l3);
		l1.setBounds(50,50,300,30);
		tf1.setBounds(50,100,300,30);
		l2.setBounds(50,150,300,30);
		tf2.setBounds(50,200,300,30);
		b.setBounds(100,300,100,30);
		l3.setBounds(50,350,300,30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String str = tf1.getText();
					N = Integer.parseInt(str);
					str = tf2.getText();
					K = Integer.parseInt(str);
					l3.setText("N="+N+", K="+K);
					InputPage inputPage = new InputPage(N,K);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(frame, "Enter valid number.","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		frame.setLayout(null);
		frame.setBounds(200,100,400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
