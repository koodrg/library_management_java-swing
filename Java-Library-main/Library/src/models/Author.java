package models;


public class Author {


    int id;

    String authorName;

    String personalWebsite;
    String description;

    public Author(int id, String authorName, String personalWebsite, String description) {
        this.id = id;
        this.authorName = authorName;
        this.personalWebsite = personalWebsite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
