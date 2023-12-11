//isAlertPresent  

 

private static boolean isDialogPresent(WebDriver driver) {

        try {

            driver.getTitle();

            return false;

        } catch (UnhandledAlertException e) {

            // Modal dialog showed

            return true;

        }

    }
