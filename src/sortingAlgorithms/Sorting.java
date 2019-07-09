package sortingAlgorithms;

import java.util.Arrays;

public class Sorting {
	/*
	 *    Merging Sort 
	 * 
	                         */
	public static void sort(int arr[], int low, int high){
		int m = ( high - low )/2;
		sort(arr, low, m);
		sort(arr, m + 1, high);
		merge(arr, low, m, high);
	}
	
	public static void merge(int arr[], int l, int m, int h){
		int n1 = m - l + 1;
		int n2 = h - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for(int j = 0; j < n2; j++)
			R[j] = arr[j + m + 1];
		int i = 0, j = 0;
		int k = l;
		while( i < n1 && j < n2){
			if(L[i] < R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while( i < n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while( j < n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	/*
	 *    Quick Sort 
	 * 
	                         */
	
	public static void quickSort(int arr[], int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	
	public static int partition(int arr[], int l, int h){
		int pivot = arr[h];
		int i = l - 1;
		for(int j = l; j < h; j++){
			if( arr[j] <= pivot ){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		return i+1;
	}
	
	/*
	 *    Insertion Sort 
	 * 
	                         */
	
	public static void insertionSort(int arr[]){
		int n = arr.length;
		for(int i=1; i < n; i++){
			int key = arr[i];
			int j = i - 1;
			while( j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	
	/*
	 *    Selection Sort 
	 * 
	                         */
	
	
	public static void selectionSort(int arr[]){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	

	/*
	 *    Counting Sort 
	 * 
	                         */
	
	public static void countingSort(char arr[]){
		int n = arr.length;
		
		char output[] = new char[n];
		int count[] = new int[256];
		
		for(int i = 0; i < 256; i++)
			count[i] = 0;
		
		for(int i=0; i < n; i++)
			count[arr[i]]++;
		
		for(int i = 1; i <= 255; i++)
			count[i] += count[i-1];
		
		for(int i = n-1; i >= 0; i--){
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		
		for(int i = 0; i < n; i++)
			arr[i] = output[i];
	}
	
	/*  sorting negative numbers with counting sort  */
	
	public static void countingSortNeg(int arr[]){
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		
		int range = max - min + 1;
		int output[] = new int[arr.length];
		int count[] = new int[range];
		
		for(int i = 0; i < range; i++)
			count[i] = 0;
		for(int i = 0; i < arr.length; i++ )
			count[arr[i] - min]++;
		for(int i = 1; i < range-1; i++)
			count[i]+=count[i-1];
		for(int i = arr.length; i >= 0; i--){
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}
		for(int i = 0; i < arr.length; i++)
			arr[i]=output[i];
		
	}
	
	
	/*
	 *    Binary array Sort 
	 * 
	                         */
	
	public static void binarySort(int arr[]){
		int j = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 1){
				j++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	
	/*
	 *    			Heap Sort 
	 * 
	      a heap is a complete binary tree which every level is completely filled, it can be represented by binary tree or array.
	 Array representation :
	 	if the parent node is sorted at index I the left child is in 2*I+1 position and the right child is in 2*2+2 position.
	 			*/
	
	public void sor(int arr[]){
		
		int n = arr.length;
		
		for(int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		
		for(int i = n-1; i >= 0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
		
		
		
	}
	
	
	
	
	
	public void heapify(int arr[], int n, int i){
		int max = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if( l < n && arr[l] > arr[max])
			max = l;
		if(r < n && arr[r] > arr[max])
			max = r;
		if(max != i){
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			heapify(arr, n, max);
		}
	}
	

	/*
	 *    Bubble Sort 
	 * 
	                         */
	
	public void bubbleSort(int arr[]){
		boolean swap = false;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length - i - 1; i++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					swap = true;
				}
			}
			if(!swap)
				break;
		}
	}

	/*
	 *    Radix Sort 
	 * 
	                     */
	public static void radixSort(int arr[], int n){
		int max = getMax(arr,n);
		for(int exp = 1; max%exp > 0; exp*=10)
			countSort(arr, n, exp);
	}
	public static int getMax(int arr[], int n){
		int max = arr[0];
		for(int i = 1; i < n; i++){
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}	
	
	public static void countSort(int arr[], int n, int exp){
		int output[] = new int[n];
		int count[] = new int[10];
		int i;
		Arrays.fill(count, 0);
		for(i=0; i < n; i++)
			count[(arr[i]/exp)%10]++;
		for(i=1; i < 10; i++)
			count[i] = count[i-1];
		for(i = n; i >= 0; i++){
			output[count[(arr[i]/exp)%10] - 1]++;
			count[(arr[i]/exp)%10]--;
		}
		for(i = 0; i < n; i++)
			arr[i] = output[i];
			
	}
	
	
	public static void main(String[] args){
		char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
                'r', 'g', 'e', 'e', 'k', 's'
                }; 
		countingSort(arr);
		System.out.println(arr[0]);
	}
	
	
	
	
	
	
	
}
