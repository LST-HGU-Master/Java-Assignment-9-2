import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
/**
 * @version (20220604)
 * @version (2026Nov24)
 **/
public class Prog92Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
    
    @Test
    public void testMain()
    {
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        Prog92.main(null);
        
        // assertion
        String[] prints = outContent.toString().split("\r\n|\n", -1);

        if (prints.length < 5) {
            fail("Prog92.main() の print 出力が 5 行ではありません！（実際の出力行数: " + (prints.length - 1) + "行）");
        }


        String expectedLine3 = "勇者工太は姿を消した！";

        // 各行のアサーション
        assertEquals("工太は攻撃した！", prints[0], "1行目の出力（通常攻撃）が異なります。");
        assertEquals("敵に5ポイントのダメージをあたえた！", prints[1], "2行目の出力（通常ダメージ）が異なります。");
        assertEquals(expectedLine3, prints[2], "3行目の出力（姿を消す）が異なります。");
        assertEquals("工太は見えない攻撃をした！", prints[3], "4行目の出力（見えない攻撃）が異なります。");
        assertEquals("敵に10ポイントのダメージをあたえた！", prints[4], "5行目の出力（見えない攻撃ダメージ）が異なります。");

        assertEquals(6, prints.length, "改行数が正しくありません（余分な print があるか、末尾改行が不足しています）。");
    }
}
