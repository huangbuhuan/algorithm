package me.buhuan.tree;

import org.junit.jupiter.api.Test;

/**
 * @author hbh
 * @date 2020/4/2
 */
public class BSTTest {
	@Test
	public void test() {
		BST<String, String> bst = new BST<>();
		bst.put("a", "b");
		bst.put("b", "c");
		System.out.println(bst);
	}

	@Test
	public void floorTest() {
		BST<String, String> bst = new BST<>();
		bst.put("a", "b");
		bst.put("c", "b");
		bst.put("d", "c");
		System.out.println(bst.floor("b"));
	}

	@Test
	public void deleteTest() {
		BST<String, String> bst = new BST<>();
		bst.put("a", "b");
		bst.put("c", "b");
		bst.put("d", "c");
		bst.delete("c");
		System.out.println(bst);
	}
}
