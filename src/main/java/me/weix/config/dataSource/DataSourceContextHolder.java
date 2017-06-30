package me.weix.config.dataSource;

/**
 * Created by wxper on 2017/6/25.
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        holder.set(dataSourceName);
    }

    public static String getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }

}
