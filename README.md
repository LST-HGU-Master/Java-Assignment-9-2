# 課題 9-2: オーバーライドと親インスタンス部分の呼び出し

### 課題の説明
InvisibleHeroは姿を現しているときは通常の攻撃をするが、 消しているときは見えない攻撃ができる。
これを表現するために、課題9-1で作成したInvisibleHeroクラスに以下に示すattackメソッドを追加しなさい。


| 変数名    | 引数のリスト  | 戻り値 | 処理内容                                                                           |
|--------|---------|-----|--------------------------------------------------------------------------------|
| attack | Slime s | なし | isVisibleがTrueのときは親クラスの通常のattackをよびだす。Falseのときは見えない攻撃をしたと表示し、スライムに10のダメージを与える。 |



### Prog92、Hero、Slimeクラス (提出不要)
```java
public class Prog92 {

	public static void main(String[] args) {
		SuperHero h = new SuperHero();
		Slime s = new Slime('A');
		h.attack(s);
		h.getInvisible();
		h.attack(s);
	}

}
```

```java
public class Hero
{
    String name = "工太";
    int hp=100;

    public void attack(Slime m) //戦う
    {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に５ポイントのダメージをあたえた！");
        m.hp -= 5;
    }
}
```

```java
public class Slime
{
    int hp = 18;
    char suffix;

    Slime(char suffx){
        this.suffix = suffx;
    }

    public void attack(Hero h)
    {
        int damage = 5;

        System.out.println("スライム" + this.suffix + "の攻撃！");
        h.hp -= damage;
        System.out.println( damage + "のダメージでHPが" + h.hp + "になった");
    }
}
```
### 実行例
```
工太は攻撃した！
敵に５ポイントのダメージをあたえた！
勇者工太は姿を消した!
工太は見えない攻撃をした！
敵に10ポイントのダメージをあたえた！
```