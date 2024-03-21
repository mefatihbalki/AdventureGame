public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Dükkana Hoşgeldin!");
        boolean showMenu = true;
        while (showMenu){
           System.out.println("1 - Silah");
           System.out.println("2 - Zırh");
           System.out.println("3 - Çıkış");
           System.out.print("Ne Yapmak İstersin? : ");
           int selectStore =Location.input.nextInt();
           while (selectStore < 1 || selectStore > 3){
               System.out.println("Belirtilen Alan Dışında Seçim Yapmayınız!!!");
               selectStore = input.nextInt();
           }
           switch (selectStore){
               case 1 :
                   printWeapon();
                   buyWeapon();
                   break;
               case 2 :
                   printArmor();
                   buyArmor();
                   break;
               case 3 :
                   System.out.println(getName() + " Kesene Bereket! ");
                   showMenu = false;
                   break;

           }

       }
        return true;

    }

    public  void  printWeapon(){
        System.out.println("------- Silahlar -------");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - "+ w.getName() + " ---Coin : " + w.getPrice() + " Hasar :" + w.getDamage() +" ---");
        }
        System.out.println("0'a Basarak Silah Alım Ekranından Çıkabilirsin!");
    }

    public void buyWeapon(){
        System.out.print("Satın Almak İstediğiniz Silahı Seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Belirtilen Alan Dışında Seçim Yapmayınız!!!");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponId(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("Cepler Delik! Paran Bu silahı Almaya Yetmiyor!!!");
                } else {

                    //Silah Satın Alma işlemi
                    System.out.println(selectedWeapon.getName() + " Envanterinize Eklendi!");
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Cepteki Coinler : " + this.getPlayer().getCoin());
                    System.out.println("Önceki Silahın :" + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız :" + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public  void  printArmor(){
        System.out.println("------- Zırhlar -------");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " ---Coin : " + a.getPrice() + " Zırh : " + a.getBlock() + " ---");
        }
        System.out.println("0'a Basarak Zırh Alım Ekranından Çıkabilirsin!");

    }

    public void buyArmor(){
        System.out.print("Satın Almak İstediğiniz Zırhı Seçiniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length){
            System.out.println("Belirtilen Alan Dışında Seçim Yapmayınız!!!");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorId(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("Cepler Delik! Paran Bu Zırhı Almaya Yetmiyor!!!");
                } else {

                    //Zırh Satın Alma işlemi
                    System.out.println(selectedArmor.getName() + " Envanterinize Eklendi!");
                    int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Cepteki Coinler : " + this.getPlayer().getCoin());
                    System.out.println("Önceki Zırhın :" + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhın :" + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }

}
