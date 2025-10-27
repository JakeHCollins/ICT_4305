package players;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerAbstractTest {

    private PlayerAbstract nflPlayerAbstract;
    private PlayerAbstract nbaPlayerAbstract;

    @BeforeEach
    public void setUp() {
        nflPlayerAbstract = new NFLPlayerAbstract("Patrick Mahomes", 5200, "Chiefs");
        nbaPlayerAbstract = new NBAPlayerAbstract("Stephen Curry", 2400, "Warriors");
    }

    @Test
    public void testInheritance() {
        assertTrue(nflPlayerAbstract != null,
                "NFLPlayerAbstract should extend PlayerAbstract");
        assertTrue(nbaPlayerAbstract != null,
                "NBAPlayerAbstract should extend PlayerAbstract");
    }

    @Test
    public void testConcreteMethodInheritance() {
        assertEquals("Patrick Mahomes", nflPlayerAbstract.getNameAbstract(),
                "Concrete method getNameAbstract() should work for NFL player");
        assertEquals("Stephen Curry", nbaPlayerAbstract.getNameAbstract(),
                "Concrete method getNameAbstract() should work for NBA player");
    }

    @Test
    public void testNFLPlayerAbstractStats() {
        assertEquals(5200, nflPlayerAbstract.getStatsAbstract(),
                "NFLPlayerAbstract should return correct stats");
    }

    @Test
    public void testNFLPlayerAbstractSport() {
        assertEquals("Football (NFL)", nflPlayerAbstract.getSportAbstract(),
                "NFLPlayerAbstract should return correct sport");
    }

    @Test
    public void testNFLPlayerAbstractTeam() {
        NFLPlayerAbstract player = (NFLPlayerAbstract) nflPlayerAbstract;
        assertEquals("Chiefs", player.getTeam(),
                "NFLPlayerAbstract should return correct team");
    }

    @Test
    public void testNBAPlayerAbstractStats() {
        assertEquals(2400, nbaPlayerAbstract.getStatsAbstract(),
                "NBAPlayerAbstract should return correct stats");
    }

    @Test
    public void testNBAPlayerAbstractSport() {
        assertEquals("Basketball (NBA)", nbaPlayerAbstract.getSportAbstract(),
                "NBAPlayerAbstract should return correct sport");
    }

    @Test
    public void testNBAPlayerAbstractTeam() {
        NBAPlayerAbstract player = (NBAPlayerAbstract) nbaPlayerAbstract;
        assertEquals("Warriors", player.getTeam(),
                "NBAPlayerAbstract should return correct team");
    }

    @Test
    public void testAbstractMethodImplementation() {
        assertNotNull(nflPlayerAbstract.getStatsAbstract(),
                "Abstract method getStatsAbstract() should be implemented");
        assertNotNull(nflPlayerAbstract.getSportAbstract(),
                "Abstract method getSportAbstract() should be implemented");

        assertNotNull(nbaPlayerAbstract.getStatsAbstract(),
                "Abstract method getStatsAbstract() should be implemented");
        assertNotNull(nbaPlayerAbstract.getSportAbstract(),
                "Abstract method getSportAbstract() should be implemented");
    }

    @Test
    public void testPolymorphicArray() {
        PlayerAbstract[] players = {nflPlayerAbstract, nbaPlayerAbstract};

        assertEquals(2, players.length, "Array should contain 2 players");

        for (PlayerAbstract player : players) {
            assertNotNull(player.getNameAbstract(), "Each player should have a name");
            assertNotNull(player.getSportAbstract(), "Each player should have a sport");
            assertTrue(player.getStatsAbstract() > 0, "Each player should have positive stats");
        }
    }

    @Test
    public void testDifferentImplementations() {
        assertNotEquals(nflPlayerAbstract.getSportAbstract(),
                nbaPlayerAbstract.getSportAbstract(),
                "Different player types should have different sports");
        assertNotEquals(nflPlayerAbstract.getNameAbstract(),
                nbaPlayerAbstract.getNameAbstract(),
                "Different players should have different names");
        assertNotEquals(nflPlayerAbstract.getStatsAbstract(),
                nbaPlayerAbstract.getStatsAbstract(),
                "Different players should have different stats");
    }

    @Test
    public void testProtectedFieldAccess() {
        assertEquals(5200, nflPlayerAbstract.getStatsAbstract(),
                "Subclass should access protected stats field");
        assertEquals("Football (NFL)", nflPlayerAbstract.getSportAbstract(),
                "Subclass should access protected sport field");
    }

    @Test
    public void testConstructorChaining() {
        PlayerAbstract newPlayer = new NFLPlayerAbstract("Joe Burrow", 3500, "Bengals");

        assertEquals("Joe Burrow", newPlayer.getNameAbstract(),
                "Constructor should properly initialize name through super()");
        assertEquals(3500, newPlayer.getStatsAbstract(),
                "Constructor should properly initialize stats through super()");
        assertEquals("Football (NFL)", newPlayer.getSportAbstract(),
                "Constructor should properly initialize sport through super()");
    }

    @Test
    public void testMultipleInstances() {
        PlayerAbstract player1 = new NFLPlayerAbstract("Player1", 1000, "Team1");
        PlayerAbstract player2 = new NFLPlayerAbstract("Player2", 2000, "Team2");

        assertNotEquals(player1.getNameAbstract(), player2.getNameAbstract(),
                "Different instances should have different names");
        assertNotEquals(player1.getStatsAbstract(), player2.getStatsAbstract(),
                "Different instances should have different stats");
    }

    @Test
    public void testZeroStats() {
        PlayerAbstract rookiePlayer = new NFLPlayerAbstract("Rookie", 0, "Team");
        assertEquals(0, rookiePlayer.getStatsAbstract(),
                "Player with zero stats should return 0");
    }

    @Test
    public void testNegativeStats() {
        PlayerAbstract player = new NFLPlayerAbstract("Player", -100, "Team");
        assertEquals(-100, player.getStatsAbstract(),
                "Player should handle negative stats if provided");
    }
}