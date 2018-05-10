package gui.prozor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import currencyConverter.CurrencyLayerApiCommunication;
import currencyConverter.Zemlja;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblUValutuZemlje;
	private JComboBox comboBoxIZ;
	private JComboBox comboBoxU;
	private JLabel lblIznos;
	private JLabel lblIznos_1;
	private JTextField textFieldIznosIz;
	private JTextField textFieldIznosU;
	private JButton btnKonvertuj;
	LinkedList<Zemlja> countries = CurrencyLayerApiCommunication.getCountries();

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setResizable(false);
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblUValutuZemlje());
		contentPane.add(getComboBoxIZ());
		contentPane.add(getComboBoxU());
		contentPane.add(getLblIznos());
		contentPane.add(getLblIznos_1());
		contentPane.add(getTextFieldIznosIz());
		contentPane.add(getTextFieldIznosU());
		contentPane.add(getBtnKonvertuj());
		dodajZemlju(comboBoxU);
		dodajZemlju(comboBoxIZ);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Iz valute zemlje:");
			lblNewLabel.setBounds(22, 32, 103, 31);
		}
		return lblNewLabel;
	}

	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje:");
			lblUValutuZemlje.setBounds(202, 29, 97, 37);
		}
		return lblUValutuZemlje;
	}

	private JComboBox getComboBoxIZ() {
		if (comboBoxIZ == null) {
			comboBoxIZ = new JComboBox();
			comboBoxIZ.setBounds(22, 74, 120, 31);
		}
		return comboBoxIZ;
	}

	private JComboBox getComboBoxU() {
		if (comboBoxU == null) {
			comboBoxU = new JComboBox();
			comboBoxU.setBounds(202, 74, 113, 31);
		}
		return comboBoxU;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(22, 127, 103, 31);
		}
		return lblIznos;
	}

	private JLabel getLblIznos_1() {
		if (lblIznos_1 == null) {
			lblIznos_1 = new JLabel("Iznos:");
			lblIznos_1.setBounds(202, 127, 86, 31);
		}
		return lblIznos_1;
	}

	private JTextField getTextFieldIznosIz() {
		if (textFieldIznosIz == null) {
			textFieldIznosIz = new JTextField();
			textFieldIznosIz.setBounds(22, 160, 120, 31);
			textFieldIznosIz.setColumns(10);
		}
		return textFieldIznosIz;
	}

	private JTextField getTextFieldIznosU() {
		if (textFieldIznosU == null) {
			textFieldIznosU = new JTextField();
			textFieldIznosU.setBounds(202, 160, 113, 31);
			textFieldIznosU.setColumns(10);
		}
		return textFieldIznosU;
	}

	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(106, 213, 143, 47);
		}
		return btnKonvertuj;
	}

	private void dodajZemlju(JComboBox zem) {
		for (int i = 0; i < countries.size(); i++) {
			zem.addItem(countries.get(i).getName());
		}
	}

}
