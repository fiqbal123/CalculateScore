
public class SinglyLinkedList<T> {
	 @Override
	public String toString() {
		return "SinglyLinkedList [start=" + start + ", end=" + end + ", size=" + size + "]";
	}

	protected Node start;
	 protected Node end ;
	 public int size ;
	 
	    /*  Constructor  */
	    public SinglyLinkedList()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }
	    
	    /*  Function to check if list is empty  */
	    public boolean isEmpty()
	    {
	        return start == null;
	    }
	    
	    /*  Function to get size of list  */
	    public int getSize()
	    {
	        return size;
	    }
	    
	    /*  Function to insert an element at begining  */
	    public void insertAtStart(T val)
	    {
	    	Node<T> node= new Node<>(val, null);
	    	size++;
	    	
	    	if (start==null) {
	    		start=node;
	    		end= start;
	    	}
	    	else {
	    		node.setLink(start);
	    		start= node;
	    	}
	    	
	    }
	    
	    /*  Function to insert an element at end  */
	    public void insertAtEnd(T val)
	    {
	    	Node<T> node= new Node<>(val, null);
	    	size++;
	    	
	    	if(start==null) {
	    		start=node;
	    		end=start;
	    	}
	    	else {
	    		end.setLink(node);
	    		end=node;
	    	}
	    }
	    
	    /*  Function to insert an element at position  */
	    public void insertAtPos(T val , int pos)
	    {
	    	Node<T> newNode= new Node<>(val, null);
	    	Node ptr= start;
	    	if(pos==1) {
	    		insertAtStart(val);
	    	}
	    	else
	    	{
	    		pos= pos -1;
		    	for(int i=1; i<size; i++) {
		    		if(i==pos) {
		    			Node temp= ptr.getLink();
		    			ptr.setLink(newNode);
		    			newNode.setLink(temp);
		    			break;
		    		}
		    		ptr= ptr.getLink();
		    		size++;
		    	}
	    		
	    	}
	    	    	
	    	
	    	

	    	
	    }
	    
	    /*  Function to update elements  */
	    public void update(T val, int pos)
	    {
	    	Node ptr= start;
	    	
	    	for (int i=1; i <size+1; i++)
	    	{
	    		if(i==pos)
	    		{
	    			ptr.setData(val);
	    			break;
	    		}
	    		ptr=ptr.getLink();
	    	}
	    	
	    }
	    
	    /*  Function to delete an element at position  */
	    public void deleteAtPos(int pos)
	    {
	    	Node ptr=start;
	    	
	    	if(pos==1) {
	    		Node newStartNode= start.getLink();
	    		start= newStartNode;
	    	}
	    	else {
		    	pos= pos-1;
		    	
		    	for(int i=1; i<size; i++) {
		    		
		    		if(i==pos)
		    		{
		    			Node nodeToDelete= ptr.getLink();
		    			ptr.setLink(nodeToDelete.getLink());
		    			nodeToDelete=null;
		    			break;    			
		    		}
		    		ptr= ptr.getLink();
		    	}
	    		
	    	}   	
	    	
	    }
	    
	    
	    /*  Function to display elements  */
	    public void display()
	    {
	        System.out.print("\nSingly Linked List = ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }    
	        if (start.getLink() == null) 
	        {
	            System.out.println(start.getData() );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.getData()+ "->");
	        ptr = start.getLink();
	        while (ptr.getLink() != null)
	        {
	            System.out.print(ptr.getData()+ "->");
	            ptr = ptr.getLink();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	    
    
	public void bubbleSort() {
		boolean sorted= false;
		while(sorted==false) {
			sorted=true;
			Node temp=start;
			while(temp.getLink() !=null) {
				Node node1= temp;
				Node node2= temp.getLink();
				
				while(node1.compareTo(node2) <0) {
					sorted=false;
					break;
				}
				
				temp=temp.getLink();
				
			}
			for (int i = 0; i < size; i++) {
				for (int j = i; j < size; j++) {
					if (elementAt(j + 1) != null) {
						if (elementAt(j).compareTo(elementAt(j + 1)) < 0) {
							swap(j, j + 1);
						}
					}
				}
			}
			
		}

	}

	    public Node elementAt(int index)
	    {
	       Node temp = start;

	       for (int i = 0; i < index; i++)
	       {
	          temp = temp.getLink();
	       }

	       return temp;
	    }

	    public void swap(int firstIndex, int secondIndex)
	    {
	       Node secondNext = elementAt(secondIndex).getLink();       
	       Node second = elementAt(secondIndex);
	       Node first = elementAt(firstIndex);
	       Node firstPrevious = elementAt(firstIndex - 1);


	       firstPrevious.setLink(second);
	       if (firstIndex==0) {
	    	   start= second;
	       }
	       first.setLink(secondNext);
	       second.setLink(first);
	    }
	    
	    
}
