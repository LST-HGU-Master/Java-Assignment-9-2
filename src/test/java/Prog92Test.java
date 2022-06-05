import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220604)
 **/
public class Prog92Test {

    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        Prog92.main(null);
        // undo the binding in System
        System.setOut(originalOut);
        
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);

        try {
            assertEquals("工太は攻撃した！", prints[0]);
            assertEquals("敵に5ポイントのダメージをあたえた！", prints[1]);
            assertEquals("勇者工太は姿を消した！", prints[2]);
            assertEquals("工太は見えない攻撃をした！", prints[3]);
            assertEquals("敵に10ポイントのダメージをあたえた！", prints[4]);
        } catch (ArrayIndexOutOfBoundsException excpt) {
            fail("Prog92.main()のprint出力が5行ではありません!");
        }
        assertEquals(6,prints.length,"改行数が6つ以上あります!"); // このif文に到達した時点で prints.lengthは6以上になっている
    }
}
