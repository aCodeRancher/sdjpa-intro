package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repository.AuthorRepository;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testMySQL() {
        long countBooks = bookRepository.count();
        assertThat(countBooks).isEqualTo(5);

        long countAuthors = authorRepository.count();
        assertThat(countAuthors).isEqualTo(3);
    }
}
