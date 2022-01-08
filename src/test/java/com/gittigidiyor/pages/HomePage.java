package com.gittigidiyor.pages;

import com.gittigidiyor.utilities.BrowserUtils;
import com.gittigidiyor.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@name='k']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//span[contains(text(),'Kapat')]")
    public WebElement cookies;

}
