import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class InvisibleHeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        InvisibleHero h = new InvisibleHero();

        // assertion
        assertTrue(h instanceof Hero);
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
        // assertion
        assertTrue(h.isVisible);

        // action
        h.attack(m);

        // assertion
        assertEquals(13, m.hp);
        assertEquals("工太は攻撃した！\n敵に５ポイントのダメージをあたえた！\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
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

        // assertion
        assertEquals(8, m.hp);
        assertEquals("工太は見えない攻撃をした！\n敵に10ポイントのダメージをあたえた！\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}
