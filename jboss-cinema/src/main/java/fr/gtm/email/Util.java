package fr.gtm.email;


import java.util.Map;
import java.util.Map.Entry;

public class Util {
	public static String replace(String template, Map<String, String> map) {
		StringBuilder sb = new StringBuilder(template);
		for(Entry<String, String> entry : map.entrySet()) {
			String var = "{{"+entry.getKey()+"}}";
			int start = sb.indexOf(var);
			if(start!=-1) {
				int stop = start + var.length();
				sb.replace(start,stop, entry.getValue());
			}
		}
		return sb.toString();
	}

}
