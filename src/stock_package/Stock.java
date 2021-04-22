package stock_package;
import java.util.Scanner;
import product_package.*;
import dealer_package.*;
import linkedlist_package.Node;
public class Stock 
{
	Scanner sc=new Scanner(System.in);
	public void checkQuantity(ProductImplementation piobj,DealerImplementation dobj)
	{
		String pdtBrand="";
		String pdtName="";
		String yorn="";
		int qtyReq=0;
		boolean bool=true;
		boolean result = false;
		
		if(piobj.ll.getHead()==null)
		{
			System.out.println("Empty list. Cannot search");
		}
		else
		{
			Node temp = piobj.ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				if((((Product)temp.getData()).getProductQuantity())<=15)
				{
					pdtBrand=((Product)temp.getData()).getBrand();
					pdtName=((Product)temp.getData()).getProductName();
					piobj.displayProductDetails((Product)temp.getData());
					
					System.out.println("WOULD LIKE TO ORDER THIS PRODUCT? ENTER Y FOR YES N FOR NO");
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
					
					if(yorn.equalsIgnoreCase("y"))
					{
						System.out.println("Enter the quantity required :");
						qtyReq=sc.nextInt();
						Dealer best_dealer=dobj.compareDealers(qtyReq,pdtBrand,pdtName);
						if(best_dealer==null)
						{
							System.out.println("NO DEALER AVAILABLE FOR THIS PRODUCT");
						}
						else
						{
							dobj.displayBest(best_dealer);
						}
					}
					result = true;//product found
				}
				temp = temp.getNext();
			}
		}
		if(result==false)
		{
			System.out.println("NO PRODUCT WITH QUANTITY LESS THAN 15.");
		}
	}
}