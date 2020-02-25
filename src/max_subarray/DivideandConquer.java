package max_subarray;

public class DivideandConquer {
	static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
		int leftSum = -100;
		int sum = 0;
		int maxLeft = -100;
		for (int i = mid; i > low; i--) {
			sum = sum + A[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = -100;
		sum = 0;
		int maxRight = -100;
		for (int j = mid + 1; j < high; j++) {
			sum = sum + A[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		int[] retArr = {maxLeft, maxRight, (leftSum + rightSum)};
		return retArr;
	}
	static int[] findMaximumSubarray(int[] A, int low, int high) {
		int[] retArray = new int[3];
		if (high == low) {
			retArray[0] = low;
			retArray[1] = high; 
			retArray[2] = A[low];
			return retArray;
		}
		else {
			int mid = (low + high)/2;
			int[] left = findMaximumSubarray(A, low, mid);
			int leftLow = left[0];
			int leftHigh = left[1];
			int leftSum  = left[2];
			int[] right = findMaximumSubarray(A, mid+1, high);
			int rightLow = right[0];
			int rightHigh = right[1];
			int rightSum = right[2];
			int[] crossing = findMaxCrossingSubarray(A, low, mid, high);
			int crossLow = crossing[0];
			int crossHigh = crossing[1];
			int crossSum = crossing[2];
			if (leftSum >= rightSum && leftSum >= crossSum) {
				return left;
			}
			else if (rightSum >= leftSum && rightSum >= crossSum) {
				return right;
			}
			else {
				return crossing;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {-1, -2, -3, 4, 5};
		int low = 0;
		int high = 4;
		arr = findMaximumSubarray(arr, low, high);
		for (int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
	}
}
