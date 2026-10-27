public class Film {
    String judul;
    String genre;
    int durasi;
    int harga;
    String[] jamTayang;
    boolean[][] kursi;

    public Film(String judul, String genre, int durasi, int harga, String[] jamTayang) {
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.harga = harga;
        this.jamTayang = jamTayang;
        this.kursi = new boolean[5][8];
    }

    public void tampilkanDetail(int nomor) {
        System.out.println(nomor + ". " + judul);
        System.out.println("   Genre   : " + genre);
        System.out.println("   Durasi  : " + durasi + " menit");
        System.out.println("   Harga   : Rp " + harga + " / tiket");
        System.out.print("   Jadwal  : ");
        for (int i = 0; i < jamTayang.length; i++) {
            System.out.print(jamTayang[i] + " WIB");
            if (i < jamTayang.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }

    public void tampilkanDenah() {
        System.out.println("\n+------------------------------------------------------+");
        System.out.println("|                    LAYAR BIOSKOP                     |");
        System.out.println("+------------------------------------------------------+");
        System.out.print("        ");
        for (int k = 1; k <= 8; k++) {
            System.out.print("  " + k + "   ");
        }
        System.out.println();

        char[] labelBaris = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < 5; i++) {
            System.out.print("    " + labelBaris[i] + "   ");
            for (int j = 0; j < 8; j++) {
                if (kursi[i][j]) {
                    System.out.print("[ X ] ");
                } else {
                    System.out.print("[ O ] ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Keterangan: [ O ] = Kosong (Tersedia) | [ X ] = Terisi");
        System.out.println("Sisa kursi kosong: " + hitungKursiKosong() + " dari 40 kursi\n");
    }

    public boolean isKursiTersedia(int baris, int kolom) {
        if (baris >= 0 && baris < 5 && kolom >= 0 && kolom < 8) {
            return !kursi[baris][kolom];
        }
        return false;
    }

    public void pesanKursi(int baris, int kolom) {
        if (baris >= 0 && baris < 5 && kolom >= 0 && kolom < 8) {
            kursi[baris][kolom] = true;
        }
    }

    public int hitungKursiKosong() {
        int kosong = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (!kursi[i][j]) {
                    kosong++;
                }
            }
        }
        return kosong;
    }
}
