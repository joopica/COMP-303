import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

class PlayOrderContextTest {

    private static final Song A = new Song("Smells like teen spirit", "Nirvana", 4);
    private static final Song B = new Song("I got a feeling", "Black-eyed Peas", 3);
    private static final Song C = new Song("September", "Greenday", 5);
    private static final Song D = new Song("Somewhere only we know", "Lily Allen", 4);

    private List<Song> s = new ArrayList<> (List.of(A, B, C, D));
    private List<Song> n = new ArrayList<> (List.of(C, D, A, B));

    PlayOrderContext shuffle;

    @BeforeEach
    void setUp() {
        shuffle = new PlayOrderContextTest(new Shuffle(s));
    }

    @Test
    void getNext() {
        assertEquals(shuffle.next(), 0);
        assertEquals(shuffle.next(), 1);
        assertEquals(shuffle.next(), 2);
        assertEquals(shuffle.next(), 4);
    }

    @Test
    void hasNext() {
        try {
            hasNext();
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    public void update()
    {
        shuffle.update(n);
        assertEquals(shuffle.getNext(), n.get(0));
        assertEquals(shuffle.getNext(), n.get(1));
    }
}