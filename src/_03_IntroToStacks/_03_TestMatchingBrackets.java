package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	Stack<Character> brackets = new Stack<Character>();
	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		int left = 0;
		int right = 0;
		Boolean r = false;
		/*brackets.push(b);
		if(b.contains("{")) {
			left++;
		}
		if(b.contains("}")) {
			right++;
		}
		if(left == right) {
			return true;
		}
		else {
		return false;
		}
	
		for(int a = 0; a < b.length(); a++) {
			brackets.push(b.charAt(a));
			for(int a1 = 0; a1 < brackets.size(); a1++) {
				brackets.pop();
				if(brackets.pop() == '{') {
					left++;
				}
				else if(brackets.pop() == '}') {
					right++;
				}
				else {
					continue;
				}
			}
			if(left == right) {
				r = true;
			}
			else {
			r = false;
		}
		}
		System.out.println(brackets.pop());
		return r;
	*/
		for(int a = 0; a < b.length(); a++) {
			if(b.charAt(a) == '{') {
				brackets.push(b.charAt(a));
			}
			else if(brackets.isEmpty() == false && b.charAt(a) == '}') {
				brackets.pop();
			}
			else {
				return false;
			}
		}
		return brackets.empty();
	}
		
}