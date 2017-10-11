package gererics;

import java.util.Comparator;

public class car implements Comparable<car> {
	private String name;
	private int price;
	private int speed;

	public static final CarspeedComparator speedctor = new CarspeedComparator();
	public static final CarReversespeedComparator speedrevctor = new CarReversespeedComparator();
	public static final CarsPriceComparator pricector = new CarsPriceComparator();
	public static final CarReversePriceComparator pricerevctor = new CarReversePriceComparator();
	public static final CarsNameComparator namector = new CarsNameComparator();
	public static final CarReversenameComparator namerevctor = new CarReversenameComparator();

	public car(String name, int price, int speed) {
		this.name = name;
		this.price = price;
		this.speed = speed;

	}

	private static class CarspeedComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.speed - o2.speed;
		}

	}

	private static class CarReversespeedComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o2.speed - o1.speed;
		}

	}

	private static class CarsPriceComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			// TODO Auto-generated method stub
			return o2.price - o1.price;
		}

	}

	private static class CarReversePriceComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.price - o2.price;
		}

	}

	private static class CarsNameComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o1.name.compareTo(o2.name);
		}

	}

	private static class CarReversenameComparator implements Comparator<car> {

		@Override
		public int compare(car o1, car o2) {
			return o2.name.compareTo(o1.name);
		}

	}

	@Override
	public int compareTo(car o) {
		return this.speed - o.speed;
	}

	@Override
	public String toString() {
		return "{" + this.name + " " + this.speed + " " + this.price + " }";
	}

}
