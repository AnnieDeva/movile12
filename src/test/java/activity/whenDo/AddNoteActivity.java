package activity.whenDo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class AddNoteActivity {
    public TextBox titleNote;
    public TextBox descriptionNote;
    public Button saveButton;

    public AddNoteActivity(){
        titleNote = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
        descriptionNote = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
        saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    }

}
