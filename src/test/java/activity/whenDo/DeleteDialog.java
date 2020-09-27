package activity.whenDo;

import appiumControl.Button;
import org.openqa.selenium.By;

public class DeleteDialog {
    public Button confirmDelete;

    public DeleteDialog(){
        confirmDelete = new Button(By.id("android:id/button1"));
    }
}
