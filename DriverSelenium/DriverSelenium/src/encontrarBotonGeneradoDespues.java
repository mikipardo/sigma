     List<WebElement>lista= data.driver.findElements(By.tagName("button"));
     
     for (WebElement webElement : lista) {
      System.out.println(webElement.toString());
      System.err.println(webElement.getText());
      System.err.println(webElement.getLocation());
      if(webElement.getText().contains("Columnas a mostrar")) {
        webElement.click();
      }
    }
