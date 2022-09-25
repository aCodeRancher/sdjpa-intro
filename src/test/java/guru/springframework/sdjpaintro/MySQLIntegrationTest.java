package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.AuthorUuid;
import guru.springframework.sdjpaintro.domain.BookUuid;
import guru.springframework.sdjpaintro.repositories.AuthorUuidRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import guru.springframework.sdjpaintro.repositories.BookUuidRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jt on 7/4/21.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

    @Test
    void testSaveBookUuid(){
        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("Hibernate and Spring Data JPA");
        bookUuid.setIsbn("45678");
        bookUuid.setPublisher("Spring Framework Guru");
        BookUuid bookSaved = bookUuidRepository.save(bookUuid);
        assertTrue(bookUuidRepository.findById(bookSaved.getId())!=null);
    }

    @Test
    void testSaveAuthorUuid(){
        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("John");
        authorUuid.setLastName("Thompson");
        AuthorUuid authorSaved = authorUuidRepository.save(authorUuid);
        assertTrue(authorUuidRepository.findById(authorSaved.getId())!=null);
    }
}


