package currencyConverter.sistemskeOperacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import currencyConverter.Konverzija;
import currencyConverter.Konverzija;
import currencyConverter.URLConnection;
import currencyConverter.Zemlja;

public class SOCuvanjeUFajl {
static final String key = "http://free.currencyconverterapi.com/api/v3/convert?q=";
	
	public static void izvrsi(LinkedList<Zemlja> countries, String imeIz, String imeU) {

		try {

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
			s = key + pros;
			s = URLConnection.getContent(s);

			JsonParser p = new JsonParser();
			Gson g = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();
			JsonObject obj = p.parse(s).getAsJsonObject();

			double odnos = g.fromJson(obj.getAsJsonObject("results").getAsJsonObject(pros).getAsJsonPrimitive("val"),
					double.class);

			Konverzija k = new Konverzija();

			k.setDatum(new GregorianCalendar().getTime());
			k.setIzValuta(z1.getCurrencyId());
			k.setuValuta(z2.getCurrencyId());
			k.setKurs(odnos);

			String kon = g.toJson(k);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("data/log.json", true)));
			writer.println(kon);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
