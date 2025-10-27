package players;

public class NFLPlayerAbstract extends PlayerAbstract {

    private String team;

    public NFLPlayerAbstract(String name, int yards, String team) {
        super(name, yards, "Football (NFL)");
        this.team = team;
    }

    @Override
    public int getStatsAbstract() {
        return stats;
    }

    @Override
    public String getSportAbstract() {
        return sport;
    }

    public String getTeam() {
        return team;
    }
}
