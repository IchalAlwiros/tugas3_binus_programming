// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// class Mobil {
//     private String merk;
//     private String warna;
//     private String platNomor;
    
//     // Konstruktor dengan parameter
//     public Mobil(String merk, String warna, String platNomor) {
//         this.merk = merk;
//         this.warna = warna;
//         this.platNomor = platNomor;
//     }
    
//     // Konstruktor default
//     public Mobil() {
//         // Default constructor tidak melakukan apa-apa di sini
//     }
    
//     // Metode getter dan setter
//     public String getMerk() {
//         return merk;
//     }
    
//     public void setMerk(String merk) {
//         this.merk = merk;
//     }
    
//     public String getWarna() {
//         return warna;
//     }
    
//     public void setWarna(String warna) {
//         this.warna = warna;
//     }
    
//     public String getPlatNomor() {
//         return platNomor;
//     }
    
//     public void setPlatNomor(String platNomor) {
//         this.platNomor = platNomor;
//     }
// }




// class AreaParkirA {
//     private ArrayList<Mobil> daftarMobil;

//     public AreaParkirA() {
//         this.daftarMobil = new ArrayList<>();
//     }

//     public void tambahMobil(Mobil mobil) {
//         daftarMobil.add(mobil);
//     }

//     public void hapusMobil(String platNomor) {
//         Mobil mobil = cariMobil(platNomor);
//         if (mobil != null) {
//             daftarMobil.remove(mobil);
//             System.out.println("Mobil dengan plat nomor " + platNomor + " berhasil dihapus dari area parkir A.");
//         } else {
//             System.out.println("Mobil dengan plat nomor " + platNomor + " tidak ditemukan di area parkir A.");
//         }
//     }

//     public Mobil cariMobil(String platNomor) {
//         for (Mobil mobil : daftarMobil) {
//             if (mobil.getPlatNomor().equals(platNomor)) {
//                 return mobil;
//             }
//         }
//         return null;
//     }
    
//     public ArrayList<Mobil> getDaftarMobil() {
//            return daftarMobil;
//     }
    
//     public void tampilkanDaftarMobil() {
//         if (daftarMobil.isEmpty()) {
//             System.out.println("Area Parkir Kosong");
//         } else {
//             System.out.println("Daftar mobil di area parkir A:");
//             for (Mobil mobil : daftarMobil) {
//                 System.out.println("Merk: " + mobil.getMerk() + ", Warna: " + mobil.getWarna() + ", Plat Nomor: " + mobil.getPlatNomor());
//             }
//         }
//     }

// }



// public class Main {
//     public static void main(String[] args) {

//         // CARA 1
//         //  AreaParkirA areaParkirA = new AreaParkirA();

//         // // Menambahkan beberapa mobil ke area parkir A
//         // Mobil mobil1 = new Mobil("Toyota", "Hitam", "B 1234 AB");
//         // Mobil mobil2 = new Mobil("Honda", "Merah", "B 5678 CD");
//         // areaParkirA.tambahMobil(mobil1);
//         // areaParkirA.tambahMobil(mobil2);

//         // // Menampilkan daftar mobil di area parkir A
//         // System.out.println("Daftar mobil di area parkir A:");
//         // for (Mobil mobil : areaParkirA.getDaftarMobil()) {
//         //     System.out.println("Merk: " + mobil.getMerk() + ", Warna: " + mobil.getWarna() + ", Plat Nomor: " + mobil.getPlatNomor());
//         // }

//         // // Menghapus mobil dengan plat nomor tertentu dari area parkir A
//         // String platNomorHapus = "B 1234 AB";
//         // areaParkirA.hapusMobil(platNomorHapus);
        
        
//         // // Menampilkan semua daftar Mobil Pada areaParkirA
//         // areaParkirA.tampilkanDaftarMobil();

//         // // // Mencari mobil dengan plat nomor tertentu di area parkir A
//         // String platNomorCari = "B 5678 CD";
//         // Mobil mobilDitemukan = areaParkirA.cariMobil(platNomorCari);
//         // if (mobilDitemukan != null) {
//         //     System.out.println("Mobil dengan plat nomor " + platNomorCari + " ditemukan di area parkir A. Merk: " + mobilDitemukan.getMerk());
//         // } else {
//         //     System.out.println("Mobil dengan plat nomor " + platNomorCari + " tidak ditemukan di area parkir A.");
//         // }

        
        
//          // CARA 2
//         AreaParkirA areaParkirA = new AreaParkirA();
//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             System.out.println("Menu:");
//             System.out.println("1. Tambah Mobil");
//             System.out.println("2. Hapus Mobil");
//             System.out.println("3. Cari Mobil");
//             System.out.println("4. Tampilkan Semua Mobil");
//             System.out.println("5. Keluar");
//             System.out.print("Pilih menu (1/2/3/4): ");
//             int menu = scanner.nextInt();
//             scanner.nextLine(); // Membuang karakter newline

//             switch (menu) {
//                 case 1:
//                     System.out.println("Masukkan data mobil:");
//                     System.out.print("Merk: ");
//                     String merk = scanner.nextLine();
//                     System.out.print("Warna: ");
//                     String warna = scanner.nextLine();
//                     System.out.print("Plat Nomor: ");
//                     String platNomor = scanner.nextLine();
//                     areaParkirA.tambahMobil(new Mobil(merk, warna, platNomor));
//                     break;
//                 case 2:
//                     System.out.print("Masukkan plat nomor mobil yang akan dihapus: ");
//                     String platNomorHapus = scanner.nextLine();
//                     areaParkirA.hapusMobil(platNomorHapus);
//                     break;
//                 case 3:
//                     System.out.print("Masukkan plat nomor mobil yang akan dicari: ");
//                     String platNomorCari = scanner.nextLine();
//                     Mobil mobilDitemukan = areaParkirA.cariMobil(platNomorCari);
//                     if (mobilDitemukan != null) {
//                         System.out.println("Mobil ditemukan:");
//                         System.out.println("Merk: " + mobilDitemukan.getMerk());
//                         System.out.println("Warna: " + mobilDitemukan.getWarna());
//                         System.out.println("Plat Nomor: " + mobilDitemukan.getPlatNomor());
//                     } else {
//                         System.out.println("Mobil dengan plat nomor " + platNomorCari + " tidak ditemukan.");
//                     }
//                     break;
//                 case 4:
//                     System.out.println("Daftar mobil di area parkir A:");
//                     areaParkirA.tampilkanDaftarMobil();
//                     break;
//                 case 5:
//                     System.out.println("Terima kasih!");
//                     System.exit(0);
//                 default:
//                     System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
//             }
//         }
//     }
// }