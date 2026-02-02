import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

  @DataProvider(name="testData")
  public Object[][] data() {
      return new Object[][] {
          {2, 3, 5}, // PASS
          {2, 3, 6}, // FAIL
      };
  }

  @Test(dataProvider="testData")
  public void calculatorTest(int a, int b, int expectedResult) {
      WebDriver driver = new ChromeDriver();
      driver.get("file:///C:/calculator-app/index.html");

      driver.findElement(By.id("a")).clear();
      driver.findElement(By.id("a")).sendKeys(String.valueOf(a));

      driver.findElement(By.id("b")).clear();
      driver.findElement(By.id("b")).sendKeys(String.valueOf(b));

      driver.findElement(By.tagName("button")).click();

      String result = driver.findElement(By.id("result")).getText();
      Assert.assertEquals(result, String.valueOf(expectedResult));
      driver.quit();
  }
}
