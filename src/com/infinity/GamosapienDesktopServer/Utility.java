package com.infinity.GamosapienDesktopServer;

public class Utility {

	public static float mappedValue(float value, float orgMIN, float orgMAX,
			float newMIN, float newMAX) {
		value = (value - orgMIN) / (orgMAX - orgMIN) * (newMAX - newMIN)
				+ newMIN;
		return value;

	}
}
