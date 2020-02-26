package max_subarray;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {
	/**
	 * findMaxSubarray uses the brute force method to find the maximum sum of integers in a given integer ArrayList
	 * @param input is the input ArrayList
	 * @return an ArrayList with the indices of the maximum subarray and the sum of their values.
	 */
	static ArrayList<Integer> findMaxSubarray(ArrayList<Integer> input) {
		// max is the maximum sum of all subarrays
		// it is set to -100, assuming none of the subarrays sum up to less than -100
		int max = -100;
		// answer is the ArrayList which includes the indices of the maximum subarray and the sum of their values
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		// This for loop goes through each element in the input ArrayList
		for(int i = 0; i < input.size(); i++) {
			// sum is the sum of the current subarray
			int sum = 0;
			// array is the ArrayList of values in the current subarray
			ArrayList<Integer> array = new ArrayList<Integer>();
			// indices is the ArrayList of indices in the current subarray
			ArrayList<Integer> indices = new ArrayList<Integer>();
			
			// This for loop makes each subarray for each element in the input ArrayList
			for(int j = i; j < input.size(); j++) {
				// The current value is added to array
				array.add(input.get(j));
				// The current index is added to indices
				indices.add(j);
				// The sum of the subarray is calculated
				sum = sum(array);
				
				// If the sum of this array is greater than the max some of arrays,
				if(sum > max) {
					// The current sum becomes the new max
					max = sum;
					// And the indices and sum are added to the answer ArrayList
					answer = new ArrayList<Integer>(indices);
					answer.add(max);
				}
			}
		}
		return answer;
	}
	/**
	 * A helper sum method to sum all the values in an array
	 * @param a is the input ArrayList
	 * @return the sum of the given ArrayList
	 */
	static int sum(ArrayList<Integer> a) {
		int sum = 0;
		for(int i = 0; i < a.size();i++) {
			sum = sum + a.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<Integer>();		
		System.out.println("How many do numbers do you want to sort?");
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Insert the number at index " + i + " : ");
			int j = scan.nextInt();
			input.add(j);
		}
		ArrayList<Integer> arr = BruteForce.findMaxSubarray(input);
		for(int i = 0; i < arr.size()-1;i++) 
			System.out.println("Index: " + arr.get(i));
		System.out.println("Sum: " + arr.get(arr.size()-1));
	}

}
