package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "default", 20.5, true);
        System.out.println(obj.publicField);
    }
}
