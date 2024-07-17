package com.api.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		//Inicia A Classe Scanner
		Scanner scanner = new Scanner(System.in);

		//Método Limpa Console
		clearConsole();

		//Texto Para Escolher O caminho que deseja seguir.
		System.out.println("========== Menu ==========");
		System.out.println("1. Ver Significado da Uf ");
		System.out.println("2. Ver Região");

		//Scaneia o Input do Usuário
		int menu = scanner.nextInt();

		//Scaneia nova Linha
		scanner.nextLine();

		//Método Para ir Para escolha do Usuário
		switch (menu) {
			case 1:
				System.out.println("Digite a Sigla de Seu Estado: ");
				String uf = scanner.nextLine().trim().toUpperCase();
				UnidadeFederal estado = UnidadeFederal.valueOf(uf);
				System.out.println("Nome: " + estado.getNome());
				break;

			case 2:
				System.out.println("Digite Sua Região: ");
				String regiao = scanner.nextLine();
				int i=1;
				for (UnidadeFederal uf2 : UnidadeFederal.values()){
					if (uf2.getRegiao().equalsIgnoreCase(regiao)) {
						System.out.println("\n"+i+"- "+uf2.getNome());
						i++;
					}	
				}	
				break;
			default:
				System.out.println("Número Invalido!, Tente Novamente.");
				break;
		}
		
	}
	public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
