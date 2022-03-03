package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Rjesenja extends JFrame implements ActionListener{
	Korisnik korisnik;
	protected String primjedba="";
	protected boolean PrimjedbeSpremne = false;
	private JPanel contentPane;
	private JTextField tfIgrac1,tfIgrac2,tfIgrac3,tfIgrac4;
	private JTextField tfDrzava1,tfDrzava2,tfDrzava3,tfDrzava4;
	private JTextField tfRijeka1,tfRijeka2,tfRijeka3,tfRijeka4;
	private JTextField tfPlanina1,tfPlanina2,tfPlanina3,tfPlanina4;
	private JTextField tfGrad1,tfGrad2,tfGrad3,tfGrad4;
	private JTextField tfBiljka1,tfBiljka2,tfBiljka3,tfBiljka4;
	protected JTextField [] tfIgraci=new JTextField[4];
	protected JTextField [] tfDrzave=new JTextField[4];
	protected JTextField [] tfRijeke=new JTextField[4];
	protected JTextField [] tfBiljke=new JTextField[4];
	protected JTextField [] tfPlanine=new JTextField[4];
	protected JTextField [] tfGradovi=new JTextField[4];
	protected JRadioButton[][] rbni=new JRadioButton[3][5];
	JButton btnPrimjedbe;
	
	public Rjesenja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691,793);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIgrac1 = new JLabel("IGRA\u010C:");
		lblIgrac1.setForeground(new Color(255, 255, 255));
		lblIgrac1.setFont(lblIgrac1.getFont().deriveFont(lblIgrac1.getFont().getSize() + 4f));
		lblIgrac1.setBounds(20, 57, 67, 25);
		contentPane.add(lblIgrac1);
		
		tfIgrac1 = new JTextField();
		tfIgrac1.setEditable(false);
		tfIgrac1.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac1.setBounds(97, 59, 121, 25);
		tfIgraci[0] = tfIgrac1;
		contentPane.add(tfIgrac1);
		tfIgrac1.setColumns(10);
		
		JLabel lbldrzava1 = new JLabel("DR\u017DAVA");
		lbldrzava1.setForeground(new Color(255, 255, 255));
		lbldrzava1.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrzava1.setFont(lbldrzava1.getFont().deriveFont(lbldrzava1.getFont().getSize() + 2f));
		lbldrzava1.setBounds(20, 113, 90, 25);
		contentPane.add(lbldrzava1);
		
		tfDrzava1 = new JTextField();
		tfDrzava1.setFont(tfDrzava1.getFont().deriveFont(tfDrzava1.getFont().getSize() + 2f));
		tfDrzava1.setEditable(false);
		tfDrzava1.setBounds(20, 148, 90, 19);
		tfDrzave[0] = tfDrzava1;
		contentPane.add(tfDrzava1);
		tfDrzava1.setColumns(10);
		
		JLabel lblRijeka1 = new JLabel("RIJEKA");
		lblRijeka1.setForeground(new Color(255, 255, 255));
		lblRijeka1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka1.setFont(lblRijeka1.getFont().deriveFont(lblRijeka1.getFont().getSize() + 2f));
		lblRijeka1.setBounds(128, 112, 82, 25);
		contentPane.add(lblRijeka1);
		
		tfRijeka1 = new JTextField();
		tfRijeka1.setEditable(false);
		tfRijeka1.setFont(tfRijeka1.getFont().deriveFont(tfRijeka1.getFont().getSize() + 2f));
		tfRijeka1.setBounds(128, 147, 90, 20);
		tfRijeke[0] = tfRijeka1;
		contentPane.add(tfRijeka1);
		tfRijeka1.setColumns(10);
		
		JLabel lblPlanina1 = new JLabel("PLANINA");
		lblPlanina1.setForeground(new Color(255, 255, 255));
		lblPlanina1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina1.setFont(lblPlanina1.getFont().deriveFont(lblPlanina1.getFont().getSize() + 2f));
		lblPlanina1.setBounds(263, 113, 92, 25);
		contentPane.add(lblPlanina1);
		
		tfPlanina1 = new JTextField();
		tfPlanina1.setFont(tfPlanina1.getFont().deriveFont(tfPlanina1.getFont().getSize() + 2f));
		tfPlanina1.setEditable(false);
		tfPlanina1.setBounds(259, 147, 96, 20);
		tfPlanine[0] = tfPlanina1;
		contentPane.add(tfPlanina1);
		tfPlanina1.setColumns(10);
		
		JLabel lblGrad1 = new JLabel("GRAD");
		lblGrad1.setForeground(new Color(255, 255, 255));
		lblGrad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad1.setFont(lblGrad1.getFont().deriveFont(lblGrad1.getFont().getSize() + 2f));
		lblGrad1.setBounds(391, 113, 93, 25);
		contentPane.add(lblGrad1);
		
		tfGrad1 = new JTextField();
		tfGrad1.setEditable(false);
		tfGrad1.setFont(tfGrad1.getFont().deriveFont(tfGrad1.getFont().getSize() + 2f));
		tfGrad1.setBounds(388, 147, 96, 20);
		tfGradovi[0] = tfGrad1;
		contentPane.add(tfGrad1);
		tfGrad1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("BILJKA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 2f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(537, 113, 59, 25);
		contentPane.add(lblNewLabel);
		
		tfBiljka1 = new JTextField();
		tfBiljka1.setFont(tfBiljka1.getFont().deriveFont(tfBiljka1.getFont().getSize() + 2f));
		tfBiljka1.setEditable(false);
		tfBiljka1.setBounds(515, 148, 96, 19);
		tfBiljke[0] = tfBiljka1;
		contentPane.add(tfBiljka1);
		tfBiljka1.setColumns(10);
		
		
		//drugi
		JLabel lblIgrac2 = new JLabel("IGRA\u010C:");
		lblIgrac2.setForeground(new Color(255, 255, 255));
		lblIgrac2.setFont(lblIgrac2.getFont().deriveFont(15f));
		lblIgrac2.setBounds(20, 217, 67, 25);
		contentPane.add(lblIgrac2);
		
		tfIgrac2 = new JTextField();
		tfIgrac2.setEditable(false);
		tfIgrac2.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac2.setBounds(103, 219, 121, 25);
		tfIgraci[1] = tfIgrac2;
		contentPane.add(tfIgrac2);
		tfIgrac2.setColumns(10);
		
		JLabel lbldrzava2 = new JLabel("DR\u017DAVA");
		lbldrzava2.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrzava2.setFont(lbldrzava2.getFont().deriveFont(lbldrzava2.getFont().getSize() + 2f));
		lbldrzava2.setBounds(20, 113, 90, 25);
		contentPane.add(lbldrzava2);
		
		tfDrzava2 = new JTextField();
		tfDrzava2.setFont(tfDrzava2.getFont().deriveFont(tfDrzava2.getFont().getSize() + 2f));
		tfDrzava2.setEditable(false);
		tfDrzava2.setBounds(20, 298, 90, 19);
		tfDrzave[1] = tfDrzava2;
		contentPane.add(tfDrzava2);
		tfDrzava2.setColumns(10);
		
		JLabel lblRijeka2 = new JLabel("RIJEKA");
		lblRijeka2.setForeground(new Color(255, 255, 255));
		lblRijeka2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka2.setFont(lblRijeka2.getFont().deriveFont(lblRijeka2.getFont().getSize() + 2f));
		lblRijeka2.setBounds(142, 263, 82, 25);
		contentPane.add(lblRijeka2);
		
		JLabel lblDrzava2 = new JLabel("DR\u017DAVA");
		lblDrzava2.setForeground(new Color(255, 255, 255));
		lblDrzava2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrzava2.setFont(lblDrzava2.getFont().deriveFont(lblDrzava2.getFont().getSize() + 2f));
		lblDrzava2.setBounds(20, 263, 90, 25);
		contentPane.add(lblDrzava2);
		
		JLabel lblPlanina2 = new JLabel("PLANINA");
		lblPlanina2.setForeground(new Color(255, 255, 255));
		lblPlanina2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina2.setFont(lblPlanina2.getFont().deriveFont(lblPlanina2.getFont().getSize() + 2f));
		lblPlanina2.setBounds(263, 263, 92, 25);
		contentPane.add(lblPlanina2);
		
		JLabel lblGrad2 = new JLabel("GRAD");
		lblGrad2.setForeground(new Color(255, 255, 255));
		lblGrad2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad2.setFont(lblGrad2.getFont().deriveFont(lblGrad2.getFont().getSize() + 2f));
		lblGrad2.setBounds(391, 263, 93, 25);
		contentPane.add(lblGrad2);
		
		JLabel lblBiljka2 = new JLabel("BILJKA");
		lblBiljka2.setForeground(new Color(255, 255, 255));
		lblBiljka2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiljka2.setFont(lblBiljka2.getFont().deriveFont(lblBiljka2.getFont().getSize() + 2f));
		lblBiljka2.setBounds(537, 263, 59, 25);
		contentPane.add(lblBiljka2);
		
		tfRijeka2 = new JTextField();
		tfRijeka2.setFont(tfRijeka2.getFont().deriveFont(tfRijeka2.getFont().getSize() + 2f));
		tfRijeka2.setEditable(false);
		tfRijeka2.setColumns(10);
		tfRijeka2.setBounds(142, 297, 90, 20);
		tfRijeke[1] = tfRijeka2;
		contentPane.add(tfRijeka2);
		
		tfPlanina2 = new JTextField();
		tfPlanina2.setFont(tfPlanina2.getFont().deriveFont(tfPlanina2.getFont().getSize() + 2f));
		tfPlanina2.setEditable(false);
		tfPlanina2.setColumns(10);
		tfPlanina2.setBounds(263, 297, 96, 20);
		tfPlanine[1] = tfPlanina2;
		contentPane.add(tfPlanina2);
		
		tfGrad2 = new JTextField();
		tfGrad2.setFont(tfGrad2.getFont().deriveFont(tfGrad2.getFont().getSize() + 2f));
		tfGrad2.setEditable(false);
		tfGrad2.setColumns(10);
		tfGrad2.setBounds(388, 297, 96, 20);
		tfGradovi[1] = tfGrad2;
		contentPane.add(tfGrad2);
		
		tfBiljka2 = new JTextField();
	    tfBiljka2.setFont(tfBiljka2.getFont().deriveFont(tfBiljka2.getFont().getSize() + 2f));
		tfBiljka2.setEditable(false);
		tfBiljka2.setColumns(10);
		tfBiljka2.setBounds(515, 298, 96, 19);
		tfBiljke[1] = tfBiljka2;
		contentPane.add(tfBiljka2);
		
		JLabel lblPrimjedba2 = new JLabel("Primjedba na odgovore:");
		lblPrimjedba2.setForeground(new Color(255, 255, 255));
		lblPrimjedba2.setFont(lblPrimjedba2.getFont().deriveFont(lblPrimjedba2.getFont().getSize() + 1f));
		lblPrimjedba2.setBounds(20, 343, 169, 25);
		contentPane.add(lblPrimjedba2);
		
	    rbni[1][0] = new JRadioButton("1");
		rbni[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][0].setBackground(Color.WHITE);
		rbni[1][0].setBounds(182, 343, 42, 24);
		contentPane.add(rbni[1][0]);
		
	    rbni[1][1] = new JRadioButton("2");
		rbni[1][1].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][1].setBackground(Color.WHITE);
		rbni[1][1].setBounds(240, 343, 36, 24);
		contentPane.add(rbni[1][1]);
		
	    rbni[1][2] = new JRadioButton("3");
		rbni[1][2].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][2].setBackground(Color.WHITE);
		rbni[1][2].setBounds(289, 345, 42, 21);
		contentPane.add(rbni[1][2]);
		
		rbni[1][3] = new JRadioButton("4");
		rbni[1][3].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][3].setBackground(Color.WHITE);
		rbni[1][3].setBounds(346, 345, 42, 21);
		contentPane.add(rbni[1][3]);
		
	    rbni[1][4] = new JRadioButton("5");
		rbni[1][4].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][4].setBackground(Color.WHITE);
		rbni[1][4].setBounds(391, 345, 42, 21);
		contentPane.add(rbni[1][4]);
		
		JLabel lblIgrac3 = new JLabel("IGRA\u010C:");
		lblIgrac3.setForeground(new Color(255, 255, 255));
		lblIgrac3.setFont(lblIgrac3.getFont().deriveFont(15f));
		lblIgrac3.setBounds(20, 395, 67, 25);
		contentPane.add(lblIgrac3);
		
		tfIgrac3 = new JTextField();
		tfIgrac3.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac3.setEditable(false);
		tfIgrac3.setColumns(10);
		
		tfIgrac3.setBounds(103, 395, 121, 25);
		tfIgraci[2] = tfIgrac3;
		contentPane.add(tfIgrac3);
		
		JLabel lblDrzava3 = new JLabel("DR\u017DAVA");
		lblDrzava3.setForeground(new Color(255, 255, 255));
		lblDrzava3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrzava3.setFont(lblDrzava3.getFont().deriveFont(lblDrzava3.getFont().getSize() + 2f));
		lblDrzava3.setBounds(20, 437, 90, 25);
		contentPane.add(lblDrzava3);
		
		JLabel lblRijeka3 = new JLabel("RIJEKA");
		lblRijeka3.setForeground(new Color(255, 255, 255));
		lblRijeka3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka3.setFont(lblRijeka3.getFont().deriveFont(lblRijeka3.getFont().getSize() + 2f));
		lblRijeka3.setBounds(142, 437, 82, 25);
		contentPane.add(lblRijeka3);
		
		JLabel lblPlanina3 = new JLabel("PLANINA");
		lblPlanina3.setForeground(new Color(255, 255, 255));
		lblPlanina3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina3.setFont(lblPlanina3.getFont().deriveFont(lblPlanina3.getFont().getSize() + 2f));
		lblPlanina3.setBounds(263, 437, 92, 25);
		contentPane.add(lblPlanina3);
		
		JLabel lblGrad3 = new JLabel("GRAD");
		lblGrad3.setForeground(new Color(255, 255, 255));
		lblGrad3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad3.setFont(lblGrad3.getFont().deriveFont(lblGrad3.getFont().getSize() + 2f));
		lblGrad3.setBounds(391, 437, 93, 25);
		contentPane.add(lblGrad3);
		
		JLabel lblBiljka3 = new JLabel("BILJKA");
		lblBiljka3.setForeground(new Color(255, 255, 255));
		lblBiljka3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiljka3.setFont(lblBiljka3.getFont().deriveFont(lblBiljka3.getFont().getSize() + 2f));
		lblBiljka3.setBounds(537, 437, 59, 25);
		contentPane.add(lblBiljka3);
		
		tfDrzava3 = new JTextField();
		tfDrzava3.setFont(tfDrzava3.getFont().deriveFont(tfDrzava3.getFont().getSize() + 2f));
		tfDrzava3.setEditable(false);
		tfDrzava3.setColumns(10);
		tfDrzava3.setBounds(20, 472, 90, 19);
		tfDrzave[2] = tfDrzava3;
		contentPane.add(tfDrzava3);
		
		tfRijeka3 = new JTextField();
		tfRijeka3.setFont(tfRijeka3.getFont().deriveFont(tfRijeka3.getFont().getSize() + 2f));
		tfRijeka3.setEditable(false);
		tfRijeka3.setColumns(10);
		tfRijeka3.setBounds(142, 472, 90, 20);
		tfRijeke[2] = tfRijeka3;
		contentPane.add(tfRijeka3);
		
		tfPlanina3 = new JTextField();
		tfPlanina3.setFont(tfPlanina3.getFont().deriveFont(tfPlanina3.getFont().getSize() + 2f));
		tfPlanina3.setEditable(false);
		tfPlanina3.setColumns(10);
		tfPlanina3.setBounds(263, 473, 96, 20);
		tfPlanine[2] = tfPlanina3;
		contentPane.add(tfPlanina3);
		
		tfGrad3 = new JTextField();
		tfGrad3.setFont(tfGrad3.getFont().deriveFont(tfGrad3.getFont().getSize() + 2f));
		tfGrad3.setEditable(false);
		tfGrad3.setColumns(10);
		tfGrad3.setBounds(388, 472, 96, 20);
		tfGradovi[2] = tfGrad3;
		contentPane.add(tfGrad3);
		
		tfBiljka3 = new JTextField();
		tfBiljka3.setFont(tfBiljka3.getFont().deriveFont(tfBiljka3.getFont().getSize() + 2f));
		tfBiljka3.setEditable(false);
		tfBiljka3.setColumns(10);
		tfBiljka3.setBounds(515, 473, 96, 19);
		tfBiljke[2] = tfBiljka3;
		contentPane.add(tfBiljka3);
		
		JLabel lblPrimjedba3 = new JLabel("Primjedba na odgovore:");
		lblPrimjedba3.setForeground(new Color(255, 255, 255));
		lblPrimjedba3.setFont(lblPrimjedba3.getFont().deriveFont(lblPrimjedba3.getFont().getSize() + 1f));
		lblPrimjedba3.setBounds(20, 519, 169, 25);
		contentPane.add(lblPrimjedba3);
		
	    rbni[2][0] = new JRadioButton("1");
		rbni[2][0].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][0].setBackground(Color.WHITE);
		rbni[2][0].setBounds(182, 519, 42, 24);
		contentPane.add(rbni[2][0]);
		
	    rbni[2][1] = new JRadioButton("2");
		rbni[2][1].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][1].setBackground(Color.WHITE);
		rbni[2][1].setBounds(240, 519, 36, 24);
		contentPane.add(rbni[2][1]);
		
		rbni[2][2] = new JRadioButton("3");
		rbni[2][2].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][2].setBackground(Color.WHITE);
		rbni[2][2].setBounds(289, 521, 42, 21);
		contentPane.add(rbni[2][2]);
		
	    rbni[2][3] = new JRadioButton("4");
		rbni[2][3].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][3].setBackground(Color.WHITE);
		rbni[2][3].setBounds(346, 521, 42, 21);
		contentPane.add(rbni[2][3]);
		
	    rbni[2][4] = new JRadioButton("5");
		rbni[2][4].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][4].setBackground(Color.WHITE);
		rbni[2][4].setBounds(402, 521, 42, 21);
		contentPane.add(rbni[2][4]);
		

		
	    btnPrimjedbe = new JButton("PO\u0160ALJI PRIMJEDBU");
		btnPrimjedbe.setForeground(new Color(255, 255, 255));
		btnPrimjedbe.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrimjedbe.setBackground(new Color(65,105,225));
		btnPrimjedbe.setBounds(465, 521, 146, 25);
		btnPrimjedbe.addActionListener(this);
		contentPane.add(btnPrimjedbe);
		
		JLabel lblNewLabel_2 = new JLabel(""); 
		lblNewLabel_2.setIcon(new ImageIcon("./src/GUI/pozadina2.jpg"));
		lblNewLabel_2.setBounds(0, 0, 677, 756);
		contentPane.add(lblNewLabel_2);
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			System.out.print("kliknuo u rjesenju");
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<=4;j++) {
					if(j==0) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfDrzave[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
						
					}
					
					if(j==3) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfGradovi[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==2) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfPlanine[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==1) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfRijeke[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==4) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfBiljke[i].getText();
						else 
							this.primjedba+="X";
					}
				}
				
				this.primjedba+="/";
			}
			System.out.println("Primjedbe"+primjedba);
			this.PrimjedbeSpremne=true;	
	}
}package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Rjesenja extends JFrame implements ActionListener{
	Korisnik korisnik;
	protected String primjedba="";
	protected boolean PrimjedbeSpremne = false;
	private JPanel contentPane;
	private JTextField tfIgrac1,tfIgrac2,tfIgrac3,tfIgrac4;
	private JTextField tfDrzava1,tfDrzava2,tfDrzava3,tfDrzava4;
	private JTextField tfRijeka1,tfRijeka2,tfRijeka3,tfRijeka4;
	private JTextField tfPlanina1,tfPlanina2,tfPlanina3,tfPlanina4;
	private JTextField tfGrad1,tfGrad2,tfGrad3,tfGrad4;
	private JTextField tfBiljka1,tfBiljka2,tfBiljka3,tfBiljka4;
	protected JTextField [] tfIgraci=new JTextField[4];
	protected JTextField [] tfDrzave=new JTextField[4];
	protected JTextField [] tfRijeke=new JTextField[4];
	protected JTextField [] tfBiljke=new JTextField[4];
	protected JTextField [] tfPlanine=new JTextField[4];
	protected JTextField [] tfGradovi=new JTextField[4];
	protected JRadioButton[][] rbni=new JRadioButton[3][5];
	JButton btnPrimjedbe;
	
	public Rjesenja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691,793);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIgrac1 = new JLabel("IGRA\u010C:");
		lblIgrac1.setForeground(new Color(255, 255, 255));
		lblIgrac1.setFont(lblIgrac1.getFont().deriveFont(lblIgrac1.getFont().getSize() + 4f));
		lblIgrac1.setBounds(20, 57, 67, 25);
		contentPane.add(lblIgrac1);
		
		tfIgrac1 = new JTextField();
		tfIgrac1.setEditable(false);
		tfIgrac1.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac1.setBounds(97, 59, 121, 25);
		tfIgraci[0] = tfIgrac1;
		contentPane.add(tfIgrac1);
		tfIgrac1.setColumns(10);
		
		JLabel lbldrzava1 = new JLabel("DR\u017DAVA");
		lbldrzava1.setForeground(new Color(255, 255, 255));
		lbldrzava1.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrzava1.setFont(lbldrzava1.getFont().deriveFont(lbldrzava1.getFont().getSize() + 2f));
		lbldrzava1.setBounds(20, 113, 90, 25);
		contentPane.add(lbldrzava1);
		
		tfDrzava1 = new JTextField();
		tfDrzava1.setFont(tfDrzava1.getFont().deriveFont(tfDrzava1.getFont().getSize() + 2f));
		tfDrzava1.setEditable(false);
		tfDrzava1.setBounds(20, 148, 90, 19);
		tfDrzave[0] = tfDrzava1;
		contentPane.add(tfDrzava1);
		tfDrzava1.setColumns(10);
		
		JLabel lblRijeka1 = new JLabel("RIJEKA");
		lblRijeka1.setForeground(new Color(255, 255, 255));
		lblRijeka1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka1.setFont(lblRijeka1.getFont().deriveFont(lblRijeka1.getFont().getSize() + 2f));
		lblRijeka1.setBounds(128, 112, 82, 25);
		contentPane.add(lblRijeka1);
		
		tfRijeka1 = new JTextField();
		tfRijeka1.setEditable(false);
		tfRijeka1.setFont(tfRijeka1.getFont().deriveFont(tfRijeka1.getFont().getSize() + 2f));
		tfRijeka1.setBounds(128, 147, 90, 20);
		tfRijeke[0] = tfRijeka1;
		contentPane.add(tfRijeka1);
		tfRijeka1.setColumns(10);
		
		JLabel lblPlanina1 = new JLabel("PLANINA");
		lblPlanina1.setForeground(new Color(255, 255, 255));
		lblPlanina1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina1.setFont(lblPlanina1.getFont().deriveFont(lblPlanina1.getFont().getSize() + 2f));
		lblPlanina1.setBounds(263, 113, 92, 25);
		contentPane.add(lblPlanina1);
		
		tfPlanina1 = new JTextField();
		tfPlanina1.setFont(tfPlanina1.getFont().deriveFont(tfPlanina1.getFont().getSize() + 2f));
		tfPlanina1.setEditable(false);
		tfPlanina1.setBounds(259, 147, 96, 20);
		tfPlanine[0] = tfPlanina1;
		contentPane.add(tfPlanina1);
		tfPlanina1.setColumns(10);
		
		JLabel lblGrad1 = new JLabel("GRAD");
		lblGrad1.setForeground(new Color(255, 255, 255));
		lblGrad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad1.setFont(lblGrad1.getFont().deriveFont(lblGrad1.getFont().getSize() + 2f));
		lblGrad1.setBounds(391, 113, 93, 25);
		contentPane.add(lblGrad1);
		
		tfGrad1 = new JTextField();
		tfGrad1.setEditable(false);
		tfGrad1.setFont(tfGrad1.getFont().deriveFont(tfGrad1.getFont().getSize() + 2f));
		tfGrad1.setBounds(388, 147, 96, 20);
		tfGradovi[0] = tfGrad1;
		contentPane.add(tfGrad1);
		tfGrad1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("BILJKA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 2f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(537, 113, 59, 25);
		contentPane.add(lblNewLabel);
		
		tfBiljka1 = new JTextField();
		tfBiljka1.setFont(tfBiljka1.getFont().deriveFont(tfBiljka1.getFont().getSize() + 2f));
		tfBiljka1.setEditable(false);
		tfBiljka1.setBounds(515, 148, 96, 19);
		tfBiljke[0] = tfBiljka1;
		contentPane.add(tfBiljka1);
		tfBiljka1.setColumns(10);
		
		
		//drugi
		JLabel lblIgrac2 = new JLabel("IGRA\u010C:");
		lblIgrac2.setForeground(new Color(255, 255, 255));
		lblIgrac2.setFont(lblIgrac2.getFont().deriveFont(15f));
		lblIgrac2.setBounds(20, 217, 67, 25);
		contentPane.add(lblIgrac2);
		
		tfIgrac2 = new JTextField();
		tfIgrac2.setEditable(false);
		tfIgrac2.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac2.setBounds(103, 219, 121, 25);
		tfIgraci[1] = tfIgrac2;
		contentPane.add(tfIgrac2);
		tfIgrac2.setColumns(10);
		
		JLabel lbldrzava2 = new JLabel("DR\u017DAVA");
		lbldrzava2.setHorizontalAlignment(SwingConstants.CENTER);
		lbldrzava2.setFont(lbldrzava2.getFont().deriveFont(lbldrzava2.getFont().getSize() + 2f));
		lbldrzava2.setBounds(20, 113, 90, 25);
		contentPane.add(lbldrzava2);
		
		tfDrzava2 = new JTextField();
		tfDrzava2.setFont(tfDrzava2.getFont().deriveFont(tfDrzava2.getFont().getSize() + 2f));
		tfDrzava2.setEditable(false);
		tfDrzava2.setBounds(20, 298, 90, 19);
		tfDrzave[1] = tfDrzava2;
		contentPane.add(tfDrzava2);
		tfDrzava2.setColumns(10);
		
		JLabel lblRijeka2 = new JLabel("RIJEKA");
		lblRijeka2.setForeground(new Color(255, 255, 255));
		lblRijeka2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka2.setFont(lblRijeka2.getFont().deriveFont(lblRijeka2.getFont().getSize() + 2f));
		lblRijeka2.setBounds(142, 263, 82, 25);
		contentPane.add(lblRijeka2);
		
		JLabel lblDrzava2 = new JLabel("DR\u017DAVA");
		lblDrzava2.setForeground(new Color(255, 255, 255));
		lblDrzava2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrzava2.setFont(lblDrzava2.getFont().deriveFont(lblDrzava2.getFont().getSize() + 2f));
		lblDrzava2.setBounds(20, 263, 90, 25);
		contentPane.add(lblDrzava2);
		
		JLabel lblPlanina2 = new JLabel("PLANINA");
		lblPlanina2.setForeground(new Color(255, 255, 255));
		lblPlanina2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina2.setFont(lblPlanina2.getFont().deriveFont(lblPlanina2.getFont().getSize() + 2f));
		lblPlanina2.setBounds(263, 263, 92, 25);
		contentPane.add(lblPlanina2);
		
		JLabel lblGrad2 = new JLabel("GRAD");
		lblGrad2.setForeground(new Color(255, 255, 255));
		lblGrad2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad2.setFont(lblGrad2.getFont().deriveFont(lblGrad2.getFont().getSize() + 2f));
		lblGrad2.setBounds(391, 263, 93, 25);
		contentPane.add(lblGrad2);
		
		JLabel lblBiljka2 = new JLabel("BILJKA");
		lblBiljka2.setForeground(new Color(255, 255, 255));
		lblBiljka2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiljka2.setFont(lblBiljka2.getFont().deriveFont(lblBiljka2.getFont().getSize() + 2f));
		lblBiljka2.setBounds(537, 263, 59, 25);
		contentPane.add(lblBiljka2);
		
		tfRijeka2 = new JTextField();
		tfRijeka2.setFont(tfRijeka2.getFont().deriveFont(tfRijeka2.getFont().getSize() + 2f));
		tfRijeka2.setEditable(false);
		tfRijeka2.setColumns(10);
		tfRijeka2.setBounds(142, 297, 90, 20);
		tfRijeke[1] = tfRijeka2;
		contentPane.add(tfRijeka2);
		
		tfPlanina2 = new JTextField();
		tfPlanina2.setFont(tfPlanina2.getFont().deriveFont(tfPlanina2.getFont().getSize() + 2f));
		tfPlanina2.setEditable(false);
		tfPlanina2.setColumns(10);
		tfPlanina2.setBounds(263, 297, 96, 20);
		tfPlanine[1] = tfPlanina2;
		contentPane.add(tfPlanina2);
		
		tfGrad2 = new JTextField();
		tfGrad2.setFont(tfGrad2.getFont().deriveFont(tfGrad2.getFont().getSize() + 2f));
		tfGrad2.setEditable(false);
		tfGrad2.setColumns(10);
		tfGrad2.setBounds(388, 297, 96, 20);
		tfGradovi[1] = tfGrad2;
		contentPane.add(tfGrad2);
		
		tfBiljka2 = new JTextField();
	    tfBiljka2.setFont(tfBiljka2.getFont().deriveFont(tfBiljka2.getFont().getSize() + 2f));
		tfBiljka2.setEditable(false);
		tfBiljka2.setColumns(10);
		tfBiljka2.setBounds(515, 298, 96, 19);
		tfBiljke[1] = tfBiljka2;
		contentPane.add(tfBiljka2);
		
		JLabel lblPrimjedba2 = new JLabel("Primjedba na odgovore:");
		lblPrimjedba2.setForeground(new Color(255, 255, 255));
		lblPrimjedba2.setFont(lblPrimjedba2.getFont().deriveFont(lblPrimjedba2.getFont().getSize() + 1f));
		lblPrimjedba2.setBounds(20, 343, 169, 25);
		contentPane.add(lblPrimjedba2);
		
	    rbni[1][0] = new JRadioButton("1");
		rbni[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][0].setBackground(Color.WHITE);
		rbni[1][0].setBounds(182, 343, 42, 24);
		contentPane.add(rbni[1][0]);
		
	    rbni[1][1] = new JRadioButton("2");
		rbni[1][1].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][1].setBackground(Color.WHITE);
		rbni[1][1].setBounds(240, 343, 36, 24);
		contentPane.add(rbni[1][1]);
		
	    rbni[1][2] = new JRadioButton("3");
		rbni[1][2].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][2].setBackground(Color.WHITE);
		rbni[1][2].setBounds(289, 345, 42, 21);
		contentPane.add(rbni[1][2]);
		
		rbni[1][3] = new JRadioButton("4");
		rbni[1][3].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][3].setBackground(Color.WHITE);
		rbni[1][3].setBounds(346, 345, 42, 21);
		contentPane.add(rbni[1][3]);
		
	    rbni[1][4] = new JRadioButton("5");
		rbni[1][4].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[1][4].setBackground(Color.WHITE);
		rbni[1][4].setBounds(391, 345, 42, 21);
		contentPane.add(rbni[1][4]);
		
		JLabel lblIgrac3 = new JLabel("IGRA\u010C:");
		lblIgrac3.setForeground(new Color(255, 255, 255));
		lblIgrac3.setFont(lblIgrac3.getFont().deriveFont(15f));
		lblIgrac3.setBounds(20, 395, 67, 25);
		contentPane.add(lblIgrac3);
		
		tfIgrac3 = new JTextField();
		tfIgrac3.setHorizontalAlignment(SwingConstants.CENTER);
		tfIgrac3.setEditable(false);
		tfIgrac3.setColumns(10);
		
		tfIgrac3.setBounds(103, 395, 121, 25);
		tfIgraci[2] = tfIgrac3;
		contentPane.add(tfIgrac3);
		
		JLabel lblDrzava3 = new JLabel("DR\u017DAVA");
		lblDrzava3.setForeground(new Color(255, 255, 255));
		lblDrzava3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrzava3.setFont(lblDrzava3.getFont().deriveFont(lblDrzava3.getFont().getSize() + 2f));
		lblDrzava3.setBounds(20, 437, 90, 25);
		contentPane.add(lblDrzava3);
		
		JLabel lblRijeka3 = new JLabel("RIJEKA");
		lblRijeka3.setForeground(new Color(255, 255, 255));
		lblRijeka3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRijeka3.setFont(lblRijeka3.getFont().deriveFont(lblRijeka3.getFont().getSize() + 2f));
		lblRijeka3.setBounds(142, 437, 82, 25);
		contentPane.add(lblRijeka3);
		
		JLabel lblPlanina3 = new JLabel("PLANINA");
		lblPlanina3.setForeground(new Color(255, 255, 255));
		lblPlanina3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanina3.setFont(lblPlanina3.getFont().deriveFont(lblPlanina3.getFont().getSize() + 2f));
		lblPlanina3.setBounds(263, 437, 92, 25);
		contentPane.add(lblPlanina3);
		
		JLabel lblGrad3 = new JLabel("GRAD");
		lblGrad3.setForeground(new Color(255, 255, 255));
		lblGrad3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad3.setFont(lblGrad3.getFont().deriveFont(lblGrad3.getFont().getSize() + 2f));
		lblGrad3.setBounds(391, 437, 93, 25);
		contentPane.add(lblGrad3);
		
		JLabel lblBiljka3 = new JLabel("BILJKA");
		lblBiljka3.setForeground(new Color(255, 255, 255));
		lblBiljka3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiljka3.setFont(lblBiljka3.getFont().deriveFont(lblBiljka3.getFont().getSize() + 2f));
		lblBiljka3.setBounds(537, 437, 59, 25);
		contentPane.add(lblBiljka3);
		
		tfDrzava3 = new JTextField();
		tfDrzava3.setFont(tfDrzava3.getFont().deriveFont(tfDrzava3.getFont().getSize() + 2f));
		tfDrzava3.setEditable(false);
		tfDrzava3.setColumns(10);
		tfDrzava3.setBounds(20, 472, 90, 19);
		tfDrzave[2] = tfDrzava3;
		contentPane.add(tfDrzava3);
		
		tfRijeka3 = new JTextField();
		tfRijeka3.setFont(tfRijeka3.getFont().deriveFont(tfRijeka3.getFont().getSize() + 2f));
		tfRijeka3.setEditable(false);
		tfRijeka3.setColumns(10);
		tfRijeka3.setBounds(142, 472, 90, 20);
		tfRijeke[2] = tfRijeka3;
		contentPane.add(tfRijeka3);
		
		tfPlanina3 = new JTextField();
		tfPlanina3.setFont(tfPlanina3.getFont().deriveFont(tfPlanina3.getFont().getSize() + 2f));
		tfPlanina3.setEditable(false);
		tfPlanina3.setColumns(10);
		tfPlanina3.setBounds(263, 473, 96, 20);
		tfPlanine[2] = tfPlanina3;
		contentPane.add(tfPlanina3);
		
		tfGrad3 = new JTextField();
		tfGrad3.setFont(tfGrad3.getFont().deriveFont(tfGrad3.getFont().getSize() + 2f));
		tfGrad3.setEditable(false);
		tfGrad3.setColumns(10);
		tfGrad3.setBounds(388, 472, 96, 20);
		tfGradovi[2] = tfGrad3;
		contentPane.add(tfGrad3);
		
		tfBiljka3 = new JTextField();
		tfBiljka3.setFont(tfBiljka3.getFont().deriveFont(tfBiljka3.getFont().getSize() + 2f));
		tfBiljka3.setEditable(false);
		tfBiljka3.setColumns(10);
		tfBiljka3.setBounds(515, 473, 96, 19);
		tfBiljke[2] = tfBiljka3;
		contentPane.add(tfBiljka3);
		
		JLabel lblPrimjedba3 = new JLabel("Primjedba na odgovore:");
		lblPrimjedba3.setForeground(new Color(255, 255, 255));
		lblPrimjedba3.setFont(lblPrimjedba3.getFont().deriveFont(lblPrimjedba3.getFont().getSize() + 1f));
		lblPrimjedba3.setBounds(20, 519, 169, 25);
		contentPane.add(lblPrimjedba3);
		
	    rbni[2][0] = new JRadioButton("1");
		rbni[2][0].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][0].setBackground(Color.WHITE);
		rbni[2][0].setBounds(182, 519, 42, 24);
		contentPane.add(rbni[2][0]);
		
	    rbni[2][1] = new JRadioButton("2");
		rbni[2][1].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][1].setBackground(Color.WHITE);
		rbni[2][1].setBounds(240, 519, 36, 24);
		contentPane.add(rbni[2][1]);
		
		rbni[2][2] = new JRadioButton("3");
		rbni[2][2].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][2].setBackground(Color.WHITE);
		rbni[2][2].setBounds(289, 521, 42, 21);
		contentPane.add(rbni[2][2]);
		
	    rbni[2][3] = new JRadioButton("4");
		rbni[2][3].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][3].setBackground(Color.WHITE);
		rbni[2][3].setBounds(346, 521, 42, 21);
		contentPane.add(rbni[2][3]);
		
	    rbni[2][4] = new JRadioButton("5");
		rbni[2][4].setHorizontalAlignment(SwingConstants.CENTER);
		rbni[2][4].setBackground(Color.WHITE);
		rbni[2][4].setBounds(402, 521, 42, 21);
		contentPane.add(rbni[2][4]);
		

		
	    btnPrimjedbe = new JButton("PO\u0160ALJI PRIMJEDBU");
		btnPrimjedbe.setForeground(new Color(255, 255, 255));
		btnPrimjedbe.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrimjedbe.setBackground(new Color(65,105,225));
		btnPrimjedbe.setBounds(465, 521, 146, 25);
		btnPrimjedbe.addActionListener(this);
		contentPane.add(btnPrimjedbe);
		
		JLabel lblNewLabel_2 = new JLabel(""); 
		lblNewLabel_2.setIcon(new ImageIcon("./src/GUI/pozadina2.jpg"));
		lblNewLabel_2.setBounds(0, 0, 677, 756);
		contentPane.add(lblNewLabel_2);
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			System.out.print("kliknuo u rjesenju");
			for(int i=1;i<3;i++)
			{
				for(int j=0;j<=4;j++) {
					if(j==0) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfDrzave[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
						
					}
					
					if(j==3) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfGradovi[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==2) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfPlanine[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==1) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfRijeke[i].getText()+"_";
						else 
							this.primjedba+="X"+"_";
					}
					if(j==4) {
						if(rbni[i][j].isSelected())
							this.primjedba+=this.tfBiljke[i].getText();
						else 
							this.primjedba+="X";
					}
				}
				
				this.primjedba+="/";
			}
			System.out.println("Primjedbe"+primjedba);
			this.PrimjedbeSpremne=true;
	
	}
}