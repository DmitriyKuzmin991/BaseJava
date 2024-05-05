package model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private List<Contact> contacts;
    private Map<SectionType, AbstractSection> resumeBody;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid most not be null");
        Objects.requireNonNull(fullName, "fullName most not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        resumeBody = new HashMap<>();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setBody(SectionType sectionType, AbstractSection section) {
        this.resumeBody.put(sectionType, section);
    }
    public AbstractSection getSection(SectionType section) {
        return resumeBody.get(section);
    }

    public Map<SectionType, AbstractSection> getBody() {
        return resumeBody;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public int compareTo(Resume r) {
        int cmp = this.fullName.compareTo(r.fullName);
        return cmp != 0 ? cmp : this.getUuid().compareTo(r.getUuid());
    }


    public void printResume() {
        System.out.println(fullName);
        for (Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("===================================");
        SectionType[] sectionTypeList = SectionType.values();
        for (SectionType section : sectionTypeList) {
            AbstractSection temp = resumeBody.get(section);
            if (temp == null) continue;
            System.out.println(section.getTitle());
            System.out.println(temp);
            System.out.println("+++++++++++++++++++++++++++");

        }
    }
}