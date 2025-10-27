package players;

public class MainAbstract {
    public static void main(String[] args) {
        PlayerAbstract nflPlayer = new NFLPlayerAbstract("Patrick Mahomes", 5200, "Chiefs");
        PlayerAbstract nbaPlayer = new NBAPlayerAbstract("Stephen Curry", 2400, "Warriors");

        System.out.println(
                nflPlayer.getNameAbstract() + " plays " + nflPlayer.getSportAbstract() + " with stats: " + nflPlayer.getStatsAbstract());
        System.out.println(
                nbaPlayer.getNameAbstract() + " plays " + nbaPlayer.getSportAbstract() + " with stats: " + nbaPlayer.getStatsAbstract());
    }
}
