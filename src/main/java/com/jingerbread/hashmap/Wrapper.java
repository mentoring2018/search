package com.jingerbread.hashmap;

import java.util.Objects;
import java.util.function.Function;

public class Wrapper implements Comparable<Wrapper> {

    private String value;

    private int hashCode;

    public Wrapper(String value, Function<String, Integer> hashFunction) {
        this.value = value;
        this.hashCode = hashFunction.apply(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper wrapper = (Wrapper) o;
        return hashCode == wrapper.hashCode &&
                Objects.equals(value, wrapper.value);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public int compareTo(Wrapper o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "value='" + value + '\'' +
                ", hashCode=" + hashCode +
                '}';
    }
}
