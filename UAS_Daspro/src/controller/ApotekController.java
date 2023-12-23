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
            System.out.println("0. Selesai pemesanan");

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
