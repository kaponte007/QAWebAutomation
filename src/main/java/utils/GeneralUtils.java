package utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtils {
    private static List<String> log;

    public static void switchToRecentWindow() {
        WebDriver driver = BrowserConfig.getDriver();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        System.out.println("Switched to another window");
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) BrowserConfig.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitLoadingPage() {
        new WebDriverWait(BrowserConfig.getDriver(), 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public static void forceWait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void addEndScenarioLog(){
        if (log != null) {
            log.add("******/******/******/******/******");
        }
    }


    public static List<String> getList() {
        return log;
    }

    public static String findStringInXml(String tagname, String xml) {
        Pattern pattern = Pattern.compile("<" + tagname + ">(.+?)</" + tagname + ">", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(xml);
        matcher.find();
        return matcher.group(1);
    }

    public static void clearLogs() {
        log.clear();
    }
}
