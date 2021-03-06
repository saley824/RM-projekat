package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Igra extends JFrame implements ActionListener{
	protected SwingWorker worker;
	protected JPanel contentPane;
	protected boolean spremnoSlanje;
	protected JTextField slovo; //polje za slovo
	protected JTextField tfDrzava;
	protected JTextField tfRijeka;
	protected JTextField tfPlanina;
	protected JTextField tfGrad;
	protected JTextField tfBiljka;
	protected String primjedbe;
	protected JLabel lblPodloga;
	private JTextField ime;
	private JTextField bodovi;
	//protected Rjesenja r = new Rjesenja();
	
	 private void initializeWorker() {
	        worker = new SwingWorker<Void, Void>() {

	            @Override
	            protected Void doInBackground() throws Exception {
	               
	                while (!isCancelled()) {
	                  
	                }
	                System.out.println("Gotovo");
	                
	                return null;
	            }

	            
	        };
	    }
	 public Igra(String imeKorisnika, int brojBodova) {
			this.spremnoSlanje=false;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 458, 486);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			slovo = new JTextField();
			slovo.setForeground(new Color(65, 105, 225));
			//slovo.setEnabled(false);
			slovo.setEditable(false);
			slovo.setFont(slovo.getFont().deriveFont(slovo.getFont().getStyle() | Font.BOLD, slovo.getFont().getSize() + 5f));
			//txtS.setText("S");
			slovo.setHorizontalAlignment(SwingConstants.CENTER);
			slovo.setBounds(98, 69, 254, 33);
			contentPane.add(slovo);
			slovo.setColumns(10);
			
			JLabel lblDrzava = new JLabel("Dr\u017Eava:");
			lblDrzava.setForeground(new Color(255, 255, 255));
			lblDrzava.setFont(lblDrzava.getFont().deriveFont(lblDrzava.getFont().getSize() + 4f));
			lblDrzava.setBounds(75, 144, 73, 25);
			contentPane.add(lblDrzava);
			
			JLabel lblRijeka = new JLabel("Rijeka:");
			lblRijeka.setForeground(new Color(255, 255, 255));
			lblRijeka.setFont(lblRijeka.getFont().deriveFont(lblRijeka.getFont().getSize() + 4f));
			lblRijeka.setBounds(75, 199, 73, 25);
			contentPane.add(lblRijeka);
			
			JLabel lblPlanina = new JLabel("Planina:");
			lblPlanina.setForeground(new Color(255, 255, 255));
			lblPlanina.setFont(lblPlanina.getFont().deriveFont(lblPlanina.getFont().getSize() + 4f));
			lblPlanina.setBounds(75, 251, 73, 25);
			contentPane.add(lblPlanina);
			
			JLabel lblGrad = new JLabel("Grad:");
			lblGrad.setForeground(new Color(255, 255, 255));
			lblGrad.setFont(lblGrad.getFont().deriveFont(lblGrad.getFont().getSize() + 4f));
			lblGrad.setBounds(75, 297, 73, 25);
			contentPane.add(lblGrad);
			
			JLabel lblBiljka = new JLabel("Biljka:");
			lblBiljka.setForeground(new Color(255, 255, 255));
			lblBiljka.setFont(lblBiljka.getFont().deriveFont(lblBiljka.getFont().getSize() + 4f));
			lblBiljka.setBounds(75, 343, 73, 25);
			contentPane.add(lblBiljka);
			
			tfDrzava = new JTextField();
			tfDrzava.setFont(tfDrzava.getFont().deriveFont(tfDrzava.getFont().getSize() + 4f));
			tfDrzava.setBounds(189, 144, 163, 25);
			contentPane.add(tfDrzava);
			tfDrzava.setColumns(10);
			
			tfRijeka = new JTextField();
			tfRijeka.setFont(tfRijeka.getFont().deriveFont(tfRijeka.getFont().getSize() + 4f));
			tfRijeka.setBounds(189, 199, 163, 25);
			contentPane.add(tfRijeka);
			tfRijeka.setColumns(10);
			
			tfPlanina = new JTextField();
			tfPlanina.setFont(tfPlanina.getFont().deriveFont(tfPlanina.getFont().getSize() + 4f));
			tfPlanina.setBounds(189, 251, 163, 25);
			contentPane.add(tfPlanina);
			tfPlanina.setColumns(10);
			
			tfGrad = new JTextField();
			tfGrad.setFont(tfGrad.getFont().deriveFont(tfGrad.getFont().getSize() + 4f));
			tfGrad.setBounds(189, 297, 163, 25);
			contentPane.add(tfGrad);
			tfGrad.setColumns(10);
			
			tfBiljka = new JTextField();
			tfBiljka.setFont(tfBiljka.getFont().deriveFont(tfBiljka.getFont().getSize() + 4f));
			tfBiljka.setBounds(189, 343, 163, 25);
			contentPane.add(tfBiljka);
			tfBiljka.setColumns(10);
			
			JButton btnPotvrdi = new JButton("POTVRDI");
			btnPotvrdi.setFont(btnPotvrdi.getFont().deriveFont(btnPotvrdi.getFont().getSize() + 5f));
			btnPotvrdi.setBackground(new Color(65, 105, 225));
			btnPotvrdi.setForeground(new Color(255, 255, 255));
			btnPotvrdi.setBounds(148, 406, 150, 33);
			btnPotvrdi.addActionListener(this);
			contentPane.add(btnPotvrdi);
			
			lblPodloga = new JLabel("");
			lblPodloga.setForeground(Color.WHITE);
			lblPodloga.setFont(lblPodloga.getFont().deriveFont(lblPodloga.getFont().getSize() + 4f));
			lblPodloga.setIcon(new ImageIcon("./src/GUI/Pozadina.jpg"));
			lblPodloga.setBounds(0, 0, 444, 471);
			contentPane.add(lblPodloga);
			
			ime = new JTextField();
			ime.setFont(ime.getFont().deriveFont(ime.getFont().getSize() + 4f));
			ime.setSelectionColor(new Color(0, 0, 205));
			//ime.setEnabled(false);
			ime.setEditable(false);
			//textField.setEditable(false);
			ime.setHorizontalAlignment(SwingConstants.CENTER);
			ime.setBounds(27, 17, 121, 33);
			contentPane.add(ime);
			ime.setColumns(10);
			ime.setText(imeKorisnika);
			
			bodovi = new JTextField(brojBodova+"");
			bodovi.setFont(ime.getFont().deriveFont(ime.getFont().getSize() + 4f));
			bodovi.setSelectionColor(new Color(0, 0, 205));
			
			bodovi.setEditable(false);
			bodovi.setHorizontalAlignment(SwingConstants.CENTER);
			bodovi.setBounds(300, 17, 121, 33);
			contentPane.add(bodovi);
			bodovi.setColumns(10);
			
			
			
			
			this.worker=new SWIgra();
			this.worker.execute();
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.spremnoSlanje = true;
		this.worker.cancel(true);
		this.setVisible(false);
		//this.r = new Rjesenja();
		//r.setVisible(true);
		
		
	}
	}