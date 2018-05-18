package currencyConverter.sistemskeOperacije;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import currencyConverter.URLConnection;
import currencyConverter.Zemlja;

import gui.prozor.GlavniProzor;

public class SOKonverzija {
	static final String key = "http://free.currencyconverterapi.com/api/v3/convert?q=";

	public static void izvrsi(LinkedList<Zemlja> countries, String imeIz, String imeU, String iznosIz) {
		Zemlja z1 = null, z2 = null;
		for (int i = 0; i < countries.size(); i++) {
			if (imeIz.equals(countries.get(i).getName())) {
				z1 = countries.get(i);
			}
			if (imeU.equals(countries.get(i).getName())) {
				z2 = countries.get(i);
			}
		}
		String s = z1.getCurrencyId() + "_";
		s += z2.getCurrencyId();
		String pros = s;
		s =  key + pros;

		try {
			s = URLConnection.getContent(s);
			JsonParser p = new JsonParser();
			JsonObject obj = p.parse(s).getAsJsonObject();
			Gson g = new GsonBuilder().setPrettyPrinting().create();

			int count = g.fromJson(obj.getAsJsonObject("query").getAsJsonPrimitive("count"), int.class);
			if (count == 0) {
				JOptionPane.showMessageDialog(null, "Ne postoji transakcija", "Greska", JOptionPane.ERROR_MESSAGE);
				return;
			}

			double odnos = g.fromJson(obj.getAsJsonObject("results").getAsJsonObject(pros).getAsJsonPrimitive("val"),
					double.class);
			
			Double a = 0.0;
			try {
				a = new Double(odnos * Double.parseDouble(iznosIz));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Niste uneli broj", "Greska", JOptionPane.ERROR_MESSAGE);
			}
			
			GlavniProzor.textFieldIznosU.setText(a.toString());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
