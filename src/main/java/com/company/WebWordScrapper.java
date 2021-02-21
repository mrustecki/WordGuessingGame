package com.company;

//brew install chromedriver
//add maven support : https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebWordScrapper {

    public static String getRandomWord(String randomWord){

        //fetch a radom word from: https://randomwordgenerator.com/

        //on mac and ubuntu give path to chromedriver witout ".exe"
        System.setProperty("webdriver.chrome.driver", "/Users/maciej/Desktop/WordGuessingGame/src/test/Resources/Webdriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //more on running headless: https://itnext.io/how-to-run-a-headless-chrome-browser-in-selenium-webdriver-c5521bc12bf0
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://randomwordgenerator.com/");
        randomWord = driver.findElementByXPath("//*[@id=\"result\"]/li").getText(); //unable to locate element
        driver.quit();

        return randomWord;
    }

}
