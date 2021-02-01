import org.junit.Assert;
import org.junit.Test;

public class YandexPageTest extends BaseTest {

    @Test
    public void YandexMarketSearchTest() {
        YandexPage yandexPage = new YandexPage(driver);
        Assert.assertEquals("Яндекс", yandexPage.getTitle());

        YandexMarketPage yandexMarketPage = yandexPage.clickMarketButton();
        yandexPage.switchToNextTab();
        Assert.assertEquals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов",
                yandexMarketPage.getTitle());

        ElectronicsPage electronicsPage = yandexMarketPage.goToElectronicsPage();
        Assert.assertEquals("Электроника", electronicsPage.getPageHeader());

        MobilePhonesPage mobilePhonesPage = electronicsPage.goToMobilePhonesPage();
        Assert.assertEquals("Мобильные телефоны", mobilePhonesPage.getPageHeader());

        mobilePhonesPage.setManufacturers();
        mobilePhonesPage.setProductPrice("20000");
        mobilePhonesPage.setProductScreenSize("3");
        mobilePhonesPage.sortByPrice();

        String productName = mobilePhonesPage.getFirstItemName();

        mobilePhonesPage.sortByPopularity();

        mobilePhonesPage.searchProductByName(productName);
        // Check the product found is what we search for
        Assert.assertTrue(mobilePhonesPage.getFirstItemName().contains(productName));

        String productPrice = mobilePhonesPage.getProductPrice();
        System.out.println("The price of " + productName + " is " + productPrice);
    }
}
