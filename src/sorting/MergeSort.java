package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

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
		System.out.println(mergeSort(list));

	}

	private static List<Integer> mergeSort(List<Integer> list) {
		Integer n = list.size();
		Integer[] arr = list.toArray(new Integer[n]);
		sort(arr, 0, n - 1);
		return Arrays.asList(arr);
	}

	static void merge(Integer[] arr, Integer l, Integer m, Integer r)
	{
		// Find sizes of two subarrays to be merged
		Integer n1 = m - l + 1;
		Integer n2 = r - m;

		/* Create temp arrays */
		Integer L[] = new Integer[n1];
		Integer R[] = new Integer[n2];

		/*Copy data to temp arrays*/
		for (Integer i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (Integer j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		Integer i = 0, j = 0;

		// Initial index of merged subarry array
		Integer k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i++];
			}
			else {
				arr[k++] = R[j++];
			}
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k++] = L[i++];
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k++] = R[j++];
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	static void sort(Integer[] arr, Integer l, Integer r)
	{
		if (l < r) {
			// Find the middle poInteger
			Integer m =l+ (r-l)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}
}
