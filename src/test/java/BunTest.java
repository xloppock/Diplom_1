import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;  // Импортируем только Bun
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тест {index}: Булочка {0} с ценой {1}")
    public static Collection<Object[]> data() {
        return TestData.getAllBunTestData();
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(expectedName, expectedPrice);

        if (expectedName == null) {
            assertNull(bun.getName());
        } else {
            assertEquals(expectedName, bun.getName());
        }
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.001f);
    }

    @Test
    public void testPublicFields() {
        Bun bun = new Bun(expectedName, expectedPrice);

        if (expectedName == null) {
            assertNull(bun.name);
        } else {
            assertEquals(expectedName, bun.name);
        }

        assertEquals(expectedPrice, bun.price, 0.001f);
    }

    @Test
    public void testBunWithNullName() {
        Bun bun = new Bun(null, 100.0f);
        assertNull(bun.getName());
        assertNull(bun.name);
        assertEquals(100.0f, bun.getPrice(), 0.001f);
    }
}