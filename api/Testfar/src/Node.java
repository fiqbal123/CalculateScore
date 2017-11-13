
public class Node<T> implements Comparable<Node>{
	
    protected T data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = null;
    }    
    /*  Constructor  */
    public Node(T d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(T d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public T getData()
    {
        return data;
    }
    
    
//	public int compareTo(Node currentNode) {
//		
//		Object currentNodeValue= currentNode.getData();
//		T nextNodeValue= this.getData();
//		
//		if(currentNodeValue < nextNodeValue) {
//			return -1;
//		}
//		else 
//		{
//			return 1;
//		}
//	}
	
    public int compareTo(Node that) {

        int cmp = ((Comparable<T>) this.getData()).compareTo((T) that.getData());
        
        if(cmp >0) {
        	return -1;
        }
        else {
        	return 1;
        }

    }
	

}
