package com.example.android.guardianfeed;

/**
 * An {@link News} object contains information related to a single News item.
 */
public class News {

    private String section; //The name of the Section

    private String title;   //The title of the article

    private String dateTimeAsString;    //The date-time of the article

    private String author;  //The author of the article

    private String link;    //The link to the article

    /**
     * @param sectionInput          The section name
     * @param titleInput            The title
     * @param dateTimeAsStringInput The date and time
     * @param authorInput           The author
     * @param linkInput             The url
     */
    public News(String sectionInput, String titleInput, String dateTimeAsStringInput, String authorInput, String linkInput) {
        section = sectionInput;
        title = titleInput;
        dateTimeAsString = dateTimeAsStringInput;
        author = authorInput;
        link = linkInput;
    }

    /**
     * @return Returns the name of the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @return Returns the title of the article
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Returns the date and time in the form of a string
     */
    public String getDateTimeAsString() {
        return dateTimeAsString;
    }

    /**
     * @return Returns the name of the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return Returns the URL of the article
     */
    public String getLink() {
        return link;
    }

}

