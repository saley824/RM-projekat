package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class Rezultati extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf2;
	private JLabel pozadina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rezultati frame = new Rezultati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rezultati() {
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
		tf3.setText("3.");
		tf3.setEnabled(false);
		tf3.setBounds(315, 214, 96, 73);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEnabled(false);
		tf2.setText("2.");
		tf2.setBackground(new Color(0, 0, 128));
		tf2.setForeground(new Color(245, 255, 250));
		tf2.setFont(tf2.getFont().deriveFont(tf2.getFont().getSize() + 23f));
		tf2.setHorizontalAlignment(SwingConstants.CENTER);
		tf2.setToolTipText("");
		tf2.setBounds(78, 194, 96, 93);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JLabel lblprvi = new JLabel("New label");
		lblprvi.setFont(lblprvi.getFont().deriveFont(lblprvi.getFont().getSize() + 6f));
		lblprvi.setHorizontalAlignment(SwingConstants.CENTER);
		lblprvi.setForeground(new Color(245, 255, 250));
		lblprvi.setBounds(199, 131, 90, 24);
		contentPane.add(lblprvi);
		
		JLabel lbldrugi = new JLabel("New label");
		lbldrugi.setFont(lbldrugi.getFont().deriveFont(lbldrugi.getFont().getSize() + 6f));
		lbldrugi.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrugi.setForeground(new Color(245, 255, 250));
		lbldrugi.setBounds(78, 160, 95, 24);
		contentPane.add(lbldrugi);
		
		JLabel lbltreci = new JLabel("New label");
		lbltreci.setFont(lbltreci.getFont().deriveFont(lbltreci.getFont().getSize() + 6f));
		lbltreci.setHorizontalAlignment(SwingConstants.CENTER);
		lbltreci.setForeground(new Color(245, 255, 250));
		lbltreci.setBounds(315, 182, 96, 24);
		contentPane.add(lbltreci);
		
		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("./src/GUI/Pozadina.jpg"));
		pozadina.setBounds(0, 0, 471, 401);
		contentPane.add(pozadina);
	}

}
