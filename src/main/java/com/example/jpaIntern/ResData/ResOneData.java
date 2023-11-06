package com.example.jpaIntern.ResData;

public class ResOneData<T> {
    public T datas;
    public String mess;

    public ResOneData(T datas, String mess) {
        this.datas = datas;
        this.mess = mess;
    }
}
