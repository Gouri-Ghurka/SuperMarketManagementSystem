package product_package;

import java.util.Scanner;

public class Product 
{
	 private int productID;
	 private int productQuantity;
	 private String productName;
	 private String productBrand;
	 private String productCategory;
	 private double productCostPrice;
	 private double productMrp;
	 private static int IDgenerator = 0;

	 public Product()  //default constructor
	 {
		 //IDgenerator++;
		 //productID = IDgenerator;
	 }
	 
	//getter methods
	 
	 public int getProductQuantity() 
	 {
			return productQuantity;
	}

	 public int getProductID()
	 {
		 return productID;
	 }
	 public String getProductName()
	 {
		 return productName;
	 }
	 public double getMrp()
	 {
		 return productMrp;
	 }
	 public String getBrand()
	 {
		 return productBrand;
	 }
	 public String getCategory() 
	 {
		 return productCategory;
	 }
	 public double getCostPrice()
	 {
		 return productCostPrice;
	 }
	 public void setProductQuantity(int productQuantity) 
	 {
		this.productQuantity = productQuantity;
	}

	public void setProductCategory(String productCategory) 
	{
		this.productCategory = productCategory;
	}

	public void setProductCostPrice(double productCostPrice) 
	{
		this.productCostPrice = productCostPrice;
	}

	public void setProductMrp(double productMrp) 
	{
		this.productMrp = productMrp;
	}


	 
	 

	 public void setProductID(int productID) 
	 {
		this.productID = productID;
	 }

	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public void setProductBrand(String productBrand) 
	{
		this.productBrand = productBrand;
	}


	public static int getIDgenerator() {
		return IDgenerator;
	}

	public static void setIDgenerator(int iDgenerator) {
		IDgenerator = iDgenerator;
	}
}
