package model;

import java.util.ArrayList;
import java.util.List;

public class CompanySection extends AbstractSection {
    private List<Company> list;

    public CompanySection() {
        this.list = new ArrayList<>();
    }
    public void addCompany(Company company) {
        list.add(company);
    }
    public void removeCompany(Company company) {
        list.remove(company);
    }

    public List<Company> getList() {
        return list;
    }

    public void setList(List<Company> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Company comp : list) {
            sb.append(comp).append("\n");
        }
        return sb.toString();
    }
}
