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
		
		
		JButton btnStart = new JButton("ZAPOCNI IGRU");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(65, 105, 225));
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
		
		JLabel lblName = new JLabel("KORISNICKO IME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getSize() + 4f));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(126, 162, 170, 25);
		contentPane.add(lblName);
		
		poruka = new JLabel("");
		poruka.setForeground(Color.WHITE);
		poruka.setBounds(108, 248, 188, 27);
		poruka.setText("Igra će početi kada udju 3 igraca");
		contentPane.add(poruka);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/GUI/Pozadina.jpg"));
		lblNewLabel.setBounds(0, 0, 454, 478);
		contentPane.add(lblNewLabel);
		
		
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

