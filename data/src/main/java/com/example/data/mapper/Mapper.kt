package com.example.data.mapper

interface Mapper<T,R> {
    fun toDomain(model:T) : R
}