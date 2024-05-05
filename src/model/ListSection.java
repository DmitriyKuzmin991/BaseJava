package model;

import java.util.List;

public class ListSection extends AbstractSection {
    private List<String> list;

    public ListSection(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String page : list) {
            sb.append('*').append(page).append("\n");
        }
        return sb.toString();
    }
}
