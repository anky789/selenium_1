import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import sun.security.mscapi.CPublicKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class config_properties {

    public static void main(String[] args) {
        excelreader excel_reader = new excelreader();

        File file = new File("C:/Users/user/IdeaProjects/abc_config/src/main/config/config.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }



        Properties pro =new Properties();
        try {
            pro.load(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }






       if(pro.getProperty("Browser").equalsIgnoreCase("Chrome"))
       {
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();

           driver.get(pro.getProperty("URL"));
          // driver.findElement(By.id("username")).sendKeys(pro.getProperty("username"));
           driver.findElement(By.id("username")).sendKeys(excel_reader.getdata("sheet1",0,0 ));
         driver.findElement(By.id("password")).sendKeys(excel_reader.getdata("sheet1",0,1 ));
         //  driver.findElement(By.id("password")).sendKeys(pro.getProperty("password"));
       } else if (pro.getProperty("Browser").equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();

       }


}
}