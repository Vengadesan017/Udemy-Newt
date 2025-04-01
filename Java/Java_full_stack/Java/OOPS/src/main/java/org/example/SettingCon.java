package org.example;

public class SettingCon{
    private Conposite data;

    public SettingCon() {
        this.data = new Conposite();
    }

    public SettingCon(String name, int value) {
        this.data = new Conposite(name, value);
    }

    @Override
    public String toString() {
        return "SettingCon{" +
                "data=" + data +
                '}' + super.toString();
    }
}
