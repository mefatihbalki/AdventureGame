public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Eve Hoşgeldin!");
        System.out.println("Sen Soluklanırken Ben de Yaralarını Sarayım...");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
