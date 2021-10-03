package RM;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Igra extends JFrame implements ActionListener{

	protected JPanel contentPane;
	protected boolean spremnoSlanje=false;
	protected JTextField txtS; //polje za slovo
	protected JTextField tfDrzava;
	protected JTextField tfRijeka;
	protected JTextField tfPlanina;
	protected JTextField tfGrad;
	protected JTextField tfBiljka;
	protected String primjedbe;
	protected Rjesenja r = new Rjesenja();
	public Igra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtS = new JTextField();
		txtS.setEnabled(false);
		txtS.setFont(txtS.getFont().deriveFont(txtS.getFont().getStyle() | Font.BOLD, txtS.getFont().getSize() + 5f));
		txtS.setText("S");
		txtS.setHorizontalAlignment(SwingConstants.CENTER);
		txtS.setBounds(75, 27, 277, 33);
		contentPane.add(txtS);
		txtS.setColumns(10);
		
		JLabel lblDrzava = new JLabel("Dr\u017Eava:");
		lblDrzava.setFont(lblDrzava.getFont().deriveFont(lblDrzava.getFont().getSize() + 4f));
		lblDrzava.setBounds(75, 94, 73, 25);
		contentPane.add(lblDrzava);
		
		JLabel lblRijeka = new JLabel("Rijeka:");
		lblRijeka.setFont(lblRijeka.getFont().deriveFont(lblRijeka.getFont().getSize() + 4f));
		lblRijeka.setBounds(75, 150, 73, 25);
		contentPane.add(lblRijeka);
		
		JLabel lblPlanina = new JLabel("Planina:");
		lblPlanina.setFont(lblPlanina.getFont().deriveFont(lblPlanina.getFont().getSize() + 4f));
		lblPlanina.setBounds(75, 202, 73, 25);
		contentPane.add(lblPlanina);
		
		JLabel lblGrad = new JLabel("Grad:");
		lblGrad.setFont(lblGrad.getFont().deriveFont(lblGrad.getFont().getSize() + 4f));
		lblGrad.setBounds(75, 259, 73, 25);
		contentPane.add(lblGrad);
		
		JLabel lblBiljka = new JLabel("Biljka:");
		lblBiljka.setFont(lblBiljka.getFont().deriveFont(lblBiljka.getFont().getSize() + 4f));
		lblBiljka.setBounds(75, 308, 73, 25);
		contentPane.add(lblBiljka);
		
		tfDrzava = new JTextField();
		tfDrzava.setFont(tfDrzava.getFont().deriveFont(tfDrzava.getFont().getSize() + 4f));
		tfDrzava.setBounds(189, 94, 163, 25);
		contentPane.add(tfDrzava);
		tfDrzava.setColumns(10);
		
		tfRijeka = new JTextField();
		tfRijeka.setFont(tfRijeka.getFont().deriveFont(tfRijeka.getFont().getSize() + 4f));
		tfRijeka.setBounds(189, 150, 163, 25);
		contentPane.add(tfRijeka);
		tfRijeka.setColumns(10);
		
		tfPlanina = new JTextField();
		tfPlanina.setFont(tfPlanina.getFont().deriveFont(tfPlanina.getFont().getSize() + 4f));
		tfPlanina.setBounds(189, 202, 163, 25);
		contentPane.add(tfPlanina);
		tfPlanina.setColumns(10);
		
		tfGrad = new JTextField();
		tfGrad.setFont(tfGrad.getFont().deriveFont(tfGrad.getFont().getSize() + 4f));
		tfGrad.setBounds(189, 259, 163, 25);
		contentPane.add(tfGrad);
		tfGrad.setColumns(10);
		
		tfBiljka = new JTextField();
		tfBiljka.setFont(tfBiljka.getFont().deriveFont(tfBiljka.getFont().getSize() + 4f));
		tfBiljka.setBounds(189, 308, 163, 25);
		contentPane.add(tfBiljka);
		tfBiljka.setColumns(10);
		
		JButton btnPotvrdi = new JButton("POTVRDI");
		btnPotvrdi.setFont(btnPotvrdi.getFont().deriveFont(btnPotvrdi.getFont().getSize() + 5f));
		btnPotvrdi.setBackground(new Color(173, 216, 230));
		btnPotvrdi.setForeground(new Color(255, 255, 255));
		btnPotvrdi.setBounds(130, 375, 150, 33);
		btnPotvrdi.addActionListener(this);
		contentPane.add(btnPotvrdi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		spremnoSlanje = true;
		this.r = new Rjesenja();
		r.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Igra igra=new Igra();
		igra.setVisible(true);
	}
	
}
