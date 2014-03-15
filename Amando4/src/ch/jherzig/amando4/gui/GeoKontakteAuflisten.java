package ch.jherzig.amando4.gui;

import ch.jherzig.amando4.R;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

public class GeoKontakteAuflisten extends ListActivity {

	private String[] NAME = new String[5];



	private void initialisiereNamen() {
		NAME[0] = "Meyer Philiph";
		NAME[1] = "Lena Herzig";
		NAME[2] = "Karain Däster";
		NAME[3] = "Leona Herzig";
		NAME[4] = "Hans Hess";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geokontakte_auflisten);
		
		zeigeGeokontakte();
	}

	private void zeigeGeokontakte() {
		initialisiereNamen();
		ArrayAdapter<String> mKontaktAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, NAME);
		setListAdapter(mKontaktAdapter);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.geo_kontakte_auflisten, menu);
		return true;
	}

}
