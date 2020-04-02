package me.buhuan.tree;

import java.util.logging.Level;

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

	public K min() {
		return min(root).k;
	}

	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	public K floor(K k) {
		Node node = floor(root, k);
		if (node == null) {
			return null;
		}
		return node.k;
	}

	/**
	 * 获取小于等于key大最大key
	 *
	 * @param node
	 * @param k
	 * @return
	 */
	private Node floor(Node node, K k) {
		if (node == null) {
			return null;
		}

		int cmp = k.compareTo(node.k);

		if (cmp == 0) {
			return node;
		}

		if (cmp < 0) {
			return floor(node.left, k);
		}

		Node t = floor(node.right, k);
		if (t != null) {
			return t;
		}

		return node;
	}

	private K select(int x) {
		if (x > size(root) || x < 0) {
			return null;
		}

		return select(root, x).k;
	}

	private Node select(Node node, int x) {
		if (node == null) {
			return null;
		}

		int t = size(node.left);
		if (t > x) {
			return select(node.left, x);
		} else if (t < x){
			return select(node.right, x - t - 1);
		}

		return node;
	}

	public int rank(K k) {
		return rank(k, root);
	}

	private int rank(K k, Node node) {
		if (node == null) {
			return 0;
		}

		int cmp = k.compareTo(node.k);
		if (cmp == 0) {
			return size(node.left);
		} else if (cmp < 0) {
			return rank(k, node.left);
		}

		return 1 + size(node.left) + rank(k, node.right);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		// 返回右节点
		if (node.left == null) {
			return node.right;
		}

		/*
		 * 递归找到最小节点删除，并重新计算节点数
		 */
		node.left = deleteMin(node.left);
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	public void delete(K k) {
		root = delete(root, k);
	}

	private Node delete(Node node, K k) {
		if (node == null) {
			return null;
		}

		int cmp = k.compareTo(node.k);
		if (cmp < 0) {
			node.left = delete(node.left, k);
		} else if (cmp > 0) {
			node.right = delete(node.right, k);
		}else {
			if (node.left == null) {
				return node.right;
			}

			if (node.right == null) {
				return node.left;
			}

			/*
			 * 1.创建一个临时节点指向当前节点
			 * 2.将当前节点指向右子树的最小节点
			 * 3.将当前节点的右子树指向删除了最小节点的右子树
			 * 4.将当前左子树指向被删除节点的左子树
			 */
			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
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
