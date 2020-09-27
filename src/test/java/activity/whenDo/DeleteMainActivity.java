package activity.whenDo;

import appiumControl.Button;
import org.openqa.selenium.By;

public class DeleteMainActivity {

    public Button deleteButton;

    public DeleteMainActivity(){
        deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    }

}
