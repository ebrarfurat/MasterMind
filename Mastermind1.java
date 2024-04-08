import java.util.Random;
import java.util.Scanner;

public class Mastermind1 {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        
        int sayi;
        do {
            int binler = random.nextInt(9) + 1;
            int yuzler = random.nextInt(10);
            int onlar = random.nextInt(10);
            int birler = random.nextInt(10);

            sayi = binler * 1000 + yuzler * 100 + onlar * 10 + birler;
        } while (!rakamlarFarkliMi(sayi));
        
      
        int tahminSayisi = 0;

        System.out.println("Dört basamaklı bir sayı tuttum. Lütfen bulmaya çalışın");
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "nci Tahmininiz:");
            int tahmin = scan.nextInt();
            
            tahminSayisi++;
            if(TahminBulma(tahmin, sayi)) {
            	System.out.println("TEBRİKLER " + tahminSayisi + "NCİ TAHMİNDE BİLDİNİZ");
                break;
            }
        }

    }

    public static boolean TahminBulma(int tahmin, int sayi) {
        int binler1 = sayi / 1000;
        int yuzler1 = sayi / 100 % 10;
        int onlar1 = sayi / 10 % 10;
        int birler1 = sayi % 10;
        int n1 = 0;
        int n2 = 0;
        int binler2 = tahmin / 1000;
        int yuzler2 = tahmin / 100 % 10;
        int onlar2 = tahmin / 10 % 10;
        int birler2 = tahmin % 10;
        if (tahmin > 999 && tahmin < 10000 && binler2 != yuzler2 && binler2 != onlar2 && binler2 != birler2 && birler2 != yuzler2 && birler2 != onlar2 && onlar2 != yuzler2) {
            if (sayi == tahmin) {
                return true;
            } else {
               
                if (binler1 == binler2) {
                    n1++;
                }
                if (yuzler1 == yuzler2) {
                    n1++;
                }
                if (onlar1 == onlar2) {
                    n1++;
                }
                if (birler1 == birler2) {
                    n1++;
                }
                if (binler1 == yuzler2 || binler1 == onlar2 || binler1 == birler2) {
                    n2--;
                }
                if (yuzler1 == binler2 || yuzler1 == onlar2 || yuzler1 == birler2) {
                    n2--;
                }
                if (onlar1 == binler2 || onlar1 == yuzler2 || onlar1 == birler2) {
                    n2--;
                }
                if (birler1 == binler2 || birler1 == yuzler2 || birler1 == onlar2) {
                    n2--;
                }
                
                System.out.println("+" + n1 + "," + n2);
            }
        } else {
            System.out.println("Geçerli bir sayı giriniz.");
        }
        return false;
    }
    public static boolean rakamlarFarkliMi(int sayi) {
        int binler = sayi / 1000 % 10;
        int yuzler = sayi / 100 % 10;
        int onlar = sayi / 10 % 10;
        int birler = sayi % 10;

        return binler != yuzler && binler != onlar && binler != birler && yuzler != onlar && yuzler != birler && onlar != birler;
    }
}
