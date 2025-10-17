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
Saat program dijalankan, program langsung menampilkan data buku dari database MySQL
ke dalam tabel (JTable) dengan kolom No, ID Buku, Judul, Jenis, Genre, dan Harga.


### Menambahkan Data

Pengguna dapat menambahkan data baru dengan mengisi form input yang terdiri dari ID Buku, Judul, Jenis, Genre, dan Harga.

Program akan melakukan validasi otomatis, meliputi:
- Semua kolom wajib diisi (tidak boleh kosong)
- Harga harus berupa angka
- ID Buku tidak boleh sama dengan yang sudah ada di database

Jika semua validasi terpenuhi, data akan disimpan ke database dan langsung muncul di tabel.
Sistem juga menampilkan pesan notifikasi:

> “Data Buku Berhasil Ditambahkan :)”

Jika ID yang dimasukan sudah ada akan menampilkan notifikasi:

> "Buat ID baru woy jangan sama!"

Jika Harga yang di masukan bukan angka akan menampilkan notifikasi:

> "Woy harga tuh harus diisi angka!"

Jika Kolom tidak diisi semua akan menampilkan notifikasi:

> "Yang lengkap hey!!!"

### Mengedit Data

Untuk mengubah data buku, pengguna dapat mengklik salah satu baris pada tabel. Data dari baris tersebut akan otomatis muncul ke form input. Tombol Add berubah menjadi Update, dan tombol Delete menjadi terlihat. Setelah melakukan perubahan, pengguna menekan tombol Update, program akan memvalidasi input kembali dan memperbarui data di database MySQL. Tabel akan diperbarui dan form dikosongkan setelah proses berhasil.

### Menghapus Data

Fitur hapus data memungkinkan pengguna untuk menghapus buku dari database.
Langkahnya adalah dengan memilih baris yang ingin dihapus, lalu menekan tombol Delete.
Sebelum dihapus, sistem akan menampilkan dialog konfirmasi:

> “Apakah kamu yakin ingin menghapus buku ini? :(”

Jika pengguna memilih Yes, data dihapus dari database dan tabel diperbarui.
Jika memilih No, proses dibatalkan dan muncul pesan:

> “Penghapusan dibatalkan.”

---

# Penjelasan Alur

Program ProductMenu berfungsi sebagai aplikasi manajemen data buku berbasis Java Swing
yang menerapkan konsep CRUD (Create, Read, Update, Delete) dengan tampilan GUI interaktif dan terhubung langsung ke database MySQL.

### Berikut alur kerja program secara lengkap:


#### Inisialisasi Program

Saat program dijalankan, objek ProductMenu dibuat dan jendela utama `(JFrame)` ditampilkan
dengan ukuran `700x600` piksel dan latar abu muda (`Color.LIGHT_GRAY`).
Komponen seperti tabel, label, tombol, dan input form diinisialisasi pada mainPanel.
Koneksi ke database dibuat melalui kelas `Database`,
dan tabel diisi menggunakan fungsi `setTable()` yang menjalankan query `SELECT * FROM product`.

#### Menampilkan Data ke Tabel

Fungsi `setTable()` menampilkan seluruh data dari tabel product di database ke dalam `JTable`.
Data diambil menggunakan objek `ResultSet` dan diisi ke dalam `DefaultTableModel` secara dinamis.


#### Menambahkan Data Buku Baru

Ketika tombol Add ditekan, fungsi insertData() dijalankan.
Program memeriksa:
- Kolom tidak boleh kosong
- Harga harus berupa angka
- ID Buku belum pernah digunakan

Jika validasi lolos, data disimpan ke database melalui perintah SQL:

> INSERT INTO product VALUES (id, judul, jenis, genre, harga);

Tabel diperbarui dengan data terbaru, form dikosongkan, dan pesan sukses muncul.

####  Memilih dan Mengedit Data

Saat baris tabel diklik, event listener MouseAdapter menyalin data ke form input. Tombol Add berubah menjadi Update, dan pengguna dapat memperbarui informasi.
Setelah menekan Update, fungsi updateData() dijalankan untuk memperbarui data di database menggunakan perintah:

> UPDATE product
> SET judul = ..., jenis = ..., genre = ..., harga = ...
> WHERE id = ...;

#### Menghapus Data Buku

Ketika tombol Delete ditekan, fungsi deleteData() dijalankan.
Program menampilkan konfirmasi terlebih dahulu melalui JOptionPane.

Jika pengguna memilih Yes, maka perintah SQL dijalankan:

> DELETE FROM product WHERE id = ...;

Tabel diperbarui dan form direset ke keadaan awal.

# Dokumentasi


https://github.com/user-attachments/assets/1689b395-3209-4458-8056-98873b07c81c



# Tampilan utama program

<img width="679" height="590" alt="Tampilan awal" src="https://github.com/user-attachments/assets/86b05b48-2149-4f1d-bcd8-974b51f6e9c1" />

