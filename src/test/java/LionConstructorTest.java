import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionConstructorTest {

    String sex;
    boolean expected;

    public LionConstructorTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Определение наличия гривы")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Самец", true}, {"Самка", false},
        };
    }

    @Test
    public void checkDoesHaveMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}

