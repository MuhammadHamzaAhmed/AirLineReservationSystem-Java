package model;

public class SpecialOffers {
	private String offer;
	private double price;
	private String code;

	public SpecialOffers() {
	}

	
	/**
	 * @param offer
	 * @param price
	 * @param code
	 */
	public SpecialOffers(String offer, double price, String code) {
		super();
		this.offer = offer;
		this.price = price;
		this.code = code;
	}


	/**
	 * @return the offer
	 */
	public String getOffer() {
		return offer;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param offer the offer to set
	 */
	public void setOffer(String offer) {
		this.offer = offer;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	

}
