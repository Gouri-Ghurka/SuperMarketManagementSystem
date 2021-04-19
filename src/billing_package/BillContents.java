package billing_package;

public class BillContents 
{
	
	private String prod_brand;
	private int qty_purchased;
	private double mrp;
	private double tot_item_price;
	
	public String getProd_brand() {
		return prod_brand;
	}
	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}
	public int getQty_purchased() {
		return qty_purchased;
	}
	public void setQty_purchased(int qty_purchased) {
		this.qty_purchased = qty_purchased;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public double getTot_item_price() {
		return tot_item_price;
	}
	public void setTot_item_price(double tot_item_price) {
		this.tot_item_price = tot_item_price;
	}
	
}
