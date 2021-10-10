package pratikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class nutella {

    //1-Test01 isimli bir class olusturun
//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi "refresh" yapin
//5- Sayfa basliginin "Amazon" ifadesi icerdigini control edin
//6-Sayfa basliginin "Amazon.com. Spend less. Smile more."a esit oldugunu control ediniz
//7- URL in amazon.com icerdigini control edin
//8-"Nutella" icin arama yapiniz


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void amazon () {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Başlık Amazon ifadesini içeriyor, TEST PASSED");
        }

        String expectedLongTitle = "Amazon.com. Spend less. Smile more." ;
        if (expectedLongTitle.equals(actualTitle)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "amazon.com";
        if (actualURL.contains(expectedURL)){
            System.out.println("URL Test PASSED");
        }else {
            System.out.println("URL Test FAILED");
        }

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucSayısı = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayısı.getText());
        //10-Sayfayi kapatin

    }
    @After
    public void tearDown (){
        driver.close();
    }
}
