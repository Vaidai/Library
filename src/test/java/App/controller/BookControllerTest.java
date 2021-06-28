package App.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Autowired
    BookController controller;

    @Test
    void contextLoads() throws  Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void name() {
        assertEquals(1, 0);
    }
}