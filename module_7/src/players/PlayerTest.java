package players;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player nflPlayer;
    private Player nbaPlayer;

    @BeforeEach
    public void setUp() {
        nflPlayer = new NFLPlayer("Tom Brady", 4500, "Patriots");
        nbaPlayer = new NBAPlayer("LeBron James", 2000, "Lakers");
    }

    @Test
    public void testPolymorphism() {
        assertInstanceOf(Player.class, nflPlayer, "NFLPlayer should implement Player interface");
        assertInstanceOf(Player.class, nbaPlayer, "NBAPlayer should implement Player interface");
    }

    @Test
    public void testNFLPlayerName() {
        assertEquals("Tom Brady", nflPlayer.getName(), "NFLPlayer should return correct name");
    }

    @Test
    public void testNFLPlayerStats() {
        assertEquals(4500, nflPlayer.getStats(), "NFLPlayer should return correct stats (yards)");
    }

    @Test
    public void testNFLPlayerSport() {
        assertEquals("Football (NFL)", nflPlayer.getSport(), "NFLPlayer should return correct sport");
    }

    @Test
    public void testNFLPlayerTeam() {
        NFLPlayer player = (NFLPlayer) nflPlayer;
        assertEquals("Patriots", player.getTeam(), "NFLPlayer should return correct team");
    }

    @Test
    public void testNBAPlayerName() {
        assertEquals("LeBron James", nbaPlayer.getName(), "NBAPlayer should return correct name");
    }

    @Test
    public void testNBAPlayerStats() {
        assertEquals(2000, nbaPlayer.getStats(), "NBAPlayer should return correct stats (points)");
    }

    @Test
    public void testNBAPlayerSport() {
        assertEquals("Basketball (NBA)", nbaPlayer.getSport(), "NBAPlayer should return correct sport");
    }

    @Test
    public void testNBAPlayerTeam() {
        NBAPlayer player = (NBAPlayer) nbaPlayer;
        assertEquals("Lakers", player.getTeam(), "NBAPlayer should return correct team");
    }

    @Test
    public void testPlayerInterfaceContract() {
        assertNotNull(nflPlayer.getName(), "getName() should not return null");
        assertNotNull(nflPlayer.getSport(), "getSport() should not return null");
        assertTrue(nflPlayer.getStats() >= 0, "getStats() should return valid value");

        assertNotNull(nbaPlayer.getName(), "getName() should not return null");
        assertNotNull(nbaPlayer.getSport(), "getSport() should not return null");
        assertTrue(nbaPlayer.getStats() >= 0, "getStats() should return valid value");
    }

    @Test
    public void testDifferentImplementations() {
        assertNotEquals(nflPlayer.getSport(), nbaPlayer.getSport(),
                "Different player types should have different sports");
        assertNotEquals(nflPlayer.getName(), nbaPlayer.getName(),
                "Different players should have different names");
    }

    // Test array of Player interface (polymorphic collection)
    @Test
    public void testPolymorphicArray() {
        Player[] players = {nflPlayer, nbaPlayer};

        assertEquals(2, players.length, "Array should contain 2 players");

        for (Player player : players) {
            assertNotNull(player.getName(), "Each player should have a name");
            assertNotNull(player.getSport(), "Each player should have a sport");
            assertTrue(player.getStats() > 0, "Each player should have positive stats");
        }
    }

    @Test
    public void testMultipleInstances() {
        Player nflPlayer2 = new NFLPlayer("Patrick Mahomes", 5200, "Chiefs");
        Player nbaPlayer2 = new NBAPlayer("Stephen Curry", 2400, "Warriors");

        assertNotEquals(nflPlayer.getName(), nflPlayer2.getName(),
                "Different NFL players should have different names");
        assertNotEquals(nbaPlayer.getName(), nbaPlayer2.getName(),
                "Different NBA players should have different names");
    }

    @Test
    public void testZeroStats() {
        Player rookiePlayer = new NFLPlayer("Rookie", 0, "Team");
        assertEquals(0, rookiePlayer.getStats(), "Player with zero stats should return 0");
    }

    @Test
    public void testEmptyTeamName() {
        NFLPlayer player = new NFLPlayer("Free Agent", 100, "");
        assertEquals("", player.getTeam(), "Player should handle empty team name");
    }
}