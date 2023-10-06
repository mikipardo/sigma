
WebElement element = driver.findElement(By.id("XpahRuta"));
JavascriptExecutor jse =(JavascriptExecutor)driver;
jse.executeScript("arguments[0].value=\'"+variableImporte+"\';",element);
