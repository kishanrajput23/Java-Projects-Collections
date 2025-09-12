package com.abe762.loop_backend.shared.service;

public class StateBuilder<T, V> {
    private StatusNotification status;
    private T value;
    private V error;

    public State<T, V> forError(V error) {
        this.error = error;
        this.status = StatusNotification.ERROR;
        return new State<>(this.status, this.value, this.error);
    }

    public State<T, V> forSuccess() {
        this.status = StatusNotification.OK;
        return new State<>(this.status, this.value, this.error);
    }

    public State<T, V> forSuccess(T value) {
        this.value = value;
        this.status = StatusNotification.OK;
        return new State<>(this.status, this.value, this.error);
    }
    public State<T, V> forUnauthorized(V error) {
        this.error = error;
        this.status = StatusNotification.UNAUTHORIZED;
        return new State<>(this.status, this.value, this.error);
    }

}
