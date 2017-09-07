import org.junit.Test;
import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Before;
import static org.junit.Assert.*;

public class GuessingGameFlowTest {
    @Test
    public void guess84WithRange0To100() {
        GuessingGame game = new GuessingGame(0, 100);
        assertEquals(50, game.guess());

        game.higher();
        assertEquals(75, game.guess());

        game.higher();
        assertEquals(87, game.guess());

        game.lower();
        assertEquals(81, game.guess());

        game.higher();
        assertEquals(84, game.guess());
    }
}