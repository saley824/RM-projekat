package GUI;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Prijava extends JFrame implements ActionListener{
	private JTextField textName;
	public JPanel contentPane,gameContentPane;
	public JLabel poruka;
	
	public Korisnik k;
	public Prijava() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 486);
		contentPane = new JPanel();
		contentPane.setFont(contentPane.getFont().deriveFont(contentPane.getFont().getSize() + 4f));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnStart = new JButton("ZAPO\u010CNI IGRU");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(173, 216, 230));
		btnStart.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(135, 206, 250), new Color(95, 158, 160), null, null));
		btnStart.setFont(btnStart.getFont().deriveFont(btnStart.getFont().getSize() + 5f));
		btnStart.setBounds(126, 285, 170, 32);
		btnStart.addActionListener(this);
		contentPane.add(btnStart);
		
		textName = new JTextField();
		textName.setFont(textName.getFont().deriveFont(textName.getFont().getSize() + 5f));
		textName.setBounds(126, 207, 170, 32);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblName = new JLabel("Korisni\u010Dko ime");
		lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getSize() + 4f));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(126, 162, 170, 25);
		contentPane.add(lblName);
		
		poruka = new JLabel("");
		poruka.setBounds(136, 245, 160, 27);
		poruka.setText("Igra će početi kad se skupe 3 igraca");
		contentPane.add(poruka);
		
		
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(textName.getText());
		
		//Igra igra = new Igra();
		//IgraNit nit=new IgraNit(igra);
		//nit.start();
		
		
			this.setVisible(false);
			k=new Korisnik(textName.getText());
			k.execute();
		
		//k=new Korisnik(textName.getText());
		//igra.setVisible(true);
		
		
		
	}
}

