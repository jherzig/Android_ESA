package ch.jherzig.amando4.gui;

import ch.jherzig.amando4.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class EinstellungenBearbeiten extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		this.addPreferencesFromResource(R.xml.amando_einstellungen);
	}

}
