package models;

public class BookCategory {
    int id;
    String bookCateName;

    public BookCategory(int id, String bookCateName) {
        this.id = id;
        this.bookCateName = bookCateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCateName() {
        return bookCateName;
    }

    public void setBookCateName(String bookCateName) {
        this.bookCateName = bookCateName;
    }
    @Override
    public String toString() {
        return this.bookCateName;
    }
}
