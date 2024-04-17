import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    Product item1 = new Product(10, "злаки", 60);
    Product item2 = new Product(25, "кукуруза", 170);
    Product item3 = new Product(7, "творог", 100);

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.remove(10);

        Product[] actual = repo.findAll();
        Product[] expected = { item2, item3 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveNonexistingProduct() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

//        repo.remove(123);
//
//        Product[] actual = repo.findAll();
//        Product[] expected = { item2, item3 };
//
//        Assertions.assertArrayEquals(expected, actual);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(123)
                );
    }
}