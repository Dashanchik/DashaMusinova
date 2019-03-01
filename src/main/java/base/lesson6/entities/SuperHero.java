package base.lesson6.entities;

import java.util.Objects;

public class SuperHero {
    private Integer number;
    private String user;
    private String description;

    public SuperHero(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return Objects.equals(number, superHero.number) &&
                Objects.equals(user, superHero.user) &&
                Objects.equals(description, superHero.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "number=" + number +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
