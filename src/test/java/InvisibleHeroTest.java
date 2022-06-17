import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @version (20220617)
 * 注意）

 **/
public class InvisibleHeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        InvisibleHero h = new InvisibleHero();

        // assertion
        assertTrue(h instanceof Hero,"InvisibleHeroはHeroを継承していません!");
    }

    @Test
    public void testAttackWhenVisible()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        InvisibleHero h = new InvisibleHero();
        Slime m = new Slime('A');
        try {
            // assertion
            assertTrue(h.isVisible,"InvisibleHeroインスタンスのisVisibleの初期値ががfalseです!");
        } catch (AssertionError err) {
            System.setOut(originalOut);
            throw err;
        }
        // action
        try {
            h.attack(m);
        } catch (StackOverflowError sofe) {
            fail("InvisibleHero.attack()メソッド内でthis.attack(スライムクラスのインスタンス)としてはいけません!");
        }
        // undo the binding in System
        System.setOut(originalOut);
        // assertion        
        String[] prints = bos.toString().split("\r\n|\n", -1);
        assertEquals(13, m.hp,"isVisibleがtrue時のattack()呼び出し後のhp変化量が指定と異なります!");
        assertEquals("工太は攻撃した！",prints[0],"print出力が実行例と異なります!");
        assertEquals("敵に5ポイントのダメージをあたえた！", prints[1],"print出力が実行例と異なります!");
        assertEquals(3,prints.length,"改行が3つ以上あります!");
    }

    @Test
    public void testAttackWhenInvisible()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        InvisibleHero h = new InvisibleHero();
        Slime m = new Slime('A');
        h.isVisible = false;
        h.attack(m);
        // undo the binding in System
        System.setOut(originalOut);
        String[] prints = bos.toString().split("\r\n|\n", -1);
        // assertion
        try {
            assertEquals(8, m.hp,"isVisibleがfalse時のattack()呼び出し後のhp変化量が指定と異なります!");
            assertEquals("工太は見えない攻撃をした！", prints[0],"print出力が実行例と異なります!");
            assertEquals("敵に10ポイントのダメージをあたえた！", prints[1],"print出力が実行例と異なります!");
            assertEquals(3,prints.length,"改行が3つ以上あります!");
        }catch (IndexOutOfBoundsException err) {
            fail("Prog81.main()のprint出力行数が２ではありません!");
        }
        assertEquals(3,prints.length,"改行が3つ以上あります!");
    }
}
