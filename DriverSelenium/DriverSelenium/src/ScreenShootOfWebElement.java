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

/*
este es mas especifico para solo un elemento
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


<dependency>
    <groupId>ru.yandex.qatools.ashot</groupId>
    <artifactId>ashot</artifactId>
    <version>1.5.4</version> <!-- Utiliza la versión más reciente -->
</dependency>
 ESTA DEPENDENCIA DE BIBLIOTECA


public class ElementScreenshotExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");

        WebElement elementToCapture = driver.findElement(By.id("boton_id"));

        Screenshot screenshot = new AShot()
            .coordsProvider(new WebDriverCoordsProvider())
            .shootingStrategy(ShootingStrategies.viewportPasting(100))
            .takeScreenshot(driver, elementToCapture);

        try {
            File destinationFile = new File("ruta/del/archivo/imagen.png");
            ImageIO.write(screenshot.getImage(), "PNG", destinationFile);
            System.out.println("Captura de pantalla del elemento guardada en: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}



*/
