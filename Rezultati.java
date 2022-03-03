package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Rezultati extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf2;
	private JLabel pozadina;

	public Rezultati(String i1, String i2, String i3, int b1, int b2, int b3) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KRAJ IGRE");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 12f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 20, 461, 55);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblprvi = new JLabel(i1 + " " + b1);
		lblprvi.setFont(lblprvi.getFont().deriveFont(lblprvi.getFont().getSize() + 6f));
		lblprvi.setHorizontalAlignment(SwingConstants.CENTER);
		lblprvi.setForeground(new Color(245, 255, 250));
		lblprvi.setBounds(199, 125, 90, 24);
		contentPane.add(lblprvi);
		
		JLabel lbldrugi = new JLabel(i2 + " " + b2);
		lbldrugi.setFont(lbldrugi.getFont().deriveFont(lbldrugi.getFont().getSize() + 6f));
		lbldrugi.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrugi.setForeground(new Color(245, 255, 250));
		//lbldrugi.setBounds(78, 160, 95, 24);
		contentPane.add(lbldrugi);
		
		JLabel lbltreci = new JLabel(i3 + " " + b3);
		lbltreci.setFont(lbltreci.getFont().deriveFont(lbltreci.getFont().getSize() + 6f));
		lbltreci.setHorizontalAlignment(SwingConstants.CENTER);
		lbltreci.setForeground(new Color(245, 255, 250));
		//lbltreci.setBounds(315, 182, 96, 24);
		contentPane.add(lbltreci);
		
		
		tf1 = new JTextField();
		tf1.setEnabled(false);
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setFont(tf1.getFont().deriveFont(tf1.getFont().getSize() + 28f));
		tf1.setText("1.");
		tf1.setForeground(new Color(245, 255, 250));
		tf1.setBackground(new Color(0, 0, 128));
		tf1.setBounds(199, 159, 96, 128);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setHorizontalAlignment(SwingConstants.CENTER);
		tf3.setFont(tf3.getFont().deriveFont(tf3.getFont().getSize() + 20f));
		tf3.setBackground(new Color(0, 0, 128));
		tf3.setForeground(new Color(245, 255, 250));
		if(b1==b2 && b2==b3) {
			tf3.setText("1.");
			tf3.setBounds(315, 159, 96, 128);
			lbltreci.setBounds(315, 131, 96, 24);
		}
		
		else if (b2==b3) {
			tf3.setText("2.");
			tf3.setBounds(315, 194, 96, 93);
			lbltreci.setBounds(315, 160, 96, 24);
		}
		else {
			tf3.setText("3.");
			tf3.setBounds(315, 214, 96, 73);
			lbltreci.setBounds(315, 182, 96, 24);
			
		}
		
		tf3.setEnabled(false);
	//	tf3.setBounds(315, 214, 96, 73);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEnabled(false);
		if(b1==b2) {
			tf2.setText("1.");
			tf2.setBounds(78, 159, 96, 128);
			lbldrugi.setBounds(78, 125, 95, 24);
		//	tf1.setBounds(199, 159, 96, 128);
		}
		
		else {
			tf2.setText("2.");
			tf2.setBounds(78, 194, 96, 93);
			lbldrugi.setBounds(78, 160, 95, 24);
			//tf2.setBounds(78, 194, 96, 93);
		}

		tf2.setBackground(new Color(0, 0, 128));
		tf2.setForeground(new Color(245, 255, 250));
		tf2.setFont(tf2.getFont().deriveFont(tf2.getFont().getSize() + 23f));
		tf2.setHorizontalAlignment(SwingConstants.CENTER);
		tf2.setToolTipText("");
		
		contentPane.add(tf2);
		tf2.setColumns(10);
		

		
		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("./src/GUI/Pozadina.jpg"));
		pozadina.setBounds(0, 0, 471, 401);
		contentPane.add(pozadina);
	}

}
