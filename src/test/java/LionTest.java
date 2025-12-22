import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        int expectedKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        Lion lion = new Lion("Самец", feline);

        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);

    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);

        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testConstructorInvalidSexThrowsException() throws Exception {
        try {
            new Lion("Сумка", feline);
            Assert.fail("Ожидалось исключение, но оно не было выброшено");
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());

        }
    }
}