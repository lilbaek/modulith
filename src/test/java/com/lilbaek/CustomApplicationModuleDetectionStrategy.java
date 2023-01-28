package com.lilbaek;

import org.springframework.modulith.core.ApplicationModuleDetectionStrategy;
import org.springframework.modulith.core.JavaPackage;

import java.util.stream.Stream;


class CustomApplicationModuleDetectionStrategy implements ApplicationModuleDetectionStrategy {

    @Override
    public Stream<JavaPackage> getModuleBasePackages(JavaPackage basePackage) {
        return basePackage.getDirectSubPackages().stream().filter(x -> x.getName().contains("feature")).findFirst().orElseThrow().getDirectSubPackages().stream();
    }
}