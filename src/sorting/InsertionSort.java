package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter elements to be sorted.Press 'q' to terminate");

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				list.add(sc.nextInt());
			} else {
				if (sc.next().equalsIgnoreCase("q")) {
					sc.close();
					break;
				}
			}
		}
		System.out.println(insertionSort(list));
	}

	private static List<Integer> insertionSort(List<Integer> list) {
		int n = list.size();
		Integer[] arr = list.toArray(new Integer[n]);
		//64 25 12 22 11 
		//25 64 12 22 11
		//12 25 64 22 11
		//12 22 25 64 11
		//11 12 22 25 64
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}
		return Arrays.asList(arr);
	}
}
