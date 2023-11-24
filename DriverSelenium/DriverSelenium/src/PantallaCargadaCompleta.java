import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsperaDeCargaDePagina {

    public static void main(String[] args) {
        // Configurar el WebDriver
        System.setProperty("webdriver.chrome.driver", "ruta/del/controlador/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Abrir la página web
        driver.get("https://www.ejemplo.com");

        // Esperar a que la página esté completamente cargada
        waitForPageLoaded(driver);

        // Continuar con las acciones después de que la página esté completamente cargada
        // ...

        // Cerrar el navegador
        driver.quit();
    }

    private static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
    }
}
