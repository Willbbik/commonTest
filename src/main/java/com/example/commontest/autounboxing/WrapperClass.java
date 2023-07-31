package com.example.commontest.autounboxing;

public class WrapperClass {

    public long run(){
        long beforeTime = System.currentTimeMillis();

        int[] list = new int[10000001];
        for(Integer i=0; i<10000000; i++){
            list[i] = i;
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = afterTime - beforeTime;

        return secDiffTime;
    }

}
