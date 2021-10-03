package RM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Component;

public class Primjedbe extends JFrame implements ActionListener {
	private JPanel contentPane;
	protected JTextField tfIgrac;
	protected JTextField tfOdgovor;
	private JButton btnPrihvati, btnOdbij;

	public Primjedbe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIgrac = new JLabel("IGRA\u010C: ");
		lblIgrac.setHorizontalAlignment(SwingConstants.CENTER);
		lblIgrac.setFont(lblIgrac.getFont().deriveFont(lblIgrac.getFont().getSize() + 4f));
		lblIgrac.setBounds(28, 26, 77, 26);
		contentPane.add(lblIgrac);

		tfIgrac = new JTextField();
		tfIgrac.setEditable(false);
		tfIgrac.setEnabled(false);
		tfIgrac.setBounds(110, 29, 96, 25);
		contentPane.add(tfIgrac);
		tfIgrac.setColumns(10);

		tfOdgovor = new JTextField();
		tfOdgovor.setHorizontalAlignment(SwingConstants.CENTER);
		tfOdgovor.setFont(tfOdgovor.getFont().deriveFont(tfOdgovor.getFont().getSize() + 2f));
		tfOdgovor.setBounds(37, 95, 300, 40);
		contentPane.add(tfOdgovor);
		tfOdgovor.setColumns(10);

		btnPrihvati = new JButton("Prihvati primjedbu");
		btnPrihvati.setForeground(new Color(255, 255, 255));
		btnPrihvati.setBackground(new Color(34, 139, 34));
		btnPrihvati.setBounds(28, 180, 137, 34);
		btnPrihvati.addActionListener(this);
		contentPane.add(btnPrihvati);

		btnOdbij = new JButton("Odbij primjedbu");
		btnOdbij.setBackground(new Color(178, 34, 34));
		btnOdbij.setForeground(new Color(255, 255, 255));
		btnOdbij.setBounds(200, 180, 137, 34);
		btnOdbij.addActionListener(this);
		contentPane.add(btnOdbij);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnPrihvati)) {

		}
		if (e.getSource().equals(btnOdbij)) {

		}
		
	}
	public static void main(String[] args) {
		Primjedbe p= new Primjedbe();
		p.setVisible(true);
	}
}
