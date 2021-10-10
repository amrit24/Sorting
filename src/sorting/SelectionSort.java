package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {

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
		System.out.println(selectionSort(list));

	}

	private static List<Integer> selectionSort(List<Integer> list) {
		Integer[] arr = list.toArray(new Integer[list.size()]);
		int n = arr.length;
		//64 25 12 22 11
		//11 25 12 22 64
		//11 12 25 22 64
		//11 12 22 25 64
		for(int i=0;i<n-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
				
		return Arrays.asList(arr);
	}

}
