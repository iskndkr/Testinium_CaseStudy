Feature: Gittigidiyor sitesinden ornek bir otomasyon

  @wip
  Scenario: gittigidiyor sayfasından ürün arama ve ekleme ve silme

    Given  "https://www.gittigidiyor.com" sitesi acilir
    And arama kutucuguna "bilgisayar" kelimesi girilir
    And arama sonuclari sayfasindan 2.sayfa acilir
    And 2. sayfanin acildigi kontrol edilir
    And sonuca gore sergilenen urunlerden rastgele bir urun secilir
    And secilen urunun urun bilgisi ve tutar bilgisi txt dosyasina yazilir
    And secilen urun sepete eklenir
    And urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir
    And adet arttirilarak urun adedinin 2 oldugu dogrulanir
    Then urun sepetten silinerek sepetin bos oldugu kontrol edilir
