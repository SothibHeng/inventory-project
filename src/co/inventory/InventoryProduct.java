package co.inventory;

import java.time.LocalDate;

import java.util.Objects;

public class InventoryProduct {
    private Integer productId;
    private String productName;
    private Integer productUnitPrice;
    private Integer productQty;
    private LocalDate date;

    // Constructor
    public InventoryProduct() {}
    public InventoryProduct(Integer productId, String productName, Integer productUnitPrice, Integer productQty, LocalDate date) {
        this.productId = productId;
        this.productName = productName;
        this.productUnitPrice = productUnitPrice;
        this.productQty = productQty;
        this.date = date;
    }

    // getter & setter


    public Integer getProductId() {
        return productId;
    }

    public Integer setProductId(Integer productId) {
        this.productId = productId;
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String setProductName(String productName) {
        this.productName = productName;
        return productName;
    }

    public Integer getProductUnitPrice() {
        return productUnitPrice;
    }

    public Integer setProductUnitPrice(Integer productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
        return productUnitPrice;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public Integer setProductQty(Integer productQty) {
        this.productQty = productQty;
        return productQty;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryProduct that = (InventoryProduct) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(productUnitPrice, that.productUnitPrice) && Objects.equals(productQty, that.productQty) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productUnitPrice, productQty, date);
    }

    @Override
    public String toString() {
        return "ItemManagement{" +
                "id=" + productId +
                ", name='" + productName + '\'' +
                ", unitPrice=" + productUnitPrice +
                ", Qty=" + productQty +
                ", date=" + date +
                '}';
    }
}

