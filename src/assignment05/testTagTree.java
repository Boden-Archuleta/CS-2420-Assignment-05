package assignment05;

import static org.junit.Assert.*;

import java.io.File;
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
	public void testParse() {
		Scanner ss = new Scanner("<a blue> <b green> </b> <c blue> </c> <d yellow> </d> </a>");
		TagTree tree = new TagTree(ss);
	}

}
