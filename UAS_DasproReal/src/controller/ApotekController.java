package controller;

import java.util.Scanner;
import model.PelayanApotek;
import model.Obat;
import model.Transaksi;

import java.util.Scanner;

public class ApotekController {
    private Transaksi transaksi;
    private PelayanApotek pelayan;

    public ApotekController(PelayanApotek pelayan) {
        this.pelayan = pelayan;
        transaksi = new Transaksi();
    }

    public void tambahObat(Obat obat) {
        transaksi.tambahObat(obat);
    }

    public void tampilkanNota() {
        transaksi.tampilkanNota();
    }

    public void prosesTransaksi(Obat obat) {
        pelayan.prosesTransaksi(this, obat);
    }

    public void mulaiPemesanan() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Pilih obat yang ingin dipesan:");
            System.out.println("1. Paracetamol (Rp5000)");
            System.out.println("2. Amoxicillin (Rp10000)");
            System.out.println("3. Vitamin C (Rp8000)");
            System.out.println("4. Perispirant (Rp75000)");
            System.out.println("5. Alparazolam (Rp118000)");
            System.out.println("6. Cetirizine (Rp19000)");
            System.out.println("7. Gliserin (Rp7000)");
            System.out.println("8. Ibuprofen (Rp28000)");
            System.out.println("9. Mikonazol (Rp39000)");
            System.out.println("10. Obat Batuk Hitam OBH (Rp378000)");
            System.out.println("11. Retinol Vitamin A (Rp29000)");
            System.out.println("12. Selesai pemesanan");

            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                break;
            }

            Obat obat = null;

            switch (pilihan) {
                case 1:
                    obat = new Obat("Paracetamol", 5000);
                    break;
                case 2:
                    obat = new Obat("Amoxicillin", 10000);
                    break;
                case 3:
                    obat = new Obat("Vitamin C", 8000);
                    break;
                case 4:
                    obat = new Obat("Perispirant", 75000);
                    break;
                case 5:
                    obat = new Obat("Alparazolam", 118000);
                    break;
                case 6:
                    obat = new Obat("Cetirizine", 19000);
                    break;
                case 7:
                    obat = new Obat("Gliserin", 7000);
                    break;
                case 8:
                    obat = new Obat("Ibuprofen", 28000);
                    break;
                case 9:
                    obat = new Obat("Mikonazol", 39000);
                    break;
                case 10:
                    obat = new Obat("Obat Batuk Hitam OBH", 378000);
                    break;
                case 11:
                    obat = new Obat("Retinol Vitamin A", 29000);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }

            prosesTransaksi(obat);

            System.out.println("Apakah ingin memesan lagi? (y/n):");
            char inginMemesanLagi = scanner.next().charAt(0);

            if (inginMemesanLagi != 'y' && inginMemesanLagi != 'Y') {
                break;
            }

        } while (true);

        System.out.println("Pemesanan selesai. Nota akhir:");
        tampilkanNota();
    }
}
