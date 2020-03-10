import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestToDoCaller {
    @Test
    public void testAddSingleElement() {
        ToDoCaller caller = new ToDoCaller();
        int result = caller.add(2,3);
        assertEquals(5,result);
    }
}
