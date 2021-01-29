import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePhonesPage extends PageObject {

    private By mobilePhonesPageHeader = By.xpath("//h1[text()='Мобильные телефоны']");

    private By appleManufacturer = By.xpath("//div//span[text()='Apple']");
    private By honorManufacturer = By.xpath("//div//span[text()='HONOR']");
    private By xiaomiManufacturer = By.xpath("//div//span[text()='Xiaomi']");

    private By inputPriceTo = By.id("glpriceto");
    private By inputScreenSizeFrom = By.id("4925721from");

    private By sortByPriceButton = By.xpath("//button[text()='по цене']");
    private By sortByPopularityButton = By.xpath("//button[text()='по популярности']");

    private By productCell = By.xpath("//article[@data-autotest-id='product-snippet']");
    private By productName = By.xpath("//article[@data-autotest-id='product-snippet']//h3");
    private By productPrice = By.xpath("//article[@data-autotest-id='product-snippet']//div[@data-zone-name='price']//span");
    private By hiddenBlock = By.xpath("//div[@data-zone-name='SearchResults']/div/div[2]");

    private By searchField = By.id("header-search");

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return driver.findElement(mobilePhonesPageHeader).getText();
    }

    public void setManufacturers() {
        driver.findElement(appleManufacturer).click();
        driver.findElement(honorManufacturer).click();
        driver.findElement(xiaomiManufacturer).click();
    }

    public void setProductPrice(String price) {
        driver.findElement(inputPriceTo).sendKeys(price);
    }

    public void setProductScreenSize(String size) {
        driver.findElement(inputScreenSizeFrom).sendKeys(size);
    }

    public void sortByPrice() {
        driver.findElement(sortByPriceButton).click();
    }

    public String getFirstItemName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(hiddenBlock));

        if (driver.findElements(productCell).size() > 0) {
            return driver.findElement(productName).getText();
        }
        return "No product matches found";
    }

    public void sortByPopularity() {
        driver.findElement(sortByPopularityButton).click();
    }

    public void searchProductByName(String productName) {
        WebElement search = driver.findElement(searchField);
        search.click();
        search.clear();
        search.sendKeys(productName);
        search.submit();
    }

    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCell));

        String price = driver.findElement(productPrice).getText();
        return price;
    }
}
