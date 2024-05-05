package model;

public enum ContactType {

    PHONENUMBER("Тел.:"),
    EMAIL("Почта:"),
    PROFILE("Профиль:"),
    HOMEPAGE("Домашняя страница:"),
    SKYPE("skype:");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
