
package dto;

public class Item {
    private int itemID;
    private String itemName;
    private float price;
    private int itemStatus;
    private String fileIMG;
    private int catID;

    public Item() {
        itemID = 0;
        itemName = "";
        price = 0;
        itemStatus = 0;
        fileIMG = null;
        catID = 0;       
    }

    public Item(int itemID, String itemName, float price, int itemStatus, String fileIMG, int catID) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.itemStatus = itemStatus;
        this.fileIMG = fileIMG;
        this.catID = catID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getFileIMG() {
        return fileIMG;
    }

    public void setFileIMG(String fileIMG) {
        this.fileIMG = fileIMG;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }
}
