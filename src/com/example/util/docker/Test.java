package com.example.util.docker;

public class Test {
    public static void main(String[] args) {
        String containerId=DockerUtils.createContainer("ubuntu");
        System.out.println(containerId);
    }
}
