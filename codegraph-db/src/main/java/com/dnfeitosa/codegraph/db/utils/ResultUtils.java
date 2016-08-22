package com.dnfeitosa.codegraph.db.utils;

import org.springframework.data.neo4j.conversion.Result;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ResultUtils {
    public static <T> List<T> toList(Result<T> result) {
        return stream(result).collect(Collectors.toList());
    }

    public static <T> Stream<T> stream(Result<T> result) {
        return StreamSupport.stream(result.spliterator(), false);
    }
}