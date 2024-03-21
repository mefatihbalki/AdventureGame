import java.util.Scanner;
public class Game {

    private Scanner input = new Scanner(System.in);

    public void  Start(){
        System.out.println("En Korkunç Dehlizlerden, Amansız Karanlık Ormanlara Koşacağınız Macera Oyununa Hoşgelginiz");
        System.out.print("Maceracının İsmi Nedir? : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Oyuna Hoşgeldin. Buradan Çıkışa Doğru Uzun Bir Yol var. Bu Yol da Asla Yalnız Olmayacaksın!");
        System.out.println("Karakterini Oluşturalım. İlgini Çeken Hangisi?");
        System.out.println("***********************************************************");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("-----Bölgeler-----");
            System.out.println();
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Tehlikeli Diyarlar ==> Mağara");
            System.out.println("4 - Tehlikeli Diyarlar ==> Orman");
            System.out.println("5 - Tehlikeli Diyarlar ==> Kayalık");
            System.out.println("0 - Oyundan Çık");

            System.out.println("Gitmek İstediğin Yeri Seçmelisin!: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new Rock(player);
                    break;
                default:
                    System.out.println("Gidebileceğin Tek Yer Gördüklerin. Onlardan Birini Seç!");
            }
            if (location == null){
                System.out.println("Maceradan Kaçma ! Mutlaka Geri Gel !!!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Yaralarınız Çok Ağır. Hayata Gözlerinizi Yumdunuz!!!");
                break;
            }

        }

    }
}
