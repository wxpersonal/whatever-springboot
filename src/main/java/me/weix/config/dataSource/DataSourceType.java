package me.weix.config.dataSource;

/**
 * Created by wxper on 2017/6/24.
 */
public enum DataSourceType {
    master("master", "主库"),
    slave1("slave1", "从库1"),
    slave2("slave2", "从库2");
    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
