package model;

import java.util.List;
import java.util.Objects;

public class Company {
    private String companyName;
    private String website;
    List<Period> periods;

    public Company(String companyName, String website, List<Period> periods) {
        this.companyName = companyName;
        this.website = website;
        this.periods = periods;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(website, company.website) && Objects.equals(periods, company.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, website, periods);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(companyName);
        sb.append("{");
        sb.append(website);
        sb.append("}");
        sb.append("\n");
        for (Period period : periods) {
            sb.append(period);
        }
        return sb.toString();
    }
}
