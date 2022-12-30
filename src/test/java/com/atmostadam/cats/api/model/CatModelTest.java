package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.entity.CatEntity;
import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.junit.jupiter.api.Test;

public class CatModelTest {


    @Test
    void adopt() {
        new Adopt();
    }

    @Test
    void cage() {
        new Cage();
    }

    @Test
    void cat() {
        new Cat();
    }

    @Test
    void delivery() {
        new Delivery();
    }

    @Test
    void disease() {
        new Disease();
    }

    @Test
    void government() {
        new Government();
    }

    @Test
    void intake() {
        new Intake();
    }

    @Test
    void location() {
        new Location();
    }

    @Test
    void organization() {
        new Organization();
    }

    @Test
    void person() {
        new Person();
    }

    @Test
    void storage() {
        new Storage();
    }

    @Test
    void catEntity() {
        new CatEntity();
    }

    @Test
    void catException() {
        new CatException("Test");
    }
}
