package activity.whenDo;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class MainActivity {

    public Button addNewNote;
    public Button noteTitle;
    public Button openNote;

    public MainActivity(){
        addNewNote = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    }

    public boolean isDisplayedNote(String titleNote){
        String locator= "//android.widget.LinearLayout/android.widget.TextView[@text='"+titleNote+"']";
        Label noteTitle = new Label(By.xpath(locator));
        return noteTitle.isDisplayed();
    }

   public void openNote(String titleNote) throws MalformedURLException {
        noteTitle = new Button(By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='"+titleNote+"']"));
        noteTitle.click();
    }

}
