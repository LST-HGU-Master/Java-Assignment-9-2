public class Prog92 {

	public static void main(String[] args) {
		InvisibleHero h = new InvisibleHero();
		Slime s = new Slime('A');
        h.attack(s);        // 1. 姿が見えている状態での攻撃（親クラスのattack）
        h.getInvisible();   // 2. 姿を消す
        h.attack(s);        // 3. 姿を消した状態での攻撃（見えない攻撃）
	}

}

