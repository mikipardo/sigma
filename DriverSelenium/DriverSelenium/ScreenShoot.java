  public boolean checkeaLogoGuardado(String src, DataModel data,String logo) {
    try {
      src = src.substring(0, src.indexOf(".png") + 4);
      data.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// tiempo implicito
      ((JavascriptExecutor) data.driver).executeScript("window.open()");
      for (String winHandle : data.driver.getWindowHandles()) {
        data.driver.switchTo().window(winHandle);
      } // Ultima pestaña
      data.driver.get(src);
      JavascriptExecutor j = (JavascriptExecutor) data.driver;// esperamos a cargar la pagina
      if (j.executeScript("return document.readyState").toString().equals("complete")) {
        System.out.println("Page has loaded");
        TakesScreenshot scrShot = ((TakesScreenshot) data.driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(
            "N://PRUEBAS_CERTIFICACION//21.AUTOMATIZACION//2.DISTRIBUIDOS//CheckSIS//configuracion//SIS//metadata//temp//img//"
                + logo+".png");
        FileUtils.copyFile(SrcFile, DestFile);
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      logger.error("Error al capturar imagen de " + logo);
      return false;
    }
    return true;
  }
