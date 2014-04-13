package ch.jherzig.amando4.gui;

import ch.jherzig.amando4.service.GeoPositionsService;
import ch.jherzig.amando4.service.GeoPositionsService.GeoPositionsServiceBinder;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class KarteAnzeigen extends Activity {

	private static Handler mKarteAnzeigenCallbackHandler;

	private ServiceConnection mGeoPositionsServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			((GeoPositionsServiceBinder)service).setzeActivityCallbackHandler(mKarteAnzeigenCallbackHandler);

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final Intent geoIntent = new Intent(this,GeoPositionsService.class);
		bindService(geoIntent, mGeoPositionsServiceConnection, Context.BIND_AUTO_CREATE);

	}
	@Override
	protected void onDestroy(){
		mKarteAnzeigenCallbackHandler.removeCallbacksAndMessages(null);
		unbindService(mGeoPositionsServiceConnection);
		stopService(new Intent(this, GeoPositionsService.class));
		
		super.onDestroy();
	}

}
