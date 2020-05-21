package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();
		char characterB;
		//2. Add five Strings to your list
		
			strings.add(0, "clone");
			strings.add(1, "mald clone");
			strings.add(2, "bald clone");
			strings.add(3, "logan");
			strings.add(4, "derek");
		//3. Print all the Strings using a standard for-loop
		System.out.println("step 3");
			for(int a = 0; a < 5; a++) {
			System.out.println(strings.get(a));
		}
		
		System.out.println("step 4");
			//4. Print all the Strings using a for-each loop
		for(String s : strings){
			System.out.println(strings);
		}
		System.out.println("step 5");
		//5. Print only the even numbered elements in the list.
		for(int a = 0; a < strings.size(); a++) {
			if(a % 2 == 1) {
				System.out.println(strings.get(a));
			}
		}
		System.out.println("step 6");
		//6. Print all the Strings in reverse order.
		for (int a = strings.size() - 1; a > -1; a--) {
			System.out.println(strings.get(a));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		System.out.println("step 7");
		for(int a = 0; a < strings.size(); a++) {
			for(int i = 0; i < strings.get(a).length(); i++) {
				if(strings.get(a).charAt(a) == 'e') {
					System.out.println(strings.get(a));
				}
			}
			
		}
	}
}
