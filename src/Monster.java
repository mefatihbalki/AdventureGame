public class Monster {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int monsterCoin;

    private int defaultHealth;

    public Monster(String name, int id, int damage, int health, int monsterCoin) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defaultHealth =defaultHealth;
        this.name = name;
        this.monsterCoin = monsterCoin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonsterCoin() {
        return monsterCoin;
    }

    public void setMonsterCoin(int monsterCoin) {
        this.monsterCoin = monsterCoin;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
