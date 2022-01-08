$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/gittigidiyor.feature");
formatter.feature({
  "name": "Gittigidiyor sitesinden ornek bir otomasyon",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "gittigidiyor sayfasından ürün arama ve ekleme ve silme",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "\"https://www.gittigidiyor.com\" sitesi acilir",
  "keyword": "Given "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.sitesiAcilir(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "arama kutucuguna \"bilgisayar\" kelimesi girilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.aramaKutucugunaKelimesiGirilir(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "arama sonuclari sayfasindan 2.sayfa acilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.aramaSonuclariSayfasindanSayfaAcilir(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "2. sayfanin acildigi kontrol edilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.sayfaninAcildigiKontrolEdilir(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sonuca gore sergilenen urunlerden rastgele bir urun secilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.sonucaGoreSergilenenUrunlerdenRastgeleBirUrunSecilir()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "secilen urunun urun bilgisi ve tutar bilgisi txt dosyasina yazilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.secilenUrununUrunBilgisiVeTutarBilgisiTxtDosyasinaYazilir()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "secilen urun sepete eklenir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.secilenUrunSepeteEklenir()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.urunSayfasindakiFiyatIleSepetteYerAlanUrunFiyatininDogruluguKarsilastirilir()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "adet arttirilarak urun adedinin 2 oldugu dogrulanir",
  "keyword": "And "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.adetArttirilarakUrunAdedininOlduguDogrulanir(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "urun sepetten silinerek sepetin bos oldugu kontrol edilir",
  "keyword": "Then "
});
formatter.match({
  "location": "com.gittigidiyor.step_definitions.MyStepDefs.urunSepettenSilinerekSepetinBosOlduguKontrolEdilir()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});