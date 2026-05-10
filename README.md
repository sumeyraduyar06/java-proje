# VIGOR Health & Wellness System 

VIGOR, Java ve Swing kullanılarak geliştirilmiş kapsamlı bir spor salonu yönetim sistemidir. 
Yöneticiler (Admin), eğitmenler (Trainer), personeller (Staff) ve üyeler (Member) için farklı modüller barındırır. 
Tüm kullanıcı ve sistem verileri users.json dosyası üzerinde güvenli bir şekilde saklanır.

##  Özellikler

Sistem, kullanıcıların rollerine göre farklı arayüzler ve yetkiler sunar:

* **Kimlik Doğrulama & Rol Yönetimi**: Tüm kullanıcılar ID ve şifreleriyle sisteme giriş yapar.
* Sistem, kullanıcının rolüne göre ilgili paneli otomatik olarak açar.
* **Admin Paneli**:
    * Sistemdeki tüm üyeleri, eğitmenleri ve personelleri görüntüleme, ekleme ve silme.
    * Personellerin maaşlarını ve branşlarını belirleme.
    * Personellerin günlük giriş-çıkış saatlerini (mesai) takip etme.
* **Üye (Member) Paneli**:
    * Farklı üyelik tipleri ile kayıt olma (Classic, Normal, Premium).
    * Üyelik bitiş tarihini takip etme ve kalan günü görüntüleme.
    * Sistem üzerinden tarih, saat aralığı, branş (Fitness, Pilates, Yüzme) ve eğitmene göre randevu/program oluşturma.
    *Çakışma kontrolü (aynı saatte aynı hocadan birden fazla randevu alınamaması) mevcuttur.
* **Eğitmen (Trainer) Paneli**:
    * Branşına göre (Fitness, Pilates, Swim) atanmış üyelerin programını haftalık ve saatlik çizelge üzerinden takip etme.
    * Mesai girişi ve çıkış saatlerini kaydetme.
* **Personel (Staff) Paneli**:
    * Günlük giriş (Entry) ve çıkış (Exit) saatlerini kaydederek mesai takibi yapma.

## Kurulum ve Çalıştırma

Projeyi yerel bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyin:

1. **Depoyu Klonlayın:**
   git clone [https://github.com/KULLANICI_ADINIZ/java-proje.git](https://github.com/sumeyraduyar06/java-proje.git)

**2. Projeyi IDE'ye Aktarın**
* IDE'nizi açın.
* **"Open Project"** 
* Klonladığınız dizinin içindeki ana proje klasörünü (içinde pom.xml dosyasının bulunduğu dizin) seçip projeyi içe aktarın.

**3. Bağımlılıkların Yüklenmesi**
* Proje bir Maven projesi olarak ayarlandığından, IDE'niz pom.xml dosyasını okuyacak ve veritabanı işlemleri için gereken
  Gson kütüphanesini otomatik olarak indirecektir.
  Sağ alt köşeden veya Build sekmesinden bu işlemin bitmesini bekleyin.

**4. Sistemi Başlatın**
* Proje dizininden ana başlangıç dosyasını bulun:
  src/main/java/com/mycompany/java_project/Java_project.java
* Bu dosyaya sağ tıklayıp Run As > Java Application seçeneğine tıklayarak uygulamayı çalıştırın.
* Uygulamay manuel eklenen admin olarak giriş yapmak için ID: 12345678912 Sifre: Vigor2026
* Uygulamayı admin olarak açtıktan sonra staff ekleyin.
* Daha sonra sign in seçeneğiyle member ekleyin. 

---

### Önemli Not (Veri Yönetimi)
Sistem, veritabanı olarak **JSON** formatını kullanmaktadır. Projenin ana dizininde bulunan `users.json` dosyası, tüm kullanıcı (Admin, Üye, Eğitmen vb.) bilgilerini tutar. Uygulamanın verileri okuyup yazabilmesi için bu dosyanın silinmemesi veya yerinin değiştirilmemesi gerekmektedir.
