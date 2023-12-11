public boolean isElementExists(String xpathOfElement){

    return driver.findElements(By.xpath(xpathOfElement)).size() > 0;

}
