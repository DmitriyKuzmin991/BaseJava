package model;

import java.time.LocalDate;
import java.util.Objects;

public class WorkPeriod {
    private String jobTitle;
    private String jobDescription;

    private LocalDate dateOfEmployment;
    private LocalDate dateOfDismissal;

    public WorkPeriod(String jobTitle, String jobDescription, LocalDate dateOfEmployment, LocalDate dateOfDismissal) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.dateOfEmployment = dateOfEmployment;
        this.dateOfDismissal = dateOfDismissal;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public LocalDate getDateOfDismissal() {
        return dateOfDismissal;
    }

    public void setDateOfDismissal(LocalDate dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkPeriod that = (WorkPeriod) o;
        return Objects.equals(jobTitle, that.jobTitle) && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(dateOfEmployment, that.dateOfEmployment) && Objects.equals(dateOfDismissal, that.dateOfDismissal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, jobDescription, dateOfEmployment, dateOfDismissal);
    }

    @Override
    public String toString() {
        return dateOfEmployment +
                "-" +
                dateOfDismissal +
                "\t" +
                jobTitle +
                "\n" +
                jobDescription;
    }
}

