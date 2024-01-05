import java.util.ArrayList;
import java.util.List;

public class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFood;

    public Animal(String species, int age, List<String> favoriteFood) {
        this.species = species;
        this.age = age;
        this.favoriteFood = new ArrayList<>(favoriteFood);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFood() {
        return new ArrayList<>(favoriteFood);
    }
}
