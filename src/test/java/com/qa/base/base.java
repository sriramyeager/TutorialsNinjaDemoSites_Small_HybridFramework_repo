package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utilis.utilities;


public class base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public base()  {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
        
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

		} catch (Throwable e) {
			e.printStackTrace();
		}


	}   

	public WebDriver initializeBroswerAndOpenApplication(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.page_Wait_Time));
		driver.get(prop.getProperty("url"));
		return driver;
	}



}

