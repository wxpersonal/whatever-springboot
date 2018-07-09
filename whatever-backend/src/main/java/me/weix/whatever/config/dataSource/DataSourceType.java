package me.weix.whatever.config.dataSource;

/**
 * Created by wxper on 2017/6/24.
 */
public enum DataSourceType {
    master("write", "读写库"),
    slave("read", "只读库");

    private String name;
    private String desc;

    DataSourceType(String type, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static DataSourceType getByName(String name) {
        return DataSourceType.valueOf(name);
    }
}
