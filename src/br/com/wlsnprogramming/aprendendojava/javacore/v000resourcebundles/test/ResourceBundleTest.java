package br.com.wlsnprogramming.aprendendojava.javacore.v000resourcebundles.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("good.morning"));
        System.out.println(resourceBundle.getString("show"));
        System.out.println(resourceBundle.getString("video"));
    }
}
