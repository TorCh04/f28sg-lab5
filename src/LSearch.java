public class LSearch {


	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/*
	 * Part 3: complete
	 */	
	/**
	 * Uses linear search to look up a given name in the catalogue and returns the
	 * number if the name is in the catalogue. Otherwise it returns -1.
	 * 
	 * TODO Where N is the number of entries in the catalogue the (worst case) complexity is:
	 *
	 * O(n)
	 *  
	 * @param name is the person name to look for in the catalogue
	 * @return the number of that person, otherwise -1 to indicate an error
	 */
	public int linearSearch(String name){
		// Get a copy of headNode reference
		Node currentNode = headNode;

		// Iterate through the linked list
		while (currentNode != null) 
		{
			// If we've found the person in the currentNode return their number
			if (currentNode.getValue().getName().equals(name))
			{
				return currentNode.getValue().getNumber();
			}
			// If not move the currentNode reference along the list
			currentNode = currentNode.nextNode;
		}
		return -1; 
	}
}
