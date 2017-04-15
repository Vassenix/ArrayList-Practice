package ArrayOps;


/**
 * Programming Project 5 for COM S 207
 * @ Vassenix
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ArrayOperations {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner stdin = new Scanner(System.in);		// initializing scanner
		System.out.print("Enter name of file containing your data: "); // asking for file input name
		String filename = stdin.next(); // stores filename
		ArrayList<Integer> data = readFromFile(filename); // puts data from file into array list
		printArray(data); // prints the array list
		
		// below statements print out a description + relevant method
		
		System.out.println("\nThe average is: " + average(data));
		System.out.println("The smallest element is: " + smallest(data));
		System.out.println("The index of the smallest element is: " + getMinIndex(data));
		System.out.println("The largest element is: " + largest(data));
		System.out.println("The index of the largest element is: " + getMaxIndex(data));
		System.out.println("The index of the 2nd largest element is: " + secondMaxIndex(data));
		
		// check for prime numbers by calling isPrime and printing them out
		
		int numPrimes = 0;
		System.out.print("The prime numbers are: ");
		for (int i = 0; i < data.size(); i++) {
			if (isPrime(data.get(i))) {
				numPrimes++;
				System.out.print(data.get(i) + " ");
				
			} // end if
		} // end for i
		
		System.out.println("\nThe number of primes is: " + numPrimes); // Prints out the # of primes found in the previous loop
		
		// calls sortUp to print out array list in ascending order
		
		sortUp(data); 
		System.out.print("The sorted array in non-decreasing order is: ");
		printArray(data); 
		
		// calls reverse to print out the sorted array list in reverse order
		
		ArrayList<Integer> reverseList = new ArrayList<Integer>();
		reverseList = reverse(data);
		System.out.print("\nThe reverse of the sorted array is: ");
		printArray(reverseList);
		
		stdin.close(); // close scanner
		
	} // end main
	

	public static void printArray(ArrayList<Integer> data) { // Prints out the array list 
		
	
		for (int i = 0; i < data.size(); i++) { // loops gets each # from list and prints it out with a space afterwards
			
			int x = data.get(i);
			
			System.out.print(x + " ");
			
		} // end for
			
	} // end printArray
			
	
	public static ArrayList<Integer> readFromFile(String fileName) throws FileNotFoundException { // Reads file and creates array list
		
	
		File f = new File(fileName);
		Scanner fileIn = new Scanner (f);
		ArrayList<Integer> list = new ArrayList<Integer>();
				while (fileIn.hasNextInt()) { // quit when you encounter ‘Q’
					int num = fileIn.nextInt();
					list.add(num);

				}// end while
				
				fileIn.close();
				return list;

		} // end readFromFile
	

		public static double average(ArrayList<Integer> data) { // Finds average value in ArrayList
		
			double sum = 0.0;
			if (!data.isEmpty()) { // if array list has numbers continues loop - kind of unnecessary since it should auto quit if no numbers are provided in readFromFile method
				for (int x : data) { // gets each value in array list and adds it to sum
					sum += x;
				} // end for
				return sum / data.size(); // takes sum / # of numbers in list to find average
			} // end if
			return sum;
		} // end average

		
		public static int smallest(ArrayList<Integer> data) { // Finds smallest value in ArrayList
			
			int smallest = data.get(0); // initializes smallest with first number in list
			
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i) < smallest) { // replaces smallest with new index number if it is smaller than the previous value in smallest
					smallest = data.get(i);
				} // end if
			} // end for
			return smallest;
		} // end smallest
		
		
		public static int getMinIndex(ArrayList<Integer> data) { // Finds index value of smallest value in ArrayList
			
			int index = 0;
			int min = data.get(0);
			
			for (int i = 1; i < data.size(); i++) {
				
				if (data.get(i) < min) { // same loop as smallest method, this method just grabs the index value of the smallest number
					min = data.get(i);
					index = i;
				} // end if
			} // end for
			return index;
		} // end getMinIndex
		
		
		public static int largest(ArrayList<Integer> data) { // Finds largest value in ArrayList
			
			int largest = data.get(0); // initializes largest with the first number in list
			
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i) > largest) { // replaces largest with new index number if it is larger than the previous largest value
					largest = data.get(i);
				} // end if
			} // end for
			return largest;
		} // end largest
		
		
		public static int getMaxIndex(ArrayList<Integer> data) { // Finds index value of largest value in ArrayList
			
			int index = 0;
			int max = data.get(0);
			
			for (int i = 1; i < data.size(); i++) {
				
				if (data.get(i) > max) {
					max = data.get(i); // same loop as largest method, just grabs the index value of the largest number
					index = i;
				} // end if
			} // end for
			return index;
		} // end getMaxIndex
		
		
		public static int secondMaxIndex(ArrayList<Integer> data) { // Finds index value of second largest value in ArrayList
			
			int secondLargest = data.get(0);
			int largest = data.get(0);
			int index = 0;
			
			for (int i = 1; i < data.size(); i++) {
				
				if (data.get(i) > largest) { // Find the largest value in list to store in largest and stores the previously largest value in secondLargest
					secondLargest = largest;
					largest = data.get(i);
					index = i;
				} // end if
				
				if (data.get(i) > secondLargest && data.get(i) != largest) { // Makes sure the largest value is greater than the secondLargest value and grabs the index value
					secondLargest = data.get(i);
					index = i;
				} // end if
			} // end for
			return index;	
		} // end secondMaxIndex
		
		
		public static boolean isPrime(int n) { // Checks whether a number is prime
			
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}	// end if			
			} // end for
			return true;
		} // end isPrime
		
		
		public static ArrayList<Integer> reverse(ArrayList<Integer> data) { // reverses the list that is inputed
			
			for (int i = 0; i < data.size() / 2; i++) { // Only need half of the data size since we are just swapping the back half of the list
				int num = data.get(i);
				data.set(i, data.get(data.size() - i - 1)); // replaces values from front to back to reverse list
				data.set(data.size() - i - 1, num);
			} // end for
			return data;
		} // end reverse
		
		
		public static void sortUp(ArrayList<Integer> data) { // sorts the inputed list in ascending order
			
			Collections.sort(data);
		} // end sortUp


} // end class ArrayOperations

	
	

	






