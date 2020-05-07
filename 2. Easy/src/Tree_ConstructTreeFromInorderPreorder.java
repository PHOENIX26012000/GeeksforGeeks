import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/construct-tree-1/1
// https://www.techiedelight.com/construct-binary-tree-from-inorder-postorder-traversals/
// https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

public class Tree_ConstructTreeFromInorderPreorder {
	
	static Map<Integer, Integer> inOrderValueIndicesMap = new HashMap<>();
	static int preOrderIndex = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String	ip1[] = br.readLine().trim().split("\\s+"), 
					ip2[] = br.readLine().trim().split("\\s+");
			int	inOrder[] = new int[n], 
				preOrder[] = new int[n];
			
			for	(int i = 0; i < n; i++) {
				inOrder[i] = Integer.parseInt(ip1[i]);
				preOrder[i] = Integer.parseInt(ip2[i]);
			}
			
			for (int i = 0; i < inOrder.length; i++) {
				inOrderValueIndicesMap.put(inOrder[i], i);
			}
			
			Node root = buildBinaryTree(inOrder, preOrder, 0, n-1);
			printPostOrder(root);
		}
	}
	
	private static Node buildBinaryTree(int[] inOrder, int[] preOrder, int inOrderStartIndex, int inOrderEndIndex) {
		if(inOrderStartIndex > inOrderEndIndex) return null;
		
		Node rootNode = new Node(preOrder[preOrderIndex]);
		preOrderIndex++;
		
		if(inOrderStartIndex == inOrderEndIndex) return rootNode;
		
		int inOrderIndex = inOrderValueIndicesMap.get(rootNode.data);
		
		rootNode.left =	buildBinaryTree(inOrder, preOrder, inOrderStartIndex, inOrderIndex-1);
		rootNode.right = buildBinaryTree(inOrder, preOrder, inOrderIndex+1, inOrderEndIndex);
		
		return rootNode;
	}
	
	private static void printPostOrder(Node root) {
		if(root == null) return;
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
