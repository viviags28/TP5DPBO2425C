import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMenu extends JFrame {
    public static void main(String[] args) {
        // Membuat window utama aplikasi
        ProductMenu menu = new ProductMenu();
        menu.setSize(700, 600);
        menu.setLocationRelativeTo(null);
        menu.setContentPane(menu.mainPanel);
        menu.getContentPane().setBackground(Color.LIGHT_GRAY);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }

    // Variabel global
    private int selectedIndex = -1; // Menyimpan baris yang dipilih
    private Database database;

    // Komponen GUI
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField judulField;
    private JComboBox<String> jenisComboBox;
    private JComboBox<String> kategoriComboBox;
    private JTextField hargaField;
    private JTable productTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel judulLabel;
    private JLabel jenisLabel;
    private JLabel genreLabel;
    private JLabel hargaLabel;

    // Constructor utama
    public ProductMenu() {
        database = new Database();
        productTable.setModel(setTable()); // Tampilkan ke tabel
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f)); // Ubah font title

        // Isi pilihan combobox Jenis & Genre
        String[] jenisData = {"???", "Fiksi", "Non-Fiksi"};
        jenisComboBox.setModel(new DefaultComboBoxModel<>(jenisData));

        String[] kategoriData = {"???", "Fantasi", "Science Fiction", "Thriller", "Misteri", "Romansa", "Aksi", "Biografi", "Filsafat", "Sosial", "Sains"};
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(kategoriData));

        deleteButton.setVisible(false); // Tombol delete disembunyikan dulu

        // Tombol Add / Update
        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) insertData(); // Jika belum pilih data, tambah baru
            else updateData(); // Jika sudah pilih data, ubah data
        });

        // Tombol Delete dengan konfirmasi
        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah kamu yakin ingin menghapus buku ini? :(",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) deleteData();
            else JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.");
        });

        // Tombol Cancel (reset form)
        cancelButton.addActionListener(e -> clearForm());

        // Klik tabel untuk edit data
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = productTable.getSelectedRow();
                // Ambil nilai dari tabel
                String curId = productTable.getModel().getValueAt(selectedIndex, 1).toString();
                String curNama = productTable.getModel().getValueAt(selectedIndex, 2).toString();
                String curJenis = productTable.getModel().getValueAt(selectedIndex, 3).toString();
                String curKategori = productTable.getModel().getValueAt(selectedIndex, 4).toString();
                String curHarga = productTable.getModel().getValueAt(selectedIndex, 5).toString();

                // Isi field form
                idField.setText(curId);
                judulField.setText(curNama);
                jenisComboBox.setSelectedItem(curJenis);
                kategoriComboBox.setSelectedItem(curKategori);
                hargaField.setText(curHarga);

                // Ubah tombol jadi mode Update
                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // Set data tabel (ID, Judul, Jenis, Genre, Harga)
    public final DefaultTableModel setTable() {
        Object[] cols = {"No", "ID Buku", "Judul", "Jenis", "Genre", "Harga"};
        DefaultTableModel tmp = new DefaultTableModel(null, cols);

        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM product");
            //isi tabel dengan hasil query
            int i = 1;
            while (resultSet.next()) {
                Object[] row = new Object[6];
                row[0] = i;
                row[1] = resultSet.getString("id");
                row[2] = resultSet.getString("judul");
                row[3] = resultSet.getString("jenis");
                row[4] = resultSet.getString("genre");
                row[5] = resultSet.getString("harga");
                tmp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    // Tambah data baru ke database dengan validasi
    public void insertData() {
        try {
            String id = idField.getText().trim();
            String nama = judulField.getText().trim();
            String jenis = jenisComboBox.getSelectedItem().toString();
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String hargaText = hargaField.getText().trim();

            // Validasi input kosong
            if (id.isEmpty() || nama.isEmpty() || hargaText.isEmpty() ||
                    jenis.equals("???") || kategori.equals("???")) {
                JOptionPane.showMessageDialog(null,
                        "Yang lengkap hey!!!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validasi harga numerik
            double harga;
            try {
                harga = Double.parseDouble(hargaText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Woy harga tuh harus diisi angka!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cek ID duplikat
            ResultSet rs = database.selectQuery("SELECT * FROM product WHERE id = '" + id + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "Buat ID baru woy jangan sama!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tambahkan data ke database
            String sqlQuery = "INSERT INTO product VALUES('" + id + "', '" + nama + "', '" + jenis + "', '" + kategori + "', '" + harga + "')";
            database.insertUpdateDeleteQuery(sqlQuery);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data Buku Berhasil Ditambahkan :)");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Update data yang dipilih langsung ke database
    public void updateData() {
        try {
            String id = idField.getText().trim();
            String nama = judulField.getText().trim();
            String jenis = jenisComboBox.getSelectedItem().toString();
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String hargaText = hargaField.getText().trim();

            // Validasi input kosong
            if (id.isEmpty() || nama.isEmpty() || hargaText.isEmpty() ||
                    jenis.equals("???") || kategori.equals("???")) {
                JOptionPane.showMessageDialog(null,
                        "Yang lengkap hey!!!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double harga;
            try {
                harga = Double.parseDouble(hargaText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Woy harga tuh harus diisi angka!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update ke database
            String sql = "UPDATE product SET judul='" + nama + "', jenis='" + jenis +
                    "', genre='" + kategori + "', harga='" + harga + "' WHERE id='" + id + "'";
            database.insertUpdateDeleteQuery(sql);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data Buku Berhasil Diubah :)");

        } catch (RuntimeException e) { // ✅ diganti jadi RuntimeException
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan database!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Hapus data terpilih langsung dari database
    public void deleteData() {
        try {
            String id = idField.getText();
            String sql = "DELETE FROM product WHERE id='" + id + "'";
            database.insertUpdateDeleteQuery(sql);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data Buku Berhasil Dihapus:)");
        } catch (RuntimeException e) { // ✅ diganti dari SQLException
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan saat menghapus data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Reset semua field form
    public void clearForm() {
        idField.setText("");
        judulField.setText("");
        jenisComboBox.setSelectedIndex(0);
        kategoriComboBox.setSelectedIndex(0);
        hargaField.setText("");
        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }
}
