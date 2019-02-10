package homework1.task06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates empty notebook
 */
public class Notebook {
    private List<Note> notes = new ArrayList<Note>();

    private void menu() {
        System.out.println("Enter 1 to add new note in the notebook");
        System.out.println("Enter 2 to edit notes");
        System.out.println("Enter 3 to delete note");
        System.out.println("Enter 4 to exit");
    }

    private void addNote(String note) throws IOException {
        Note newNote = new Note(note);
        newNote.setId(notes.size() + 1);
        notes.add(newNote);
    }

    private void deleteNote(int id) {
        notes.remove(id - 1);
    }

    private void editNote(int id, String note) {
        Note newNote = new Note(note);
        newNote.setId(id);
        notes.set(id - 1, newNote);
    }

    private void showAllNotes() {
        for (Note note : notes) {
            System.out.println(note.getId() + ")" + " " + note.getContent());
        }
    }

    /**
     * This method creates and manages the contents of a new notebook.
     *
     * @throws IOException
     */
    public void createNotebook() throws IOException {
        this.menu();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            String r = reader.readLine();
            try {
                if (r.equals("1")) {
                    System.out.println("Please, enter new note");
                    this.addNote(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (r.equals("2")) {
                System.out.println("Please, choose the id of the note you want edit to");
                int id = Integer.parseInt(reader.readLine());
                System.out.println("Please, enter the new note for id" + " " + id);
                this.editNote(id, reader.readLine());
            }
            if (r.equals("3")) {
                System.out.println("Please, choose the id of the note you want delete to");
                int id = Integer.parseInt(reader.readLine());
                this.deleteNote(id);
            }
            if (r.equals("4")) {
                flag = false;
            } else {
                this.menu();
            }
            this.showAllNotes();
        }
    }

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        try {
            notebook.createNotebook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
