package com.andersenlab.katokoleg.topic4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITasks {

    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, Integer::sum);
    }

    public List<String> getNameAndPlaceOfOrigin(Stream<Singer> singers) {
        return singers.collect(Collectors.collectingAndThen(
                Collectors.toMap(Singer::getName, Singer::getPlaceOfOrigin),
                map -> map.entrySet().stream()))
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public List<Album> getNeededAlbums (Stream<Album> albums) {
        return albums
                .filter(album -> album.getSongs().size() < 3 )
                .collect(Collectors.toList());
    }

    public int getTotalNumberOfSongs (Stream<Album> albums) {
        return albums.map(a -> a.getSongs().size())
                .reduce(0, Integer::sum);
    }

    public long countLowerCaseChars(String someString) {
        return someString.chars()
                .filter(c -> c >= 97 && c <= 122).count();
    }
}
