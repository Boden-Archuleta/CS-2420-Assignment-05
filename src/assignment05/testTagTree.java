package assignment05;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testTagTree {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() throws IOException {
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		ss.close();
	}

	@Test
	public void testMaxHeight() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(2, tree.getHeight(), 0);
		
		ss.close();
	}
	
	@Test
	public void testMaxDegree() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(3, tree.getMaxDegree());
		
		ss.close();
	}
	
	@Test
	public void testPreOrder() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals("blue red green yellow orange", tree.outputPrefix());
		
		ss.close();
	}
	
	
	@Test 
	public void testPostOrder() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals("red yellow green orange blue", tree.outputPostfix());
		
		ss.close();
	}
	
	
	@Test
	public void testBinaryTree() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(false, tree.isBinaryTree());
		
		ss.close();
	}
	
	@Test
	public void twoTreeTest() throws FileNotFoundException{
		File f = new File("src/assignment05/inputTwo.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(true, tree.isTwoTree());
		
		ss.close();
	}
	
	@Test
	public void fullTreeTest() throws FileNotFoundException{
		File f = new File("src/assignment05/inputTwo.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(true, tree.isFullBinaryTree());
		
		ss.close();
	}
	
	@Test
	public void testFindLevel() throws FileNotFoundException{
		File f = new File("src/assignment05/input.txt");
		Scanner ss = new Scanner(f);
		TagTree tree = new TagTree(ss);
		
		assertEquals(1, tree.findDepth("yellow"));
		
		ss.close();
	}
	
}
