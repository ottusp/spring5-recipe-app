package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void testGetId() throws Exception{
        Long id = 4L;

        category.setId(id);

        assert (id.equals(category.getId()));
    }

    @Test
    public void testGetDescription() {
    }

    @Test
    public void testGetRecipes() {
    }
}