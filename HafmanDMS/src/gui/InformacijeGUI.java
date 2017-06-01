package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stabla.HafmanovoStablo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class InformacijeGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblVisinaStabla;
	private JTextField textFieldVisina;
	private JLabel lblBalansirano;
	private JTextField textFieldBalansirano;
	private JLabel lblPotpuno;
	private JTextField textFieldPotpuno;
	private JLabel lblStriktnoBinarno;
	private JLabel lblStriktnoBinarnoP;
	private JLabel lblNivoListova;
	private JLabel lblNivoListoraO;
	private JButton button;
	/**
	 * Create the frame.
	 */
	public InformacijeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacijeGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Text-Color-Black.png")));
		setResizable(false);
		setTitle("Informacije o stablu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 449, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(GUIKontroler.plava);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblVisinaStabla());
		contentPane.add(getTextFieldVisina());
		contentPane.add(getLblBalansirano());
		contentPane.add(getTextFieldBalansirano());
		contentPane.add(getLblPotpuno());
		contentPane.add(getTextFieldPotpuno());
		contentPane.add(getLblStriktnoBinarno());
		contentPane.add(getLabel_1());
		contentPane.add(getLblNivoListova());
		contentPane.add(getLblNivoListoraO());
		contentPane.add(getButton());
		setLocationRelativeTo(GUIKontroler.glavniProzor);
	}
	private JLabel getLblVisinaStabla() {
		if (lblVisinaStabla == null) {
			lblVisinaStabla = new JLabel("Visina stabla:");
			lblVisinaStabla.setForeground(Color.WHITE);
			lblVisinaStabla.setHorizontalAlignment(SwingConstants.CENTER);
			lblVisinaStabla.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVisinaStabla.setBounds(10, 11, 125, 25);
		}
		return lblVisinaStabla;
	}
	private JTextField getTextFieldVisina() {
		if (textFieldVisina == null) {
			textFieldVisina = new JTextField();
			textFieldVisina.setForeground(Color.WHITE);
			textFieldVisina.setEditable(false);
			textFieldVisina.setBackground(GUIKontroler.plava);
			textFieldVisina.setBounds(145, 11, 279, 25);
			textFieldVisina.setColumns(10);
			textFieldVisina.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			textFieldVisina.setText(HafmanovoStablo.visinaStabla(GUIKontroler.koren)-1+"");
		}
		return textFieldVisina;
	}
	private JLabel getLblBalansirano() {
		if (lblBalansirano == null) {
			lblBalansirano = new JLabel("Balansirano:");
			lblBalansirano.setForeground(Color.WHITE);
			lblBalansirano.setHorizontalAlignment(SwingConstants.CENTER);
			lblBalansirano.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblBalansirano.setBounds(10, 89, 125, 25);
		}
		return lblBalansirano;
	}
	private JTextField getTextFieldBalansirano() {
		if (textFieldBalansirano == null) {
			textFieldBalansirano = new JTextField();
			textFieldBalansirano.setForeground(Color.WHITE);
			textFieldBalansirano.setEditable(false);
			textFieldBalansirano.setBackground(GUIKontroler.plava);
			textFieldBalansirano.setBounds(145, 89, 288, 25);
			textFieldBalansirano.setColumns(10);
			textFieldBalansirano.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			textFieldBalansirano.setText((HafmanovoStablo.balansirano(GUIKontroler.koren)==true?"DA":"NE")+"");
		}
		return textFieldBalansirano;
	}
	private JLabel getLblPotpuno() {
		if (lblPotpuno == null) {
			lblPotpuno = new JLabel("Potpuno binarno:");
			lblPotpuno.setForeground(Color.WHITE);
			lblPotpuno.setHorizontalAlignment(SwingConstants.CENTER);
			lblPotpuno.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPotpuno.setBounds(10, 129, 125, 25);
		}
		return lblPotpuno;
	}
	private JTextField getTextFieldPotpuno() {
		if (textFieldPotpuno == null) {
			textFieldPotpuno = new JTextField();
			textFieldPotpuno.setForeground(Color.WHITE);
			textFieldPotpuno.setEditable(false);
			textFieldPotpuno.setBackground(GUIKontroler.plava);
			textFieldPotpuno.setBounds(145, 129, 288, 25);
			textFieldPotpuno.setColumns(10);
			textFieldPotpuno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			textFieldPotpuno.setText(HafmanovoStablo.potpuno(GUIKontroler.koren)==true?"DA":"NE"+"");
		}
		return textFieldPotpuno;
	}
	private JLabel getLblStriktnoBinarno() {
		if (lblStriktnoBinarno == null) {
			lblStriktnoBinarno = new JLabel("Striktno binarno:");
			lblStriktnoBinarno.setForeground(Color.WHITE);
			lblStriktnoBinarno.setHorizontalAlignment(SwingConstants.CENTER);
			lblStriktnoBinarno.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblStriktnoBinarno.setBounds(10, 169, 125, 25);
		}
		return lblStriktnoBinarno;
	}
	private JLabel getLabel_1() {
		if (lblStriktnoBinarnoP == null) {
			lblStriktnoBinarnoP = new JLabel("Svako Hafmanovo stablo je striktno binarno");
			lblStriktnoBinarnoP.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblStriktnoBinarnoP.setForeground(Color.WHITE);
			lblStriktnoBinarnoP.setBounds(145, 169, 288, 25);
		}
		return lblStriktnoBinarnoP;
	}
	private JLabel getLblNivoListova() {
		if (lblNivoListova == null) {
			lblNivoListova = new JLabel("Nivo listova:");
			lblNivoListova.setHorizontalAlignment(SwingConstants.CENTER);
			lblNivoListova.setForeground(Color.WHITE);
			lblNivoListova.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNivoListova.setBounds(10, 53, 125, 25);
		}
		return lblNivoListova;
	}
	private JLabel getLblNivoListoraO() {
		if (lblNivoListoraO == null) {
			lblNivoListoraO = new JLabel("Nivo simbola odgovara du\u017Eini njegovog koda");
			lblNivoListoraO.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNivoListoraO.setForeground(Color.WHITE);
			lblNivoListoraO.setBounds(145, 53, 288, 25);
		}
		return lblNivoListoraO;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Izlaz");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 15));
			button.setBackground(new Color(137, 189, 211));
			button.setBounds(163, 225, 120, 35);
		}
		return button;
	}
}
