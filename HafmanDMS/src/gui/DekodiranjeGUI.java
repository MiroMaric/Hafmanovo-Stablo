package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import stabla.HafmanovoStablo;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DekodiranjeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnIzlaz;

	public DekodiranjeGUI() {
		ImageIcon img = new ImageIcon("icons/ah.jpg");
		setIconImage(img.getImage());
		setResizable(false);
		setTitle("Dekodiranje koda");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBackground(GUIKontroler.plava);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnIzlaz());
		setLocationRelativeTo(GUIKontroler.glavniProzor);
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(10, 65, 414, 35);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Kod");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 35, 414, 25);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Dekodiraj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kod = textField.getText();
					try {
						textField.setText(HafmanovoStablo.dekodirajKod(GUIKontroler.koren, kod));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(GUIKontroler.dekodiranje, "Dati kod ne predstavlja reč unete azbuke", "Greska", JOptionPane.OK_OPTION);
					}
				}
			});
			btnNewButton.setBackground(GUIKontroler.plavat);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(95, 111, 120, 35);
		}
		return btnNewButton;
	}
	private JButton getBtnIzlaz() {
		if (btnIzlaz == null) {
			btnIzlaz = new JButton("Izlaz");
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnIzlaz.setForeground(Color.WHITE);
			btnIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzlaz.setBackground(new Color(137, 189, 211));
			btnIzlaz.setBounds(225, 111, 120, 35);
		}
		return btnIzlaz;
	}
}
