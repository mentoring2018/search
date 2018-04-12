package com.jingerbread.hashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class CustomHashMap<T extends Comparable<? super T>> {

    private List<T>[] buckets;

    private int bucketCount;

    private Function<T, Integer> hashFunction;

    public CustomHashMap(int count, Function<T, Integer> hashFunction) {
        this.buckets = new List[count];
        this.bucketCount = count;
        this.hashFunction = hashFunction;
    }

    public void put(T value) {
        int hashCode = hashFunction.apply(value);
        int bucketNumber = hashCode % bucketCount;
        List<T> bucket = buckets[bucketNumber];

        if (bucket == null) {
            bucket = new ArrayList<>();
            buckets[bucketNumber] = bucket;
        }
        int found = Collections.binarySearch(bucket, value);
        if (found < 0) {
            bucket.add(value);
            Collections.sort(bucket);
            //log.warn("Added {} to bucket {}", value, bucketNumber);
        } else {
            log.warn("Skipped {} to bucket {} found {}:{}", value, bucketNumber, found, bucket.get(found));
        }
    }

    public Optional<T> get(T value) {
        int hashCode = hashFunction.apply(value);
        int bucketNumber = hashCode % bucketCount;
        List<T> bucket = buckets[bucketNumber];

        if (bucket == null) {
            return Optional.empty();
        }
        if (Collections.binarySearch(bucket, value) > 0) {
            return Optional.of(value);
        }
        return Optional.empty();
    }
}
