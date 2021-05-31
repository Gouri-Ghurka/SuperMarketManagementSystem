
package product_package;
import linkedlist_package.*;


import java.util.Scanner;

import java.sql.*;

public class ProductImplementation
{
	public LinkedList ll = new LinkedList();

	public void addProduct(Scanner sc)
	{
		Product p = new Product();
		this.acceptNameBrandQuantity(sc,p);
		this.checkIfAlreadyPesent(p,sc);
	}
	
	//accept these details to check if the product is existing or not
	public void acceptNameBrandQuantity(Scanner sc,Product p)
	{
		String temp = "";
		Boolean bool = true;
		System.out.println("Enter the Product name");
		temp = sc.nextLine();
		if(temp.isEmpty())
		{
			do 
			{
				temp = sc.nextLine();
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product name");
					bool = false;
				}
				else
				{
					p.setProductName(temp);
					bool = true;
				}
			}while(bool==false);
		}
		else
		{
			do 
			{
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product name");
					temp = sc.nextLine();
					bool = false;
				}
				else
				{
					p.setProductName(temp);
					bool = true;
				}
			}while(bool==false);
		}

		System.out.println("Enter the Product brand");
		temp = sc.nextLine();
		if(temp.isEmpty())
		{
			do 
			{
				temp = sc.nextLine();
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product brand");
					bool = false;
				}
				else
				{
					p.setProductBrand(temp);
					bool = true;
				}
			}while(bool==false);
		}
		else
		{
			do 
			{
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product brand");
					temp = sc.nextLine();
					bool = false;
				}
				else
				{
					p.setProductBrand(temp);
					bool = true;
				}
			}while(bool==false);
		}

		System.out.println("Enter the Product Quantity");
		do
		{
			bool = sc.hasNextInt();
			if(bool)
			{
				p.setProductQuantity(sc.nextInt());
			}
			else
			{
				temp =  sc.next();
				System.out.println("Please enter a valid Quantity");
			}

		}while(!bool);
	}

	//accept these details only if the product does not exist
	public void acceptCategoryCpMrp(Scanner sc,Product p)
	{
		Boolean bool = true;
		String temp = "";
		System.out.println("Enter the Product category");
		temp = sc.nextLine();
		if(temp.isEmpty())
		{
			do 
			{
				temp = sc.nextLine();
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product category");
					bool = false;
				}
				else
				{
					p.setProductCategory(temp);
					bool = true;
				}
			}while(bool==false);
		}
		else
		{
			do 
			{
				if(temp.isBlank())
				{
					System.out.println("Please enter a valid product category");
					temp = sc.nextLine();
					bool = false;
				}
				else
				{
					p.setProductBrand(temp);
					bool = true;
				}
			}while(bool==false);
		}

		System.out.println("Enter the Product Cost Price");
		do
		{
			bool = sc.hasNextDouble();
			if(bool)
			{
				p.setProductCostPrice(sc.nextDouble());
			}
			else
			{
				temp = sc.next();
				System.out.println("Please enter a valid cost price");
			}

		}while(!bool);

		System.out.println("Enter the Product MRP");
		do
		{
			bool = sc.hasNextInt();
			if(bool)
			{
				p.setProductMrp(sc.nextDouble());
			}
			else
			{
				temp =  sc.next();
				System.out.println("Please enter a valid MRP");
			}

		}while(!bool);

	}
	
	public void displayProductDetails(Product p)
	 {
		String s = String.format("\n|%-15d", p.getProductID());
		 System.out.print(s);
		 s = String.format("|%-15s", p.getProductName());
		 System.out.print(s);
		 s = String.format("|%-15s", p.getBrand());
		 System.out.print(s);
		 s = String.format("|%-20s", p.getCategory());
		 System.out.print(s);
		 s = String.format("|%-15f", p.getCostPrice());
		 System.out.print(s);
		 s = String.format("|%-15f", p.getMrp());
		 System.out.print(s);
		 s = String.format("|%-15d", p.getProductQuantity());
		 System.out.print(s+"|");
	 }

	public void checkIfAlreadyPesent(Product p, Scanner sc)
	{
		int flag = 0;//turns 1 if an identical product is found
		Node temp = ll.getHead();
		while(temp!=null)
		{
			Product ptemp = (Product)temp.getData();
			if(p.getBrand().equalsIgnoreCase(ptemp.getBrand()))
			{
				if(p.getProductName().equalsIgnoreCase(ptemp.getProductName()))
				{
					addQuantity(temp,p.getProductQuantity());
					flag = 1;
				}
			}
			if(flag==1)
			{
				temp = null;//loop termination
			}
			else
			{
				temp = temp.getNext();
			}
		}
		if(flag==0)//no match was found
		{
			int id = Product.getIDgenerator();
			id++;
			Product.setIDgenerator(id);
			p.setProductID(id);
			this.acceptCategoryCpMrp(sc, p);
			ll.insertLast(p);
		}
	}

	public void deleteProduct(Scanner sc)
	{
		int id = 0;
		Boolean bool = true;
		System.out.println("Enter the product ID for the product to be deleted");
		do
		{
			bool = sc.hasNextInt();
			if(bool)
			{
				id = sc.nextInt();
			}
			else
			{
				String s =  sc.next();
				System.out.println("Please enter a valid ID");
			}

		}while(!bool);

		Node result=searchProductBasedOnID(id);
		ll.deleteNode(result);
	}

	public void displayList()
	{
		if(ll.getHead()==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			System.out.printf("|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", "PRODUCT ID","PRODUCT NAME","PRODUCT BRAND","PRODUCT CATEGORY","COST PRICE","MRP","QUANTITY");
			System.out.printf("\n|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", " "," "," "," "," "," "," ");
			Node temp = ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				this.displayProductDetails((Product)temp.getData());
				temp = temp.getNext();
			}
		}
		
	}

	public void printProductDetailsBasedOnID(Scanner sc)
	{
		int id = 0;
		System.out.println("Enter the product ID that has to be searched");
		id = sc.nextInt();
		Node result=searchProductBasedOnID(id);
		if(result==null)
		{
			System.out.println("The product could not be found");
		}
		else
		{
			//Headings are displayed only once since ID is unique.
			System.out.printf("\n|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", "PRODUCT ID","PRODUCT NAME","PRODUCT BRAND","PRODUCT CATEGORY","COST PRICE","MRP","QUANTITY");
			System.out.printf("\n|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", " "," "," "," "," "," "," ");
			this.displayProductDetails((Product) result.getData());
		}
	}

	private Node searchProductBasedOnID(int id)
	{
		Node result = null;

		if(ll.getHead()==null)
		{
			System.out.println("Empty list. Cannot search");
		}
		else
		{

			Node temp = ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				if((((Product)temp.getData()).getProductID())==id)
				{
					result =  temp;
				}
				temp = temp.getNext();
			}
		}
		return result;

	}

	public void searchProductBasedOnBrand(Scanner sc)
	{
		boolean result = false;
		int flag = 0;//becomes 1 if headings are printed once
		String brand = null;
		if(ll.getHead()==null)
		{
			System.out.println("Empty list. Cannot search");
		}
		else
		{
			System.out.println("Enter the product brand that has to be searched");
			brand = sc.next();
			Node temp = ll.getHead();
			
			while(temp!=null)  //traverse till the end
			{
				if((((Product)temp.getData()).getBrand()).equalsIgnoreCase(brand))
				{
					if(flag==0)
					{
						System.out.printf("\n|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", "PRODUCT ID","PRODUCT NAME","PRODUCT BRAND","PRODUCT CATEGORY","COST PRICE","MRP","QUANTITY");
						System.out.printf("\n|%-15s|%-15s|%-15s|%-20s|%-15s|%-15s|%-15s|", " "," "," "," "," "," "," ");
						flag = 1;
					}
					this.displayProductDetails((Product)temp.getData());
					result = true;//product found
					
				}
				temp = temp.getNext();
			}
		}
		if(result==false)
		{
			System.out.println("\nThe product could not be found");
		}

	}

	public void addToDataBase()
	{


		Connection con = null;
		Statement st = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
			st=con.createStatement();
			st.executeUpdate("delete from products");
			if(ll.getHead()==null)
			{
				System.out.println("The list is empty. Cannot add to database.");
			}
			else
			{
				//adding entire linked list

				Node temp = ll.getHead();//used for traversing the linked list
				while(temp!=null)
				{
					Product p = (Product) temp.getData();

					st.executeUpdate("insert into products(productID,productName,productBrand,productCategory,productCostPrice,productMrp,productQuantity) values ("+p.getProductID()+",'"+p.getProductName()+"','"+p.getBrand()+"','"+p.getCategory()+"',"+p.getCostPrice()+","+p.getMrp()+","+p.getProductQuantity()+")");
					temp = temp.getNext();
				}

				st.close();
				con.close();
			}
		}
		catch(Exception e)
		{
			//System.out.println("Hello");
			System.out.println(e);
		}
	}

	public void retrieveFromDataBase()
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from products");
			while(rs.next())//this loop executes till the table contents are exhausted. Doesn't stop at the end of a row
			{
				Product p = new Product();
				p.setProductID(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setProductBrand(rs.getString(3));
				p.setProductCategory(rs.getString(4));
				p.setProductCostPrice(rs.getDouble(5));
				p.setProductMrp(rs.getDouble(6));
				p.setProductQuantity(rs.getInt(7));
				ll.insertLast(p);
				Product.setIDgenerator(p.getProductID());
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			//System.out.println("Hello");
			System.out.println(e);
		}
	}

	public void addQuantity(Node node,int newQuantity)
	{
		int updatedQuantity = 0;
		updatedQuantity = ((Product) node.getData()).getProductQuantity()+newQuantity;
		((Product) node.getData()).setProductQuantity(updatedQuantity);
	}

	public void subQuantity(int id,int quantitySold)//gouri will send productID and sold quantity
	{
		int updatedQuantity = 0;
		Node result=searchProductBasedOnID(id);
		if(result==null)
		{
			System.out.println("The product could not be found");
		}
		else
		{
			updatedQuantity = ((Product) result.getData()).getProductQuantity()-quantitySold;
			((Product)result.getData()).setProductQuantity(updatedQuantity);
		}
	}

	
	public Node mergeSort()
	{
		LinkedList sorted = new LinkedList();
		//since we do not want to change the original linked list, copying into the sorted list
		Node temp = ll.getHead();
		while(temp!=null)
		{
			sorted.insertLast((Object)temp.getData());
			temp = temp.getNext();
		}
		
		if(sorted.getHead()==null)
		{
			System.out.println("Empty list. Cannot sort");
		}
		else
		{
			if(sorted.getHead().getNext()==null)
			{
				System.out.println("There is only 1 element in the list. No need to sort");
			}
			else
			{
				sorted.setHead(split(sorted.getHead()));
			}
		}
		return sorted.getHead();
	}
	
	private Node split(Node head)
	{
		Node mid = null;
		Node nextOfMid = null;
		Node result = null;
		Node head1 = null;
		Node head2 = null;
		
		if(head==null || head.getNext()==null)//there is no list left or there is a single element left.
		{
			result = head;
		}
		else 
		{
			mid = calculateMid(head);
			nextOfMid = mid.getNext();
			mid.setNext(null);//indicates end of divided list(1st half)
		
			//head holds 1st node of 1st half
			//nextOfMid holds 1st node of 2nd half
			
			head1 = split(head);
			head2 = split(nextOfMid);
			result = merge(head1,head2);
		}
		return result;
	}
	
	private Node merge(Node head1,Node head2)
	{
		Node head = null;//will store the head of two merged lists
		int q1 = 0;//stores quantity of head1
		int q2 = 0;//stores quantity of head2
		if(head1==null)
		{
			head = head2;//if head1 is empty, no need to sort head2
		}
		else
		{
			if(head2==null)
			{
				head = head1;//if head2 is empty, no need to sort head1
			}
			else
			{
				//sorting in ascending order based on quantity available of the product
				q1 = ((Product) head1.getData()).getProductQuantity();
				q2 = ((Product) head2.getData()).getProductQuantity();
				if(q1>q2)
				{
					head = head2;
					head.setNext(merge(head1,head2.getNext()));
				}
				else
				{
					head = head1;
					head.setNext(merge(head1.getNext(),head2));
				}
			}
		}
		return head;
	}
	
	private Node calculateMid(Node head)
	{
		//slow moves at half the speed of fast.
		//till fast reaches the end of the list, slow points to the mid node
		
		Node slow = null;
		Node fast = null;
		if (head!=null) 
		{
			slow = head;
			fast = head;

			while ((fast.getNext() != null) && (fast.getNext().getNext() != null)) 
			{
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
		}
		return slow;
	}
	
	//just written if in case no of products in the market has to be known
	public int calculateLengthOfLinkedList(LinkedList templl)
	{
		int len = 0;
		Node temp = templl.getHead();
		while(temp!=null)
		{
			len++;
			temp = temp.getNext();
		}
		return len;
	}
	
	public void displayProductsAboutToFinish()
	{
		if(ll.getHead()==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			Node temp = ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				if(((Product)temp.getData()).getProductQuantity()<=15)
				{
					this.displayProductDetails((Product)temp.getData());
				}
				temp = temp.getNext();
			}
		}
	}
	
	public void updateCost(int id,double mrp,double cost)
	{
		Node nodeToBeUpdated = null;
		nodeToBeUpdated = this.searchProductBasedOnID(id);
		if(nodeToBeUpdated==null)
		{
			System.out.println("Product not found");
		}
		else
		{
			((Product)nodeToBeUpdated.getData()).setProductMrp(mrp);
			((Product)nodeToBeUpdated.getData()).setProductCostPrice(cost);
		}
		
	}
	
}