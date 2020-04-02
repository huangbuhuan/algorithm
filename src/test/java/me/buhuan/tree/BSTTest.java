package me.buhuan.tree;

import org.junit.jupiter.api.Test;

/**
 * @author hbh
 * @date 2020/4/2
 */
public class BSTTest {

	private static BST<String, String> bst = new BST<>();
	static  {
		bst.put("a", "b");
		bst.put("t", "c");
		bst.put("b", "b");
		bst.put("g", "c");
		bst.put("h", "b");
		bst.put("q", "c");
	}

	@Test
	public void test() {
		System.out.println(bst);
	}

	@Test
	public void floorTest() {
		System.out.println(bst.floor("b"));
	}

	@Test
	public void deleteTest() {
		bst.delete("c");
		System.out.println(bst);
	}

	@Test
	public void keysTest() {
		System.out.println(bst.keys());
	}

}
