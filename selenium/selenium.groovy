@Grapes([
    @Grab("org.seleniumhq.selenium:selenium-support:3.0.1"),
    @Grab(group='org.seleniumhq.selenium', module='selenium-chrome-driver', version='3.0.1'),
])

//import geb.Browser
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public static void main(String[] args) {
  println "start ${new Date().format('yyyy/MM/dd HH:mm:ss')}"

  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
  ChromeDriver driver = new ChromeDriver();
  driver.get("http://gebish.org");
  WebDriverWait<WebDriver> wait = new WebDriverWait(driver, 30);

  System.out.println(driver.getTitle());

  WebElement elem = driver.findElement(By.id("main"));
  List<WebElement> list = elem.findElements(new By.ByTagName("h1"));
  for (WebElement e : list) {
    System.out.println(e.getText());
  }

  println ("*"*10)

  // XPATHでの指定も可能「//div[@id='main']//h1」
  List<WebElement> lista =   driver.findElements(By.xpath("//div[@id='main']//h1"));
  for (WebElement e : lista) {
    System.out.println(e.getText());
  }

  println ("*"*10)

  WebElement sidebar = driver.findElement(By.id("sidebar"));
  List<WebElement> sidemenus = driver.findElements(new By.ByClassName("sidemenu"));
  for (WebElement sidemenu : sidemenus) {
    List<WebElement> links = sidemenu.findElements(new By.ByTagName("a"));
    for (WebElement link : links) {
      if (link.getText().equals("jQuery-like API")) {
        link.click();
        break;
      }
    }
  }
  WebElement elem2 = driver.findElement(By.id("main"));
  List<WebElement> list2 = elem2.findElements(new By.ByTagName("h1"));
  for (WebElement e : list2) {
    System.out.println(e.getText());
  }

  println "end ${new Date().format('yyyy/MM/dd HH:mm:ss')}"
}
