package models;

public class PublicationHouse {
    int id;
    String houseName;
    String address;
    String email;
    String representativeName;

    public PublicationHouse(int id, String houseName, String address, String email, String representativeName) {
        this.id = id;
        this.houseName = houseName;
        this.address = address;
        this.email = email;
        this.representativeName = representativeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }
}
