/* 
 * A6Tester.java
 */
import java.util.*;
import java.io.*;

public class A6Tester {

	
	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main(String[] args) {
		testHeapOperations(); // implemented for you

		testFrequency();
		testBSTProperty();
		testEntryList();

		System.out.println("\nPASSED " + testPassCount + "/" + testCount + " TESTS");
		
		//Uncomment the following once you have completed Parts 1 and 2
		
		 System.out.println();
		 System.out.println("Analysis results:");
		 testFrequencyReport(args);
		
	}
	
	public static void testHeapOperations() {
		System.out.println("**Testing Heap**");
		Entry<String, Integer> e1 = new Entry<String, Integer>("word", 6);
		Entry<String, Integer> e2 = new Entry<String, Integer>("heap", 9);
		Entry<String, Integer> e3 = new Entry<String, Integer>("bst", 13);
		Entry<String, Integer> e4 = new Entry<String, Integer>("test", 4); 
		Entry<String, Integer> e5 = new Entry<String, Integer>("computer", 11);
		Entry<String, Integer> e6 = new Entry<String, Integer>("csc", 1);
		Entry<String, Integer> result, expected; 
		
		MaxFrequencyHeap<String, Integer> h1 = new MaxFrequencyHeap<String, Integer>();
		displayResults(h1.isEmpty(), "Heap test1");
		displayResults(h1.size()==0, "Heap test2");
		
		h1.insert(e1);
		displayResults(!h1.isEmpty(), "Heap test3");
		displayResults(h1.size()==1, "Heap test4");
		
		h1.insert(e2);
		h1.insert(e3);
		
		result = h1.removeMax();
		expected = new Entry<String, Integer>("bst", 13);
		if (result != null) {
			displayResults(result.equals(expected), "Heap test5");
		} else {
			displayResults(false, "Heap test5");
		}
		displayResults(!h1.isEmpty(), "Heap test6");	
		displayResults(h1.size()==2, "Heap test7");
	
		h1.insert(e4);
		h1.insert(e5);
		h1.insert(e6);
		displayResults(h1.size()==5, "Heap test8");
		
		try {
			result = h1.removeMax();
			displayResults(result.equals(e5), "Heap test9");	
			result = h1.removeMax();
			displayResults(result.equals(e2), "Heap test10");	
			result = h1.removeMax();
			displayResults(result.equals(e1), "Heap test11");	
			result = h1.removeMax();
			displayResults(result.equals(e4), "Heap test12");	
			result = h1.removeMax();
			displayResults(result.equals(e6), "Heap test13");	
		} catch (NullPointerException e) {
			displayResults(false, "One of Heap tests 9 through 13");
		}
		displayResults(h1.isEmpty(), "Heap test14");
		
		System.out.println();
	}
	
	public static void testFrequency() {
		System.out.println("**Testing frequency and size**");
		int expected = 0;
		int returned = 0;
		
		WordFrequencyBST<String,Integer> bst = new WordFrequencyBST<String,Integer>();
		returned = bst.size();
		displayResults(returned == expected, "testing size initialized correctly in constructor");		
		
		bst.handleWord("heap");
		bst.handleWord("test");
		bst.handleWord("word");
		bst.handleWord("computer");
		bst.handleWord("bst");
		bst.handleWord("csc");
		
		expected = 6;
		returned = bst.size();
		displayResults(returned == expected, "testing size updated correctly in handleWord");	
		//System.out.println(returned);

		expected = 1;
		returned = bst.getFrequency("test");
		displayResults(returned == expected, "testing frequency after handling word 1 time");
		
		expected = 0;
		returned = bst.getFrequency("science");
		displayResults(returned ==expected, "testing frequency after never handling word");
		
		bst.handleWord("bst");
		bst.handleWord("bst");
		bst.handleWord("bst");
		bst.handleWord("csc");
		
		expected = 6; // size should not have changed
		returned = bst.size();
		displayResults(returned == expected, "testing size updated correctly for duplicate words");
		//System.out.println(returned);
		
		expected = 4;
		returned = bst.getFrequency("bst");
		displayResults(returned == expected, "testing frequency after handling word 3 times");
		//System.out.println(returned);

		expected = 2;
		returned = bst.getFrequency("csc");
		displayResults(returned == expected, "testing frequency after handling word 2 times");
		//System.out.println(returned);
		System.out.println();

		bst.handleWord("bst");

		expected = 5;
		returned = bst.getFrequency("bst");
		displayResults(returned == expected, "testing frequency after handling word 3 times");
		//System.out.println(returned);

		expected = 0;
		returned = bst.getFrequency("math");
		displayResults(returned == expected, "testing frequency after handling word 3 times");

		bst.handleWord("math");

		expected = 1;
		returned = bst.getFrequency("math");
		displayResults(returned == expected, "testing frequency after handling word 3 times");

		expected = 7; // size should not have changed
		returned = bst.size();
		displayResults(returned == expected, "testing size updated correctly for duplicate words");

	}
	
	public static void testBSTProperty() {
		System.out.println("**Testing Binary Search Tree property**");
		
		List<Entry<String,Integer>> returned = null;
		
		WordFrequencyBST<String,Integer> bst = new WordFrequencyBST<String,Integer>();
		bst.handleWord("heap");
		bst.handleWord("test");
		bst.handleWord("word");
		bst.handleWord("computer");
		bst.handleWord("bst");
		bst.handleWord("csc");
		
		String[] inOrderExpected = {"bst","computer","csc","heap","test","word"};
		returned = bst.entryList(WordFrequencyBST.BST_INORDER);
		//System.out.println(returned);
		keysMatch(returned, inOrderExpected);
		
		String[] preOrderExpected = {"heap","computer","bst","csc","test","word"};
		returned = bst.entryList(WordFrequencyBST.BST_PREORDER);
		//System.out.println(returned);
		keysMatch(returned, preOrderExpected);
		
		String[] postOrderExpected = {"bst","csc","computer","word","test","heap"};
		returned = bst.entryList(WordFrequencyBST.BST_POSTORDER);
		//System.out.println(returned);
		keysMatch(returned, postOrderExpected);
		
		System.out.println();
	}
	
	public static void testEntryList() {
		System.out.println("**Testing entryList**");
		
		List<Entry<String,Integer>> returned = null;
		
		WordFrequencyBST<String,Integer> bst = new WordFrequencyBST<String,Integer>();
		bst.handleWord("heap");
		bst.handleWord("test");
		bst.handleWord("word");
		bst.handleWord("computer");
		bst.handleWord("bst");
		bst.handleWord("csc");
		
		String[] levelOrderExpected = {"heap","computer","test","bst","csc","word"};
		returned = bst.entryList();
		//System.out.println(returned);
		keysMatch(returned, levelOrderExpected);

		System.out.println();
	}

	public static void keysMatch(List<Entry<String,Integer>> returned, String[] expected) {
		displayResults(expected.length == returned.size(), "comparing lists, size");
		
		if (expected.length != returned.size()) {
			// if sizes don't match, don't need to compare all elements
			displayResults(false, "end of comparing all keys in lists");
			return;
		}
		
		Iterator<Entry<String,Integer>> i = returned.iterator();
		int pos = 0;
		boolean failed = false;


		while (!failed && i.hasNext()) {
			Entry<String,Integer> e = i.next();

			if (!e.getKey().equals(expected[pos])) {
				// System.out.println(e + ":" + key_expected[pos] + "," + value_expected[pos]);
				failed = true;
				break;
			}
			pos++;
		}
		displayResults(!failed, "end of comparing all keys in lists");
	}
	
	public static void testFrequencyReport(String[] args) {
		
		testOverall(args);
		testAtLeastLength(args);
		testStartsWith(args);
	}
	
	public static void testOverall(String[] args) {
		MaxFrequencyHeap<String, Integer> h = init(args);
		
		if (h != null) {
			List<Entry<String, Integer>> results;
			System.out.println("\nOverall most frequent:");
			results = WordFrequencyReport.overallMostFrequent(h);
			System.out.println(results);
		}
	}
	
	public static void testAtLeastLength(String[] args) {
		MaxFrequencyHeap<String, Integer> h = init(args);
		
		if (h != null) {
			List<Entry<String, Integer>> results;
			int minLength = 6;
			System.out.println("\nMost frequent words with "+minLength+" or more characters:");
			results = WordFrequencyReport.atLeastLength(h, minLength);
			System.out.println(results);
		}
	}
	
	public static void testStartsWith(String[] args) {
		MaxFrequencyHeap<String, Integer> h = init(args);
		
		if (h != null) {
			List<Entry<String, Integer>> results;
			char letter = 'c';
			System.out.println("\nMost frequent words starting with a "+letter);
			results = WordFrequencyReport.startsWith(h, letter);
			System.out.println(results);
		}
	}
	
	public static MaxFrequencyHeap<String, Integer> init(String[] args) {
		if (args.length == 0) {
			System.out.println("invalid input arguments - should be: java A4Tester <filename>");
			System.exit(-1);
		}
		try {
			Scanner s = new Scanner(new File(args[0]));
			WordFrequencyBST<String, Integer> bst = readFile(s);
			return bst.createHeapFromTree();
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file specified - ensure it is saved in the right location");
			System.exit(-1);
		}
		return null;
	}

	public static WordFrequencyBST<String, Integer> readFile(Scanner fileReader) {
		WordFrequencyBST<String, Integer> wordTree = new WordFrequencyBST<String, Integer>();
		
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			String[] words = line.split("[^a-zA-Z0-9]+");
			for (int i = 0; i < words.length; i++) {
				if (words[i].length() > 0) {
					wordTree.handleWord(words[i].toLowerCase());
				}
			}
		}
		fileReader.close();
		return wordTree;
	}
	
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
}
