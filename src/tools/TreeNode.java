package tools;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left, right;
	public TreeNode() {
		val = null;
		left = null;
		right = null;
	}
	public TreeNode(T val) {
		this.val = val;
		left = null;
		right = null;
	}
	public String address() {
		String[] spl = this.toString().split("@");
		return spl[spl.length - 1];
	}
}
