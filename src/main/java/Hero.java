public class Hero
{
    String name = "工太";
    int hp=100;

    public void attack(Slime s) //戦う
    {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
        s.hp -= 5;
    }
}
