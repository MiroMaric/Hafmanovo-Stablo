package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class OProjektuGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtrOProjektuDiskretne;
	private JButton btnIzlaz;
	
	public OProjektuGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OProjektuGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Text-Color-Black.png")));
		setTitle("O projektu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(GUIKontroler.plava);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnIzlaz());
		setLocationRelativeTo(GUIKontroler.glavniProzor);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 200);
			scrollPane.setViewportView(getTxtrOProjektuDiskretne());
		}
		return scrollPane;
	}
	private JTextArea getTxtrOProjektuDiskretne() {
		if (txtrOProjektuDiskretne == null) {
			txtrOProjektuDiskretne = new JTextArea();
			txtrOProjektuDiskretne.setEditable(false);
			txtrOProjektuDiskretne.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtrOProjektuDiskretne.setText("   Data aplikacija je nastala realizacijom seminarskog rada\r\n   na temu \"Primene stabala\".\r\n   Diskretne Matemati\u010Dke Strukture\r\n\r\n   Mentor: Neboj\u0161a Nikoli\u0107\r\n\r\n   Studenti: Miro Mari\u0107 1031/16 , Jovan Lazi\u0107 1036/16\r\n\r\n   FON ,Beograd 2017.");
			txtrOProjektuDiskretne.setBackground(GUIKontroler.plava);
			txtrOProjektuDiskretne.setForeground(Color.WHITE);
		}
		return txtrOProjektuDiskretne;
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
			btnIzlaz.setBounds(157, 220, 120, 35);
			btnIzlaz.setBackground(GUIKontroler.plavat);
		}
		return btnIzlaz;
	}
}
