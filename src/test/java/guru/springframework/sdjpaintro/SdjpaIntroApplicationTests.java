package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repository.AuthorRepository;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SdjpaIntroApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testBookRepository() {
        long countBooks = bookRepository.count();

        assertThat(countBooks).isEqualTo(5);

        long countAuthors = authorRepository.count();
        assertThat(countAuthors).isEqualTo(3);
    }

}
