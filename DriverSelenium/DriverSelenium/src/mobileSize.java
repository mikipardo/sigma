Java
Map<String, String> mobileEmulation = new HashMap<>();

mobileEmulation.put("deviceName", "Nexus 5");

ChromeOptions chromeOptions = new ChromeOptions();

chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

WebDriver driver = new ChromeDriver(chromeOptions);

// para ajustar tamaño
