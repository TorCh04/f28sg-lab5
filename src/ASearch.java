public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
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
		// Iterate through the array
		for (int i = 0; i < catalogue.length; i++) 
		{
			// Fail case
			if (catalogue[i] == null)
			{
				return -1;
			}	

			// If we've found the name return the number
			if (catalogue[i].getName() == name)
			{
				return catalogue[i].getNumber();
			}	
		}
		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	/**
	 * Uses binary search to look up a given name in the catalogue and returns the
	 * number if the name is in the catalogue. Otherwise it returns -1.
	 * 
	 * TODO Where N is the number of entries in the catalogue the (worst case) complexity is:
	 *
	 * O(log n)
	 *  
	 * @param first the array index of the start of search space
	 * @param last the array index of the end of the search space
	 * @param name the person name being searched for
	 * @return the persons phone number if their name is found or -1 otherwise
	 */
	private int binarySearch(int first,int last,String name){
		// Fail Case
		if (first > last)
		{
			return -1;
		}
		else
		{
			// Get middle position within given range
			int middle = (first + last) / 2;
			// Get the middle name wihtin given range
			String midName = catalogue[middle].getName();

			// We've found the name we're searching for
			if (midName.equals(name))
			{
				// Returns the number of the name we found
				return catalogue[middle].getNumber();
			}

			// Bottom half of the search
			else if (midName.compareTo(name) > 0)
			{
				// Recurse bottom half of the search
				return binarySearch(first, middle - 1, name);
			}

			// Top half of the search
			else 
			{
				// Recurse top half of the search
				return binarySearch(middle + 1, last, name);
			}
		
		}
	}

	// helper method exposed to the programmer
	public int binarySearch(String name){
		return binarySearch(0,current-1,name);
	}
	
	
}
