package proxyTest;


public class Test01 {

    public static void main(String[] args) {
        Girl girl = new WangMeiLi();
        WangMeiLiProxy wangMeiLiWangMeiLiProxy = new WangMeiLiProxy(girl);
        Girl mother = (Girl)wangMeiLiWangMeiLiProxy.getProxyInstance();
        mother.data();

        mother.watchMovie();
    }
}
