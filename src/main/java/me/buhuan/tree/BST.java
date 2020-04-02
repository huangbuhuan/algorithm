package me.buhuan.tree;

/**
 * 二叉查找树
 *
 * @author hbh
 * @date 2020/4/2
 */
public class BST <K extends Comparable<K>, V> {
	private Node root;

	private class Node {
		private K k;
		private V val;
		private Node left, right;
		private int n;

		public Node(K k, V val, int n) {
			this.k = k;
			this.val = val;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Node{" +
				"k=" + k +
				", val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.n;
	}

	public V get(K k) {
		return get(root, k);
	}

	private V get(Node node, K k) {
		if (node == null) {
			return null;
		}
		int cmp = k.compareTo(node.k);
		if (cmp == 0) {
			return node.val;
		}
		return cmp <0 ? get(node.left, k) : get(node.right, k);
	}

	public void put(K k, V v) {
		root = put(root, k, v);
	}

	private Node put(Node node, K k, V v) {
		if (node == null) {
			return new Node(k, v, 1);
		}
		int cmp = k.compareTo(node.k);
		if (cmp == 0) {
			node.val = v;
		} else if (cmp < 0) {
			node.left = put(node.left, k, v);
		} else {
			node.right = put(node.right, k, v);
		}
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	@Override
	public String toString() {
		return "BST{" +
			"root=" + root +
			'}';
	}
}
