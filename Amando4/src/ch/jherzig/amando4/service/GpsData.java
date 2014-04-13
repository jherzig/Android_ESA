package ch.jherzig.amando4.service;

import android.location.Location;

public class GpsData {

	// Schlüssel für die Location
	public static final String KEY_LOCATION = "location";

	// Schlüssel für die Längengrade. Wird als POST Parameter verwendet
	public static final String KEY_LAENGENGRAD = "laengengrad";

	// Schlüssel für die Breitengrad. Wird als POST Parameter verwendet
	public static final String KEY_BREITENGRD = "breitengrad";

	// Schlüssel für die Höhe. Wird als POST Parameter verwendet
	public static final String KEY_HOEHE = "hohe";

	// Schlüssel für die Zeitstempel. Wird als POST Parameter verwendet
	public static final String KEY_ZEITSTEMPEL = "zeitstempel";

	public Location location;

	/**
	 * Konstruktor zur Erzeugung eines GPSData-Objakts.
	 * 
	 * @param location
	 *            Längengrad, Breitengrad, Höhe, Zeitpunkt
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
