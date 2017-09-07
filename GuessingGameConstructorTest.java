import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class GuessingGameConstructorTest {
    GuessingGame game;

    @Before
    public void initialize() {
        game = new GuessingGame(5, 10);
    }

    @Test
    public void assignsMinToThis() {
        assertEquals(game.min, 5);
    }

    @Test
    public void assignsMaxToThis() {
        assertEquals(game.max, 10);
    }
}