import org.junit.Assert;
import org.junit.Test;

public class ListTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldToValidArgs() {
        new ArrayList(-1);
    }


    @Test
    public void shouldAddElement() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        Assert.assertEquals("[Guilherme, Jéssica, Luna]", arraylist.toString());
    }

    @Test
    public void shouldAddElementInPosition() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        arraylist.add("Célia", 1);
        arraylist.add("Edinelson", 2);

        Assert.assertEquals("[Guilherme, Célia, Edinelson, Jéssica, Luna]", arraylist.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAddElementInInvalidPosition() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        arraylist.add("Célia", 4);

    }

    @Test
    public void shouldToRemoveElementFromPosition() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        arraylist.remove(0);

        Assert.assertEquals("[Jéssica, Luna]", arraylist.toString());
    }

    @Test
    public void shouldToGetElementFromPosition() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        String result = arraylist.get(0);

        Assert.assertEquals("Guilherme", result);
    }

    @Test
    public void shouldVerifyIfContains() {

        IList<String> arraylist = new ArrayList(2);

        arraylist.add("Guilherme");
        arraylist.add("Jéssica");
        arraylist.add("Luna");

        boolean result = arraylist.contains("Luna");

        Assert.assertTrue(result);
    }

}
