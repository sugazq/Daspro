package controller;

import java.util.Scanner;
import model.PelayanApotek;

public class ApotekApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        model.PelayanApotek[] pelayanArray = {
                new model.PelayanApotek("Agus"),
                new model.PelayanApotek("Aura"),
                new model.PelayanApotek("Fadil"),
                new model.PelayanApotek("Riram")
        };

        System.out.println("Pilih pelayan:");
        for (int i = 0; i < pelayanArray.length; i++) {
            System.out.println((i + 1) + ". " + pelayanArray[i].getNama());
        }

        int pilihanPelayan = scanner.nextInt();

        if (pilihanPelayan < 1 || pilihanPelayan > pelayanArray.length) {
            System.out.println("Pilihan pelayan tidak valid.");
            return;
        }

        model.PelayanApotek pelayan = pelayanArray[pilihanPelayan - 1];

        controller.ApotekController apotekController = new controller.ApotekController(pelayan);

        apotekController.mulaiPemesanan();
    }
}
