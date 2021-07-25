package models;

import java.sql.Date;

public class RentingBook {
    int id;
    int bookId;
    int staffId;
    int studentId;
    Date actualReturnDate;
    Date returnDate;

    public RentingBook(int id, int bookId, int staffId, int studentId, Date actualReturnDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.staffId = staffId;
        this.studentId = studentId;
        this.actualReturnDate = actualReturnDate;
        this.returnDate = returnDate;
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

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public  Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
