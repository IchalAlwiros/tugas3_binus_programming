import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Mobil {
    private String merk;
    private String warna;
    private String platNomor;
    private LocalDateTime checkin;
    private LocalDateTime checkout;

    // Konstruktor dengan parameter
    public Mobil(String merk, String warna, String platNomor) {
        this.merk = merk;
        this.warna = warna;
        this.platNomor = platNomor;
    }

    // Konstruktor default
    public Mobil() {
        // Default constructor tidak melakukan apa-apa di sini
    }

    // Metode getter dan setter
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    // Metode untuk mengatur check-in menggunakan string format "YYYY-MM-DD HH:mm"
    public void setCheckin(String checkin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.checkin = LocalDateTime.parse(checkin, formatter);
    }

    // Metode untuk mengatur check-out menggunakan string format "YYYY-MM-DD HH:mm"
    public void setCheckout(String checkout) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.checkout = LocalDateTime.parse(checkout, formatter);
    }

    // Metode untuk mendapatkan string format check-in
    public String getFormattedCheckin() {
        if(checkin != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return checkin.format(formatter);
        } else {
            return "Belum checkin";
        }
    }

    // Metode untuk mendapatkan string format check-out
    public String getFormattedCheckout() {
         if(checkout != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return checkout.format(formatter);
         } else {
            return "Belum checkout";
         }
    }
}


class Parking {
    private String areas;
    private int seat;

    public Parking(String areas, int seat) {
        this.areas = areas;
        this.seat = seat;
    }

    public void parkingArea() {
        System.out.println("Area Parking " + areas);
    }

    // Getter dan setter
    public String getParkingArea() {
        return areas;
    }

    public void setParkingArea(String areas) {
        this.areas = areas;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}


class AreaParkirA extends Parking {
    private ArrayList<Mobil> daftarMobil;

   public AreaParkirA(String areas, int seat) {
        super(areas, seat);
        this.daftarMobil = new ArrayList<>();
    }

    public void tambahMobil(Mobil mobil) {
        String platNomor = mobil.getPlatNomor();
        
        // Cek apakah mobil dengan nomor plat yang sama sudah ada dalam daftar dan belum checkout
        for (Mobil mobilDiDaftar : daftarMobil) {
            if (mobilDiDaftar.getPlatNomor().equals(platNomor) && mobilDiDaftar.getCheckout() == null) {
                System.out.println("Mobil dengan nomor plat " + platNomor + " masih berada di dalam area parkir.");
                return; // Keluar dari metode jika mobil masih berada di dalam area parkir
            }
        }
        
        mobil.setCheckin(LocalDateTime.now());
        daftarMobil.add(mobil);
        tampilkanDaftarMobil();
    }

    public void hapusMobil(String platNomor) {
        Mobil mobil = cariMobil(platNomor);
        if (mobil != null) {
            mobil.setCheckout(LocalDateTime.now());
            tampilkanDaftarMobil();
        } else {
            System.out.println("Mobil dengan plat nomor " + platNomor + " tidak ditemukan di area parkir A.");
        }
    }

    public Mobil cariMobil(String platNomor) {
        for (Mobil mobil : daftarMobil) {
            if (mobil.getPlatNomor().equals(platNomor)) {
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                System.out.println("|      Merk        |      Warna       |   Plat Nomor     |     Check In     |    Check Out     |");
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", mobil.getMerk(), mobil.getWarna(), mobil.getPlatNomor(), mobil.getFormattedCheckin(), mobil.getFormattedCheckout());
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                return mobil;
            }
        }
        
        System.out.println("+--------------------------------------------------+");
        System.out.println(String.format("|      Mobil tidak ditemukan di Parkir %s      |", super.getParkingArea()));
        System.out.println("+--------------------------------------------------+");
        return null;
    
    }

    public void tampilkanDaftarMobil() {
        if (daftarMobil.isEmpty()) {
            System.out.println("=[ Area Parkir " + super.getParkingArea() + " Kosong ]=");
        } else {
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            System.out.println("|                                   [ " + "AREA PARKIR " + super.getParkingArea() + " ]                                     |");
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            System.out.println("|      Merk        |      Warna       |   Plat Nomor     |     Check In     |    Check Out     |");
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            for (Mobil mobil : daftarMobil) {
                System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", mobil.getMerk(), mobil.getWarna(), mobil.getPlatNomor(), mobil.getFormattedCheckin(), mobil.getFormattedCheckout());
            }
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
        }
    }
}

class AreaParkirB extends Parking {
    private ArrayList<Mobil> daftarMobil;

   public AreaParkirB(String areas, int seat) {
        super(areas, seat);
        this.daftarMobil = new ArrayList<>();
    }

    public void tambahMobil(Mobil mobil) {
        String platNomor = mobil.getPlatNomor();
        
        // Cek apakah mobil dengan nomor plat yang sama sudah ada dalam daftar dan belum checkout
        for (Mobil mobilDiDaftar : daftarMobil) {
            if (mobilDiDaftar.getPlatNomor().equals(platNomor) && mobilDiDaftar.getCheckout() == null) {
                System.out.println("Mobil dengan nomor plat " + platNomor + " masih berada di dalam area parkir.");
                return; // Keluar dari metode jika mobil masih berada di dalam area parkir
            }
        }
        
        mobil.setCheckin(LocalDateTime.now());
        daftarMobil.add(mobil);
        tampilkanDaftarMobil();
    }

    public void hapusMobil(String platNomor) {
        Mobil mobil = cariMobil(platNomor);
        if (mobil != null) {
            mobil.setCheckout(LocalDateTime.now());
            tampilkanDaftarMobil();
        } else {
            System.out.println("Mobil dengan plat nomor " + platNomor + " tidak ditemukan di area parkir A.");
        }
    }

    public Mobil cariMobil(String platNomor) {
        for (Mobil mobil : daftarMobil) {
            if (mobil.getPlatNomor().equals(platNomor)) {
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                System.out.println("|      Merk        |      Warna       |   Plat Nomor     |     Check In     |    Check Out     |");
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", mobil.getMerk(), mobil.getWarna(), mobil.getPlatNomor(), mobil.getFormattedCheckin(), mobil.getFormattedCheckout());
                System.out.println("+------------------+------------------+------------------+------------------+------------------+");
                return mobil;
            }
        }
        
        System.out.println("+--------------------------------------------------+");
        System.out.println(String.format("|      Mobil tidak ditemukan di Parkir %s      |", super.getParkingArea()));
        System.out.println("+--------------------------------------------------+");
        return null;
    
    }

    public void tampilkanDaftarMobil() {
        if (daftarMobil.isEmpty()) {
            System.out.println("=[ Area Parkir " + super.getParkingArea() + " Kosong ]=");
        } else {
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            System.out.println("|                                   [ " + "AREA PARKIR " + super.getParkingArea() + " ]                                     |");
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            System.out.println("|      Merk        |      Warna       |   Plat Nomor     |     Check In     |    Check Out     |");
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
            for (Mobil mobil : daftarMobil) {
                System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", mobil.getMerk(), mobil.getWarna(), mobil.getPlatNomor(), mobil.getFormattedCheckin(), mobil.getFormattedCheckout());
            }
            System.out.println("+------------------+------------------+------------------+------------------+------------------+");
        }
    }
}




public class newMain {
    public static void main(String[] args) {


        AreaParkirA areaA = new AreaParkirA("Area A", 10);
        AreaParkirB areaB = new AreaParkirB("Area B", 10);
        // Scanner scanner = new Scanner(System.in);
        
        Scanner scanner = new Scanner(System.in);

      
            System.out.println("Menu:");
            System.out.println("1. Area A");
            System.out.println("2. Area B");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");
            int pilihanArea = scanner.nextInt();
            // scanner.nextLine(); // Membuang karakter newline

            switch (pilihanArea) {
                case 1:
                    handleAreaA(areaA);
                    break;
                case 2:
                    handleAreaB(areaB);
                    break;
                case 3:
                    System.out.println("Terima kasih! Telah Menggunakan System Parkir");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
            }
        
        // Membuat beberapa objek Mobil
        // Mobil mobil1 = new Mobil("Toyota", "Hitam", "B 1234 CD");
        // Mobil mobil2 = new Mobil("Honda", "Merah", "B 5678 EF");

        // Menambahkan mobil ke dalam area parkir
        // areaA.tambahMobil(mobil1);
        // areaA.tambahMobil(mobil2);

        // Melakukan pencarian mobil berdasarkan plat nomor
        // areaA.cariMobil("B 1234 CD");
        
    }
    
     public static void handleAreaA(AreaParkirA areaA) {
        // Logika untuk menangani area A
        System.out.println("[ Anda memilih Area A ]");
        // AreaParkirA areaA = new AreaParkirA("Area A", 10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Checkin Mobil");
            System.out.println("2. Checkout Mobil");
            System.out.println("3. Cari Mobil");
            System.out.println("4. Tampilkan Semua Mobil");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline

            switch (menu) {
                case 1:
                    System.out.println("Masukkan data mobil:");
                    System.out.print("Merk: ");
                    String merk = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warna = scanner.nextLine();
                    System.out.print("Plat Nomor: ");
                    String platNomor = scanner.nextLine();
                    areaA.tambahMobil(new Mobil(merk, warna, platNomor));
                    break;
                case 2:
                    System.out.print("Masukkan plat nomor mobil yang akan dihapus: ");
                    String platNomorHapus = scanner.nextLine();
                    areaA.hapusMobil(platNomorHapus);
                    break;
                case 3:
                    System.out.print("Masukkan plat nomor mobil yang akan dicari: ");
                    String platNomorCari = scanner.nextLine();
                    Mobil mobilDitemukan = areaA.cariMobil(platNomorCari);
                    break;
                case 4:
                    System.out.println("Daftar mobil di area parkir A:");
                    areaA.tampilkanDaftarMobil();
                    break;
                case 5:
                    // System.out.println("Terima kasih! Telah Menggunakan System Parkir");
                    // System.exit(0);
                    main(null); 
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
    }

    public static void handleAreaB(AreaParkirB areaB) {
        // Logika untuk menangani area B
        System.out.println("Anda memilih Area B");
        // AreaParkirB areaB = new AreaParkirB("Area B", 10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Checkin Mobil");
            System.out.println("2. Checkout Mobil");
            System.out.println("3. Cari Mobil");
            System.out.println("4. Tampilkan Semua Mobil");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline

            switch (menu) {
                case 1:
                    System.out.println("Masukkan data mobil:");
                    System.out.print("Merk: ");
                    String merk = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warna = scanner.nextLine();
                    System.out.print("Plat Nomor: ");
                    String platNomor = scanner.nextLine();
                    areaB.tambahMobil(new Mobil(merk, warna, platNomor));
                    break;
                case 2:
                    System.out.print("Masukkan plat nomor mobil yang akan dihapus: ");
                    String platNomorHapus = scanner.nextLine();
                    areaB.hapusMobil(platNomorHapus);
                    break;
                case 3:
                    System.out.print("Masukkan plat nomor mobil yang akan dicari: ");
                    String platNomorCari = scanner.nextLine();
                    Mobil mobilDitemukan = areaB.cariMobil(platNomorCari);
                    break;
                case 4:
                    System.out.println("Daftar mobil di area parkir A:");
                    areaB.tampilkanDaftarMobil();
                    break;
                case 5:
                    // System.out.println("Terima kasih! Telah Menggunakan System Parkir");
                    main(null); 
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
    }
}
