import java.util.*;
public class HeapSort {
	public void sort(int arr[])
	{
		int N = arr.length;

		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		for (int i = N - 1; i > 0; i--) {

			int x = arr[0];
			arr[0] = arr[i];
			arr[i] = x;

			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int N, int i) {
		// ...existing code...
	}
}
