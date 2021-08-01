package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductRepositoryTest {
        private ProductRepository repository = new ProductRepository();

        Product first = new Book(1, "Boris Godunov", 500, "Pushkin");
        Product second = new Book(2, "War and Peace", 800, "Tolstoy");
        Product third = new Book(3, "The Master and Margarita", 400, "Bulgakov");
        Product fourth = new Smartphone(4, "Redmi", 15000, "Xiaomi");
        Product fifth = new Smartphone(5, "Iphone", 56000, "Apple");
        Product sixth = new Smartphone(6, "Galaxy", 25000, "Samsung");

        @Test
        public void addAll(){
                repository.save(first);
                repository.save(second);
                repository.save(third);
                repository.save(fourth);
                repository.save(fifth);
                repository.save(sixth);
                Product[] actual = repository.findAll();
                Product[] expected = new Product[]{first,second,third,fourth,fifth,sixth};
                assertArrayEquals(expected,actual);

        }


        @Test
        public void shouldDeleteNotExistingId(){
                addAll();
                assertThrows(NotFoundException.class, () -> {
                        repository.removeById(7);
                });
        }
        @Test
        public void shouldDeleteExistingId() {
                addAll();
                repository.removeById(5);

                Product[] expected = new Product[]{first,second,third,fourth,sixth};
                Product[] actual = repository.findAll();
                assertArrayEquals(expected, actual);
        }


}
