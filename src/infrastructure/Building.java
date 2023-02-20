package infrastructure;

 import java.util.Objects;

public abstract class Building {
    protected Location location;
    protected int playerId;

    public Building(){
        this.playerId = 0;
    }

    public int getPlayerId(){return  this.playerId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;

        Building building = (Building) o;

        if (playerId != building.playerId) return false;
        return location.equals(building.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
