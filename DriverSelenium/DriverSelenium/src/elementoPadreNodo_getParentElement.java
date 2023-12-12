import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FindParentElementHTMLExample {
    public static void main(String[] args) {
        // Configurar el sistema para utilizar el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver");

        // Iniciar el navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Abrir la página HTML local
        driver.get("file:///ruta/a/tu/archivo/ejemplo.html");

        try {
            // Localizar el elemento hijo por su ID
            WebElement childElement = driver.findElement(By.id("elementoHijo"));

            // Obtener el elemento padre basado en la estructura HTML con la función getParentElement
            WebElement parentElement = getParentElement(driver, childElement);

            // Imprimir información sobre el elemento padre
            System.out.println("Etiqueta padre: " + parentElement.getTagName());
            System.out.println("Atributo 'id' del padre: " + parentElement.getAttribute("id"));
        } finally {
            // Cerrar el navegador al finalizar
            driver.quit();
        }
    }

    // Método para obtener el elemento padre de un elemento dado utilizando JavaScript
    private static WebElement getParentElement(WebDriver driver, WebElement childElement) {
        return (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].parentNode;", childElement);
    }
}
