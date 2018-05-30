package tests.MayaTestSmoke;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;
import pages.ustMenuPagesMaya.*;

public class MayaSmokeTestProductsUstMenu extends BaseTest {

    @BeforeMethod
    public void loginBeforeTests() {



    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Maya Login ve Anasayfa Açılır")
    public void TS0001_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductsProductsPage productsProductsPage = new ProductsProductsPage();
        //Ürün/Ürün Aileleri sayfası
        productsProductsPage.openPage();
        productsProductsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Satış Kategorileri Açılır. ")
    public void TS0002_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductSalesCategoriesPage productSalesCategoriesPage = new ProductSalesCategoriesPage();

        //Ürün/Satış Kategorileri
        productSalesCategoriesPage.openPage();
        productSalesCategoriesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Rapor Kategorileri Açılır. ")
    public void TS0003_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductReportCategoriesPage productReportCategoriesPage = new ProductReportCategoriesPage();

        //Ürün/Rapor Kategorileri
        productReportCategoriesPage.openPage();
        productReportCategoriesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Regexp Syafası Açılır. ")
    public void TS0004_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductRegexpManagementPage productRegexpManagementPage = new ProductRegexpManagementPage();

        //Ürün/Regexp Sayfası
        productRegexpManagementPage.openPage();
        productRegexpManagementPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Değer Listeleri Sayfası Açılır. ")
    public void TS0005_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductPropertyListsPage productPropertyListsPage = new ProductPropertyListsPage();

        //Ürün/Değer Listeleri sayfası
        productPropertyListsPage.openPage();
        productPropertyListsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Özellikler Sayfası Açılır. ")
    public void TS0006_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductPropertiesPage productPropertiesPage = new ProductPropertiesPage();
         Thread.sleep(2000);
        //Ürün/Özellikler sayfası
        productPropertiesPage.openPage();
        productPropertiesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün-CFS/PR Sayfası Açılır. ")
    public void TS0007_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductProductServicesPage productProductServicesPage = new ProductProductServicesPage();

        //Ürün-CFS/PR sayfası
        productProductServicesPage.openPage();
        productProductServicesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Üst Menüden Ürün/Ürün Grupları Sayfası Açılır. ")
    public void TS0008_MayaUrunlerUstMenuTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductProductGroupPage productProductGroupPage = new ProductProductGroupPage();

        //Ürün/Ürün Grupları  sayfası
        productProductGroupPage.openPage();
        productProductGroupPage.sayfaKontrolu();

    }


}
