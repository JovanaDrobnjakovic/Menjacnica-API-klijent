package gui.kontroler;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JComboBox;

import currencyConverter.Menjacnica;
import currencyConverter.Zemlja;

import gui.prozor.GlavniProzor;

public class GUIKontroler {
	public static LinkedList<Zemlja> countries = Menjacnica.preuzmiZemlje();
	public static GlavniProzor gp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void konvertuj() {
		Menjacnica.konverzija(countries, GlavniProzor.comboBoxIZ.getSelectedItem().toString(),
				GlavniProzor.comboBoxU.getSelectedItem().toString(), GlavniProzor.textFieldIznosIz.getText());

		Menjacnica.cuvanjeUFajl(countries, GlavniProzor.comboBoxIZ.getSelectedItem().toString(),
				GlavniProzor.comboBoxU.getSelectedItem().toString());
	}

	public static void dodajZemlju(JComboBox zem) {
		for (int i = 0; i < countries.size(); i++) {
			zem.addItem(countries.get(i).getName());
		}
	}
}
