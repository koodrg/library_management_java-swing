package models;

public class Supplier {
    int id;
    String supplierName;
    String address;
    String cellPhone;

    public Supplier(int id, String supplierName, String address, String cellPhone) {
        this.id = id;
        this.supplierName = supplierName;
        this.address = address;
        this.cellPhone = cellPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
