package testClean;

import activity.whenDo.AddNoteActivity;
import activity.whenDo.DeleteDialog;
import activity.whenDo.DeleteMainActivity;
import activity.whenDo.MainActivity;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class WhenDoTest {
    MainActivity mainActivity = new MainActivity();
    AddNoteActivity addNoteActivity = new AddNoteActivity();
    DeleteMainActivity deleteMainActivity = new DeleteMainActivity();
    DeleteDialog deleteDialog = new DeleteDialog();

    @Test
    public void verifyCreateNewNote() throws MalformedURLException{
        String titleNote="NA001";
        mainActivity.addNewNote.click();
        addNoteActivity.titleNote.type("NA001");
        addNoteActivity.descriptionNote.type("DA001");
        addNoteActivity.saveButton.click();
       //Verificación
        Assert.assertTrue("ERROR, la nota no fue creada", mainActivity.isDisplayedNote(titleNote));
    }

    @Test
    public void verifyDeleteNote() throws MalformedURLException{
        String titleNote = "DEL001";
        mainActivity.addNewNote.click();
        addNoteActivity.titleNote.type("DEL001");
        addNoteActivity.descriptionNote.type("DESC001");
        addNoteActivity.saveButton.click();
        mainActivity.openNote("DEL001");
        deleteMainActivity.deleteButton.click();
        deleteDialog.confirmDelete.click();
        //Verificación
        Assert.assertFalse("ERROR, la nota no fue eliminada", mainActivity.isDisplayedNote(titleNote));
    }


}
