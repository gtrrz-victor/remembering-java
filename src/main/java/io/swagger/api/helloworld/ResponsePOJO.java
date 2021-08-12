package io.swagger.api.helloworld;

import java.util.Objects;

public class ResponsePOJO {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    private String name;
    private Number value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsePOJO that = (ResponsePOJO) o;
        return Objects.equals(name, that.name) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "ResponsePOJO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
