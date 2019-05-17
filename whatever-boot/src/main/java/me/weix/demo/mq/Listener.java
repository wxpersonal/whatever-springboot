package me.weix.demo.mq;

/**
 * @Author: Wells.Wei
 * @Date: 2017/5/10
 * @Description:
 */

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.text.DecimalFormat;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            MapMessage map = (MapMessage)message;
            String stock = map.getString("stock");
            double price = map.getDouble("price");
            double offer = map.getDouble("offer");
            boolean up = map.getBoolean("up");
            DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
            System.out.println(stock + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up?"up":"down"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}