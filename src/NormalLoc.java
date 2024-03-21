public abstract class NormalLoc extends Location{

    public NormalLoc(Player player, String name){
        super(player,name);
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Eve Hoşgeldin!");
        System.out.println("Biraz Soluklan Ben de O sırada Yaralarını Sarayım");
        return true;
    }
}
