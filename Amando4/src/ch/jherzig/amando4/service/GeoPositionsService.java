package ch.jherzig.amando4.service;

import java.util.List;

import ch.jherzig.amando4.kontakt.TelefonnummernHelfer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

public class GeoPositionsService extends Service {

	private GpsData mGpsData;

	private List<String> mEmpfaengerMobilnummern;
	private String mStichwort;
	private static boolean mPositionNachverfolgen;
	private String mEigeneMobilnummer;

	private Handler mKarteAnzeigenCallbackHandler;

	private final IBinder mGpsBinder = new GeoPositionsServiceBinder();

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	public class GeoPositionsServiceBinder extends Binder {
		/**
		 * Liefert die letzte bekannte eigene Position.
		 * 
		 * @return Letzte bekannte eigene Position.
		 */
		public GpsData getGpsData() {
			return mGpsData;
		}

		public void sendeGeoPosition(final List<String> empfaenger,
				final String stichwort, final boolean positionAktualisieren) {
			mEmpfaengerMobilnummern = empfaenger;
			mStichwort = stichwort;
			mPositionNachverfolgen = positionAktualisieren;
			mEigeneMobilnummer = ermittleEigeneMobilnummer();
			
			sendeGeoPositionImlp(false);
		}
		public void setzeActivityCallbackHandler (final Handler callback) {
			mKarteAnzeigenCallbackHandler = callback;			
		}


	}
	
	private void sendeGeoPositionImlp(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private String ermittleEigeneMobilnummer() {
		final String eigeneMobilnummer = TelefonnummernHelfer.ermittleEigeneMobilnumer(this);
		return TelefonnummernHelfer.bereinigteTelefonnummer(eigeneMobilnummer);
	}

}
