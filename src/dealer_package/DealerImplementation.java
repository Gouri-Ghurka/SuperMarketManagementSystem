package dealer_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

import linkedlist_package.LinkedList;
import linkedlist_package.Node;

public class DealerImplementation 
{

	LinkedList ll=new LinkedList();
	Scanner sc=new Scanner(System.in);
	public void retrieve()//to retrieve the existing data from database
	{

		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket","root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from Dealer");
			while(rs.next())
			{
				Dealer dretrieve=new Dealer();
				dretrieve.setD_id(rs.getInt(1));
				dretrieve.setD_name(rs.getString(2));
				dretrieve.setD_category(rs.getString(3));
				dretrieve.setD_prod_name(rs.getString(4));
				dretrieve.setD_company(rs.getString(5));
				dretrieve.setD_contact_no(rs.getString(6));
				dretrieve.setD_email(rs.getString(7));
				dretrieve.setD_address(rs.getString(8));
				dretrieve.setD_qty_available(rs.getInt(9));
				dretrieve.setPrice_per_piece(rs.getDouble(10));
				dretrieve.setD_discount(rs.getDouble(11));
				ll.insertLast(dretrieve);
				Dealer.setIdGenerator(dretrieve.getD_id());//to set id generator to last id value

			}

			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	private Dealer acceptDealerDetails()
	{
		Dealer d=new Dealer();
		boolean check=false;
		String temp;
		System.out.println("Enter Dealer Name");
		do
		{
			check=false;
		
				String name=sc.nextLine();
				if(name.isBlank())
				{
					//temp=sc.nextLine();
					System.out.println("Please Enter Appropriate Name!!!");
					check=false;
					
				}
				else
				{
					d.setD_name(name);
					check=true;
				}
		}while(check==false);
		
		System.out.println("Enter Dealer Category");
		do
		{
			check=false;
			String cat=sc.nextLine();
			if(cat.isBlank())
			{
				System.out.println("Please Enter Appropriate Category!!!");

			}
			else
			{
				d.setD_category(cat);
				check=true;
			}

		}while(check==false);

		System.out.println("Enter Product Name sold");
		do
		{
			check=false;
			String p_name=sc.nextLine();
			if(p_name.isBlank())
			{
				System.out.println("Please Enter Appropriate Product Name!!!");
			}
			else
			{
				d.setD_prod_name(p_name);
				check=true;
			}

		}while(check==false);
		System.out.println("Enter Dealer Company Name");
		do
		{
			check=false;
			String brand=sc.nextLine();
			if(brand.isBlank())
			{
				System.out.println("Please Enter Appropriate Company Name!!!");
			}
			else
			{
				d.setD_company(brand);
				check=true;
			}

		}while(check==false);
		System.out.println("Enter Dealer e-mail address");
		do
		{
			check=false;
			String email=sc.nextLine();
			if(email.isBlank())
			{
				System.out.println("Please Enter Appropriate Email-Address!!!");
			}
			else
			{
				d.setD_email(email);
				check=true;
			
			}

		}while(check==false);

		System.out.println("Enter Dealer Address");
		do
		{
			check=false;
			String address=sc.nextLine();
			if(address.isBlank())
			{
				System.out.println("Please Enter Appropriate Address!!!");
				
			}
			else
			{
				check=true;
			}

		}while(check==false);



		System.out.println("Enter Dealer Contact Number");
		do
		{
			check=false;
			String contactNo=sc.nextLine();
			if(contactNo.isBlank())
			{
				check=false;
			}
			else//when alphabets are entered
			{
				check=Pattern.matches("[6789]{1}[0-9]{9}",contactNo);
				if(check)
				{
					check=true;
					d.setD_contact_no(contactNo);//contact number starts with 6,7,8,9 and have 10 digits
				}
				else
				{
					check=false;
				}
			}
				if(check==false)
				{
					System.out.println("Please Enter Appropriate Contact Number!!!");
				}

		}while(check==false);



		System.out.println("Enter Quantity of Product available with the dealer");

		do
		{
			check=sc.hasNextInt();

			if(check)
			{
				d.setD_qty_available(sc.nextInt());
				if(d.getD_qty_available()>=0)
				{
					check=true;//when quantity entered by user is integer and positive
				}

			}
			else if(sc.hasNextDouble())//to check quantity entered is of type double or not
			{
				@SuppressWarnings("unused")
				double temp1;
				temp1=(sc.nextDouble());
			}
			else//to check quantity entered is of type String
			{
				temp=sc.next();
				if(temp.isBlank())
				{
					System.out.println("Please Enter Appropriate Quantity!!!");
				}
				check=false;

			}
			if(check==false)
			{
				System.out.println("Please Enter Appropriate Quantity!!!");
			}
		}while(check==false);
		System.out.println("Enter Price per piece");
		do
		{
			check=false;//check turns true when appropriate value of price is entered

			check=sc.hasNextDouble();
			if(check)
			{
				d.setPrice_per_piece(sc.nextDouble());
				if(d.getPrice_per_piece()>0)
				{
					check=true;//when entered value is decimal and positive
				}
			}
			else//entered value is string
			{
				temp=sc.next();
			}
			if(check==false)
			{
				System.out.println("Please Enter Appropriate Price!!!");
			}

		}while(check==false);


		System.out.println("Enter Discount provided");
		do
		{
			check=false;//check turns true when appropriate discount value is entered


			check=sc.hasNextDouble();
			if(check)
			{
				d.setD_discount(sc.nextDouble());
				if(d.getD_discount()>=0&&d.getD_discount()<100)
				{
					check=true;//when entered value is decimal and positive
				}
			}
			else//when entered value is string
			{
				temp=sc.next();
			}
			if(check==false)
			{
				System.out.println("Please Enter Appropriate Values for Discount!!!");

			}
		}while(check==false);

		return d;
	}
	public void addNewDealer()
	{
		Node temp=ll.getHead();

		int flag=0;//turns 1 when dealer with same contact number,product and brand already exists
		System.out.println("Enter Details of Dealer\n");
		Dealer d=this.acceptDealerDetails();
		while(temp!=null)
		{
			if((d.getD_contact_no()).equals(((Dealer)(temp.getData())).getD_contact_no()))
			{
				if((d.getD_prod_name()).equalsIgnoreCase(((Dealer)(temp.getData())).getD_prod_name()))
				{
					if((d.getD_company()).equalsIgnoreCase(((Dealer)(temp.getData())).getD_company()))
					{
						flag=1;
						break;
					}
				}
			}
			temp=temp.getNext();
		}
		if(flag==1)
		{
			System.out.println("Such Dealer Already Exists");
		}
		else
		{
			int id=Dealer.getIdGenerator();
			id++;
			Dealer.setIdGenerator(id);
			d.setD_id(id);
			ll.insertLast(d);
			System.out.println("Data of New Dealer inserted to the list successfully");
		}
	}
	private Node partition(Node front,Node back)
	{
		Node pivot=back;
		Node present=front;
		Dealer temp=null;
		while(front!=pivot)
		{
			if(((Dealer)front.getData()).getD_finalPrice()<((Dealer)pivot.getData()).getD_finalPrice())
			{
				temp=(Dealer)front.getData();
				front.setData(present.getData());
				present.setData(temp);
				present=present.getNext();
			}
			front=front.getNext();				
		}
		temp=(Dealer)pivot.getData();
		pivot.setData(present.getData());
		present.setData(temp);
		return present;
	}
	private void quickSort(Node front,Node back)
	{
		if(front!=back&&front!=back.getNext())
		{
			Node pivot=partition(front,back);
			Node temp=front;
			if(pivot!=front)
			{
				while(temp.getNext()!=pivot)
				{
					temp=temp.getNext();
				}
			}
			quickSort(front,temp);
			quickSort(pivot.getNext(),back);

		}
	}
	public Dealer sort(LinkedList ll)//sort the dealers on the basis of final price
	{
		Node temp=ll.getHead();
		while(temp.getNext()!=null)
		{
			temp=temp.getNext();
		}
		quickSort(ll.getHead(),temp);
		return ((Dealer)ll.getHead().getData());

	}
	public Dealer compareDealers(int quantityReq,String company,String p_name)
	{
		Node temp=ll.getHead();
		LinkedList temp_ll=new LinkedList();//list of dealers having enough quantity of the product of particular brand
		Dealer d_min=new Dealer();
		while(temp!=null)
		{

			if(p_name.equalsIgnoreCase(((Dealer)temp.getData()).getD_prod_name())&&company.equalsIgnoreCase(((Dealer)temp.getData()).getD_company())&&(quantityReq<=((Dealer)temp.getData()).getD_qty_available()))
			{
				double total_price=0.0;
				double finalPrice=0.0;
				total_price=quantityReq*(((Dealer)temp.getData()).getPrice_per_piece());
				finalPrice=total_price-(total_price)*(((Dealer)temp.getData()).getD_discount()/100);
				((Dealer)temp.getData()).setD_finalPrice(finalPrice);
				temp_ll.insertLast(temp.getData());
			}
			temp=temp.getNext();
		}
		if(temp_ll.getHead()==null)
		{
			d_min=null;//no dealer exist with enough quantity
		}
		else if(temp_ll.getHead().getNext()==null)
		{
			d_min=((Dealer)temp_ll.getHead().getData()); //only single dealer available with enough quantity
		}
		else
		{
			d_min=sort(temp_ll);
		}
		return d_min;
	}
	public void displayBest(Dealer best)
	{
		System.out.println("ORDER IS PLACED WITH:");
		System.out.println("NAME:               "+best.getD_name());
		System.out.println("ID:                 "+best.getD_id());
		System.out.println("TOTAL PRICE:        "+(best.getD_finalPrice()/(1-(best.getD_discount()/100))));
		System.out.println("DISCOUNT            "+(best.getD_finalPrice()/(1-(best.getD_discount()/100)))*(best.getD_discount()/100));
		System.out.println("FINAL PRICE:        "+best.getD_finalPrice());
	}
	public Node searchWithId(int id)
	{
		Node result=null;
		if(ll.getHead()==null)
		{
			System.out.println("Empty List,Cannot Search");
		}
		else
		{
			Node temp=ll.getHead();

			while(temp!=null)
			{
				if(((Dealer)temp.getData()).getD_id()==id)
				{
					result=temp;
					break;
				}
				temp=temp.getNext();
			}
		}
		return result;
	}
	public void displayWithId()
	{
		boolean check=false;//check turns true when appropriate id is entered
		int id=0;//accept id entered by user
		System.out.println("Enter ID of the Dealer whose details you want to Display");

		do
		{
			check=sc.hasNextInt();

			if(check)
			{
				id=sc.nextInt();
				if(id>0)
				{
					check=true;//when id entered by user is integer and positive
				}

			}
			else if(sc.hasNextDouble())//when id entered by user is of type double
			{
				@SuppressWarnings("unused")
				double temp1;
				temp1=(sc.nextDouble());
			}
			else//when id entered by user is of type double
			{
				@SuppressWarnings("unused")
				String temp=sc.next();

			}
			if(check==false) 
			{
				System.out.println("Please Enter Appropriate ID!!!");
			}
		}while(check==false);
		Node temp=searchWithId(id);
		if(temp!=null)
		{
			System.out.println("Name of Dealer is:                "+((Dealer)temp.getData()).getD_name());
			System.out.println("Product Category is:              "+((Dealer)temp.getData()).getD_category());
			System.out.println("Product Name is:                  "+((Dealer)temp.getData()).getD_prod_name());
			System.out.println("Product Company:                  "+((Dealer)temp.getData()).getD_company());
			System.out.println("Dealer's Contact No is:           "+((Dealer)temp.getData()).getD_contact_no());
			System.out.println("Dealer's Email Address is:        "+((Dealer)temp.getData()).getD_email());
			System.out.println("Dealer's Address is:              "+((Dealer)temp.getData()).getD_address());
		}
		else
		{
			System.out.println("Data of Dealer with Id "+id+" doesn't exist!!!");
		}
	}


	public void displayList()
	{

		if(ll.getHead()==null)//list is empty
		{
			System.out.println("No Dealer Exists in the List");
		}
		else
		{
			Node temp=ll.getHead();
			while(temp!=null)
			{
				System.out.println("Id of Dealer is:              "+((Dealer)temp.getData()).getD_id());
				System.out.println("Name of Dealer is:            "+((Dealer)temp.getData()).getD_name());
				System.out.println("Product Category is:          "+((Dealer)temp.getData()).getD_category());
				System.out.println("Product Name is :             "+((Dealer)temp.getData()).getD_prod_name());
				System.out.println("Product Company:              "+((Dealer)temp.getData()).getD_company());
				System.out.println("Dealer's Contact No is        "+((Dealer)temp.getData()).getD_contact_no());
				System.out.println("Dealer's Email Address is:    "+((Dealer)temp.getData()).getD_email());
				System.out.println("Dealer's Address is :         "+((Dealer)temp.getData()).getD_address());
				System.out.println("--------------------------------------------------------------------------");

				temp=temp.getNext();
			}
		}
	}



	public void deleteWithId()
	{
		boolean check=false;//check turns true when appropriate id is entered
		int id=0;       //accept id no. entered by user
		System.out.println("Enter ID of the Dealer whose details you want to Delete");

		do
		{
			check=sc.hasNextInt();

			if(check)
			{
				id=sc.nextInt();
				if(id>0)
				{
					check=true;////when id entered by user is integer and positive
				}

			}
			else if(sc.hasNextDouble())//when id entered by user is of type double
			{
				@SuppressWarnings("unused")
				double temp1;
				temp1=(sc.nextDouble());
			}
			else//when id entered by user is of type string
			{
				@SuppressWarnings("unused")
				String temp=sc.next();

			}
			if(check==false) 
			{
				System.out.println("Please Enter Appropriate ID!!!");
			}
		}while(check==false);
		Node temp=searchWithId(id);//return null when data associated with entered id is not found
		if(temp!=null)
		{
			ll.deleteNode(temp);
			System.out.println("Data deleted Successfully");
		}
		else
		{
			System.out.println("Data of Dealer with Id "+id+" is Not Found!!!");
		}

	}
	public void addToDatabase()//to load the data present in the linked list back to database
	{
		Connection con=null;
		Statement st=null;

		if(ll.getHead()!=null)
		{

			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket","root","root");
				st=con.createStatement();
				st.executeUpdate("delete from Dealer");
				Node temp=ll.getHead();
				while(temp!=null)
				{
					Dealer d=(Dealer)(temp.getData());
					st.executeUpdate("insert into Dealer values("+d.getD_id()+",'"+d.getD_name()+"','"+d.getD_category()+"','"+d.getD_prod_name()+"','"+
							d.getD_company()+"','"+d.getD_contact_no()+"','"+d.getD_email()+"','"+d.getD_address()+"',"+
							d.getD_qty_available()+","+d.getPrice_per_piece()+","+d.getD_discount()+")");
					temp=temp.getNext();
				}
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


		}
	}
}


