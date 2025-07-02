package com.literaturaApi.literaturaApi.service;

public interface IConvertirDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
