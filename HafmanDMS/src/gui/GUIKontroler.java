package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import cvorovi.Cvor;
import stabla.*;

public class GUIKontroler {

	public static HafmanGUI glavniProzor;
	public static InformacijeGUI informacije;
	public static DekodiranjeGUI dekodiranje;
	public static KodiranjeGUI kodiranje;
	public static OProjektuGUI oProjektu;
	public static Queue<Cvor> cvorovi;
	public static StabloGenerator stabloGenerator;
	public static BTreePrinter treePrinter;
	public static Cvor koren;
	public static List<Cvor> listovi;
	public static Color plavat = new Color(137, 189, 211);
	public static Color plava = new Color(154, 211, 222);
	public static Color siva = new Color(227, 227, 227);
	public static Color sivat = new Color(201, 201, 201);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new HafmanGUI();
					glavniProzor.setVisible(true);
					cvorovi = new PriorityQueue<Cvor>();
					koren = null;
					listovi = new LinkedList<Cvor>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void otvoriInformacijeGUI() {
		informacije = new InformacijeGUI();
		informacije.setVisible(true);
		informacije.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				informacije.dispose();
			}

		});

	}

	public static void otvoriDekodiranjeGUI() {
		dekodiranje = new DekodiranjeGUI();
		dekodiranje.setVisible(true);
		dekodiranje.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dekodiranje.dispose();
			}

		});
	}

	public static void otvoriKodiranjeGUI() {
		kodiranje = new KodiranjeGUI();
		kodiranje.setVisible(true);
		kodiranje.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				kodiranje.dispose();
			}

		});
	}


	public static void otvoriOProjektuGUI() {
		oProjektu = new OProjektuGUI();
		oProjektu.setVisible(true);
		oProjektu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				oProjektu.dispose();
			}

		});
	}
}
