public abstract class GameCharacter {
    private int id;
    private String name;
    private int damage;
    private  int health;
    private  int Coin;

    public GameCharacter(int id,String name, int damege, int health, int coin) {
        this.id = id;
        this.damage = damege;
        this.health = health;
        this.Coin = coin;
        this.name=name;
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
        this.health = health;
    }

    public int getCoin() {
        return Coin;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
