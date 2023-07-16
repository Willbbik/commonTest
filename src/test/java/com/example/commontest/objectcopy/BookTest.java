package com.example.commontest.objectcopy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void 얕은복사() {

        BookStore originBookStore = new BookStore("북스토어1");
        BookStore copyBookStore = originBookStore;

        assertEquals(originBookStore, copyBookStore);
        assertEquals(originBookStore.getName(), copyBookStore.getName());

        originBookStore.changeName("북스토어2");

        assertEquals(originBookStore, copyBookStore);
        assertEquals(originBookStore.getName(), copyBookStore.getName());
    }

    @Test
    void 방어적복사() {
        /**
         * 객체 생성시 새로운 메모리 주소를 할당한다.
         *
         * 즉 배열의 메모리 주소는 다르지만
         * 배열 요소들의 메모리 주소는 동일하다.
         */

        List<Book> books = new ArrayList<>();
        BookStore bookStore = new BookStore("북스토어", books);

        assertEquals(bookStore.getBooks().size(), 0);

        //배열에 book 객체 추가
        Book book1 = new Book("책1");
        Book book2 = new Book("책2");
        Book book3 = new Book("책3");
        books.addAll(List.of(book1, book2, book3));

        assertEquals(bookStore.getBooks().size(), 0);
    }

    @Test
    void 방어적복사2() {
        /**
         * List의 메모리 주소는 변경되지만
         * List 내부 요소의 메모리 주소는 그대로다.
         *
         * 즉 내부요소는 방어가 되지 않는다.
         * 이것이 방어적 복사의 단점
         */

        List<Book> books = new ArrayList<>();
        BookStore bookStore = new BookStore("북스토어", books);

        assertEquals(bookStore.getBooks().size(), 0);

        //배열에 book 객체 추가
        Book book1 = new Book("책1");
        Book book2 = new Book("책2");
        Book book3 = new Book("책3");
        books.addAll(List.of(book1, book2, book3));
        bookStore.changeBooks(books);

        //이름 바꾸기 전
        for(int i=1; i<=books.size(); i++){
            assertEquals(books.get(i-1).getName(), "책"+i);
        }

        //이름변경
        books.forEach(book -> book.changeName(book.getName() + "신규"));

        //이름 바꾼 후
        for(int i=1; i<=books.size(); i++){
            assertEquals(books.get(i-1).getName(), "책"+i+"신규");
        }
    }



}