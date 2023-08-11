package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class YearAutomationPage extends RunCucumberTest {

    private final By searchInput = By.name("q");
    private final By wikipediaLink = By.cssSelector("a[href*='wikipedia.org']");
    private final By contentText = By.id("content");

    /**
     * Open the Google page
     */
    public void getGooglePage() {
        String URL = "https://www.google.com.br/";
        getDriver("chrome").get(URL);
        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        clickElementByClass(getDriver());
    }

    /**
     * Search a specific text on Google search
     */
    public void searchByText(String searchTerm) {
        WebElement searchInputElement = getDriver().findElement(searchInput);
        searchInputElement.sendKeys(searchTerm);
        searchInputElement.submit();
    }

    /**
     * Click on first link that appears Wikipedia
     */
    public void clickWikipediaLink() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(wikipediaLink));

        WebElement firstWikipediaLink = getDriver().findElement(wikipediaLink);
        firstWikipediaLink.click();
    }

    /**
     * Returns TRUE is found the first years of automation on page
     */
    public boolean yearAutomation(String year) {
        return verifyTextExistInPage(getDriver(), year);
    }

    /**
     * Check if text exists in page
     */
    private boolean verifyTextExistInPage(WebDriver driver, String year) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contentText));

        WebElement contentElement = driver.findElement(contentText);
        return contentElement.getText().contains(year);
    }

    /**
     * Take a screenshot of the page
     */
    public void takeScreenshotWikipediaPage(String screenshotName) {
        File screenshotsFolder = new File("screenshots");
        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdir();
        }

        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            ImageIO.write(ImageIO.read(screenshot), "png", new File(screenshotsFolder, screenshotName + ".png"));
            System.out.println("Screenshot saved as " + screenshotName + ".png");
        } catch (IOException e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
        }
    }

    /**
     * Helps to click in element by class
     */
    private void clickElementByClass(WebDriver driver) {
        By elementSelector = By.cssSelector("." + "QS5gu" + "." + "sy4vM");
        WebElement element = driver.findElement(elementSelector);
        if(element != null) {
            element.click();
        }
    }
}
