package com.foolchen.kotlin.java.object;

/**
 * @author chenchong. Created on 2017/6/4.
 */
public class DelegateExample {
  interface Base {
    void print();
  }

  static class BaseImpl implements Base {
    int x;

    public BaseImpl(int x) {
      this.x = x;
    }

    @Override
    public void print() {
      System.out.println(x);
    }
  }

  static class Derived implements Base {
    Base base;

    public Derived(Base base) {
      this.base = base;
    }

    @Override
    public void print() {
      this.base.print();
    }
  }

  public static void main(String[] args) {
    new Derived(new BaseImpl(10)).print();
  }
}
