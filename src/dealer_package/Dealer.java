package dealer_package;

public class Dealer
{
	private int d_id;
	private String d_name;
	private String d_category;
	private String d_prod_name;
	private String d_company;
	private String d_contact_no;
	private String d_email;
	private String d_address;
	private int d_qty_available;
	private double price_per_piece;
	private double d_discount;
	private double d_finalPrice;
	private static int idGenerator=0;

	public static int getIdGenerator() {
		return idGenerator;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public static void setIdGenerator(int idGenerator) {
		Dealer.idGenerator = idGenerator;
	}
	public int getD_id() 
	{
		return d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public String getD_category() {
		return d_category;
	}
	public String getD_prod_name() {
		return d_prod_name;
	}
	public String getD_company() {
		return d_company;
	}
	public String getD_contact_no() {
		return d_contact_no;
	}
	public String getD_email() {
		return d_email;
	}
	public String getD_address() {
		return d_address;
	}
	public int getD_qty_available() {
		return d_qty_available;
	}
	public double getPrice_per_piece() {
		return price_per_piece;
	}
	public double getD_discount() {
		return d_discount;
	}
	public double getD_finalPrice()
	{
		return d_finalPrice;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public void setD_category(String d_category) {
		this.d_category = d_category;
	}
	public void setD_prod_name(String d_prod_name) {
		this.d_prod_name = d_prod_name;
	}
	public void setD_company(String d_company) {
		this.d_company = d_company;
	}
	public void setD_contact_no(String d_contact_no) {
		this.d_contact_no = d_contact_no;
	}
	public void setD_email(String d_email) {
		this.d_email = d_email;
	}
	public void setD_address(String d_address) {
		this.d_address = d_address;
	}
	public void setD_qty_available(int d_qty_available) {
		this.d_qty_available = d_qty_available;
	}
	public void setPrice_per_piece(double price_per_piece) {
		this.price_per_piece = price_per_piece;
	}
	public void setD_discount(double d_discount) {
		this.d_discount = d_discount;
	}
	public void setD_finalPrice(double d_finalPrice) {
		this.d_finalPrice = d_finalPrice;
	}
}
	