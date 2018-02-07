package com.linus.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumTest {
	protected static String baseUrl = "http://localhost:8080/WebTest";
	protected static Selenium2 seleniumOfIE;
	protected static Selenium2 seleniumOfFirefox;
	protected static Selenium2 seleniumOfChrome;
	  
    @BeforeClass
    public static void beforeClass() throws Exception {
        createSeleniumOnce(); 
    }
    
    /** 
     * 创建Selenium. 
     */  
    protected static void createSeleniumOnce() throws Exception {
  
        if (seleniumOfIE == null) {  
        	System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer\\IEDriverServer.exe");
        	
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
            ieCapabilities.setCapability(  
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,  
                            true);  
            WebDriver driver = new InternetExplorerDriver(ieCapabilities);  
            seleniumOfIE = new Selenium2(driver, baseUrl);  
              
//            s.setStopAtShutdown();  
        } 
        
        if (seleniumOfFirefox == null) {  
            
            DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();  
            firefoxCapabilities.setCapability(FirefoxDriver.BINARY, "C:\\Users\\lyan2\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
            firefoxCapabilities.setCapability(FirefoxDriver.PROFILE, "");
            firefoxCapabilities.setJavascriptEnabled(true);
            WebDriver driver = new FirefoxDriver(firefoxCapabilities);  
            seleniumOfFirefox = new Selenium2(driver, baseUrl);  
              
//            s.setStopAtShutdown();  
        } 
        
        if (seleniumOfChrome == null) {  
            // need selenium 1 server started
        	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
        	
        	DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();  
        	//if chrome is not started, then set chrome binary path
//        	ChromeOptions options = new ChromeOptions();
//        	options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//            chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	
            chromeCapabilities.setJavascriptEnabled(true);
            WebDriver driver = new ChromeDriver(chromeCapabilities);  
            seleniumOfChrome = new Selenium2(driver, baseUrl);  
              
//            s.setStopAtShutdown();  
        }
    }
    
    @Test
    public void testInIE() {
    	seleniumOfIE.open("/index.jsp");
    	seleniumOfIE.type(By.name("name"), "linus");
    	seleniumOfIE.findElement(By.name("password")).sendKeys("password");
    	seleniumOfIE.click(By.id("submit"));
    }
    
    @Test
    public void testInFirefox() {
    	seleniumOfFirefox.open("/index.jsp");
    	seleniumOfFirefox.type(By.name("name"), "linus");
    	seleniumOfFirefox.findElement(By.name("password")).sendKeys("password");
    	seleniumOfFirefox.click(By.id("submit"));
    }
    
    @Test
    public void testInChrome() {
    	seleniumOfChrome.open("/index.jsp");
    	seleniumOfChrome.type(By.name("name"), "linus");
    	seleniumOfChrome.findElement(By.name("password")).sendKeys("password");
    	seleniumOfChrome.click(By.id("submit"));
    }

}
