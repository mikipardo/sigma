package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeDriver {
  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver",
        "N:\\PRUEBAS_CERTIFICACION\\21.AUTOMATIZACION\\chromedriver.exe");

    // TODO Auto-generated method stub
    // Set up the wWebDriverManager for chrome driver
    WebDriver driver = new ChromeDriver();

    driver.get("https://sis-d.redsys.es/sis/simulador/realizarPago.html");
    // esperamos a cargar elemento recuerda eque es en segundo
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement tarjetaImg = wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("/html/body/form[2]/table[1]/tbody/tr/td[1]/b/a")));

    if (tarjetaImg.isEnabled()) {
      // COMERCIO
      driver.findElement(By.name("fuc")).click();
      driver.findElement(By.name("fuc")).clear();
      driver.findElement(By.name("fuc")).sendKeys("14282594");
      // TERMINAL
      driver.findElement(By.name("terminal")).click();
      driver.findElement(By.name("terminal")).clear();
      driver.findElement(By.name("terminal")).sendKeys("3");
      // ENTORNO INTE
      WebElement entornoSelect = driver.findElement(By.name("entorno"));
      Select entorno = new Select(entornoSelect);
      entorno.selectByValue("3"); // Integracion
      // CHECK BOX MODAl
      driver.findElement(By.name("modal")).click();
      // click tarjeta
      driver.findElement(By.tagName("a")).click();
    
     // System.out.println(pageSource);

      // ************************************
      // --- Hasta aqui el cambio de página
      // ************************************
      
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
      } // Ultima pestaña

      WebElement btn = driver.findElement(By.xpath("/html/body/button[1]"));
      btn.click();
   // esperamos
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    //  WebDriverWait wait = new WebDriverWait(WebDriverRefrence,20);
      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div/div/div[2]/iframe")));
      
      // esto es para cambiar al iframe
    //   driver.switchTo().frame(0);
       
       // 4548810007777777 1249
       //introducir datos //4361940000566218 1224
       driver.findElement(By.id("card-number")).sendKeys("4548810007777777");//card
       driver.findElement(By.id("card-expiration")).sendKeys("1249");//date
       try {
         Thread.sleep(1000);
       } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       driver.findElement(By.id("divImgAceptar")).click();//accept
      
    }
  }

}
