package Main;

public class Main {

    public static void main(String[] args) {
        idAndPass idNpass = new idAndPass();
        loginPage loginpage = new loginPage(idNpass.getLoginInfo());
    }
}
