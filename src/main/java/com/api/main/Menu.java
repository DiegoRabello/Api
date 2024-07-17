package com.api.main;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        int menu;

        while (sair == false) {
            System.out.println("\t\t\t=============================");
            System.out.println("\t\t\t|                           |");
            System.out.println("\t\t\t|         Menu              |");
            System.out.println("\t\t\t|                           |");
            System.out.println("\t\t\t|       1. Ver UF           |");
            System.out.println("\t\t\t|       2. Ver Região       |");
            System.out.println("\t\t\t|       3. Sair             |");
            System.out.println("\t\t\t|                           |");
            System.out.println("\t\t\t=============================");

            menu = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (menu) {
                case 1:
                    System.out.print("\nDigite a Sigla de Seu Estado: ");
                    String uf = scanner.nextLine().trim().toUpperCase();
                    UnidadeFederal estado = UnidadeFederal.valueOf(uf);
                    System.out.println("Nome: " + estado.getNome());
                    break;

                case 2:
                    System.out.print("\nDigite Sua Região: ");
                    String regiao = scanner.nextLine();
                    int i = 1;
                    for (UnidadeFederal uf2 : UnidadeFederal.values()) {
                        if (uf2.getRegiao().equalsIgnoreCase(regiao)) {
                            System.out.println("\n" + i + "- " + uf2.getNome());
                            i++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Número Invalido!, Tente Novamente.");
                    break;
            }
        }
    }
}