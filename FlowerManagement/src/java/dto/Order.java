
package dto;

import java.sql.Date;

public class Order {
    private int orderID;
    private Date orderDate;
    private int orderStatus;
    private String shipperID;
    private int cusID;

    public Order() {
        orderID = 0;
        orderDate = null;
        orderStatus = 0;
        shipperID = "";
        cusID = 0;
    }

    public Order(int orderID, Date orderDate, int orderStatus, String shipperID, int cusID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.shipperID = shipperID;
        this.cusID = cusID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShipperID() {
        return shipperID;
    }

    public void setShipperID(String ShipperID) {
        this.shipperID = ShipperID;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }
}
