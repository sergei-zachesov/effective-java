package com.zachesov.effectivejava.chapter07.item05.keytoelement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Zachesov Sergei
 * @since 11/8/2022
 */
@ToString
@AllArgsConstructor
@Getter
public class Album {

  private String name;

  private double sales;

  private Artist artist;
}
