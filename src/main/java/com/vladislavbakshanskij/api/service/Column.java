package com.vladislavbakshanskij.api.service;

public enum Column {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5);
    /**
     * Index column in array.
     */
    private final int id;

    Column(int id) {
        this.id = id;
    }

    /**
     * Returns the index column in array.
     *
     * @return index column in array.
     */
    public int getId() {
        return id;
    }
}
