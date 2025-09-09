package com.abe762.loop_backend.shared.service;

public class State<T, V> {
    private T value;
    private V error;
    private StatusNotification status;

    public State(StatusNotification status, T value, V error) {
        this.value = value;
        this.error = error;
        this.status = status;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public V getError() {
        return error;
    }

    public void setError(V error) {
        this.error = error;
    }

    public StatusNotification getStatus() {
        return status;
    }

    public void setStatus(StatusNotification status) {
        this.status = status;
    }

    public static <T, V> StateBuilder<T, V> builder() {
        return new StateBuilder<>();
    }
}
