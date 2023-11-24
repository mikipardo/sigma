// Este primero con bucle

public class VerificarExistenciaBoton {

    public static void main(String[] args) {
        // Especifica la ubicación del controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "ruta/del/controlador/chromedriver");

        // Inicializa el WebDriver
        WebDriver driver = new ChromeDriver();

        // Abre una página web
        driver.get("https://www.ejemplo.com");

        // Utiliza el método findElements para encontrar todos los elementos que coincidan con el selector
        // En este caso, estamos buscando botones por su etiqueta <button>
        // Puedes ajustar el selector según tus necesidades
        // Si la lista de elementos encontrados es mayor que cero, significa que al menos un botón está presente
        if (driver.findElements(By.tagName("button")).size() > 0) {
            System.out.println("El botón está presente en la página.");
        } else {
            System.out.println("El botón no está presente en la página.");
        }

        // Cierra el navegador
        driver.quit();
    }
}

/*
findElements() para contar elementos:
Si quieres verificar cuántos elementos coinciden con un selector, puedes usar findElements() y verificar la longitud de la lista devuelt
  */
List<WebElement> botones = driver.findElements(By.tagName("button"));
if (!botones.isEmpty()) {
    System.out.println("Hay botones en la página. Cantidad: " + botones.size());
} else {
    System.out.println("No hay botones en la página.");
}
/*
 Manejo de excepciones:
Si prefieres manejar la excepción directamente, puedes hacer uso de try-catch para manejar la excepción NoSuchElementException, que se lanza cuando no se encuentra el elemento.
*/
try {
    WebElement boton = driver.findElement(By.id("id_del_boton"));
    System.out.println("El botón está presente en la página.");
} catch (NoSuchElementException e) {
    System.out.println("El botón no está presente en la página.");
}
// COMPROBAR SI ESTAN VISIBLES PERO ES SI YA EXISTEN PREVIAMENTE

/*isDisplayed() para verificar visibilidad:
Puedes usar el método isDisplayed() para verificar si un elemento está visible en la página.*/

WebElement boton = driver.findElement(By.id("id_del_boton"));
if (boton.isDisplayed()) {
    System.out.println("El botón está visible en la página.");
} else {
    System.out.println("El botón no está visible en la página.");
}
/*
isEnabled() para verificar si un elemento está habilitado:
Puedes usar el método isEnabled() para verificar si un botón (u otro elemento) está habilitado para interacciones
*/
WebElement boton = driver.findElement(By.id("id_del_boton"));
if (boton.isEnabled()) {
    System.out.println("El botón está habilitado para interacciones.");
} else {
    System.out.println("El botón no está habilitado para interacciones.");
}
/*
isSelected() para elementos de tipo checkbox o radio button:
Si estás trabajando con elementos de tipo checkbox o radio button, puedes usar el método isSelected() para verificar si están seleccionados
*/
WebElement checkbox = driver.findElement(By.id("id_del_checkbox"));
if (checkbox.isSelected()) {
    System.out.println("El checkbox está seleccionado.");
} else {
    System.out.println("El checkbox no está seleccionado.");
}
