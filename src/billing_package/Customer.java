package billing_package;

public class Customer 
{
	private String c_name;
	private String c_phone_no;
	private int tot_points;
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_phone_no() {
		return c_phone_no;
	}
	public void setC_phone_no(String c_phone_no) {
		this.c_phone_no = c_phone_no;
	}
	public int getTot_points() {
		return tot_points;
	}
	public void setTot_points(int tot_points) {
		this.tot_points = tot_points;
	}
	
}
