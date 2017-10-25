package assignment05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TagTree {
	
	private Node root;
	
	private static class Node{
		String data;
		String id;
		Set<Node> children;
		Node(String i, String d){
			id = i;
			data = d;
			children = new HashSet<Node>();
		}
	}

	TagTree(Scanner ss){
		root = parseNode(ss, ss.next());
		scan(root, ss);
	}
	
	private void scan(Node current, Scanner ss){
		while (ss.hasNext()){
			String next = ss.next();
			
			while(!isEndTag(next)){
				Node child = parseNode(ss, next);
				next = ss.next();
				if (!isEndTag(next)){
					scan(child, ss);
				}
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
		
		return 0;
	}
	
	public int getMaxDegree(){
		
		return 0;
	}
	
	public String outputPrefix(){
		
		return null;
	}
	
	public String outputPostfix(){
		
		return null;
	}
	
	public boolean isBinaryTree(){
		
		return true;
	}
	
	public boolean isTwoTree(){
		
		return true;
	}
	
	public boolean isFullBinaryTree(){
		
		return true;
	}
	
	public int findDepth(String word){
		
		return 0;
	}
}
