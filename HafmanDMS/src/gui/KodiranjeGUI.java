package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import stabla.HafmanovoStablo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class KodiranjeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblRec;
	private JTextField textField;
	private JButton btnKodiraj;
	private JButton btnIzlaz;

	public KodiranjeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(KodiranjeGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Text-Color-Black.png")));
		setResizable(false);
		setTitle("Kodiranje re\u010Di");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBackground(GUIKontroler.plava);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblRec());
		contentPane.add(getTextField());
		contentPane.add(getBtnKodiraj());
		contentPane.add(getBtnIzlaz());
		setLocationRelativeTo(GUIKontroler.glavniProzor);
	}

	private JLabel getLblRec() {
		if (lblRec == null) {
			lblRec = new JLabel("Re\u010D");
			lblRec.setForeground(Color.WHITE);
			lblRec.setHorizontalAlignment(SwingConstants.CENTER);
			lblRec.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRec.setBounds(10, 35, 414, 25);
		}
		return lblRec;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setColumns(10);
			textField.setBounds(10, 65, 414, 35);
		}
		return textField;
	}
	private JButton getBtnKodiraj() {
		if (btnKodiraj == null) {
			btnKodiraj = new JButton("Kodiraj");
			btnKodiraj.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnKodiraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rec = textField.getText();
					try {
						textField.setText(HafmanovoStablo.kodirajRec(GUIKontroler.koren, rec));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(GUIKontroler.kodiranje, "Data reč sadrži simbole koji se ne nalaze u unetoj azbuci", "Greška", JOptionPane.OK_OPTION);
					}
				}
			});
			btnKodiraj.setForeground(Color.WHITE);
			btnKodiraj.setBackground(GUIKontroler.plavat);
			btnKodiraj.setBounds(91, 111, 120, 35);
		}
		return btnKodiraj;
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
			btnIzlaz.setBounds(228, 111, 120, 35);
		}
		return btnIzlaz;
	}
}
