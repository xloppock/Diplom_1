import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;
    private final String expectedName;

    public IngredientTypeTest(IngredientType type, String expectedName) {
        this.type = type;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return TestData.getIngredientTypeTestData();
    }

    @Test
    public void testToString() {
        assertEquals(expectedName, type.toString());
    }

    @Test
    public void testValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }

    @Test
    public void testValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalid() {
        IngredientType.valueOf("INVALID_TYPE");
    }
}