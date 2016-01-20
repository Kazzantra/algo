package test;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class SeDesBinaryTree {
	public enum eORDER {PRE, IN, POST};
	public enum eUSING {VAL, ADDR};
	public static Integer[] traverse(TreeNode<Integer> root, eORDER order, eUSING using) {
		List<Integer> list = new ArrayList<>();
		//if(root != null)
			//traverseHelper(root, list, order, using);
		return list.toArray(new Integer[list.size()]);
	}
	/*
	private static void traverseHelper(TreeNode<Integer> root, List<Integer> list, eORDER order, eUSING using) {
		switch(order) {
		case PRE:
			list.add(using == eUSING.VAL ? root.val : root.address());
			if(root.left != null)
				traverseHelper(root.left, list, order);
			if(root.right != null)
				traverseHelper(root.right, list, order);
			break;
		case IN:
			if(root.left != null)
				traverseHelper(root.left, list, order);
			list.add(root.val);
			if(root.right != null)
				traverseHelper(root.right, list, order);
			break;
		case POST:
			if(root.left != null)
				traverseHelper(root.left, list, order);
			if(root.right != null)
				traverseHelper(root.right, list, order);
			list.add(root.val);
		}
	}
	public static TreeNode<Integer> deserializeBinaryTree(Integer[] preOrder, Integer[] inOrder) {
		TreeNode<Integer> ret = null;
		if(preOrder.length > 0 && inOrder.length > 0)
			ret = deserializeHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		return ret;
	}
	private static TreeNode<Integer> deserializeHelper(Integer[] preOrder, int pStart, int pEnd, Integer[] inOrder, int iStart, int iEnd) {
		TreeNode<Integer> ret = null;
		if(pStart < pEnd && pStart >= 0 && pStart < preOrder.length) {
			ret = new TreeNode<Integer>(preOrder[pStart]);
			int index = inStart;
			while(inOrder[])
			
		}
		return ret;
	}
	*/
}
