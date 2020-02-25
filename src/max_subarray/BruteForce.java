package max_subarray;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {
	static ArrayList<Integer> findMaxSubarray(ArrayList<Integer> a) {
		int sum = 0;
		int max = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for(int i = 0; i < a.size(); i++) {
			//System.out.println("I: " + i);
			
			ArrayList<Integer> array = new ArrayList<Integer>();
			//array.add(a.get(i));
			
			//sum = sum + a.get(i);
			
			for(int j = i; j < a.size(); j++) {
				
				//System.out.println("j: " + j);
				array.add(a.get(j));
				sum = sum(array);
				if(sum > max) {
					//System.out.println("Max Before: " + max);
					max = sum;
					//System.out.println("Max After: " + max);
					maxArray = new ArrayList<Integer>(array);
					answer = new ArrayList<Integer>(maxArray);
					answer.add(max);
					sum = 0;
				}
			}
		}
		return answer;
	}
	static int sum(ArrayList<Integer> a) {
		int sum = 0;
		for(int i = 0; i<a.size();i++) {
			sum = sum + a.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		BruteForce bf = new BruteForce();
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		//System.out.println("===========================\nBefore Method\n===========================\n");
		
		System.out.println("How many do numbers do you want to insert?");
		int n = scan.nextInt();
		for(int i = 0; i<n; i++) {
			System.out.println("Insert a number: ");
			int j = scan.nextInt();
			al.add(j);
		}
		
		//System.out.println("===========================\nMethod\n===========================\n");
		ArrayList<Integer> al2 = bf.findMaxSubarray(al);
		
		//System.out.println("===========================\nAfter Method\n===========================\n");
		for(int i = 0; i<al2.size();i++) {
			if(i == al2.size()-1) {
				System.out.println("Sum: " + al2.get(i));
				
			}else {
				System.out.println("Index: " + al2.get(i));
			}
		}
	}

}
