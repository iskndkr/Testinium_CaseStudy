package com.gittigidiyor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SecilenUrunSayfasi extends HomePage{


    @FindBy(id = "add-to-basket")
    public WebElement sepeteEkle;

    @FindBy(partialLinkText = "Sepete Git")
    public WebElement sepeteGit;

    @FindBy(css = "#sp-subTitle")
    public WebElement urunOzellikleri;

    @FindBy(xpath = "//div[@id='sp-price-lowPrice']")
    public WebElement urunFiyati;


    public void writeTextFile(String sContent) {
        String filepath = "src/test/resources/dosyalar/ozellikler.txt";
        File f = new File(filepath);
        BufferedWriter bw;
        try {
            FileWriter writer = new FileWriter(f,true);
            bw = new BufferedWriter(writer);
            bw.write(sContent);
            writer.write("\r\n");
            bw.close();
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}
