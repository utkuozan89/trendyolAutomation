package data;

import common.BaseLibrary;

public class TestData extends BaseLibrary {
    // static DBConnection dbconn  = new DBConnection();
    // PoC'de kullnailan SolCrm
    // public static final String belgenetURL = "http://www.belgenet.com.tr:8282/edys-web/mainInbox.xhtml";

    // Mevcut SolCrm - internal IP
    // public static final String belgenetURL = "http://10.101.20.153:8889/edys-web/sistemeGiris.xhtml";

    // Mevcut SolCrm - external IP
    //public static final String mayaURL = dbconn.GetUrl("MAYA");

    public static final String mayaURL = "https://extprp.superonline.net/sol-crm-2.0/login.xhtml";
    public static final String foxURL = "http://172.20.165.150/netflowsolprp/FoxStartCenter.aspx";
    //public final  String  mayaURL = GetUrl("MAYA","PRP");


    //Default usernameOPTIIM
    public static final String usernameOPTIIM = "optiim";
    public static final String passwordOPTIIM = "123";

    public static final String usernameTS2336 = "ts2336user";
    public static final String passwordTS23362 = "123";

    public static String docPathWindows = "C:\\TestAutomation\\BelgenetFTA\\documents\\";
    public static String docDownloadPathWindows = "C:\\Users\\" + getPCUsername() + "\\Downloads\\";
    public static String docPathLinux = "documents/";
    public static String docDownloadPathLinux = "/home/optiim";//"home/optiim/Downloads";
}
