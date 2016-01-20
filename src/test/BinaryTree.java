package test;

import tools.TreeNode;
import tools.io;

public class BinaryTree<T> {
	TreeNode<T> root;
	BinaryTree() { }
	private class Printer implements Action<TreeNode> {
		@Override
		public void actOn(TreeNode node) { io.pl(node.val);}
	}
	public static <A extends Action<TreeNode>> void dfs(TreeNode root, A action) {
		if(root != null ) {
			if(action != null)
				action.actOn(root);
			dfs(root.left, action);
			dfs(root.right, action);
		}
	}
	public void dfs() {
		dfs(root, new Printer());
	}
}
