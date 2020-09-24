import java.util.*;

class KLists{

	public void merge(double [] left, double [] right, double [] target)
	{
		int leftIndex = 0;
		int rightIndex = 0;
		int targetIndex = 0;

		while((leftIndex < left.length) && (rightIndex < right.length)) //makes sure that there are elements in both left array and right array
		{
			if(left[leftIndex] > right[rightIndex]) //compares value to see which is smaller, adds smaller one to target array
			{
				 target[targetIndex] = right[rightIndex];
				 targetIndex++;
				 rightIndex++;
			}
			else
			{
				target[targetIndex] = left[leftIndex];
				targetIndex++;
				leftIndex++;
			}
		}

		while(leftIndex < left.length) //if there are any leftover values in left array, adds them to the target array
		{
			target[targetIndex] = left[leftIndex];
			targetIndex++;
			leftIndex++;
		}

		while(rightIndex < right.length) //if there are any leftover values in right array, adds them to the target array
		{
			target[targetIndex] = right[rightIndex];
			targetIndex++;
			rightIndex++;
		}

	}
	public double [] mergeKLists (double [][] outerArray)
	{
		double [] sortedArr = {};
		if(outerArray.length > 0) //makes sure outerArray is not empty
		{
			sortedArr = outerArray[0];
			for(int i = 1; i < outerArray.length; i++) //goes through each subarray
			{
				double [] target = new double [sortedArr.length + outerArray[i].length]; //temp array to store sorted values
				merge(sortedArr, outerArray[i], target); //merges outerArray with its subarrays, then places it into temp array
				sortedArr = target; //puts new values into outerArray
			}
		}
		return sortedArr;
	}

	public static void main(String args[])
	{
		KLists kl = new KLists();
		double [][] arr1 = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
		double [][] arr2 = {};
		double [][] arr3 = {{}};
		double [][] arr4 = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
		System.out.println(Arrays.toString(kl.mergeKLists(arr1)));
		System.out.println(Arrays.toString(kl.mergeKLists(arr2)));
		System.out.println(Arrays.toString(kl.mergeKLists(arr3)));
		System.out.println(Arrays.toString(kl.mergeKLists(arr4)));
	}
}
