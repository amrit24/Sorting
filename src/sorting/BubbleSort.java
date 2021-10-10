package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

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
		System.out.println(bubbleSort(list));		
	}

	private static List<Integer> bubbleSort(List<Integer> list) {
		Integer[] arr = list.toArray(new Integer[list.size()]);
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return Arrays.asList(arr);
		
	}
}
