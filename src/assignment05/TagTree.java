package assignment05;

import java.util.ArrayList;
import java.util.Scanner;

public class TagTree {
	
	private Node root;
	
	private static class Node{
		String data;
		String id;
		ArrayList<Node> children;
		Node(String i, String d){
			id = i;
			data = d;
		}
	}

	TagTree(Scanner ss){
		root = new Node(parse(ss.next()), parse(ss.next()));
	}
	
	private String parse(String raw){
		if (raw.charAt(raw.length() - 1) != '>'){
			return raw.substring(1, raw.length());
		}
		else if (raw.charAt(0) != '<'){
			return raw.substring(0, raw.length() - 1);
		}
		else {
			return raw.substring(2, raw.length() - 1);
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
	
	public boolean isCompleteBinaryTree(){
		
		return true;
	}
	
	public int findDepth(String word){
		
		return 0;
	}
}
