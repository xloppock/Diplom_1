import praktikum.*;  // Импортируем все классы из пакета praktikum
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Object[]> getDatabaseBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Object[]> params = new ArrayList<>();
        for (Bun bun : buns) {
            params.add(new Object[]{bun.getName(), bun.getPrice()});
        }
        return params;
    }

    public static List<Object[]> getAdditionalBuns() {
        return Arrays.asList(new Object[][]{
                {"", 0.0f},
                {"Тестовая", -50.0f},
                {null, 100.0f},
                {"Очень длинное название", 999.99f},
                {"Булочка с символом $%^", 150.5f}
        });
    }

    public static List<Object[]> getAllBunTestData() {
        List<Object[]> allData = new ArrayList<>();
        allData.addAll(getDatabaseBuns());
        allData.addAll(getAdditionalBuns());
        return allData;
    }

    public static List<Object[]> getDatabaseIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Object[]> params = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            params.add(new Object[]{
                    ingredient.getType(),
                    ingredient.getName(),
                    ingredient.getPrice()
            });
        }
        return params;
    }

    public static List<Object[]> getAdditionalIngredients() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "", 0.0f},
                {IngredientType.SAUCE, null, 100.0f},
                {IngredientType.SAUCE, "Соус", -50.0f},
                {IngredientType.SAUCE, "Очень длинное название соуса для теста", 150.5f},
                {IngredientType.FILLING, "", 0.0f},
                {IngredientType.FILLING, null, 200.0f},
                {IngredientType.FILLING, "Начинка", -100.0f},
                {IngredientType.FILLING, "Специальная начинка с уникальным вкусом", 999.99f},
                {IngredientType.SAUCE, "Дорогой соус", Float.MAX_VALUE},
                {IngredientType.FILLING, "Дешевая начинка", Float.MIN_VALUE},
                {IngredientType.SAUCE, "Соус !@#$%^&*()", 100.0f},
                {IngredientType.FILLING, "Начинка & название", 200.0f}
        });
    }

    public static List<Object[]> getAllIngredientTestData() {
        List<Object[]> allData = new ArrayList<>();
        allData.addAll(getDatabaseIngredients());
        allData.addAll(getAdditionalIngredients());
        return allData;
    }

    public static List<Object[]> getIngredientTypeTestData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }
}