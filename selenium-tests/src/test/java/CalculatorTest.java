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
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); // Path to ChromeDriver
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/LENOVO/Documents/Desktop/Calculator-app/index.html");
    }

    @Test
    public void testAddition() {
        WebElement aField = driver.findElement(By.id("a"));
        WebElement bField = driver.findElement(By.id("b"));
        WebElement resultField = driver.findElement(By.id("result"));

        int a = Integer.parseInt(aField.getAttribute("value"));  // Read manual input
        int b = Integer.parseInt(bField.getAttribute("value"));
        int actualResult = Integer.parseInt(resultField.getText().replace("Result: ", ""));

        int expectedResult = a + b; // Calculate expected
        Assert.assertEquals(actualResult, expectedResult);      // Pass/Fail automatically
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
