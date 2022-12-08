package com.zachesov.effectivejava.chapter07.item05.keytoelement;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toMap;

/**
 * @author Zachesov Sergei
 * @since 11/8/2022
 */
public class Main {

  public static void main(String[] args) {

    Artist artistA = new Artist("Sting");
    Artist artistB = new Artist("Splin");

    Album albumA = new Album("A", 1, artistA);
    Album albumB = new Album("B", 1000, artistB);
    Album albumC = new Album("C", 4000, artistB);
    Album albumD = new Album("D", 10000, artistA);
    Album albumE = new Album("E", 500, artistB);
    Album albumF = new Album("F", 1000, artistA);

    List<Album> albums = List.of(albumA, albumB, albumC, albumC, albumD, albumE, albumF);

    Map<Artist, Album> topHits =
        albums.stream().collect(toMap(Album::getArtist, a -> a, maxBy(comparing(Album::getSales))));
    System.out.println(topHits);
  }
}
