package currencyConverter;


import java.util.LinkedList;

import currencyConverter.sistemskeOperacije.SOCuvanjeUFajl;
import currencyConverter.sistemskeOperacije.SOKonverzija;
import currencyConverter.sistemskeOperacije.SOPreuzmiZemlje;


public class Menjacnica {
	public static LinkedList<Zemlja> preuzmiZemlje() {
		return SOPreuzmiZemlje.izvrsi();
	}
	
	public static void cuvanjeUFajl(LinkedList<Zemlja> countries, String imeIz, String imeU) {
		SOCuvanjeUFajl.izvrsi(countries, imeIz, imeU);
	}
	
	public static void konverzija(LinkedList<Zemlja> countries, String imeIz, String imeU, String iznosIz) {
		SOKonverzija.izvrsi(countries, imeIz, imeU, iznosIz);
	}
}
