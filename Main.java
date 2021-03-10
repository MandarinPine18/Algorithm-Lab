public class Main {
	public static void main(String[] args) {
		// testing arrays
		String[] names = {"Bobby", "Joe", "Billy", "Jane", "Tina", "Mary"};
		int[] ages = {13, 18, 11, 34, 11, 4};
		System.out.println("names: " + process(names) + "\nages: " + process(ages) + "\n");
		System.out.println("The minimum is " + findMin(ages)[0] + " found at index " + findMin(ages)[1] + ".");
		System.out.println("The average is " + average(ages));
		System.out.println("The sum is " + sum(ages));
		System.out.println("\"Joe\" appears " + count(names, "Joe") + "times.");
		System.out.println("\"Jane\" is located at index " + locate(names, "Jane"));
		System.out.println("ages reversed is: " + process(reverse(ages)));
		System.out.println("The even numbers of ages are: " + process(even(ages)));
		System.out.println("names shifted one to the right is: " + process(toTheRight(names)));
		System.out.println("The array ages " + (consecutive(ages) ? "has" : "does not have") + " consecutive numbers in it.");
		System.out.println("The array names " + (duplicate(names) ? "has" : "does not have") + " duplicates in it.");
		System.out.println(howManyB(names) + " names start with the letter \"B\"");
		System.out.println(belowOrEqual20(ages) + " ages are below or equal to 20.");
	}

	// 1.
	public static int[] findMin(int[] arr) {
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				index = i;
				min = arr[index];
			}
		}
		// it is formatted like this to return both the minimum and the index of the minimum
		return new int[] {min, index};
	}

	// 2.
	public static int average(int[] arr) {
		int total = 0;
		for(int val: arr) {
			total += val;
		}
		return total/arr.length;
	}

	// 3.
	public static int sum(int[] arr) {
		int total = 0;
		for(int val: arr) {
			total += val;
		}
		return total;
	}

	// 4.
	public static int count(String[] arr, String target) {
		int count = 0;
		for (String val: arr) {
			if (val.equals(target)) {
				count++;
			}
		}
		return count;
	}

	// 5.
	// although this would seem like a boolean problem, your example used a number, so I will return a number
	public static int locate(String[] arr, String target) {
		int index = 0;
		for (String val: arr) {
			index++;
			if (val.equals(target)) {
				return index;
			}
		}
		return -1;
	}

	// 6.
	public static int[] even(int[] arr) {
		int count = 0;
		for (int val: arr) {
			if (val % 2 == 0) {
				count++;
			}
		}

		int[] even = new int[count];
		int index = 0;
		for (int val: arr) {
			if (val % 2 == 0) {
				even[index] = val;
				index++;
			}
		}
		return even;
	}

	// 7.
	public static int[] reverse(int[] arr) {
		int count = 0;
		int[] temp = new int[arr.length];
		for(int i = arr.length-1; i >= 0; i--) {
			temp[count] = arr[i];
			count++;
		}
		return temp;
	}

	// 8.
	public static String[] toTheRight(String[] arr) {
		String[] temp = new String[arr.length];
		for(int i = 0; i < arr.length-1; i++) {
			temp[i+1] = arr[i];
		}
		temp[0] = arr[arr.length-1];    // edge case
		return temp;
	}

	// 9.
	public static boolean consecutive(int[] arr) {
		Integer mem = null;
		for(int val: arr) {
			if (mem != null && mem == val) {
				return true;
			}
			mem = val;
		}
		return false;
	}

	// 10.
	public static boolean duplicate(String[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(i != j && arr[i].equals(arr[j])) {
					return true;
				}
			}
		}
		return false;
	}

	// 11.
	public static int howManyB(String[] arr) {
		int count = 0;
		for(String val: arr) {
			if (val.substring(0, 1).equals("B")) {
				count++;
			}
		}
		return count;
	}

	// 12.
	public static int belowOrEqual20(int[] arr) {
		int count = 0;
		for (int val: arr) {
			if (val <= 20) {
				count++;
			}
		}
		return count;
	}

	// these are simple parsing methods which process arrays to an easily readable, printable format
	public static String process(Object[] arr) {
        String temp = "[" + arr[0];
        for(int i = 1; i < arr.length; i++) {
            temp += ", " + arr[i];
        }
        temp+="]";
        return temp;
    }

    public static String process(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return process(temp);
    }
}