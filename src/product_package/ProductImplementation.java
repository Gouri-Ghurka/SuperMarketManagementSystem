package product_package;
import linkedlist_package.*;

import java.util.Scanner;

import java.sql.*;

//equals method is case sensitive
//remaining: sort products based on quantity to place an order to the dealer. use insertion sort
//no need to sort. whenever we are subtracting the quantity, check if it has gone below a specific value.
//If yes, then place an order to the dealer


public class ProductImplementation
{
	public LinkedList ll = new LinkedList();
	private Product p = new Product();

	public void addProduct(Scanner sc)
	{
		this.acceptProductDetails(sc);
		this.checkIfAlreadyPesent(p);
	}
	
	//accept the details if the product is new in the warehouse
	public void acceptProductDetails(Scanner sc)
	 {		
		 	Boolean bool = true;
			System.out.println("Enter the Product name");
			do
			{
				bool = sc.hasNext();
				if(bool)
				{
					p.setProductName(sc.next());
				}
				else
				{
					System.out.println("Please enter a valid name");
				}
				
			}while(!bool);
			
			System.out.println("Enter the Product brand");
			do
			{
				bool = sc.hasNext();
				if(bool)
				{
					p.setProductBrand(sc.next());
				}
				else
				{
					System.out.println("Please enter a valid brand");
				}
				
			}while(!bool);
			
			System.out.println("Enter the Product category");
			do
			{
				bool = sc.hasNext();
				if(bool)
				{
					p.setProductCategory(sc.next());
				}
				else
				{
					System.out.println("Please enter a valid category");
				}
				
			}while(!bool);
			
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
					String s = sc.next();
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
					String s =  sc.next();
					System.out.println("Please enter a valid MRP");
				}
				
			}while(!bool);
			
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
					String s =  sc.next();
					System.out.println("Please enter a valid Quantity");
				}
				
			}while(!bool);
		
	 }
	
	public void displayProductDetails(Product p)
	 {
		 System.out.println("Product ID = "+p.getProductID());
		 System.out.println("Product Name = "+p.getProductName());
		 System.out.println("Product Brand = "+p.getBrand());
		 System.out.println("Product Category = "+p.getCategory());
		 System.out.println("Product Cost Price = "+p.getCostPrice());
		 System.out.println("Product MRP = "+p.getMrp());
		 System.out.println("Product Quantity available = "+p.getProductQuantity());
	 }

	public void checkIfAlreadyPesent(Product p)
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
		System.out.println(result);
		ll.deleteNode(result);
		System.out.println("deleteNode");
	}

	public void displayList()
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
			System.out.println("Product found. Details are: ");
			this.displayProductDetails((Product) result.getData());
		}
	}

	public Node searchProductBasedOnID(int id)
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
					System.out.println("Product found. Details are: ");
					this.displayProductDetails((Product)temp.getData());
					result = true;//product found
				}
				temp = temp.getNext();
			}
		}
		if(result==false)
		{
			System.out.println("The product could not be found");
		}

	}

	public void addToDataBase()//incomplete
	{


		Connection con = null;
		Statement st = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarketManagementSystem","root","root");
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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarketManagementSystem","root","root");
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
	
}