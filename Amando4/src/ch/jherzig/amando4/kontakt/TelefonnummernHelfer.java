package ch.jherzig.amando4.kontakt;

import java.text.StringCharacterIterator;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;

public class TelefonnummernHelfer {

	public static String ermittleEigeneMobilnumer(final Context context) {
		TelephonyManager telephonManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String tel = telephonManager.getLine1Number();
		return tel;
	}
	
	public static boolean compare(String a, String b) {
		return PhoneNumberUtils.compare(a, b);
	}
	
	public static String bereinigteTelefonnummer(String phoneNumber){
		if (phoneNumber == null) {
			return phoneNumber;
		}
		
		phoneNumber = phoneNumber.replace("\\+", "00");
		StringCharacterIterator sci = new StringCharacterIterator(phoneNumber);
		char c;
		StringBuilder sb = new StringBuilder();
		
		while ((c= sci.current()) != StringCharacterIterator.DONE) {
		
			if (Character.isDigit(c)) {
				sb.append(c);
			}
			sci.next();
		}
		return sb.toString();
	}

}
