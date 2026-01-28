import org.junit.Test;
import praktikum.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PraktikumTest {

    @Test
    public void testMainMethod() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(bos));

            Praktikum.main(new String[]{});

            String output = bos.toString();

            assertTrue("Вывод должен содержать название булочки",
                    output.contains("black bun") || output.contains("white bun") || output.contains("red bun"));
            assertTrue("Вывод должен содержать Price:", output.contains("Price:"));
            assertTrue("Вывод должен содержать ингредиенты",
                    output.contains("sauce") || output.contains("filling"));

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMainMethodNoExceptions() {
        try {
            Praktikum.main(new String[]{});
        } catch (Exception e) {
            fail("Main method should not throw exceptions: " + e.getMessage());
        }
    }
}