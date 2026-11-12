
package testpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkillSwapTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static String url = "https://skillswap-six-psi.vercel.app/login";

    public static void verifyURL(String partOfURL, String page) {
        String actURL = driver.getCurrentUrl();
        Assert.assertTrue(actURL.contains(partOfURL),
                page + " failed. Actual URL: " + actURL);
    }

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
    }

    // Test 1: Login
    @Test(priority = 1)
    public void loginTest() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("userEmail")));

        driver.findElement(By.id("userEmail"))
                .sendKeys("Kiran@gmail.com");

        driver.findElement(By.id("userPassword"))
                .sendKeys("Kiran@123");

        driver.findElement(By.id("login-submit-button")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));
        verifyURL("/dashboard", "Login");

        System.out.println("Login Test Passed");
    }

    // Test 2: Dashboard
    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void dashboardTest() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'Welcome back')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Welcome back')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'Kiran')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Total')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Pending')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Upcoming Sessions')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Completed Sessions')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Reviews Received')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Average Rating')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Unread Notifications')]")).isDisplayed());

        System.out.println("Dashboard Test Passed");
    }

    // Test 3: Profile
    @Test(priority = 3, dependsOnMethods = "dashboardTest")
    public void profileTest() {

        driver.findElement(
                By.xpath("//a[contains(text(),'Edit Profile')]")).click();

        wait.until(ExpectedConditions.urlContains("/profile"));
        verifyURL("/profile", "Profile");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("profile-name")));

        Assert.assertTrue(driver.findElement(
                By.id("profile-name")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("profile-email")).isDisplayed());

        Assert.assertFalse(driver.findElement(
                By.id("profile-email")).isEnabled());

        Assert.assertTrue(driver.findElement(
                By.id("profile-city")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("profile-bio")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("teach-skills")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("learn-skills")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("profile-submit-button")).isDisplayed());

        System.out.println("Profile Test Passed");
    }

    // Test 4: Explore
    @Test(priority = 4, dependsOnMethods = "profileTest")
    public void exploreTest() {

        driver.findElement(
                By.xpath("//a[@href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));
        verifyURL("/explore", "Explore");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Explore Skill Partners')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'Explore Skill Partners')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("explore-search-input")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.id("explore-city-filter-input")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//section[contains(@class,'grid-cols-1')]/article[1]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//article[@id='user-card-01A7QT7HtFST3BePMhXJFKyUI1B2']/div[4]/a")).isDisplayed());

        By sendRequestButton = By.xpath(
                "//article[@id='user-card-01A7QT7HtFST3BePMhXJFKyUI1B2']/div[4]/button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                sendRequestButton));

        WebElement button = driver.findElement(sendRequestButton);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", button);

        wait.until(ExpectedConditions.elementToBeClickable(
                sendRequestButton));

        button.click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Request sent successfully')]")),
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'You already sent a request')]"))
        ));

        System.out.println("Send Request Test Passed");
        System.out.println("Explore Test Passed");
    }

    // Test 5: View Partner Profile
    @Test(priority = 5, dependsOnMethods = "exploreTest")
    public void viewProfileTest() {

        driver.findElement(
                By.xpath("//article[@id='user-card-01A7QT7HtFST3BePMhXJFKyUI1B2']/div[4]/a")).click();

        wait.until(ExpectedConditions.urlContains("/users/"));
        verifyURL("/users/", "View Profile");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Remo')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'Remo')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'About')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'This user has not added a bio yet.')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//div[contains(text(),'chennai')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Can Teach')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'No teaching skills added.')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Wants to Learn')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'No learning skills added.')]")).isDisplayed());

        System.out.println("View Profile Test Passed");

        // Back to Explore
        driver.findElement(
                By.xpath("//a[@href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));
        verifyURL("/explore", "Back to Explore");

        System.out.println("Back to Explore Test Passed");
    }

    // Test 6: Requests
    @Test(priority = 6, dependsOnMethods = "viewProfileTest")
    public void requestsTest() {

        driver.findElement(
                By.xpath("//span[contains(text(),'Requests')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Skill Requests')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'Skill Requests')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Received Requests')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Sent Requests')]")).isDisplayed());

        System.out.println("Requests Test Passed");
    }

    // Test 7: Sessions
    @Test(priority = 7, dependsOnMethods = "requestsTest")
    public void sessionsTest() {

        driver.findElement(
                By.xpath("//span[contains(text(),'Sessions')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'My Sessions')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'My Sessions')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Upcoming Sessions')]")).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//h2[contains(text(),'Completed Sessions')]")).isDisplayed());

        By activeCount = By.cssSelector("span.bg-amber-50");

        wait.until(ExpectedConditions.visibilityOfElementLocated(activeCount));

        Assert.assertEquals(
                driver.findElement(activeCount).getText().trim(), "0 Active");

        By doneCount = By.cssSelector("span.bg-emerald-50");

        wait.until(ExpectedConditions.visibilityOfElementLocated(doneCount));

        Assert.assertEquals(
                driver.findElement(doneCount).getText().trim(), "2 Done");

        System.out.println("Sessions Test Passed");
    }

    // Test 8: Chat
    @Test(priority = 8, dependsOnMethods = "sessionsTest")
    public void chatTest() {

        driver.findElement(
                By.xpath("//span[contains(text(),'Chat')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Chats')]")));

        Assert.assertTrue(driver.findElement(
                By.xpath("//h1[contains(text(),'Chats')]")).isDisplayed());

        System.out.println("Chat Test Passed");
    }

    // Test 9: Send Chat Message
    @Test(priority = 9, dependsOnMethods = "chatTest")
    public void sendMessageTest() {

        // Click user
        By user = By.xpath("//h2[@title='anu@gmail.com']");

        wait.until(ExpectedConditions.elementToBeClickable(user));
        driver.findElement(user).click();

        // Locate message textbox
        By messageBox = By.id(
                "chat-message-input-acq6lEemaQZiUnVOh9Mm5K9w8EB3_exBzOfxzxFgGvLoGYajx4NhpyP43");

        wait.until(ExpectedConditions.visibilityOfElementLocated(messageBox));

        // Type message
        driver.findElement(messageBox)
                .sendKeys("Hello Anu, this is a test message.");

        // Click Send button
        By sendButton = By.xpath("//span[contains(text(),'Send')]");

        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        driver.findElement(sendButton).click();

        System.out.println("Send Message Test Passed");
    }
    
 // Test 10: Logout
    @Test(priority = 10, dependsOnMethods = "sendMessageTest")
    public void logoutTest() {

        // Click profile button
        By profileButton = By.xpath("//span[contains(text(),'Kiran')]");

        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();

        // Click Logout
        By logoutButton = By.id("header-logout-button");

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();

        // Verify login page
        wait.until(ExpectedConditions.urlContains("/login"));
        verifyURL("/login", "Logout");

        System.out.println("Logout Test Passed");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
