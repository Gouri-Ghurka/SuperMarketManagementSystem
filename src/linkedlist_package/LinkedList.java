package linkedlist_package;

public class LinkedList 
{
   private Node head;
	
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	
	public void insertLast(Object obj)
	{
		Node newnode=new Node();
		newnode.setData(obj);
		if (head==null)
		{
			head=newnode;
		}
		else
		{
			Node temp=head;
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			temp.setNext(newnode);
		}
	}
	
	public void deleteNode(Node node)
	{
		if(head==null)
		{
			return;
		}
		if(node.equals(head))
		{
			head=head.getNext();
			return;
		}
		Node temp=head;
		while(temp!=null)
		{
			if(node.equals(temp.getNext()))
			{
				temp.setNext(temp.getNext().getNext());
				return;
			}
			temp=temp.getNext();
		}
	}
}
