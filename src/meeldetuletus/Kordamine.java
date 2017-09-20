package meeldetuletus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONObject;

public class Kordamine {
	
	public static void main (String args[]) {
		
		JSONObject obj = new JSONObject();    
		obj.put("nimi","Jyri");    
		obj.put("vanus", new Integer(27));
		//System.out.println(obj.get("vanus"));
		
		ArrayList<String> numbrid = new ArrayList<String>();
		numbrid.add("yks");
		numbrid.add("kaks");
		numbrid.add("kolm");
		
		Kordamine k = new Kordamine();
		System.out.println(k.kas_algab_suure_t2hega("test"));
		System.out.println(k.kas_suuri_t2hti_rohkem("TESt"));
		System.out.println(k.kas_s6na_on_sama("viis", 5));
		System.out.println(k.vanuse_p2rimine(obj));
		System.out.println(k.kas_s6na_on_listis("kaks", numbrid));
		System.out.println(k.mapi_p2rimine(8));
		System.out.println(k.loo_kylaline("Jyri", 8, "jyri@mail.com").toString());
		
		for (Kylalised kylaline : k.kylalistest_listi_tegemine(5)) {
			System.out.println(kylaline.toString());
		}
	}
	
	public boolean kas_algab_suure_t2hega (String str) {
		return (Character.isUpperCase(str.charAt(0)));
	}
	
	public boolean kas_suuri_t2hti_rohkem (String str) {
		int tasakaal = 0;
		for (int i = 0; i < str.length()-1; i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				tasakaal ++;
			} else {
				tasakaal --;
			}
		}
		return (tasakaal > 0);
	}
	
	public boolean kas_s6na_on_sama (String str, int i) {
		if (i >= 0 && i <= 9) {
			return (str.equals(number_s6naks(i)));
		} else {
			throw new IllegalArgumentException("number ei ole vahemikus 0-9");
		}
	}
	
	public String number_s6naks (int i) {
		String [] s6nad = {"null", "yks", "kaks", "kolm", "neli", "viis", "kuus", "seitse", "kaheksa", "yheksa"};
		return s6nad[i];
	}
	
	public String vanuse_p2rimine (JSONObject inimene) {
		return (String) inimene.get("vanus").toString();
	}
	
	public boolean kas_s6na_on_listis (String str, ArrayList<String> l) {
		return (l.contains(str));
	}
	
	public Map<Integer, String> mapi_p2rimine (int number) {
		Map<Integer, String> m1 =  new HashMap<Integer, String>();
		for (int i = 1; i <= number; i++) {
			m1.put(i, suvalise_s6na_p2rimine(5));
		}
		return m1;
	}
	
	public String suvalise_s6na_p2rimine(int length) {
	    String r = "";
	    for(int i = 0; i < length; i++) {
	        r += (char)(Math.random() * 26 + 97);
	    }
	    return r;
	}
	
	public Kylalised loo_kylaline (String nimi, int vanus, String email) {
		Kylalised kylaline = new Kylalised(nimi, vanus, email);
		return kylaline;
	}
	
	public ArrayList<Kylalised> kylalistest_listi_tegemine (int kylaliste_arv) {
		ArrayList<Kylalised> kylalised = new ArrayList<Kylalised>();
		Random ran = new Random();
		int vanus = ran.nextInt(100);
		for (int i = 1; i <= kylaliste_arv; i++) {
			kylalised.add(loo_kylaline(suvalise_s6na_p2rimine(5), vanus, suvalise_s6na_p2rimine(5)+"@mail.com"));
		}
		return kylalised;
	}
	
}
