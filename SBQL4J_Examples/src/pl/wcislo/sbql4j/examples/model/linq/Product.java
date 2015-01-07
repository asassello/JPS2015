package pl.wcislo.sbql4j.examples.model.linq;

public class Product {
//	public Product(int unitsInStock, String productName, double unitPrice) {
//		this.unitsInStock = unitsInStock;
//		this.productName = productName;
//		this.unitPrice = unitPrice;
//	}
	
	

	public Product(int productID, String productName, String category,
			double unitPrice, int unitsInStock) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}



	public int productID;
	public String productName;
	public String category;
	public double unitPrice;
	public int unitsInStock;
	
	
	@Override
	public String toString() {
		return "Product[productID="+productID+", productName="+productName+", category="+category+", unitPrice="+unitPrice+", unitsInStock="+unitsInStock+"]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + productID;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + unitsInStock;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productID != other.productID)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double
				.doubleToLongBits(other.unitPrice))
			return false;
		if (unitsInStock != other.unitsInStock)
			return false;
		return true;
	}
	
}