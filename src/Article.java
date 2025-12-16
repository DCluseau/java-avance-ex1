
public class Article {
	int id;
	String description;
	String brand;
	double unitPrice;
	
	public Article() {
		this.id = 0;
		this.description = "";
		this.brand = "";
		this.unitPrice = 0.0;
	}
	public Article(int id, String description, String brand, double unitPrice) {
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "\nId : " + id + "\nDescription : " + description + "\nMarque : " + brand + "\nPrix unitaire : " + unitPrice;
	}
	
	
}
