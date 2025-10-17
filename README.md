# Janji

Saya Vivi Agustina Suryana dengan NIM 2400456 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek Untuk keberkahan-Nya, maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.

---

# Desain Program

<img width="796" height="649" alt="desain" src="https://github.com/user-attachments/assets/5a592daf-f3ce-42ce-8f2c-12c172048ec2" />


Program ini adalah aplikasi berbasis **GUI** yang dibuat menggunakan **Java Swing** untuk mengelola **data buku**.  
Setiap buku memiliki 5 atribut utama, yaitu:

- **ID Buku**  
- **Judul**  
- **Jenis** (Fiksi / Non-Fiksi)  
- **Genre** (Fantasi, Thriller, dll)  
- **Harga**

## Program ini dapat melakukan:

### Menampilkan Data

Saat program dijalankan, program akan langsung menampilkan **data buku dalam tabel (`JTable`)**  
yang berisi kolom **No, ID Buku, Judul, Jenis, Genre, dan Harga.**

### Menambahkan Data

Untuk menambah data baru, pengguna dapat mengisi **form input** yang terdiri dari **ID Buku, Judul, Jenis, Genre, dan Harga.**  
Data yang berhasil ditambahkan akan langsung muncul di tabel,  
dan sistem akan menampilkan pesan notifikasi:

> “Data Buku Berhasil Ditambahkan :)”

sebagai konfirmasi bahwa data telah tersimpan.

### Mengedit Data

Pengguna dapat melakukan **perubahan terhadap data** yang sudah ada dengan cara **mengklik salah satu baris pada tabel.**  
Setelah melakukan perubahan, pengguna menekan tombol **Update** untuk menyimpan data baru.  
Program kemudian memperbarui tabel dan **mengosongkan form** agar siap untuk input berikutnya.

### Menghapus Data

Fitur **hapus data** memungkinkan pengguna menghapus buku yang tidak diperlukan.  
Langkahnya adalah dengan **memilih baris yang ingin dihapus**, lalu menekan tombol **Delete.**  
Sebelum data benar-benar dihapus, muncul dialog konfirmasi berisi pesan:

> “Apakah kamu yakin ingin menghapus buku ini? :(”

Jika pengguna memilih **Yes**, data akan dihapus dari database dan tabel diperbarui.  
Jika memilih **No**, proses penghapusan dibatalkan dan muncul pesan:

> “Penghapusan dibatalkan.”

---

# Penjelasan Alur

Program **ProductMenu** ini berfungsi sebagai **aplikasi manajemen data buku berbasis Java Swing**,  
di mana program ini menerapkan konsep **CRUD (Create, Read, Update, Delete)** dengan tampilan **GUI yang interaktif dan mudah digunakan.**

### Berikut alur kerja program secara lengkap:


#### Inisialisasi Program

Ketika program dijalankan, objek `ProductMenu` dibuat dan jendela utama (`JFrame`) ditampilkan  
dengan ukuran **700x600 piksel** serta latar belakang berwarna **abu muda (`Color.LIGHT_GRAY`)**.  
Komponen seperti **tabel, form input, tombol, dan label** diinisialisasi melalui **main panel**.  
Kemudian program memanggil metode `populateList()` untuk mengisi daftar awal data buku,  
dan menampilkan data tersebut ke dalam tabel melalui `setTable()`.

#### Menampilkan Data ke Tabel

Data buku ditampilkan pada komponen `JTable` menggunakan **DefaultTableModel**.  
Setiap baris berisi informasi **No, ID Buku, Judul, Jenis, Genre, dan Harga**,  
sehingga pengguna dapat melihat seluruh daftar buku yang tersedia.


#### Menambahkan Data Buku Baru

Ketika pengguna mengisi form (ID, Judul, Jenis, Genre, dan Harga) lalu menekan tombol **Add**,  
program menjalankan fungsi `insertData()`.  
Fungsi ini akan mengambil semua nilai dari form input.  
Setelah data berhasil dimasukkan, data akan ditambahkan ke **list lokal (`listProduct`)**,  
dan tabel diperbarui menggunakan `productTable.setModel(setTable())`.  
Lalu form dikosongkan dan muncul pesan notifikasi:

> “Data Buku Berhasil Ditambahkan :)”

####  Memilih dan Mengedit Data

Saat pengguna mengklik salah satu baris dalam tabel, event listener **`MouseAdapter`** menangkap aksi tersebut  
dan menyalin data dari tabel ke form input.  
Tombol **Add** berubah menjadi **Update**, dan tombol **Delete** menjadi terlihat.  
Jika pengguna menekan tombol **Update**, program menjalankan fungsi `updateData()`,  
yang memperbarui data pada list `listProduct` dan database.  
Setelah data diperbarui, tabel direfresh, form dikosongkan, dan tombol kembali ke mode default.


#### Menghapus Data Buku

Pengguna dapat memilih baris dalam tabel lalu menekan tombol **Delete.**  
Program akan menampilkan konfirmasi menggunakan **`JOptionPane`** dengan pesan:

> “Apakah kamu yakin ingin menghapus buku ini? :(”

Jika pengguna memilih **Yes**, fungsi `deleteData()` dijalankan untuk menghapus data dari `listProduct`  
dan memperbarui tampilan tabel.  
Jika memilih **No**, muncul pesan bahwa penghapusan dibatalkan.

# Dokumentasi


https://github.com/user-attachments/assets/1689b395-3209-4458-8056-98873b07c81c



# Tampilan utama program

<img width="679" height="590" alt="Tampilan awal" src="https://github.com/user-attachments/assets/86b05b48-2149-4f1d-bcd8-974b51f6e9c1" />

