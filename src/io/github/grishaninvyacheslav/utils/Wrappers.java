package io.github.grishaninvyacheslav.utils;

public class Wrappers {
    public static class ObjectWrapper<T> {
        public T value;

        public ObjectWrapper(T value) {
            this.value = value;
        }
    }
}
