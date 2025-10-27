package players;

public class NBAPlayer implements Player {
    private String name;
    private int points; // example of stat
    private String team;

    public NBAPlayer(String name, int points, String team) {
        this.name = name;
        this.points = points;
        this.team = team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStats() {
        return points;
    }

    @Override
    public String getSport() {
        return "Basketball (NBA)";
    }

    public String getTeam() {
        return team;
    }
}
