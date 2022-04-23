
/**
 * This class is making structure of each treeNode.
 * @author y
 
 */
public class TreeNode<T> 
{
	private T data;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode)
	{
		this (dataNode, null, null);
	}

	/**
	 * Constructor helper
	 * @param dataNode
	 * @param leftChild
	 * @param rightChild
	 */
	public TreeNode(T dataNode, TreeNode<T> leftChild, TreeNode<T> rightChild) 
	{
		data = dataNode;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	/**
	 * used for making deep copies
	 * @param node node to make copy of
	 */
	public TreeNode(TreeNode<T> node)
	{
		new TreeNode<>(node);
//		TreeNode<T> newRoot = new TreeNode<>(node);
//		if(leftChild != null)
//			leftChild.setLeftChild(newRoot);
//		if(rightChild != null)
//			rightChild.setRightChild(newRoot);
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the leftChild
	 */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
}
