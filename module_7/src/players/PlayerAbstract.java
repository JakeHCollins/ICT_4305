package players;

public abstract class PlayerAbstract {
    protected String name;
    protected int stats;
    protected String sport;

    public PlayerAbstract(String name, int stats, String sport) {
        this.name = name;
        this.stats = stats;
        this.sport = sport;
    }

    // Concrete method
    public String getNameAbstract() {
        return name;
    }

    // Abstract methods to be implemented by the following subclasses
    public abstract int getStatsAbstract();
    public abstract String getSportAbstract();
}
    
