
# Görev Yönetim Uygulaması

Bu proje, Java Spring Boot, Hibernate ve Spring Security kullanarak geliştirilmiş bir **Görev Yönetim Uygulaması**dır.  
Uygulamanın amacı, görevlerin birden fazla kullanıcı arasında atanabilmesini sağlamak ve görev süreçlerini kolayca yönetmektir.

## 🚀 Özellikler
- **Kullanıcı Yönetimi**: Kullanıcıların eklenmesi ve listelenmesi
- **Görev Yönetimi**: Görevlerin eklenmesi ve birden fazla kullanıcıya atanması
- **Many-to-Many İlişki**: Kullanıcılar ve görevler arasında çift yönlü ilişki
- **Spring Security ile Güvenlik** (Geliştirme aşamasında)
- **Veritabanı Desteği**: H2 veya MySQL gibi SQL tabanlı veritabanları ile çalışma

## 🛠️ Kullanılan Teknolojiler
- **Java 17**
- **Spring Boot 3**
- **Hibernate ORM**
- **Spring Security** (Geliştirilmeye devam ediyor)
- **JPA** (Java Persistence API)
- **H2 Database** (Test ortamı için)

## 📋 API Endpointleri

### **Görev API'si** (`/api/task`)
- **Görev Oluşturma:**  
  `POST /api/task/create`  
  Görev oluşturmak için kullanılır.

- **Görev Güncelleme:**  
  `POST /api/task/update/{id}`  
  Mevcut görevi güncellemek için kullanılır.

- **Görev Bilgisi Getirme:**  
  `GET /api/task/{id}`  
  ID’ye göre bir görevin bilgilerini döner.

- **Tüm Görevleri Getirme:**  
  `GET /api/task/allTasks`  
  Sistemdeki tüm görevleri listeler.

- **Görev Atama:**  
  `POST /api/task/assign`  
  **Parametreler:**  
  - `userId`: Kullanıcının ID’si  
  - `taskId`: Görevin ID’si  
  Görevi belirtilen kullanıcıya atar.

### **Kullanıcı API'si** (`/api/user`)
- **Kullanıcı Oluşturma:**  
  `POST /api/user/create`  
  Yeni kullanıcı oluşturmak için kullanılır.

- **Kullanıcı Bilgisi Getirme:**  
  `GET /api/user/{id}`  
  ID’ye göre bir kullanıcının bilgilerini döner.

- **Kullanıcı Silme:**  
  `DELETE /api/user/delete/{id}`  
  Belirtilen ID’ye sahip kullanıcıyı siler.

- **Tüm Kullanıcıları Getirme:**  
  `GET /api/user/getAll`  
  Sistemdeki tüm kullanıcıları listeler.

## 🎯 Geliştirme Planları
- [ ] **Spring Security** entegrasyonu ile kullanıcı doğrulaması  
- [ ] **E-posta bildirimleri** ile görev güncellemeleri  
- [ ] **Frontend** geliştirmesi (React veya Angular ile)  
- [ ] **Docker** desteği eklemek


