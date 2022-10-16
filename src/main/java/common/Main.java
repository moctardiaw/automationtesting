package common;

public class Main {

    public static void main(String[] args){

        ClientToken ct = new ClientToken();
        System.out.println(ct.getUrlToken());
        System.out.println(ct.getUrlCucumber());
        System.out.println(ct.getClientId());
        System.out.println(ct.getClientSecret());
    }
}
