package com.example.commontest.objectcopy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void 얕은복사(){

        BookStore originBookStore = new BookStore("북스토어1");
        BookStore copyBookStore = originBookStore;

        assertEquals(originBookStore, copyBookStore);
        assertEquals(originBookStore.getName(), copyBookStore.getName());

        originBookStore.changeName("북스토어2");

        assertEquals(originBookStore, copyBookStore);
        assertEquals(originBookStore.getName(), copyBookStore.getName());
    }

}