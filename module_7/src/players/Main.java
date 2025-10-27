package players;

public class Main {
    public static void main(String[] args) {
        Player nflPlayer = new NFLPlayer("Tom Brady", 4500, "Patriots");
        Player nbaPlayer = new NBAPlayer("LeBron James", 2000, "Lakers");

        System.out.println(
                nflPlayer.getName() + " plays " + nflPlayer.getSport() + " with stats: " + nflPlayer.getStats());
        System.out.println(
                nbaPlayer.getName() + " plays " + nbaPlayer.getSport() + " with stats: " + nbaPlayer.getStats());
    }
}
