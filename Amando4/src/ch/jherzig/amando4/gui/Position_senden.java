package ch.jherzig.amando4.gui;

import ch.jherzig.amando4.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Position_senden extends Activity {

	private long mGeoKontaktId;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_senden);

		 final Intent intent = new Intent(this,GeoKontakteAuflisten.class);
		 intent.putExtra(GeoKontakteAuflisten.SELECT_KONTAKT, true);

		 startActivityForResult(intent, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.geo_kontakte_auflisten, menu);
		return true;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case Activity.RESULT_OK:
			setmGeoKontaktId(data.getExtras().getLong(
					GeoKontakteAuflisten.IN_PARAM_KONTAKT_ID));
			break;
		case Activity.RESULT_CANCELED:
			finish();
			break;
		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void onClickPositionSenden(final View sfView) {
		// TODO: onClickPositionSenden
		shortToast("// TODO: onClickPositionSenden");
	}
	
	private void shortToast(String text) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	public long getmGeoKontaktId() {
		return mGeoKontaktId;
	}

	public void setmGeoKontaktId(long mGeoKontaktId) {
		this.mGeoKontaktId = mGeoKontaktId;
	}

	/*
	 * protected void onStart() { // TODO: Lade Geokontakte aus der Datenbank
	 * und zeige diese an. //Toast toast = new Toast(this); //toast.setText(
	 * "// TODO: Lade Geokontakte aus der Datenbank und zeige diese an.");
	 * //toast.show(); }
	 */
}
