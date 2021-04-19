package billing_package;
import product_package.ProductImplementation;
import linkedlist_package.LinkedList;
import linkedlist_package.Node;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Billing 
{
	private int prod_id;
	private int total_items;
	private double tot_price;
	private double total;
	private double tax=0.0;
	private double discount=0.0;
	private double grand_total;
	private static double gst=0.12;
	private int curr_points=0;
	private int tot_points=0;
	private long bill_no=0;
	private static long billNoGenerator=000001;
	private String phoneno;
	private String customername;

	Scanner sc=new Scanner(System.in);
	LinkedList cll=new LinkedList();
	LinkedList pll=new LinkedList();
	//ProductImplementation product=new ProductImplementation();

	public Billing()
	{
		this.bill_no=Billing.billNoGenerator++;
	}

	public void retrive()
	{
		Connection con;
		Statement st;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagementsystem", 
					"root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from customer");
			while(rs.next())
			{
				Customer cobj=new Customer();
				cobj.setC_name(rs.getString(1));
				cobj.setC_phone_no(rs.getString(2));
				cobj.setTot_points(rs.getInt(3));
				cll.insertLast(cobj);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String acceptCustomerPhoneNO()
	{
		Boolean bool=true;
		String phone="";
		String temp="";
		System.out.println("Enter Customer's Phone number"); 
		do 
		{
			bool=sc.hasNext("[6789]{1}[0-9]{9}"); 
			if(bool) 
			{ 
				phone=sc.next(); 
			} 
			else 
			{
				temp=sc.next();
				System.out.println("Please enter valid phone number"); 
			}
		}while(!bool);
		
		return phone;
	}

	public void billGeneration(ProductImplementation product) 
	{
		phoneno=this.acceptCustomerPhoneNO();
		Node currentNode=cll.getHead();
		int flag=0;
		while(currentNode!=null && flag==0)
		{
			Customer c=(Customer) currentNode.getData();
			if(phoneno.equals(c.getC_phone_no()))
			{
				customername=c.getC_name();
				tot_points=c.getTot_points();
				flag=1;
			}
			currentNode=currentNode.getNext();
		}
		
		if(flag==1)
		{
			boolean verify=false;
			String yorn="";
			System.out.println("**VERIFY CUSTOMER NAME.ENTER Y OR y FOR YES , N OR n FOR NO.**");
			System.out.println("Customer Name:"+customername);
			do
			{
				verify=sc.hasNext();
				if(verify)
				{
					yorn=sc.next();
				}
				else
				{
					System.out.println("Please enter a valid input");
				}
				if(!(yorn.equalsIgnoreCase("y")||yorn.equalsIgnoreCase("n")))
				{
					verify=false;
					System.out.println("Please enter y-yes or n-no");
				}
			}while(!verify);
			
			if(yorn.equalsIgnoreCase("n"))
			{
				this.acceptCustomerPhoneNO();
			}
		}
		
		if(flag==0)
		{
			addCustomer(phoneno);
		}
		
		billCalculation(product);
		printBill();
	}

	public void billCalculation(ProductImplementation product)
	{
		String yorn="";
		Boolean bool=true;
		int avaiQty=0;
		do
		{
			String temp="";
			BillContents obj=new BillContents();
			System.out.println("Enter Product id:");
			do
			{
				bool=sc.hasNextInt();
				if(bool)
				{
					prod_id=sc.nextInt();
					if(prod_id<=0)
					{
						System.out.println("Please enter valid product ID");
						bool=false;
					}
				}
				else
				{
					temp=sc.next();
					System.out.println("Please enter valid product ID");
				}
			}while(!bool);
			
			try 
			{
				Connection con;
				Statement st;
				ResultSet rs;
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagementsystem", 
						"root","root");
				st=con.createStatement();
				rs=st.executeQuery("select productBrand,productMrp,productQuantity from products where productID="+prod_id);
				while(rs.next())
				{
					obj.setProd_brand(rs.getString(1));
					obj.setMrp(rs.getDouble(2));
					avaiQty=rs.getInt(3);
				}
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Enter quantity of product:");
			do
			{
				bool=sc.hasNextInt();
				if(bool)
				{
					obj.setQty_purchased(sc.nextInt());
					if(obj.getQty_purchased()<=0||obj.getQty_purchased()>avaiQty)
					{
						System.out.println("Please enter qyantity between 1 and "+avaiQty);
						bool=false;
					}
				}
				else
				{
					temp=sc.next();
					System.out.println("Please enter valid product quantity");
				}
			}while(!bool);
			
			obj.setTot_item_price((float) (obj.getQty_purchased()*obj.getMrp()));
			pll.insertLast(obj);
			total_items=total_items+obj.getQty_purchased();
			
			product.subQuantity(prod_id, obj.getQty_purchased());
			
			tot_price=tot_price+obj.getTot_item_price();
			System.out.println("Enter y if there is another product.Enter n if there are no more products");
			do
			{
				bool=sc.hasNext();
				if(bool)
				{
					yorn=sc.next();
				}
				else
				{
					System.out.println("Please enter a valid input");
				}
				if(!(yorn.equalsIgnoreCase("y")||yorn.equalsIgnoreCase("n")))
				{
					bool=false;
					System.out.println("Please enter y-yes or n-no");
				}
			}while(!bool);
		}while(yorn.equalsIgnoreCase("y"));

		if(tot_price >= 0.0 && tot_price < 100 )
		{
			curr_points=0;
		}
		else
		{
			curr_points=(int) (tot_price/100);//1 point for every 100 Rs.
		}

		tot_points = tot_points+curr_points;

		if(tot_points>=100)
		{
			discount=tot_price * 0.15;// 15% discount for every 100 points
			total = tot_price - discount;
			tot_points=tot_points-100;
		}
		else
		{
			total=tot_price;
		}
		updatePoints();
		
		tax=total*gst;
		grand_total=total+tax;
	}

	public void updatePoints()
	{
		int flag=0;
		Node currentNode=cll.getHead();
		while(currentNode!=null && flag==0)
		{
			Customer c=(Customer) currentNode.getData();
			if(phoneno.equals(c.getC_phone_no()))
			{
				c.setTot_points(tot_points);
				flag=1;
			}
			currentNode=currentNode.getNext();
		}
	}

	public void printBill()
	{
		System.out.println("\tALL IN ONE Supermarket");
		System.out.println("Bill NO.:"+bill_no);

		LocalDate d=LocalDate.now(); 
		System.out.print(d+"\t"); 
		LocalTime t=LocalTime.now(); 
		System.out.println(t);
		System.out.println();
		
		System.out.format("%15s %5s %6s %8s\n","PRODUCT","QTY","MRP","TOTAL");
		System.out.println("-----------------------------------------------");
		//System.out.println("PRODUCT\t\tQTY\tMRP\tTOTAL");
		Node currentNode=pll.getHead();		
		
		while(currentNode!=null)
		{
			
			BillContents b=(BillContents) currentNode.getData();
			//ll.display(b)
			System.out.format("%15s %5d %6.2f %8.2f\n",b.getProd_brand(),b.getQty_purchased(),b.getMrp(),b.getTot_item_price());
			currentNode=currentNode.getNext();
		}
		System.out.println("-----------------------------------------------");
		System.out.format("%15s %5d %6s %8.2f\n","TOTAL",total_items," ",tot_price);
		System.out.format("%15s %5s %6s %8.2f\n","DISCOUNT"," "," ",discount);
		System.out.println("-----------------------------------------------");
		System.out.format("%15s %5s %6s %8.2f\n","TOTAL"," "," ",total);
		System.out.format("%15s %5s %6s %8.2f\n","TAX"," "," ",tax);
		System.out.println("-----------------------------------------------");
		System.out.format("%15s %5s %6s %8.2f\n","GRAND TOTAL"," "," ",grand_total);
		System.out.println("-----------------------------------------------");
		System.out.format("%30s","*THANK YOU.VISIT AGAIN*");
	}

	public void loadIntoDatabase()
	{
		Connection con;
		Statement st; 
		try 
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagementsystem", "root","root");
			st=con.createStatement();
			st.executeUpdate("delete from customer");
			Node currentNode=cll.getHead();
			while(currentNode!=null)
			{
				Customer c=(Customer) currentNode.getData();
				st.executeUpdate("insert into customer values ('"+c.getC_name()+"',"+c.getC_phone_no()+","+c.getTot_points()+")");
				currentNode=currentNode.getNext();
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addCustomer(String phno) 
	{  
		boolean bool=true;
		System.out.println("**New Customer.Accept details.**");
		System.out.println("Enter Customer Name:");
		sc.nextLine();	
		  do 
		  { 
			  	
			  customername=sc.nextLine();
			  if(customername.isBlank()) 
			  { 
				  System.out.println("please enter valid customer name");  
				  bool=false;
			  } 
			  else
			  {
				  bool=true;
			  }
		  }while(!bool);
		 
		
		Customer cobj=new Customer();
		cobj.setC_name(customername);
		cobj.setC_phone_no(phno);
		cobj.setTot_points(0);//new customer points are always zero
		cll.insertLast(cobj);	  
	}
}
