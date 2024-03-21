import java.util.Random;

public abstract class BattleLoc extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumb =this.randomMonster();
        System.out.println("Şuan Tehlikeli Noktalardan Biri Olan " + this.getName() +"'dasınız");
        System.out.println("Etrafına Dikkatli Bak! Burada " + monsterNumb + " tane " + this.randomMonster() + this.getMonster().getName() + " Var");
        System.out.print("Savaş için (S) Kaçmak için (K) Tuşlarına Bas :");
        String selectCase = input.nextLine().toUpperCase();


        //Savaşma Durumu
        if (selectCase.equals("S") && combat(monsterNumb)){
            System.out.println("Cesaretini Taktir Ediyorum! Silahını Hazırla!!!");
            if (combat(monsterNumb)){
                System.out.println(this.getName() + getMonster().getName() + "ler Yok edildi");
                return true;
            }

        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("Allah Gani Gani Rahmet Eylesin");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumb){
        for (int i = 1; i <= monsterNumb; i++){
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("Hasar Vermek için (H) Kaçmak için (K) Tuşlarına Bas :");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")){
                    System.out.println("Canavara Hasar Verdiniz!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0){
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " Size Vurdu!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Canavalar Yokedildi!");
                System.out.println(this.getMonster().getMonsterCoin() + " Coin Envanterinize Eklendi!");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + getMonster().getMonsterCoin());
                System.out.println("Güncel Coin : " + this.getPlayer().getCoin());
            }else {
                return false;
            }
        }


        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "Canavarının Canı : " + this.getMonster().getHealth());
        System.out.println("-----------------------------------");
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri : ");
        System.out.println("***************************");
        System.out.println("Can : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Coin : " + this.getPlayer().getCoin());
        System.out.println();
    }

    public void monsterStats(int i){
        System.out.println(i + ". " + this.getMonster().getName() + "Değerleri : ");
        System.out.println("***************************");
        System.out.println("Can : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getMonsterCoin());
    }

    //Random Canavar Üretme
    public int randomMonster(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
