package com.datastructures.linkedlists;

public class DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList listClass = new DoublyLinkedList();
		
		LinkedList list = listClass.new LinkedList("First Node");
		list.addNode(listClass.new LinkedList("Second Node"));
		list.addNode(listClass.new LinkedList("Third Node"));
		list.addNode(listClass.new LinkedList("Fourth Node"));
		
		printLinkedList(list);
		
	}


	private static void printLinkedList(LinkedList list) {
		System.out.println("*****  Traversing from Head to last");
		while(list.getNextNode()!=null) {
			System.out.print(list.getData()+"| ---> |");
			list = list.getNextNode();
		}
		System.out.println(list.getData()+"| ---> |");
		
		System.out.println("*****  Traversing from Last to Head");
		while(list.getPrevNode()!=null) {
			System.out.print(list.getData()+"| ---> |");
			list = list.getPrevNode();
		}
		System.out.println(list.getData()+"| ---> |");
	}
	
	
	public class LinkedList{
		
		private String data;
		private LinkedList nextNode; 
		private LinkedList prevNode; 
		
		public LinkedList(String data) {
			this.data = data;
		}
				
		public LinkedList(String data, LinkedList prevNode, LinkedList nextNode) {
			super();
			this.data = data;
			this.prevNode = prevNode;
			this.nextNode = nextNode;
		}
		
		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		
		public LinkedList getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(LinkedList prevNode) {
			this.prevNode = prevNode;
		}

		public LinkedList getNextNode() {
			return nextNode;
		}
		
		public void setNextNode(LinkedList nextNode) {
			this.nextNode = nextNode;
		}
		
		public void addNode(LinkedList nextNode) {
			LinkedList pointer = this;
			
			while(pointer.getNextNode()!=null) {
				pointer = pointer.getNextNode();
			}
			pointer.setNextNode(nextNode);
			nextNode.setPrevNode(pointer);
		}
	}
}
