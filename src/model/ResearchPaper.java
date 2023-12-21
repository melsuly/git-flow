package model;

import java.util.Date;
import java.util.List;

public class ResearchPaper {
    private int citations;
    private String name;
    private List<String> authors;
    private String journal;
    private int pages;
    private Date publicationDate;
    private String doi;

    public ResearchPaper(int citations, String name, List<String> authors, String journal, int pages, Date publicationDate, String doi) {
        this.citations = citations;
        this.name = name;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.doi = doi;
    }

    public int getCitations() {
        return citations;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getJournal() {
        return journal;
    }

    public int getPages() {
        return pages;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getDoi() {
        return doi;
    }

    public String getCitation(Format format) {
        switch (format) {
            case PLAIN_TEXT:
                return "";
            case BIBTEX:
                return "";
            default:
                return "";
        }
    }
}
