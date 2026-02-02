import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); // ChromeDriver path
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/LENOVO/Documents/Desktop/Calculator-app/index.html");
    }

    @Test
    public void testAddition() {
        WebElement aField = driver.findElement(By.id("a"));
        WebElement bField = driver.findElement(By.id("b"));

        // Read manual values
        int a = Integer.parseInt(aField.getAttribute("value"));
        int b = Integer.parseInt(bField.getAttribute("value"));

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement resultField = driver.findElement(By.id("result"));
        int result = Integer.parseInt(resultField.getText().replace("Result: ", ""));

        Assert.assertEquals(result, a + b); // Automatic pass/fail
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
