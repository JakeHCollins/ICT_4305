package players;

public class NBAPlayerAbstract extends PlayerAbstract {

    private String team;

    public NBAPlayerAbstract(String name, int points, String team) {
        super(name, points, "Basketball (NBA)");
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
