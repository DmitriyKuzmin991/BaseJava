package model;

import java.util.List;
import java.util.Objects;

public class Company {
    private String companyName;
    private String website;
    List<WorkPeriod> workTime;

    public Company(String companyName, String website, List<WorkPeriod> workTime) {
        this.companyName = companyName;
        this.website = website;
        this.workTime = workTime;
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

    public List<WorkPeriod> getWorkTime() {
        return workTime;
    }

    public void setWorkTime(List<WorkPeriod> workTime) {
        this.workTime = workTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(website, company.website) && Objects.equals(workTime, company.workTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, website, workTime);
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
        for (WorkPeriod period : workTime) {
            sb.append(period);
        }
        return sb.toString();
    }
}
