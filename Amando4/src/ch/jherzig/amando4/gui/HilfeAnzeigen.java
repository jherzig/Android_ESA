package ch.jherzig.amando4.gui;

import java.io.IOException;
import java.io.InputStream;

import ch.jherzig.amando4.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;

public class HilfeAnzeigen extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hilfe_anzeigen);

		final WebView view = (WebView) findViewById(R.id.webview);
		view.getSettings().setJavaScriptEnabled(true);
		initialisiereWebKit(view, this);
		view.bringToFront();
	}

	private void initialisiereWebKit(WebView view, Context context) {
		final String mimetype = "text/html";
		final String encoding = "UTF-8";
		String htmldata;

		int contectMenue = R.raw.hilfe_komplett;
		InputStream is = context.getResources().openRawResource(contectMenue);

		try {
			if (is != null && is.available() > 0) {
				final byte[] bytes = new byte[is.available()];
				is.read(bytes);
				htmldata = new String(bytes);
				view.loadDataWithBaseURL(null, htmldata, mimetype, encoding,
						null);
			}
		} catch (IOException e) {
		}
	}

}
