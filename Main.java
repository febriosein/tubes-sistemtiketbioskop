import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Film[] daftarFilm = new Film[5];
        daftarFilm[0] = new Film("Spider-Man: Brand New Day", "Petualangan / Fiksi ilmiah", 145, 50000, new String[]{"11:30", "14:20", "17:10", "20:00"});
        daftarFilm[1] = new Film("Avengers: Doomsday", "Fiksi ilmiah / Laga", 165, 55000, new String[]{"12:00", "15:15", "18:30", "21:45"});
        daftarFilm[2] = new Film("The Odyssey", "Laga / Fantasi", 172, 50000, new String[]{"12:45", "16:00", "19:15"});
        daftarFilm[3] = new Film("Ghost in the Cell", "Horor / Komedi", 106, 45000, new String[]{"13:15", "15:30", "17:45", "20:30"});
        daftarFilm[4] = new Film("Project Hail Mary", "Fiksi ilmiah / Petualangan", 156, 50000, new String[]{"12:15", "15:10", "18:05", "21:00"});

        boolean berjalan = true;

        while (berjalan) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    menuLihatFilm(daftarFilm);
                    break;
                case 2:
                    menuPesanTiket(scanner, daftarFilm);
                    break;
                case 3:
                    menuLihatDenah(scanner, daftarFilm);
                    break;
                case 4:
                    System.out.println("\n=======================================================");
                    System.out.println("  Terima kasih telah menggunakan sistem tiket bioskop! ");
                    System.out.println("=======================================================\n");
                    berjalan = false;
                    break;
                default:
                    System.out.println("\n[!] Pilihan tidak valid. Silakan pilih menu nomor 1-4.\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("=======================================================");
        System.out.println("            SISTEM PEMESANAN TIKET BIOSKOP             ");
        System.out.println("=======================================================");
        System.out.println("1. Lihat Daftar Film");
        System.out.println("2. Pesan Tiket");
        System.out.println("3. Lihat Denah Kursi");
        System.out.println("4. Keluar");
        System.out.println("=======================================================");
    }

    public static void menuLihatFilm(Film[] daftarFilm) {
        System.out.println("\n================== DAFTAR FILM TAYANG =================");
        for (int i = 0; i < daftarFilm.length; i++) {
            daftarFilm[i].tampilkanDetail(i + 1);
            System.out.println("-------------------------------------------------------");
        }
        System.out.println();
    }

    public static void menuLihatDenah(Scanner scanner, Film[] daftarFilm) {
        System.out.println("\n================ PILIH FILM UNTUK DENAH ===============");
        for (int i = 0; i < daftarFilm.length; i++) {
            System.out.println((i + 1) + ". " + daftarFilm[i].judul);
        }
        System.out.println("-------------------------------------------------------");

        int pilih = 0;
        while (pilih < 1 || pilih > daftarFilm.length) {
            System.out.print("Pilih nomor film (1-" + daftarFilm.length + "): ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih < 1 || pilih > daftarFilm.length) {
                System.out.println("[!] Nomor film tidak valid!");
            }
        }

        Film filmDipilih = daftarFilm[pilih - 1];
        System.out.println("\nDenah Kursi untuk Film: " + filmDipilih.judul);
        filmDipilih.tampilkanDenah();
    }

    public static void menuPesanTiket(Scanner scanner, Film[] daftarFilm) {
        System.out.println("\n================== PEMESANAN TIKET ====================");
        
        for (int i = 0; i < daftarFilm.length; i++) {
            System.out.println((i + 1) + ". " + daftarFilm[i].judul + " (Rp " + daftarFilm[i].harga + ")");
        }
        System.out.println("-------------------------------------------------------");

        int pilihFilm = 0;
        while (pilihFilm < 1 || pilihFilm > daftarFilm.length) {
            System.out.print("Pilih nomor film (1-" + daftarFilm.length + "): ");
            pilihFilm = scanner.nextInt();
            scanner.nextLine();

            if (pilihFilm < 1 || pilihFilm > daftarFilm.length) {
                System.out.println("[!] Nomor film tidak valid!");
            }
        }

        Film filmDipilih = daftarFilm[pilihFilm - 1];

        int sisaKursi = filmDipilih.hitungKursiKosong();
        if (sisaKursi == 0) {
            System.out.println("\n[!] Maaf, seluruh kursi untuk film ini telah habis terisi!\n");
            return;
        }

        System.out.println("\nJadwal Tayang untuk " + filmDipilih.judul + ":");
        for (int i = 0; i < filmDipilih.jamTayang.length; i++) {
            System.out.println((i + 1) + ". " + filmDipilih.jamTayang[i] + " WIB");
        }

        int pilihJam = 0;
        while (pilihJam < 1 || pilihJam > filmDipilih.jamTayang.length) {
            System.out.print("Pilih jam tayang (1-" + filmDipilih.jamTayang.length + "): ");
            pilihJam = scanner.nextInt();
            scanner.nextLine();

            if (pilihJam < 1 || pilihJam > filmDipilih.jamTayang.length) {
                System.out.println("[!] Pilihan jam tayang tidak valid!");
            }
        }
        String jamDipilih = filmDipilih.jamTayang[pilihJam - 1];

        int jumlahTiket = 0;
        while (jumlahTiket <= 0 || jumlahTiket > sisaKursi) {
            System.out.print("\nMasukkan jumlah orang/tiket (Tersisa " + sisaKursi + "): ");
            jumlahTiket = scanner.nextInt();
            scanner.nextLine();

            if (jumlahTiket <= 0) {
                System.out.println("[!] Jumlah tiket minimal 1!");
            } else if (jumlahTiket > sisaKursi) {
                System.out.println("[!] Jumlah tiket melebihi kursi yang tersedia (" + sisaKursi + ")!");
            }
        }

        filmDipilih.tampilkanDenah();
        String[] kursiDipilih = new String[jumlahTiket];

        for (int i = 0; i < jumlahTiket; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.print("Pilih kursi ke-" + (i + 1) + " (Contoh: A1, B3, E8): ");
                String inputKursi = scanner.nextLine().trim();

                if (inputKursi.length() != 2) {
                    System.out.println("[!] Format tidak valid! Masukkan 1 huruf baris (A-E) dan 1 angka kolom (1-8).");
                    continue;
                }

                char barisChar = inputKursi.charAt(0);
                if (barisChar >= 'a' && barisChar <= 'e') {
                    barisChar = (char) (barisChar - 32);
                }

                int barisIndex = barisChar - 'A';
                int kolomIndex = inputKursi.charAt(1) - '1';

                if (barisIndex < 0 || barisIndex > 4 || kolomIndex < 0 || kolomIndex > 7) {
                    System.out.println("[!] Posisi kursi di luar batas! Baris A-E dan Kolom 1-8.");
                    continue;
                }

                if (!filmDipilih.isKursiTersedia(barisIndex, kolomIndex)) {
                    System.out.println("[!] Kursi " + barisChar + (kolomIndex + 1) + " sudah terisi! Silakan pilih kursi lain.");
                    continue;
                }

                filmDipilih.pesanKursi(barisIndex, kolomIndex);
                kursiDipilih[i] = "" + barisChar + (kolomIndex + 1);
                valid = true;
                System.out.println("[OK] Kursi [" + kursiDipilih[i] + "] berhasil dipilih.");
            }
        }

        int totalBayar = jumlahTiket * filmDipilih.harga;
        System.out.println("\n================== PEMBAYARAN =========================");
        System.out.println("Jumlah Tiket : " + jumlahTiket);
        System.out.println("Harga Satuan : Rp " + filmDipilih.harga);
        System.out.println("TOTAL BAYAR  : Rp " + totalBayar);
        System.out.println("-------------------------------------------------------");

        int uangBayar = 0;
        do {
            System.out.print("Masukkan uang pembayaran (Rp): ");
            uangBayar = scanner.nextInt();
            scanner.nextLine();

            if (uangBayar < totalBayar) {
                int kurang = totalBayar - uangBayar;
                System.out.println("[!] Uang tidak cukup! Kekurangan: Rp " + kurang);
            }
        } while (uangBayar < totalBayar);

        int kembalian = uangBayar - totalBayar;

        cetakTiket(filmDipilih, jamDipilih, jumlahTiket, kursiDipilih, totalBayar, uangBayar, kembalian);
    }

    public static void cetakTiket(Film film, String jam, int jumlah, String[] kursi, int total, int bayar, int kembalian) {
        System.out.println("\n=======================================================");
        System.out.println("             STRUK BUKTI PEMESANAN TIKET               ");
        System.out.println("=======================================================");
        System.out.println(" Judul Film      : " + film.judul);
        System.out.println(" Genre / Durasi  : " + film.genre + " (" + film.durasi + " menit)");
        System.out.println(" Jam Tayang      : " + jam + " WIB");
        System.out.println(" Jumlah Tiket    : " + jumlah + " tiket");
        System.out.print(" Kursi Dipesan   : ");
        for (int i = 0; i < kursi.length; i++) {
            System.out.print("[" + kursi[i] + "] ");
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println(" Harga per Tiket : Rp " + film.harga);
        System.out.println(" TOTAL HARGA     : Rp " + total);
        System.out.println(" UANG PEMBAYARAN : Rp " + bayar);
        System.out.println(" KEMBALIAN       : Rp " + kembalian);
        System.out.println("=======================================================");
        System.out.println("     Terima kasih! Selamat menikmati film bioskop.     ");
        System.out.println("=======================================================\n");
    }
}
