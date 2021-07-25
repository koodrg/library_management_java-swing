package models;

import java.util.Date;

public class ExportBookDetail {
    int id;
    int bookId;
    int exportId;
    int quantity;
    double price;
    Date expiredDate;

    public ExportBookDetail(int id, int bookId, int exportId, int quantity, double price, Date expiredDate) {
        this.id = id;
        this.bookId = bookId;
        this.exportId = exportId;
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

    public int getExportId() {
        return exportId;
    }

    public void setExportId(int exportId) {
        this.exportId = exportId;
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
