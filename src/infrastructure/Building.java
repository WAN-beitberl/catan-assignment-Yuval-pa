package infrastructure;

 import java.util.Objects;

public abstract class Building {
    protected Location location;
    protected int playerId;
    protected boolean isVisible;

    private Building(){
        this.playerId = 0;
        this.isVisible = false;
    }
    public Building(Location location) {
        this();
        this.location = location;
    }

    /**
     * @return The location of the building
     */
    public Location getLocation(){
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;

        Building building = (Building) o;

        if (playerId != building.playerId) return false;
        if (isVisible != building.isVisible) return false;
        return location.equals(building.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
