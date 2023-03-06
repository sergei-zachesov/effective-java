package com.zachesov.effectivejava.chapter11.item79;

/**
 * @author Zachesov Sergei
 * @since 2023-02-20
 */
@FunctionalInterface
public interface SetObserver<E> {

  void added(ObservableSet<E> set, E element);
}
