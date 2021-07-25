package models;

import java.util.Date;

public class ImportBookDetail {
    int id;
    int bookId;
    int importId;
    int quantity;
    double price;
    Date expiredDate;

    public ImportBookDetail(int id, int bookId, int importId, int quantity, double price, Date expiredDate) {
        this.id = id;
        this.bookId = bookId;
        this.importId = importId;
        this.quantity = quantity;
        this.price = price;
        this.expiredDate = expiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getImportId() {
        return importId;
    }

    public void setImportId(int importId) {
        this.importId = importId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
