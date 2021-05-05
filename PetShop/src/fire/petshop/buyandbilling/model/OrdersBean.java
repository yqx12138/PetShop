package fire.petshop.buyandbilling.model;

/**
 * 类名：OrdersBean
 * 功能：保存对应数据库中Orders表的业务记录
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.util.Date;

public class OrdersBean {

	private int orderId;

	private String userId;

	private Date orderDate;

	private String shipAddr1;

	private String shipAddr2;

	private String shipCity;

	private String shipState;

	private String shipZip;

	private String shipCountry;

	private String billAddr1;

	private String billAddr2;

	private String billCity;

	private String billState;

	private String billZip;

	private String billCountry;

	private String courier;

	private double totalPrice;

	private String billToFirstName;

	private String billToLastName;

	private String shipToFirstName;

	private String shipToLastName;

	private String cardType;

	private String creditCard;

	private Date exprDate;

	private String local;

	public OrdersBean()
	{}
	
	public OrdersBean(	int orderId, 
						String userId, 
						Date orderDate,
						String shipAddr1, 
						String shipAddr2, 
						String shipCity, 
						String shipState, 
						String shipZip, 
						String shipCountry, 
						String billAddr1, 
						String billAddr2, 
						String billCity,
						String billState, 
						String billZip, 
						String billCountry,
						String courier, 
						double totalPrice, 
						String billToFirstName, 
						String billToLastName, 
						String shipToFirstName, 
						String shipToLastName, 
						String cardType, 
						String creditCard, 
						Date exprDate, 
						String local
					) 
	{
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.shipAddr1 = shipAddr1;
		this.shipAddr2 = shipAddr2;
		this.shipCity = shipCity;
		this.shipState = shipState;
		this.shipZip = shipZip;
		this.shipCountry = shipCountry;
		this.billAddr1 = billAddr1;
		this.billAddr2 = billAddr2;
		this.billCity = billCity;
		this.billState = billState;
		this.billZip = billZip;
		this.billCountry = billCountry;
		this.courier = courier;
		this.totalPrice = totalPrice;
		this.billToFirstName = billToFirstName;
		this.billToLastName = billToLastName;
		this.shipToFirstName = shipToFirstName;
		this.shipToLastName = shipToLastName;
		this.cardType = cardType;
		this.creditCard = creditCard;
		this.exprDate = exprDate;
		this.local = local;
	}

	public String getBillAddr1() {
		return billAddr1;
	}

	public void setBillAddr1(String billAddr1) {
		this.billAddr1 = billAddr1;
	}

	public String getBillAddr2() {
		return billAddr2;
	}

	public void setBillAddr2(String billAddr2) {
		this.billAddr2 = billAddr2;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillCountry() {
		return billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillToFirstName() {
		return billToFirstName;
	}

	public void setBillToFirstName(String billToFirstName) {
		this.billToFirstName = billToFirstName;
	}

	public String getBillToLastName() {
		return billToLastName;
	}

	public void setBillToLastName(String billToLastName) {
		this.billToLastName = billToLastName;
	}

	public String getBillZip() {
		return billZip;
	}

	public void setBillZip(String billZip) {
		this.billZip = billZip;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Date getExprDate() {
		return exprDate;
	}

	public void setExprDate(Date exprDate) {
		this.exprDate = exprDate;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getShipAddr1() {
		return shipAddr1;
	}

	public void setShipAddr1(String shipAddr1) {
		this.shipAddr1 = shipAddr1;
	}

	public String getShipAddr2() {
		return shipAddr2;
	}

	public void setShipAddr2(String shipAddr2) {
		this.shipAddr2 = shipAddr2;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	public String getShipToFirstName() {
		return shipToFirstName;
	}

	public void setShipToFirstName(String shipToFirstName) {
		this.shipToFirstName = shipToFirstName;
	}

	public String getShipToLastName() {
		return shipToLastName;
	}

	public void setShipToLastName(String shipToLastName) {
		this.shipToLastName = shipToLastName;
	}

	public String getShipZip() {
		return shipZip;
	}

	public void setShipZip(String shipZip) {
		this.shipZip = shipZip;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
