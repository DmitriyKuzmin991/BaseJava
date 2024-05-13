package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private final Link homePage;
    private final List<Period> periods = new ArrayList<>();

    public Company(String name, String url, List<Period> list) {
        this.homePage = new Link(name, url);
        periods.addAll(list);
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(homePage, company.homePage) && Objects.equals(periods, company.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, periods);
    }

    @Override
    public String toString() {
        return "Company{" +
                "homePage=" + homePage +
                ", periods=" + periods +
                '}';
    }
}
