package reuse;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static File takeshots(WebDriver driver,String screenshotpath) throws IOException
    {
        TakesScreenshot screenshot=((TakesScreenshot)driver );
        File scrfile=screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(screenshotpath);
        FileHandler.copy(scrfile,DestFile);
        return DestFile;

    }


}