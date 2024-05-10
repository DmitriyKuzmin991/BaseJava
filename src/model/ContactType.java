package model;

public enum ContactType {

    PHONE("Тел.:"),
    MOBILE("Мобильный:"),
    HOME_PHONE("Мобильный:"),
    SKYPE("skype:"),
    EMAIL("Почта:"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль Github"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOMEPAGE("Домашняя страница:");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
