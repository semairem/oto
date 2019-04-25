package com.semairem.otoGaleri;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Program {


	private static Connection con = null;

	static Scanner scanner = new Scanner(System.in);



	public static void main(String[] args) {

		boolean donguDevamEdiyor = true;
		do {
			
			System.out.println("");
			Menu.menuYazdir();
			System.out.println("");
			System.out.print("Se�iminiz=");
			System.out.println("");
			int secim = scanner.nextInt();
			switch (secim) {

			case 1:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Ara� Sorgulanacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.aracSorgulama();
				System.out.println("");
				
				break;

			case 2:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Ara� Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.arabaEkleme();
				System.out.println("");
				break;

			case 3:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Ara� Kiralanacak Veya Sat�n Al�nacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				Methodlar.araclariSecme();
				
					
				

				break;

			case 4:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Ara� Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				System.out.println("");

				break;

			case 5:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("�al��anlar Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanlariListeleme();
				System.out.println("");
				
				break;

			case 6:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("�al��an Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanEkleme();
				System.out.println("");

				break;

			case 7:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("��k�� Yap�lacak");
				System.out.println("-------------------------------");
				System.out.println("");
				donguDevamEdiyor = false;

				break;

			default:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Hatal� Se�im Yapt�n�z");
				System.out.println("-------------------------------");
				System.out.println("");

				break;
			}
		} while (donguDevamEdiyor);
	}

	
}