package ru.itmo.lesson13;

public class PairContainer <T, S>  {

 private T key;
 private S value;

 public PairContainer(T key, S value) {
  this.key = key;
  this.value = value;
 }


 public T getKey() {
  System.out.println("PairContainer.key = " +key);
  return key;
 }

 public S getValue() {
  System.out.println("PairContainer.value = " +value);
  return value;
 }
}
