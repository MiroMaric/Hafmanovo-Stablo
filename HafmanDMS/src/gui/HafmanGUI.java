package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import cvorovi.Cvor;
import stabla.BTreePrinter;
import stabla.HafmanovoStablo;
import stabla.StabloGenerator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class HafmanGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnDodaj;
	private JTextField textFieldSimbol;
	private JTextField textFieldFrek;
	private JLabel lblSimbol;
	private JLabel lblFrek;
	private JScrollPane scrollPane;
	private String simboli = "Simboli:";
	private String frekvencija = "Frekven:";
	private String kodovi = "Kodovi: ";
	private JScrollPane scrollPane_1;
	private JButton btnIzgenerisiStablo;
	private JTextPane textPane;
	private JPanel panelDodatneOpcije;
	private JButton btnKodirajRec;
	private JButton btnDekodirajKod;
	private JButton btnInformacije;
	private JTextArea textAreaCvorovi;
	private JButton btnNewButton;
	private JButton button;
	
	public HafmanGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HafmanGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Text-Color-Black.png")));
		setResizable(false);
		setTitle("Hafmanovo stablo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 600);
		contentPane = new JPanel();
		contentPane.setBackground(GUIKontroler.plava);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		contentPane.add(getPanelDodatneOpcije(), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(GUIKontroler.plava);
			panel.setLayout(null);
			panel.add(getBtnDodaj());
			panel.setPreferredSize(new Dimension(0, 140));
			panel.add(getTextFieldSimbol());
			panel.add(getTextFieldFrek());
			panel.add(getLblSimbol());
			panel.add(getLblFrek());
			panel.add(getScrollPane());
			panel.add(getBtnIzgenerisiStablo());
		}
		return panel;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setFont(new Font("Candara", Font.BOLD, 15));
			btnDodaj.setForeground(Color.WHITE);
			btnDodaj.setBackground(GUIKontroler.plavat);
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(GUIKontroler.koren!=null){
							GUIKontroler.koren = null;
							textAreaCvorovi.setText("");
							GUIKontroler.cvorovi.clear();
							simboli = "Simboli:";
							frekvencija = "Frekven:";
							kodovi = "Kodovi: ";
							textPane.setText("");
							GUIKontroler.listovi.clear();
							btnDekodirajKod.setEnabled(false);
							btnKodirajRec.setEnabled(false);
							btnInformacije.setEnabled(false);
						}
						String simbol = textFieldSimbol.getText();
						if(simbol.length()>1){
							JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Simbol ne može sadržati vise karaktera", "Greška", JOptionPane.OK_OPTION);
							return;
						}
						if(simbol.length()==0){
							JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Simbol mora biti unet", "Greška", JOptionPane.OK_OPTION);
							return;
						}
						int frek = 0;
						frek = Integer.parseInt(textFieldFrek.getText());
						if(frek<1){
							JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Frekvencija mora biti pravilno uneta", "Greška", JOptionPane.OK_OPTION);
							return;
						}
						Cvor cvor = new Cvor(simbol, frek, null, null);
						if(GUIKontroler.cvorovi.contains(cvor)){
							JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Simbol je vec unet", "Greška", JOptionPane.OK_OPTION);
							return;
						}
						GUIKontroler.cvorovi.add(cvor);
						simboli += "\t"+cvor.simbol;
						frekvencija += "\t"+cvor.frekvencija;
						textAreaCvorovi.setText(simboli+"\n"+frekvencija);
						textFieldSimbol.setText("");
						textFieldFrek.setText("");
						GUIKontroler.listovi.add(cvor);
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Frekvencija mora biti uneta", "Greška", JOptionPane.OK_OPTION);
					}
				
				}
			});
			btnDodaj.setBounds(198, 29, 130, 35);
		}
		return btnDodaj;
	}
	private JTextField getTextFieldSimbol() {
		if (textFieldSimbol == null) {
			textFieldSimbol = new JTextField();
			textFieldSimbol.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldSimbol.setBounds(10, 29, 80, 35);
			textFieldSimbol.setColumns(10);
		}
		return textFieldSimbol;
	}
	private JTextField getTextFieldFrek() {
		if (textFieldFrek == null) {
			textFieldFrek = new JTextField();
			textFieldFrek.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldFrek.setColumns(10);
			textFieldFrek.setBounds(100, 29, 80, 35);
		}
		return textFieldFrek;
	}
	private JLabel getLblSimbol() {
		if (lblSimbol == null) {
			lblSimbol = new JLabel("Simbol");
			lblSimbol.setFont(new Font("Candara", Font.BOLD, 15));
			lblSimbol.setForeground(Color.WHITE);
			lblSimbol.setHorizontalAlignment(SwingConstants.CENTER);
			lblSimbol.setBounds(10, 11, 80, 14);
		}
		return lblSimbol;
	}
	private JLabel getLblFrek() {
		if (lblFrek == null) {
			lblFrek = new JLabel("Frekvencija");
			lblFrek.setFont(new Font("Candara", Font.BOLD, 15));
			lblFrek.setForeground(Color.WHITE);
			lblFrek.setHorizontalAlignment(SwingConstants.CENTER);
			lblFrek.setBounds(100, 11, 80, 14);
		}
		return lblFrek;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 75, 524, 65);
			Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
			scrollPane.setBorder( border );
			scrollPane.setViewportView(getTextAreaCvorovi());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setViewportBorder(null);
			Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
			scrollPane_1.setBorder( border );
		}
		return scrollPane_1;
	}
	private JButton getBtnIzgenerisiStablo() {
		if (btnIzgenerisiStablo == null) {
			btnIzgenerisiStablo = new JButton("Izgeneri\u0161i stablo");
			btnIzgenerisiStablo.setFont(new Font("Candara", Font.BOLD, 15));
			btnIzgenerisiStablo.setForeground(Color.WHITE);
			btnIzgenerisiStablo.setBackground(GUIKontroler.plavat);
			btnIzgenerisiStablo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(GUIKontroler.listovi.size()<2){
						JOptionPane.showMessageDialog(GUIKontroler.glavniProzor, "Azbuka mora imati najmanje dva slova", "Greška", JOptionPane.OK_OPTION);
						return;
					}
					GUIKontroler.koren = StabloGenerator.HafmanovAlgoritam(GUIKontroler.cvorovi);
					String tekst = BTreePrinter.printNode(GUIKontroler.koren);
					textPane.setText(tekst);
					BTreePrinter.tekst = "";
					for(int i=0;i<GUIKontroler.listovi.size();i++){
						GUIKontroler.listovi.get(i).kod = HafmanovoStablo.hafmanovKod(GUIKontroler.koren, GUIKontroler.listovi.get(i));
						kodovi+="\t"+GUIKontroler.listovi.get(i).kod;
					}
					textAreaCvorovi.setText(textAreaCvorovi.getText()+"\n"+kodovi);
					
					btnDekodirajKod.setEnabled(true);
					btnKodirajRec.setEnabled(true);
					btnInformacije.setEnabled(true);
					
				}
			});
			btnIzgenerisiStablo.setBounds(338, 29, 155, 35);
		}
		return btnIzgenerisiStablo;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setForeground(Color.DARK_GRAY);
			textPane.setEditable(false);
			textPane.setBackground(GUIKontroler.sivat);
			textPane.setFont(new Font("Courier New", Font.PLAIN, 15));
			
		}
		return textPane;
	}
	private JPanel getPanelDodatneOpcije() {
		if (panelDodatneOpcije == null) {
			panelDodatneOpcije = new JPanel();
			panelDodatneOpcije.setBackground(GUIKontroler.plava);
			panelDodatneOpcije.setLayout(null);
			panelDodatneOpcije.setPreferredSize(new Dimension(0, 50));
			panelDodatneOpcije.add(getBtnKodirajRec());
			panelDodatneOpcije.add(getBtnDekodirajKod());
			panelDodatneOpcije.add(getBtnInformacije());
			panelDodatneOpcije.add(getBtnNewButton());
			panelDodatneOpcije.add(getButton());
		}
		return panelDodatneOpcije;
	}
	private JButton getBtnKodirajRec() {
		if (btnKodirajRec == null) {
			btnKodirajRec = new JButton("Kodiraj re\u010D");
			btnKodirajRec.setEnabled(false);
			btnKodirajRec.setFont(new Font("Candara", Font.BOLD, 15));
			btnKodirajRec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriKodiranjeGUI();
				}
			});
			btnKodirajRec.setForeground(Color.WHITE);
			btnKodirajRec.setBackground(GUIKontroler.plavat);
			btnKodirajRec.setBounds(57, 11, 130, 35);
		}
		return btnKodirajRec;
	}
	private JButton getBtnDekodirajKod() {
		if (btnDekodirajKod == null) {
			btnDekodirajKod = new JButton("Dekodiraj kod");
			btnDekodirajKod.setEnabled(false);
			btnDekodirajKod.setFont(new Font("Candara", Font.BOLD, 15));
			btnDekodirajKod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriDekodiranjeGUI();
				}
			});
			btnDekodirajKod.setForeground(Color.WHITE);
			btnDekodirajKod.setBackground(GUIKontroler.plavat);
			btnDekodirajKod.setBounds(197, 11, 130, 35);
		}
		return btnDekodirajKod;
	}
	private JButton getBtnInformacije() {
		if (btnInformacije == null) {
			btnInformacije = new JButton("Informacije");
			btnInformacije.setEnabled(false);
			btnInformacije.setFont(new Font("Candara", Font.BOLD, 15));
			btnInformacije.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriInformacijeGUI();
				}
			});
			btnInformacije.setForeground(Color.WHITE);
			btnInformacije.setBackground(GUIKontroler.plavat);
			btnInformacije.setBounds(336, 11, 130, 35);
		}
		return btnInformacije;
	}
	private JTextArea getTextAreaCvorovi() {
		if (textAreaCvorovi == null) {
			textAreaCvorovi = new JTextArea();
			textAreaCvorovi.setFont(new Font("Courier New", Font.BOLD, 13));
			textAreaCvorovi.setEditable(false);
			textAreaCvorovi.setForeground(Color.DARK_GRAY);
			textAreaCvorovi.setBackground(GUIKontroler.siva);
		}
		return textAreaCvorovi;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(HafmanGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
			btnNewButton.setToolTipText("O projektu");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriOProjektuGUI();
				}
			});
			btnNewButton.setBackground(GUIKontroler.plavat);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(474, 11, 40, 35);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.koren = null;
					textAreaCvorovi.setText("");
					GUIKontroler.cvorovi.clear();
					simboli = "Simboli:";
					frekvencija = "Frekven:";
					kodovi = "Kodovi: ";
					textPane.setText("");
					GUIKontroler.listovi.clear();
					btnDekodirajKod.setEnabled(false);
					btnKodirajRec.setEnabled(false);
					btnInformacije.setEnabled(false);
				}
			});
			button.setIcon(new ImageIcon(HafmanGUI.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
			button.setToolTipText("Restart");
			button.setForeground(Color.WHITE);
			button.setBackground(new Color(137, 189, 211));
			button.setBounds(10, 11, 40, 35);
		}
		return button;
	}
}
