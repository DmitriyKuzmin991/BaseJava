package model;

public class TextSection extends AbstractSection{
    private String sectionDescription;

    public TextSection(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    @Override
    public String toString() {
        return sectionDescription;
    }
}
