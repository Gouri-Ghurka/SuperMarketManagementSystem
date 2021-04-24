package user_package;
import java.util.Scanner;

import product_package.ProductImplementation;

public class User 
{
	

	public static void main(String[] args) 
	{
		ProductImplementation piobj = new ProductImplementation();
		EmployeeImplementation empobj = new EmployeeImplementation();
		Billing bobj = new Billing();
		Stock sobj = new Stock();
		DealerImplementation diobj = new DealerImplementation();
		
		int roleChoice = 0;
		int functionChoice = 0;
		int inventoryChoice=0;
		int billingch=0;
		int salesChoice=0;
		Boolean bool = false;
		int open = 0;//if 1 then it is open
		Scanner sc = new Scanner(System.in);

		//retrieving all the data from the data base into the linked lists
		piobj.retrieveFromDataBase();
		empobj.retrieveFromDataBase();
		bobj.retrieve();
		diobj.retrieve();

		do
		{
			System.out.println("SELECT AN OPTION: ");
			System.out.println("1. OPEN");
			System.out.println("0. CLOSE");
			System.out.println("ENTER CHOICE:");
			do
			{
				bool = sc.hasNextInt();
				if(bool)
				{
					open = sc.nextInt();
				}
				else
				{
					String s =  sc.next();
					System.out.println("Please enter a valid choice");
				}

			}while(!bool);

			switch(open)
			{
			case 1:
				System.out.println("WELCOME!");
				do
				{
					System.out.println("ROLES:");
					System.out.println("1. STORE MANAGER");
					System.out.println("2. INVENTORY CONTROL SPECIALIST");
					System.out.println("3. CASHIER");
					System.out.println("4. SALES ASSOCIATE");
					System.out.println("5. VIEW PROFILE");
					System.out.println("0. EXIT");
					System.out.println("ENTER YOUR ROLE: ");
					do
					{
						bool = sc.hasNextInt();
						if(bool)
						{
							roleChoice = sc.nextInt();
						}
						else
						{
							String s =  sc.next();
							System.out.println("Please enter a valid choice");
						}

					}while(!bool);

					switch(roleChoice)
					{
					case 1:
						do
						{
							System.out.println("FUNCTIONS:");
							System.out.println("1. DISPLAY THE PRODUCT LIST");
							System.out.println("2. DISPLAY THE EMPLOYEE LIST");
							System.out.println("3. DISPLAY THE DEALER LIST");
							System.out.println("4. DISPLAY THE PRODUCTS OF A PARTICULAR BRAND");
							System.out.println("5. CHECK STOCK FOR PRODUCTS WITH QUANTITY LESS THAN 15");
							System.out.println("0. EXIT");
							System.out.println("PLEASE ENTER A CHOICE FROM THE ABOVE MENU: ");
							do
							{
								bool = sc.hasNextInt();
								if(bool)
								{
									functionChoice = sc.nextInt();
								}
								else
								{
									String s =  sc.next();
									System.out.println("Please enter a valid choice");
								}

							}while(!bool);
							switch(functionChoice)
							{
							case 1: piobj.displayList();
							System.out.println("Number of products in the market are: "+piobj.calculateLengthOfLinkedList(templl));
							break;
							case 2: empobj.displayList();
							break;
							case 3: diobj.displayList();
							break;
							case 4: piobj.searchProductBasedOnBrand(sc);
							break;
							case 5: piobj.displayProductsAboutToFinish();
							break;
							case 0: System.out.println("Exiting...");
							break;
							default:System.out.println("*INVALID CHOICE*");
							}
						}while(functionChoice!=0);
						break;

					case 2:
						do
						{
							System.out.println("FUNCTIONS:");
							System.out.println("1. DISPLAY PRODUCT LIST");
							System.out.println("2. CHECK STOCK");
							System.out.println("3. ADD DETAILS OF NEW DEALER");
							System.out.println("4. DISPLAY DETAILS OF A PARTICULAR DEALER");
							System.out.println("5. DELETE DETAILS OF A PARTICULAR DEALER");
							System.out.println("6. ADD NEW PRODUCT");
							System.out.println("7. UPDATE PRICE OF A PARTICULAR PRODUCT");
							System.out.println("8. DISPLAY DETAILS OF A PRODUCT BASED ON ID ");
							System.out.println("9. DISPLAY DETAILS OF PRODUCT BASED ON BRAND");
							System.out.println("10. DELETE DETAILS OF A PARTICULAR PRODUCT");

							System.out.println("0. EXIT");
							System.out.println("PLEASE ENTER A CHOICE FROM THE ABOVE MENU: ");
							do
							{
								bool = sc.hasNextInt();
								if(bool)
								{
									inventoryChoice = sc.nextInt();
								}
								else
								{
									String s =  sc.next();
									System.out.println("Please enter a valid choice");
								}

							}while(!bool);
							
							switch(inventoryChoice)
							{
							case 1: piobj.displayList();
							break;
							case 2: sobj.checkstock(piobj,diobj);
							break;
							case 3: diobj.addNewDealer();
							break;
							case 4: diobj.displayWithId();
							break;
							case 5: diobj.deleteWithId();
							break;
							case 6: piobj.addProduct(sc);
							break;
							case 7: 
								int id = 0;
								double mrp = 0.0;
								double cost = 0.0;
								System.out.println("Enter the product ID of the product for which the cost is to be updated");
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

								System.out.println("Enter its MRP");

								do
								{
									bool = sc.hasNextInt();
									if(bool)
									{
										mrp = sc.nextDouble();
									}
									else
									{
										String s =  sc.next();
										System.out.println("Please enter a valid MRP");
									}

								}while(!bool);

								System.out.println("Enter its cost price");

								do
								{
									bool = sc.hasNextDouble();
									if(bool)
									{
										cost = sc.nextDouble();
									}
									else
									{
										String s = sc.next();
										System.out.println("Please enter a valid cost price");
									}

								}while(!bool);

								piobj.updateCost(id,mrp,cost);
								break;
							case 8: piobj.printProductDetailsBasedOnID(sc);
							break;
							case 9: piobj.searchProductBasedOnBrand(sc);
							break;
							case 10:piobj.deleteProduct(sc);
							break;
							case 0: System.out.println("Exiting...");
							break;
							default:
								System.out.println("INVALID CHOICE");

							}
						}while(inventoryChoice!=0);
						break;


					case 3:
						do
						{
							System.out.println("1.GENERATE A BILL");
							System.out.println("0.EXIT");
							System.out.println("ENTER CHOICE :");
							do
							{
								bool = sc.hasNextInt();
								if(bool)
								{
									billingch = sc.nextInt();
								}
								else
								{
									String s =  sc.next();
									System.out.println("Please enter a valid choice");
								}
							}while(!bool);

							switch(billingch)
							{
							case 1:
								bobj.billGeneration(piobj);
								break;
							case 0:
								System.out.println("EXITING...");
								break;
							default:
								System.out.println("INVALID CHOICE");
							}
						}while(billingch!=0);
						break;
					case 4:
						do
						{
							System.out.println("FUNCTIONS");
							System.out.println("1. VIEW PRODUCT DETAILS BASED ON ID");
							System.out.println("2. VIEW PRODUCT DETAILS BASED ON BRAND");
							System.out.println("0. EXIT");
							System.out.println(" PLEASE ENTER CHOICE ");
							do
							{
								bool = sc.hasNextInt();
								if(bool)
								{
									salesChoice = sc.nextInt();
								}
								else
								{
									String s =  sc.next();
									System.out.println("Please enter a valid choice");
								}

							}while(!bool);

							switch(salesChoice)
							{
							case 1: piobj.printProductDetailsBasedOnID(sc);
							break;
							case 2: piobj.searchProductBasedOnBrand(sc);
							break;
							case 0: System.out.println("Exiting..");
							break;
							default:System.out.println("*INVALID CHOICE*");
							}
						}while(salesChoice!=0);

						break;
					case 5:
						empobj.searchEmployeeBasedOnId();
						break;
					case 0:
						System.out.println("EXITING...");
						break;

					default:
						System.out.println("*INVALID CHOICE*");
					}
				}while(roleChoice != 0);//while corresponding to roles

			case 0:
				piobj.addToDataBase();
				empobj.addToDatabase();
				diobj.addToDatabase();
				bobj.loadIntoDatbase();
				System.out.println("CLOSING...");
				break;

			default:
				System.out.println("*INVALID CHOICE*");

			}
		}while(open != 0);
	}

}
