package Main;

import java.util.HashMap;

public class idAndPass {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    idAndPass(){
        logininfo.put("mouayed","MrMouDou123");
        logininfo.put("anis","PASSWORD");
        logininfo.put("douaa","maha123");
    }

    protected HashMap getLoginInfo() {
        return logininfo;
    }
}
