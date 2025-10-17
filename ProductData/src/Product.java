// Saya Vivi Agustina Suryana dengan NIM 2400456 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek Untuk keberkahan-Nya, maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.

public class Product {
    private String id;        // ID Buku
    private String nama;      // Judul Buku
    private String jenis;     // Jenis (Cetak, E-book, Audio Book)
    private String kategori;  // Genre
    private double harga;     // Harga

    public Product(String id, String nama, String jenis, double harga, String kategori) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.kategori = kategori;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenis() {
        return this.jenis;
    }

    public double getHarga() {
        return this.harga;
    }

    public String getKategori() {
        return this.kategori;
    }
}
