package com.datastructures.linkedlists;

public class SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList listClass = new SinglyLinkedList();
		
		LinkedList list = listClass.new LinkedList("First Node", null);
		list.addNode(listClass.new LinkedList("Second Node", null));
		list.addNode(listClass.new LinkedList("Third Node", null));
		list.addNode(listClass.new LinkedList("Fourth Node", null));
		
		printLinkedList(list);
		
	}


	private static void printLinkedList(LinkedList list) {
		while(list.getNextNode()!=null) {
			System.out.print(list.getData()+"| ---> |");
			list = list.getNextNode();
		}
		System.out.println(list.getData()+"| ---> |");
	}
	
	
	public class LinkedList{
		
		private String data;
		private LinkedList nextNode; 
		
		public LinkedList(String data, LinkedList nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}
		
		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
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
		}
	}
}
