package assignment05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.omg.CORBA.Current;

public class TagTree {
	
	public Node root;
	
	private static class Node{
		String data;
		String id;
		ArrayList<Node> children;
		Node(String i, String d){
			id = i;
			data = d;
			children = new ArrayList<Node>();
		}
	}

	TagTree(Scanner ss){
		root = parseNode(ss, ss.next());
		scan(root, ss);
	}
	
	private void scan(Node current, Scanner ss){
		while (ss.hasNext()){
			String next = ss.next();
			if (isEndTag(next)){
				return;
			}
			else {
				Node child = parseNode(ss, next);
				scan(child, ss);
				current.children.add(child);
			}
		}
	}
	
	private Node parseNode(Scanner ss, String raw){
		String i = raw.substring(1, raw.length());
		raw = ss.next();
		String d = raw.substring(0, raw.length() - 1);
		return new Node(i, d);
	}
	
	private boolean isEndTag(String input){
		if (input.charAt(1) == '/') {
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getHeight(){
		return getHeight(root, 0);
	}
	
	private int getHeight(Node current, int level){
		if (current.children.size() == 0)
			return level;
		level++;
		
		for (Node n : current.children){
			level = getHeight(n, level);
		}
		
		return level;
	}
	
	public int getMaxDegree(){
		return getMaxDegree(root, 0);
	}
	
	private int getMaxDegree(Node current, int degree){
		if (current.children.size() == 0)
			return degree;
		
		for (Node n : current.children){
			degree++;
			Math.max(degree, getMaxDegree(n, 0));
		}
		
		return degree;
	}
	
	public String outputPrefix(){
		return outputPrefix(root, "");
	}
	
	private String outputPrefix(Node current, String output){
		output = output.concat(current.data);
		
		if (current.children.size() == 0){
			return output;
		}
		
		for (Node n : current.children){
			output = output.concat(" ");
			output = outputPrefix(n, output);
		}
		
		return output;
	}
	
	public String outputPostfix(){
		return outputPostfix(root, "");
	}
	
	private String outputPostfix(Node current, String output){
		if (current.children.size() == 0){
			return output.concat(current.data);
		}
		
		for (Node n : current.children){
			output = outputPostfix(n, output);
			output = output.concat(" ");
		}
		
		output = output.concat(current.data);
		
		return output;
	}
	
	public boolean isBinaryTree(){
		if (this.getMaxDegree(root, 0) > 2){
			return false;
		}
		
		return true;
	}
	
	public boolean isTwoTree(){
		return isTwoTree(root);
	}
	
	private boolean isTwoTree(Node current){
		if (current.children.size() != 2 && current.children.size() != 0){
			return false;
		}
		
		for (Node n : current.children){
			isTwoTree(n);
		}
		
		return true;
	}
	
	public boolean isFullBinaryTree(){
		int levels = this.getHeight();
		
		int numNodes = this.nodeCount(root, 0);
		if ((Math.pow(2, levels) - 1 == numNodes)){
			return true;
		}
		
		return false;
	}
	
	private int nodeCount(Node current, int count){
		count++;
		if (current.children.size() == 0){
			return count;
		}
		
		for (Node n : current.children){
			count = nodeCount(n, count);
		}
		
		return count;
	}
	
	public int findDepth(String word){
		return findDepth(word, root, 0, -1);
	}
	
	private int findDepth(String word, Node current, int level, int val){
		return 0;
	}
	
	
	
	
}
