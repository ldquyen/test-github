
package dto;

public class OrderDetail {
    private int orderDetailID;
    private int quantity;
    private float orderDetailPrice;
    private int itemID;
    private int orderID;

    public OrderDetail() {
        orderDetailID = 0;
        quantity = 0;
        orderDetailPrice = 0;
        itemID = 0;
        orderID = 0;
    }

    public OrderDetail(int orderDetailID, int quantity, float orderDetailPrice, int itemID, int orderID) {
        this.orderDetailID = orderDetailID;
        this.quantity = quantity;
        this.orderDetailPrice = orderDetailPrice;
        this.itemID = itemID;
        this.orderID = orderID;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getOrderDetailPrice() {
        return orderDetailPrice;
    }

    public void setOrderDetailPrice(float orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }   
}
