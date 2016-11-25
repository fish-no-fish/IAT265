package util;

import main.PongPanel;

public class Util {
	public static double random(double low, double high) {
		return low + Math.random() * (high - low);
	}
}
