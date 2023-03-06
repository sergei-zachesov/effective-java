package com.zachesov.effectivejava.chapter11.item79;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Zachesov Sergei
 * @since 2023-02-20
 */
public class ObservableSet<E> extends ForwardingSet<E> {

  public ObservableSet(Set<E> s) {
    super(s);
  }

  //  private final List<SetObserver<E>> observers = new ArrayList<>();
  //
  //  public void addObserver(SetObserver<E> observer) {
  //    synchronized (observers) {
  //      observers.add(observer);
  //    }
  //  }
  //
  //  public boolean removeObserver(SetObserver<E> observer) {
  //    synchronized (observers) {
  //      return observers.remove(observer);
  //    }

  //  private void notifyElementAdded(E element) {
  //    synchronized (observers) {
  //      for (SetObserver<E> observer : observers) observer.added(this, element);
  //    }
  //  }

  // Alien method moved outside of synchronized block - open calls
  //    private void notifyElementAdded(E element) {
  //      List<SetObserver<E>> snapshot = null;
  //      synchronized (observers) {
  //        snapshot = new ArrayList<>(observers);
  //      }
  //      for (SetObserver<E> observer : snapshot) observer.added(this, element);
  //    }

  // Thread-safe observable set with CopyOnWriteArrayList
  private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

  public void addObserver(SetObserver<E> observer) {
    observers.add(observer);
  }

  public boolean removeObserver(SetObserver<E> observer) {
    return observers.remove(observer);
  }

  private void notifyElementAdded(E element) {
    for (SetObserver<E> observer : observers) observer.added(this, element);
  }

  @Override
  public boolean add(E element) {
    boolean added = super.add(element);
    if (added) notifyElementAdded(element);
    return added;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    boolean result = false;
    for (E element : c) result |= add(element); // Calls notifyElementAdded
    return result;
  }
}
