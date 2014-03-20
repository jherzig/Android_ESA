package ch.jherzig.amando4.gui;

import ch.jherzig.amando4.R;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Toast;

public class Startseite extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startseite);
		setTitle(R.string.startseite_titel);
		registerForContextMenu(findViewById(R.id.sf_start_geokontakte));
		registerForContextMenu(findViewById(R.id.sf_position_senden));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.hauptmenue, menu);
		return super.onCreateOptionsMenu(menu);

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.opt_einstellungenBearbeiten:
			final Intent intent = new Intent(this, EinstellungenBearbeiten.class);
			startActivity(intent);
		case R.id.opt_hilfe:
			shortToast("// TODO onOptionsItemSelected R.id.opt_hilfe");
			// TODO onOptionsItemSelected R.id.opt_hilfe
			return true;
		case R.id.opt_amandoBeenden:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if (v.getId() == R.id.sf_start_geokontakte) {
			getMenuInflater().inflate(R.menu.startseite_contextmenue, menu);
		}
		if (v.getId() == R.id.sf_position_senden) {
			shortToast("onCreateContextMenu sf_position_senden");
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.opt_geokontakt_verwalten_hilfe) {
			final Intent intent = new Intent(this, HilfeAnzeigen.class);
			startActivity(intent);
			return true;
		}
		return super.onContextItemSelected(item);
	}

	public void onClickPositionSenden(final View sfView) {
		shortToast("// TODO onCklickPositionSenden");
		// TODO onCklickPositionSenden
	}

	public void onClickGeokontakteVerwalten(final View sfView) {
		Intent i = new Intent(this, GeoKontakteAuflisten.class);
		startActivity(i);
	}

	public void onClickKarteAnzeigen(final View sfView) {
		shortToast("// TODO onClickKarteAnzeigen");
		// TODO onCklickPositionSenden
	}

	public void onClickSimulationStarten(final View sfView) {
		shortToast("// TODO onClickSimulationStarten");
		// TODO onClickSimulationStarten
	}
	
	public void onClickNicknameAnzeigen(final View sfView) {
		//Auf Einstellungen zugreiffen
		SharedPreferences einstellungen = PreferenceManager.getDefaultSharedPreferences(this);
		String nickname = einstellungen.getString("nickname", "unbekannt");
		shortToast("Der Nickname lautet: " + nickname);
	}

	private void shortToast(String text) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
