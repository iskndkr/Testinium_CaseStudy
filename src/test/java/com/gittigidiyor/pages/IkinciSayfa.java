package com.gittigidiyor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IkinciSayfa extends HomePage{

    @FindBy(xpath = "//*[contains(@alt,'Turbox Tx1070')]")
    public WebElement secilecekUrun;


}
