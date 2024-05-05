package model;

public class Contact {
    ContactType type;
    String data;

    public Contact(ContactType type, String data) {
        this.type = type;
        this.data = data;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ContactType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return type.getTitle() + " " + data;
    }
}
