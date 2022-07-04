package io.github.edufolly.kafka;

/**
 * @author Eduardo Folly
 */
public class MyObject {

    public String name;
    public int age;

    public MyObject() {
    }

    public MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyObject{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

}
