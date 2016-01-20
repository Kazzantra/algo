package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tools.TreeNode;
import tools.io;

public class CommonAncestor {
	
	static enum eUSING {VAL, ADDR};
	
	public static TreeNode<Integer> findLowestCommonAncestor(
			TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b) {
		if(root == null || a == null || b == null) {
			return null;
		} else if(root == a || root == b) {
			return root;
		} else {
			TreeNode<Integer> l = findLowestCommonAncestor(root.left, a, b);
			TreeNode<Integer> r = findLowestCommonAncestor(root.right, a, b);
			if(l == null && r == null)
				return null;
			else if((l == a && r == b) || (l == b || r == a))
				return root;
			else
				return l == null ? r : l ;
		}
	}
	public static TreeNode<Integer> createTree(int numNodes) {
		if(numNodes < 1)
			return null;
		TreeNode<Integer> ret = new TreeNode<Integer>(numNodes);
		ret.left = createTree((numNodes - 1) / 2);
		int numRight = numNodes == 2 || numNodes == 1 ?
					   numNodes - 1 :
					   (numNodes - (numNodes - 1) / 2) ;
		ret.right = createTree(numRight);
		return ret;
	}
	public static <T> String treeToString(TreeNode<T> root, eUSING addrFlag) {
		String ret = "";
		if(root != null) {
			LinkedList<TreeNode<T>> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					TreeNode<T> node = q.pollFirst();
					if(addrFlag == eUSING.ADDR)
						ret += node.address();
					else
						ret += node.val == null ? "" : node.val.toString();
					ret += "\t";
					if(node.left != null)
						q.addLast(node.left);
					if(node.right != null)
						q.addLast(node.right);
				}
				ret += "\n";
			}
		}
		return ret;
	}
	private static <T> void pickRandTreeNodeHelper(TreeNode<T> root, List<TreeNode<T>> all) {
		if(root == null)
			return;
		all.add(root);
		if(root.left != null)
			pickRandTreeNodeHelper(root.left, all);
		if(root.right != null)
			pickRandTreeNodeHelper(root.right, all);
	}
	public static <T> TreeNode<T> pickRandTreeNode(TreeNode<T> root) {
		if(root == null)
			return null;
		List<TreeNode<T>> all = new ArrayList<>();
		pickRandTreeNodeHelper(root, all);
		return all.get(io.rnd(all.size()));
	}
	public static void main(String[] args) {
		TreeNode<Integer> root = createTree(10);
		//io.pl(treeToString(root, eUSING.VAL));
		io.pl(treeToString(root, eUSING.ADDR));
		TreeNode<Integer> picked1 = pickRandTreeNode(root);
		TreeNode<Integer> picked2 = pickRandTreeNode(root);
		io.pl(picked1.address() + " " + picked2.address());
		io.pl(findLowestCommonAncestor(root, picked1, picked2).address());
	}
}
