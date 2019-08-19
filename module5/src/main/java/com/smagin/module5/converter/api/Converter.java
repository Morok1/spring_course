package com.smagin.module5.converter.api;

public interface Converter<S, D> {
    D convert(S s);
}
