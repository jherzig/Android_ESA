package ch.jherzig.amando4.service;

import android.location.Location;

public class GpsData {

	// Schl�ssel f�r die Location
	public static final String KEY_LOCATION = "location";

	// Schl�ssel f�r die L�ngengrade. Wird als POST Parameter verwendet
	public static final String KEY_LAENGENGRAD = "laengengrad";

	// Schl�ssel f�r die Breitengrad. Wird als POST Parameter verwendet
	public static final String KEY_BREITENGRD = "breitengrad";

	// Schl�ssel f�r die H�he. Wird als POST Parameter verwendet
	public static final String KEY_HOEHE = "hohe";

	// Schl�ssel f�r die Zeitstempel. Wird als POST Parameter verwendet
	public static final String KEY_ZEITSTEMPEL = "zeitstempel";

	public Location location;

	/**
	 * Konstruktor zur Erzeugung eines GPSData-Objakts.
	 * 
	 * @param location
	 *            L�ngengrad, Breitengrad, H�he, Zeitpunkt
	 */
	public GpsData(Location location) {
		this.location = location;
	}

	public double getLaengengrad() {
		return location.getLongitude();
	}

	public double getBreitengrad() {
		return location.getLatitude();
	}

	public double getHoehe() {
		return location.getAltitude();
	}

	public long getZeitstempel() {
		return location.getTime();
	}

	@Override
	public String toString() {
		return "GpsData [Breitengrad=" + location.getLatitude()
				+ ",Laengengrad=" + location.getLongitude() + ", Hoehe="
				+ location.getAltitude() + ", Zeitstempel="
				+ location.getTime() + "]";
	}
}
