package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Pobjednik extends JFrame {

	private JPanel contentPane;
	private JTextField tfPobjednik;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Pobjednik frame = new Pobjednik("sasa");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Pobjednik(String ime) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POBJEDNIK");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 6f));
		lblNewLabel.setBounds(132, 36, 138, 47);
		contentPane.add(lblNewLabel);
		
		tfPobjednik = new JTextField(ime);
		tfPobjednik.setBounds(98, 110, 192, 37);
		contentPane.add(tfPobjednik);
		tfPobjednik.setColumns(10);
		tfPobjednik.setEditable(false);
		
		JLabel lblPozadina = new JLabel("");
	
		lblPozadina.setIcon(new ImageIcon("./src/GUI/Pozadina.jpg"));
		lblPozadina.setBounds(0, 0, 399, 255);
		contentPane.add(lblPozadina);
	}
}