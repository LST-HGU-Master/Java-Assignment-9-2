# 課題 9-2: オーバーライドと親インスタンス部分の呼び出し

### 課題の説明
`InvisibleHero`は姿を現しているときは通常の攻撃を行うが、姿を消しているときは「見えない攻撃」を行う。<br>
これを表現するために、課題9-1で作成した`InvisibleHero`クラスに以下に示す`attack`メソッドを追加しなさい。

追加するメソッドと仕様
| メソッド名    | 引数のリスト  | 戻り値 | 処理内容                                                                           |
|--------|---------|-----|--------------------------------------------------------------------------------|
| `attack` | `Slime s` | なし | `isVisible`の状態に応じて攻撃処理を分岐する(詳細は下記を参照)。 |

【処理詳細】
１．`isVisible == true`（姿が見えている）の場合:<br>
　・親クラス `Hero` の `attack(s)` メソッドを呼び出す（`super.attack(s);` を使用）。<br>
２．`isVisible == false`（姿を消している）の場合:<br>
　・`"工太は見えない攻撃をした！"` と表示する。<br>
　・`"敵に10ポイントのダメージをあたえた！"` と表示する。<br>
　・引数のスライム `s` の `hp` を 10 減少させる（`s.hp -= 10;`）。

### 動作確認用クラス (これらのコードの提出は不要)
・Prog92.java
```java
public class Prog92 {

    public static void main(String[] args) {
        InvisibleHero h = new InvisibleHero();
        Slime s = new Slime('A');
        h.attack(s);        // 1. 姿が見えている状態での攻撃（親クラスのattack）
        h.getInvisible();   // 2. 姿を消す（課題9-1の動的ステルスレベル出力）
        h.attack(s);        // 3. 姿を消した状態での攻撃（見えない攻撃）
    }

}
```

・Hero.java
```java
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
```

・Slime.java
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
敵に5ポイントのダメージをあたえた！
勇者工太は姿を消した！（ステルスレベル:2）  ← ※学籍番号(例:4724301)に応じた動的出力
工太は見えない攻撃をした！
敵に10ポイントのダメージをあたえた！
```
