package ch.jherzig.amando4.gui;

import java.util.Arrays;
import ch.jherzig.amando4.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListActivity;
import android.content.Context;

public class GeoKontakteAuflisten extends ListActivity {

	private String[] NAME = new String[5];
	private ArrayAdapter<String> mKontaktAdapter; 


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
		((Spinner) this.findViewById(R.id.sp_sortierung))
				.setOnItemSelectedListener(mSpinnerItemAuswahlListener);
	}

	private void zeigeGeokontakte() {
		initialisiereNamen();
		mKontaktAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, NAME);
		setListAdapter(mKontaktAdapter);
	}

	
	/**
	 * 
	 */
	private AdapterView.OnItemSelectedListener mSpinnerItemAuswahlListener = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long id) {
			switch (position) {
			case 0: // Standard
				initialisiereNamen();
				mKontaktAdapter.notifyDataSetChanged();
				shortToast("Standard");
				break;
			case 1: // Name
				Arrays.sort(NAME);
				mKontaktAdapter.notifyDataSetChanged();
				shortToast("NAME");
			default:
				break;
			}
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private void shortToast(String text) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}


	protected void onListItemClick(ListView l, View v, int position, long id) {
		final Toast hinweis = Toast.makeText(this,
				"Element " + ((TextView) v).getText(), Toast.LENGTH_LONG);
		hinweis.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.geo_kontakte_auflisten, menu);
		return true;
	}

}
