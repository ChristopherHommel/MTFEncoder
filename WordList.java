
/**
 * 
 * @author Christopher
 * ID: 1325383
 * Creates a new Node containing a word in the world list
 * For a singly connected linked list
 * 
 */
public class WordList {
	
		protected int count;
		protected Node head;
		
		//Set the count to 0 as there is no words in the wordlist yet
		public WordList()
		{
			count = 0;
		}
		
		/**
		 * Adds a new word to the list of words
		 * @param datavalue
		 */
		public void Add(String datavalue)
		{
			//If there is nothing in the head of the node
			//The you must be at the end of the list and set the node head to null and 
			//the data to the passed aprameter datavalue
			if(head == null)
			{
				head = new Node(datavalue, head);
			}
			//Otherwise create a new node with the datavalue passed in
			else
			{
				Node temp = new Node(datavalue, head);
				head = temp;
			}
			//Increase the count to get the the total length of the list
			count++;
		}


		/**
		 * 
		 * If the datavalue passed into the method matches a datavalue in the linked list
		 * get that position until found
		 * @param datavalue
		 * @return the length of the list
		 */
		public int GetIndex(String datavalue)
		{
			
			Node current = head;
			int i;
		
			for(i = 1; i < count; i++)
			{
				
				if(current.GetData().equals(datavalue))
				{
					return i;
				}
				
				else
				{
					current = current.GetNext();
				}

			}
			return i;
		}

		/**
		 * Moves every new word the the front of the list
		 * @param datavalue
		 */
		public void MoveToFront(String datavalue)
		{	
			
			Node current = head;
			
			//If at the end of the list or there is nothing in the list
			//return 
			if(current.GetNext() == null)
				return;
			
			//If the datavalue matches the value at the start of the list
			//No need to move it to the front as it already exists there
			if(head.GetData().equals(datavalue))
				return;	

			
			for(int i = 0; i < count; i++)
			{
				//If the next nodes datavalue is equal 
				if((current.GetNext()).GetData().equals(datavalue))
				{	
					//Get the next nodes data
					Node temp = current.GetNext();
					//Map the node to the front
					current.SetNext((current.GetNext()).GetNext());
					temp.SetNext(head);


					head = temp;


					return;
				}
				//Move to the next node
				current = current.GetNext();
			}	
		}	
		
		/**
		 * 
		 * @param datavalue
		 * @return true if the list contains the passed in datavalue
		 */
		public boolean ContainsElement(String datavalue)
		{	

			Node current = head;
			int i;
			
	        	for(i = 0; i < count; i++)
	    		{

				if(current.GetData().equals(datavalue))
				{
				    return true;
				}

				current = current.GetNext();
			}

			return false;
		}
		
		/**
		 * 
		 * @param index
		 * @return position of the passed in datavalue
		 */
		public String GetWord(int index)
		{
			Node current = head;
			int i;


			for(i = 1; i < index; i++)
			{

				if(current.GetNext() == null)
				{
					return null;
				}

				current = current.GetNext();

			}

			return current.GetData();
		}
		
		/**
		 * 
		 * @author Christopher
		 * ID: 1325383
		 * Creates a new node class for data to be stored
		 */
		private class Node
		{

			private Node next;
			private String data;
			
			//Constructor for the node class
			//Sets a word for each node
			//And sets the head of each node;
			public Node(String datavalue, Node node)
			{
				this.data = datavalue;
				this.next = node;
			}
			
			/**
			 * 
			 * @return the data of the current node
			 */
			public String GetData() {
				return this.data;
			}
			
			/**
			 * 
			 * @return the data of the next node
			 */
			public Node GetNext() {
				return this.next;
			}

			/**
			 * 
			 * @param _next sets the data of the next node
			 */
			public void SetNext(Node _next) {
				this.next = _next;
			}
			
			
			
			
		}

}
