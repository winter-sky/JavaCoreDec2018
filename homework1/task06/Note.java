package homework1.task06;

/**
 *This class creates a new notepad entry
 */
public class Note {
    private int id;
    private String content;

    public Note(String note){
        content = note;
    }

    /**
     * Sets an id for a new entry.
     * @param id
     */
    public void setId(int id){
        this.id=id;
    }

    /**
     * Retrieves the id of an existing entry.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the contents of the notepad entry
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the contents of the notepad entry
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
