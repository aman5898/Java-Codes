package gererics;

import java.util.Comparator;
import java.util.Scanner;

public class genericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 6, 2, 9, 2, 3, 4, 5, 1 };
		// display(arr);
		car[] c = new car[5];
		c[0] = new car("Audi", 100, 1000);
		c[1] = new car("BMW", 200, 50);
		c[2] = new car("Porsche", 150, 200);
		c[3] = new car("Merc", 300, 3000);
		c[4] = new car("Benz", 50, 2000);
		// bubblesort(arr);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the basis of your comp 1.Speed 2. Name 3.Price");
		int x = scn.nextInt();
		System.out.println("Regular or irreggular");
		boolean bl = scn.nextBoolean();
		GenericHeap<car> gh = null;
		
		if (x == 1 && bl == true) {
			gh = new GenericHeap<>(car.speedctor);
		} else if (x == 1 && bl == false) {
			gh = new GenericHeap<>(car.speedrevctor);
		} else if (x == 2 && bl == true) {
			gh = new GenericHeap<>(car.namector);
		} else if (x == 2 && bl == false) {
			gh = new GenericHeap<>(car.namerevctor);
		} else if (x == 3 && bl == true) {
			gh = new GenericHeap<>(car.pricector);
		} else if (x == 3 && bl == false) {
			gh = new GenericHeap<>(car.pricerevctor);
		}
		for (car cars : c) {
			gh.add(cars);
		}
		gh.display();
		while (gh.size() != 0) {
			System.out.println(gh.removeHp());
		}

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val + " ,");
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			counter++;
		}
	}

}
