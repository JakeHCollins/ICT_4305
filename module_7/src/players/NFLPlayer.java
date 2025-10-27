package players;

public class NFLPlayer implements Player {
    private String name;
    private int yards; // example of stat
    private String team;

    public NFLPlayer(String name, int yards, String team) {
        this.name = name;
        this.yards = yards;
        this.team = team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStats() {
        return yards;
    }

    @Override
    public String getSport() {
        return "Football (NFL)";
    }

    public String getTeam() {
        return team;
    }
}
