package com.managment.hotels.hotels.user;

public @interface JoinColumn {
    String referencedColumnName();

    String name();
}
