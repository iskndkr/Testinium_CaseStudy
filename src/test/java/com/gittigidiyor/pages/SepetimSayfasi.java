package com.gittigidiyor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SepetimSayfasi extends HomePage{

    @FindBy(css = ".new-price")
    public WebElement sepettekiFiyat;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement urunSayisiDropdown;

    @FindBy(css = ".gg-d-16.gg-m-14.detail-text")
    public WebElement fiyatKontrol;

    @FindBy(css = ".gg-icon.gg-icon-bin-medium")
    public WebElement silButonu;

    @FindBy(xpath = "//div[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']/h2")
    public WebElement sepetBosMesaji;
}
