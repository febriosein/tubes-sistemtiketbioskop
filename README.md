<div align="center">

# 🎬 Sistem Pemesanan Tiket Bioskop

### ⭐ Aplikasi CLI Java — Tugas Besar Pemrograman Komputer ⭐

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![CLI](https://img.shields.io/badge/CLI-Application-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Selesai-brightgreen?style=for-the-badge)

> *Simulasi sistem kasir bioskop interaktif berbasis terminal — dibangun murni dengan 7 materi dasar Java, tanpa pustaka atau framework eksternal.*

</div>

---

## 📑 Daftar Isi
- [Gambaran Umum](#-gambaran-umum)
- [Struktur Proyek](#-struktur-proyek)
- [Daftar Film yang Tersedia](#-daftar-film-yang-tersedia)
- [Fitur Aplikasi](#-fitur-aplikasi)
- [Alur Program](#-alur-program)
- [Penerapan 7 Materi Dasar Java](#-penerapan-7-materi-dasar-java)
- [Penjelasan Kode](#-penjelasan-kode)
- [Cara Menjalankan](#-cara-menjalankan)
- [Demo Tampilan Program](#-demo-tampilan-program)
- [Anggota Kelompok](#-anggota-kelompok)

---

## 🌟 Gambaran Umum

Program ini mensimulasikan **sistem kasir bioskop** yang memungkinkan pengguna untuk:
- 🔍 Menjelajahi katalog film yang sedang tayang
- 🪑 Melihat denah kursi studio secara visual
- 🎟️ Memesan tiket dengan memilih posisi kursi
- 💰 Melakukan transaksi pembayaran tunai lengkap dengan struk

Seluruh interaksi dilakukan melalui terminal/konsol dengan antarmuka teks yang intuitif dan validasi input yang ketat untuk mencegah kesalahan pengguna.

---

## 📂 Struktur Proyek

```
Tubes Kompro/
├── 📄 Film.java      → Class blueprint objek film & logika denah kursi studio
├── 📄 Main.java      → Alur utama program, antarmuka menu & transaksi kasir
└── 📄 README.md      → Dokumentasi proyek (file ini)
```

| File | Peran | Penjelasan |
|:---:|:---:|---|
| `Film.java` | **Model Data** | Menyimpan informasi film (judul, genre, durasi, harga, jadwal) dan mengelola matriks denah kursi studio berukuran 5 baris × 8 kolom |
| `Main.java` | **Controller & View** | Mengontrol alur program, menampilkan menu, menerima input pengguna, memproses pemesanan, dan mencetak struk transaksi |

---

## 🎬 Daftar Film yang Tersedia

| No | Judul Film | Genre | Durasi | Harga | Jadwal Tayang (WIB) |
|:--:|---|---|:---:|:---:|---|
| 1 | 🕷️ **Spider-Man: Brand New Day** | Petualangan / Fiksi ilmiah | 145 menit | Rp 50.000 | `11:30` `14:20` `17:10` `20:00` |
| 2 | 🦸 **Avengers: Doomsday** | Fiksi ilmiah / Laga | 165 menit | Rp 55.000 | `12:00` `15:15` `18:30` `21:45` |
| 3 | ⚔️ **The Odyssey** | Laga / Fantasi | 172 menit | Rp 50.000 | `12:45` `16:00` `19:15` |
| 4 | 👻 **Ghost in the Cell** | Horor / Komedi | 106 menit | Rp 45.000 | `13:15` `15:30` `17:45` `20:30` |
| 5 | 🚀 **Project Hail Mary** | Fiksi ilmiah / Petualangan | 156 menit | Rp 50.000 | `12:15` `15:10` `18:05` `21:00` |

---

## 🌟 Fitur Aplikasi

### 1️⃣ Lihat Daftar Film
Menampilkan seluruh katalog film yang sedang tayang beserta genre, durasi, harga tiket, dan jadwal jam tayang yang tersedia.

### 2️⃣ Pesan Tiket
Fitur utama dengan alur pemesanan lengkap:
```
Pilih Film → Pilih Jam Tayang → Tentukan Jumlah Tiket → Pilih Kursi → Bayar → Cetak Struk
```

**Validasi yang diterapkan:**
- ✅ Kursi yang sudah dipesan (`[ X ]`) tidak dapat dipilih ulang
- ✅ Input huruf kecil (`b3`) otomatis dikonversi ke huruf besar (`B3`)
- ✅ Jumlah tiket tidak boleh melebihi sisa kursi kosong
- ✅ Pembayaran harus cukup — jika kurang, ditampilkan nominal kekurangan

### 3️⃣ Lihat Denah Kursi
Menampilkan peta visual kursi bioskop untuk film pilihan:
- `[ O ]` → Kursi **kosong** (tersedia untuk dipesan)
- `[ X ]` → Kursi **terisi** (sudah dipesan orang lain)
- Layout: **5 baris** (A–E) × **8 kolom** (1–8) = **40 kursi** per studio

### 4️⃣ Keluar
Menghentikan program dengan pesan penutup.

---

## 🔄 Alur Program

```
                         ┌─────────────────────┐
                         │    MULAI PROGRAM     │
                         └─────────┬───────────┘
                                   ▼
                    ┌──────────────────────────────┐
              ┌────►│     MENU UTAMA (1 / 2 / 3 / 4)    │
              │     └──────┬─────┬─────┬──────┬────┘
              │            │     │     │      │
              │     ┌──────┘     │     │      └───────┐
              │     ▼            ▼     ▼              ▼
              │  ┌──────┐  ┌─────────┐  ┌──────┐  ┌──────────┐
              │  │[1]   │  │[2]      │  │[3]   │  │[4]       │
              │  │Lihat │  │Pesan    │  │Lihat │  │Keluar    │
              │  │Daftar│  │Tiket    │  │Denah │  │Program   │
              │  │Film  │  │         │  │Kursi │  │          │
              │  └──┬───┘  └────┬────┘  └──┬───┘  └────┬─────┘
              │     │           │          │           │
              │     │     ┌─────┴─────┐    │           ▼
              │     │     │ Pilih Film│    │    ┌────────────┐
              │     │     │ Pilih Jam │    │    │  SELESAI   │
              │     │     │ Jml Tiket │    │    └────────────┘
              │     │     │ Pilih Kursi│   │
              │     │     │ Pembayaran│    │
              │     │     │ Cetak Struk│   │
              │     │     └─────┬─────┘   │
              │     │           │         │
              └─────┴───────────┴─────────┘
                   (kembali ke menu utama)
```

---

## 🧠 Penerapan 7 Materi Dasar Java

<table>
<tr><th>No</th><th>Materi</th><th>Penerapan dalam Program</th></tr>

<tr><td align="center"><b>1</b></td>
<td><b>Percabangan</b></td>
<td>

- `switch-case` → Pemilihan menu utama (1–4)
- `if-else` → Validasi batas koordinat kursi, ketersediaan kursi, format input, dan kecukupan uang pembayaran

</td></tr>

<tr><td align="center"><b>2</b></td>
<td><b>Scanner</b></td>
<td>

- `Scanner(System.in)` → Membaca semua input dari pengguna
- `nextInt()` → Membaca angka (pilihan menu, jumlah tiket, nominal uang)
- `nextLine()` → Membaca teks (kode kursi) dan membersihkan buffer newline

</td></tr>

<tr><td align="center"><b>3</b></td>
<td><b>Perulangan</b></td>
<td>

- `while` → Loop menu utama agar program terus berjalan & loop validasi input
- `for` → Iterasi daftar film, rendering matriks denah kursi, input kursi berulang
- `do-while` → Menjamin pembayaran diulang sampai uang mencukupi

</td></tr>

<tr><td align="center"><b>4</b></td>
<td><b>Array (1D & 2D)</b></td>
<td>

- `Film[]` → Array 1D objek untuk menyimpan 5 film
- `String[]` → Array 1D untuk jadwal jam tayang & daftar kursi yang dipesan
- `boolean[5][8]` → Array 2D sebagai matriks denah kursi studio (baris A–E × kolom 1–8)

</td></tr>

<tr><td align="center"><b>5</b></td>
<td><b>Class & Object</b></td>
<td>

- Class `Film` → Blueprint dengan atribut, konstruktor, dan method
- Instansiasi objek → `new Film("Spider-Man: Brand New Day", ...)` untuk membuat 5 objek film

</td></tr>

<tr><td align="center"><b>6</b></td>
<td><b>Operator Aritmatika & Logika</b></td>
<td>

- **Aritmatika:** `jumlahTiket * harga` (total bayar), `uangBayar - totalBayar` (kembalian), `barisChar - 32` (konversi huruf kecil → kapital melalui ASCII), `kosong++` (increment)
- **Logika & Relasional:** `&&`, `||`, `!`, `>=`, `<=`, `<`, `>`, `==`

</td></tr>

<tr><td align="center"><b>7</b></td>
<td><b>Java Method</b></td>
<td>

- `tampilkanMenu()` → Menampilkan menu utama
- `menuLihatFilm()` → Menampilkan katalog film
- `menuLihatDenah()` → Menampilkan denah kursi pilihan
- `menuPesanTiket()` → Alur lengkap pemesanan tiket
- `cetakTiket()` → Mencetak struk transaksi
- `tampilkanDetail()`, `tampilkanDenah()`, `isKursiTersedia()`, `pesanKursi()`, `hitungKursiKosong()` → Method milik class `Film`

</td></tr>
</table>

---

## 🔍 Penjelasan Kode

### 📄 `Film.java` — Class Model Data Film

Class ini merepresentasikan satu unit film bioskop beserta studio pemutarannya.

**Atribut:**

| Atribut | Tipe Data | Fungsi |
|---|---|---|
| `judul` | `String` | Menyimpan nama/judul film |
| `genre` | `String` | Menyimpan kategori genre film |
| `durasi` | `int` | Durasi pemutaran film (dalam menit) |
| `harga` | `int` | Harga tiket satuan per orang (dalam Rupiah) |
| `jamTayang` | `String[]` | Daftar jadwal jam pemutaran yang tersedia |
| `kursi` | `boolean[][]` | Matriks 5×8 status kursi (`false` = kosong, `true` = terisi) |

**Method:**

| Method | Return | Fungsi |
|---|:---:|---|
| `Film(...)` | — | Konstruktor: inisialisasi data film dan matriks kursi kosong `new boolean[5][8]` |
| `tampilkanDetail(int nomor)` | `void` | Mencetak ringkasan informasi film (judul, genre, durasi, harga, jadwal) |
| `tampilkanDenah()` | `void` | Merender visualisasi denah kursi studio ke terminal dengan format `[ O ]` / `[ X ]` |
| `isKursiTersedia(int baris, int kolom)` | `boolean` | Mengecek apakah koordinat valid dan kursi masih kosong |
| `pesanKursi(int baris, int kolom)` | `void` | Mengubah status kursi dari `false` → `true` (dipesan) |
| `hitungKursiKosong()` | `int` | Menghitung total kursi yang masih bernilai `false` di seluruh matriks |

---

### 📄 `Main.java` — Class Controller & Antarmuka

Class ini mengelola antarmuka pengguna, input, alur percabangan, dan transaksi.

**Method:**

| Method | Fungsi |
|---|---|
| `main(String[] args)` | Entry point: inisialisasi 5 objek film, menjalankan loop menu utama dengan `switch-case` |
| `tampilkanMenu()` | Menampilkan header dan 4 opsi menu utama |
| `menuLihatFilm(Film[])` | Menampilkan daftar seluruh film dengan memanggil `tampilkanDetail()` |
| `menuLihatDenah(Scanner, Film[])` | Meminta pengguna memilih film, lalu menampilkan denah kursi terkini |
| `menuPesanTiket(Scanner, Film[])` | **Alur utama transaksi:** pilih film → cek sisa kursi → pilih jam → jumlah tiket → pilih kursi satu per satu → pembayaran → cetak struk |
| `cetakTiket(Film, String, int, String[], int, int, int)` | Mencetak struk bukti pemesanan lengkap ke terminal |

---

## 🚀 Cara Menjalankan

### Prasyarat
Pastikan **Java Development Kit (JDK)** versi 8 atau lebih baru sudah terpasang:
```bash
java -version
javac -version
```

### Langkah Eksekusi

**Cara 1 — Kompilasi lalu jalankan (semua versi JDK):**
```bash
# 1. Buka terminal di folder proyek
cd "Tubes Kompro"

# 2. Kompilasi kedua file
javac Film.java Main.java

# 3. Jalankan program
java Main
```

**Cara 2 — Jalankan langsung (JDK 11 ke atas):**
```bash
java Main.java
```

---

## 💻 Demo Tampilan Program

### 🏠 Menu Utama
```
=======================================================
            SISTEM PEMESANAN TIKET BIOSKOP             
=======================================================
1. Lihat Daftar Film
2. Pesan Tiket
3. Lihat Denah Kursi
4. Keluar
=======================================================
Pilih menu (1-4): _
```

### 🪑 Denah Kursi Studio
```
+------------------------------------------------------+
|                    LAYAR BIOSKOP                     |
+------------------------------------------------------+
          1     2     3     4     5     6     7     8   
    A   [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] 
    B   [ O ] [ O ] [ O ] [ X ] [ X ] [ O ] [ O ] [ O ] 
    C   [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] 
    D   [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] 
    E   [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] [ O ] 
--------------------------------------------------------
Keterangan: [ O ] = Kosong (Tersedia) | [ X ] = Terisi
Sisa kursi kosong: 38 dari 40 kursi
```

### 🧾 Struk Bukti Pemesanan
```
=======================================================
             STRUK BUKTI PEMESANAN TIKET               
=======================================================
 Judul Film      : Avengers: Doomsday
 Genre / Durasi  : Fiksi ilmiah / Laga (165 menit)
 Jam Tayang      : 15:15 WIB
 Jumlah Tiket    : 2 tiket
 Kursi Dipesan   : [B4] [B5] 
-------------------------------------------------------
 Harga per Tiket : Rp 55000
 TOTAL HARGA     : Rp 110000
 UANG PEMBAYARAN : Rp 150000
 KEMBALIAN       : Rp 40000
=======================================================
     Terima kasih! Selamat menikmati film bioskop.     
=======================================================
```

---

## 👥 Anggota Kelompok

<div align="center">

### Kelompok 4 — Pemrograman Komputer (Kompro)

| No | Nama Lengkap | NIM | Peran |
|:--:|---|:---:|:---:|
| 1 | **Muhammad Dico Aditya** | G1A026048 | 👑 **Ketua** |
| 2 | **Berta Eka Pratama** | G1A026010 | Anggota |
| 3 | **M. Renno Febriosein** | G1A026014 | Anggota |
| 4 | **Yusuf Alpiqri Basin** | G1A026016 | Anggota |

</div>

---

<div align="center">

**Bahasa:** Java (Standard Edition) &nbsp;|&nbsp; **Platform:** Windows / Linux / macOS

*Dibuat dengan ☕ oleh Kelompok 4*

</div>
