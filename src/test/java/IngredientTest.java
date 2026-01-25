import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тест {index}: {0} {1} цена {2}")
    public static Collection<Object[]> data() {
        return TestData.getAllIngredientTestData();
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        if (expectedName == null) {
            assertNull(ingredient.getName());
        } else {
            assertEquals(expectedName, ingredient.getName());
        }
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testPublicFields() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        assertEquals(expectedType, ingredient.type);

        if (expectedName == null) {
            assertNull(ingredient.name);
        } else {
            assertEquals(expectedName, ingredient.name);
        }

        assertEquals(expectedPrice, ingredient.price, 0.001f);
    }
}