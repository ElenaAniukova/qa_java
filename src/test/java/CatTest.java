import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetSound() {

        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception{
        List<String> expectedFood = List.of("Птица", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);

        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood,actualFood);

}
}



