package com.carvethsolutions.loglib;

public interface Loggable {
    default String getTag() {
        return getClass().getEnclosingClass().getTypeName();
    }
}
