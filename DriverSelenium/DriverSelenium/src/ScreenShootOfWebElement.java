import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ElementScreenshotExample {
    public static void main(String[] args) {
        // Configura la ubicación del ChromeDriver
        System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver.exe");

        // Inicializa el WebDriver
        WebDriver driver = new ChromeDriver();

        // Navega a la página web
        driver.get("https://www.example.com");

        // Localiza el elemento que deseas capturar
        WebElement elementToCapture = driver.findElement(By.id("boton_id"));

        // Captura la screenshot del elemento
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Define la ruta y el nombre del archivo para la captura de pantalla
            File destinationFile = new File("ruta/del/archivo/imagen.png");

            // Copia la captura de pantalla al archivo especificado
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Captura de pantalla guardada en: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cierra el WebDriver
        driver.quit();
    }
}
