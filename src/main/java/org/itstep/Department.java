package org.itstep;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Comparable<Department>, Serializable {
    private String name;
    private String masterName;

    public Department(String name, String masterName) {
        this(name);
        this.masterName = masterName;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Override
    public int compareTo(Department o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", masterName='" + masterName + '\'' +
                '}';
    }
}
