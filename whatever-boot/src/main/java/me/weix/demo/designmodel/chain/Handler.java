package me.weix.demo.designmodel.chain;

/**
 * 请求handler
 * @author weix
 * @date 2018/12/7 10:43
 */
public abstract class Handler {

    protected Handler handler;

    public abstract void handle(double discount);

    public static Handler createHander(Handler handler){
        Handler market = new Market();
        Handler manager = new Manager();
        Handler boss = new Boss();
        market.setHandler(manager);
        manager.setHandler(boss);
        if(handler.getClass() == market.getClass()) {
            return market;
        } else if(handler.getClass() == manager.getClass()) {
            return manager;
        } else {
            return boss;
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
