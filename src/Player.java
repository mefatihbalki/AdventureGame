import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defaultHealth;
    private int coin;
    private String name;
    private String character;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void  selectChar(){

        GameCharacter[] charList = {new Emre(), new Ilke(), new Fatih()};

        System.out.println("***********************************************************");
        for(GameCharacter gameCharacter : charList) {

            System.out.println("ID : " + gameCharacter.getId() +
                    "\t Karakter:" + gameCharacter.getName() +
                    "\t Hasar : " + gameCharacter.getDamage() +
                    "\t Sağlık :" + gameCharacter.getHealth() +
                    "\t Para:" + gameCharacter.getCoin());
        }
        System.out.println("***********************************************************");
        System.out.println("Lütfen Yola Çıkacağınız Maceracıyı Seçiniz! Örn: 1 : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Emre());
                break;
            case 2:
                initPlayer(new Ilke());
                break;
            case 3:
                initPlayer(new Fatih());
                break;
            default:
                initPlayer(new Fatih());
        }
        System.out.println(getCharacter() + " Yola Hazır ol! Macera Başlıyor!!!");
    }


    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setDefaultHealth(gameCharacter.getHealth());
        this.setCoin(gameCharacter.getCoin());
        this.setCharacter(gameCharacter.getName());


    }

    public void printInfo(){
        System.out.println(
                "*Zırhın : " + this.getInventory().getArmor().getName() +
                " *Bloklama : " + this.getInventory().getArmor().getBlock() +
                " *Silahın : " + this.getInventory().getWeapon().getName() +
                " *Hasarın : " + this.getTotalDamage() +
                " *Sağlığın : " + this.getHealth() +
                " *Paran : "  + this.getCoin());

    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
