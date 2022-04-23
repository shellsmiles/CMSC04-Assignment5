import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of 
 * MorseCode to English
 * @author y
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root;
	//protected String letter;
	
	public MorseCodeTree()
	{
		root = null;
		buildTree();
	}

	/**Returns a reference to the root
	 * @return the root
	 * getRoot in interface LinkedConverterTreeInterface<java.lang.String>
	 */
	@Override
	public TreeNode<String> getRoot() 
	{
		return root;
	}
	
	/**Sets the root of the MorseCodeTree
	 * @param root a newNode that will be the root of MorseCodeTree
	 * setRoot in interface LinkedConverterTreeInterface<java.lang.String>
	 */
	@Override
	public void setRoot(TreeNode<String> newRoot) 
	{
		this.root = newRoot;
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * @param code the code for the new node to be added
	 * @param letter the data of the new TreeNode to be added
	 * 
	 */
	@Override
	 public void insert(String code, String letter)	
	 {
		 addNode(root,code,letter);
	 }
	 
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if (code.length()==1)
		{
			if (code.equals("."))
				root.leftChild = new TreeNode<String>(letter);
			else if (code.equals("-"))
				root.rightChild = new TreeNode<String>(letter);
		}
		else
		{
			if(code.substring(0, 1).equals("."))
				addNode(root.leftChild, code.substring(1),letter);
			else if (code.substring(0, 1).equals("-"))
				addNode(root.rightChild, code.substring(1),letter);
		}	
	}
	
	
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code : the letter
	 */
	@Override
	public String fetch(String code)
	{
		return fetchNode(root, code);
	}
	
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{
		String letter=null;
		if(code.length()==1)
		{
			if(code.equals("."))
				letter = root.getLeftChild().getData();
			else if (code.equals("-"))
				letter = root.getRightChild().getData();
		}
		else
		{
			if(code.substring(0, 1).equals("."))
				letter = fetchNode(root.getLeftChild(), code.substring(1));
			else if (code.substring(0, 1).equals("-"))
				letter = fetchNode(root.getRightChild(), code.substring(1));
		}
		return letter;
	}
	
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		return null;
	}
		
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		return null;
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree()
	{
		root = new TreeNode<String>("");
		//level #1 -2
		insert(".","e");
		insert("-","t");
		//level #2 -4
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//level #3 -8
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//level #4 -12
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}
	

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> outputList = new ArrayList<>();
		LNRoutputTraversal(root,outputList);
		return outputList;
	}
	
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if( root != null)
		{// InOrder traversal : left- root- right
			LNRoutputTraversal(root.getLeftChild(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}
	
}
