package com.agilie.internship.di_sample.mvp;

public interface Presenter<T> {
  void setView(T view);

  // Lifecycle methods (onStart() etc)

  // Input events (on...Clicked, on...Swipe etc)
}