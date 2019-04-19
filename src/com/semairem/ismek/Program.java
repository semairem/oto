package com.semairem.ismek;

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
			System.out.print("Seçiminiz=");
			System.out.println("");
			int secim = scanner.nextInt();
			switch (secim) {

			case 1:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Sorgulanacak");
				System.out.println("-------------------------------");
				System.out.println("");
				
				break;

			case 2:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				arabaEkleme();
				System.out.println("");
				break;

			case 3:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Kiralanacak Veya Satın Alınacak");
				System.out.println("-------------------------------");
				System.out.println("");
				araclariListeleme();
				araclariSecme();
				
					
				

				break;

			case 4:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				araclariListeleme();
				System.out.println("");

				break;

			case 5:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalışanlar Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				calisanlariListeleme();
				System.out.println("");
				
				break;

			case 6:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalışan Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				calisanEkleme();
				System.out.println("");

				break;

			case 7:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çıkış Yapılacak");
				System.out.println("-------------------------------");
				System.out.println("");
				donguDevamEdiyor = false;

				break;

			default:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Hatalı Seçim Yaptınız");
				System.out.println("-------------------------------");
				System.out.println("");

				break;
			}
		} while (donguDevamEdiyor);
	}

//	-------------------------------------------------------------------------------------------------------------------

	public static void arabaEkleme() {
		OtoGaleri otoGaleri = new OtoGaleri();
		int id = otoGaleri.getId();
		String durumu=otoGaleri.getDurumu();
		System.out.println("Aracın Durumunu Yazınız");
		durumu=scanner.next();
		System.out.println("Araç Türünü Giriniz(Otomobil, Kamyon, Motor vb)");
		String aracTuru = otoGaleri.getAracTuru();
		aracTuru = scanner.next();
		System.out.println("Araç Tipini Giriniz(Satılık/Kiralık)");
		String aracTipi = otoGaleri.getAracTuru();
		aracTipi = scanner.next();
		System.out.println("Aracın Modelini Giriniz");
		String modeli = otoGaleri.getModeli();
		modeli = scanner.next();
		System.out.println("Yakıt Türünü Giriniz");
		String yakiti = otoGaleri.getYakiti();
		yakiti = scanner.next();
		System.out.println("arabanın Markasını Giriniz");
		String markasi = otoGaleri.getMarkasi();
		markasi = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			String sorgu = "INSERT INTO aracOlusturma ( aracTuru, aracTipi,  markasi, modeli, yakiti,id,durumu) VALUES"
					+ " (?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setString(1, aracTuru);
			prepareStatement.setString(2, aracTipi);
			prepareStatement.setString(3, markasi);
			prepareStatement.setString(4, modeli);
			prepareStatement.setString(5, yakiti);
			prepareStatement.setInt(6, id);
			prepareStatement.setString(7, durumu);

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		System.out.println("Kayıt eklendi");
	}
	
//	----------------------------------------------------------------------------------------------------------------------

	public static void araclariListeleme() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from aracOlusturma");
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				System.out.println("No    Aracın Türü       Aracın Tipi      Aracın Modeli      Aracın Yakıtı     Aracın Markası    Aracın Durumu");
				System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "      -      " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------
	
	public static void calisanEkleme()
	{
		calisan calisan=new calisan();
		int id=calisan.getId();
		System.out.println("Çalışanın Adını Giriniz");
		String adi=calisan.getAdi();
		adi = scanner.next();
		System.out.println("Çalışanın Soyadını Giriniz");
		String soyadi=calisan.getSoyadi();
		soyadi = scanner.next();
		System.out.println("Çalışanın Yaşını Giriniz");
		int yasi=calisan.getYasi();
		yasi = scanner.nextInt();
		System.out.println("Çalışanın Görevini Yazınız");
		String gorevi=calisan.getGorevi();
		gorevi = scanner.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			String sorgu = "INSERT INTO calisanOlusturma ( id, adi, soyadi, yasi, gorevi) VALUES"
					+ " (?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, adi);
			prepareStatement.setString(3, soyadi);
			prepareStatement.setInt(4, yasi);
			prepareStatement.setString(5, gorevi);
			
			

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		System.out.println("Kayıt eklendi");
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------
	
	public static void calisanlariListeleme()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calisanolusturma");
			while (rs.next()) {
				int id = rs.getInt(1);
				String adi = rs.getString(2);
				String soyadi = rs.getString(3);
				String yasi = rs.getString(4);
				String gorevi = rs.getString(5);
				
				System.out.println(id + " " + adi + " " + soyadi + " " + yasi + " " + gorevi);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------
	
	public static void araclariSecme() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from aracOlusturma");
			
			System.out.println("Kiralamak veya Satın Almak İstedeğiniz Aracın Numarasını Yazınız");
			int alınacakArabaninIdNumarasi=scanner.nextInt();
			for(int i=0;i<=alınacakArabaninIdNumarasi;i++)
			{
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				if(id==alınacakArabaninIdNumarasi){
					System.out.println(id + " " + aracTuru + " " + aracTipi + " " + modeli + " " + yakiti + " " + markasi+durumu);
					System.out.println("Kiralamak Veya Satın Almak İstediğinize Emin Misiniz?(evet/hayır)");
					String secim=scanner.next();
					
					switch (secim) {
					case "evet":
						durumu="Seçildi";
						System.out.println("No  Aracın Türü   Aracın Tipi     Aracın Modeli    Aracın Yakıtı   Aracın Markası   Aracın Durumu");
						System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "   -    " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
						break;
						
					case "hayır":
						
						break;

					default:
						System.out.println("Hatalı Seçim Yaptınız");
						break;
					}
					
				}
			}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
	}
	
	
	}


