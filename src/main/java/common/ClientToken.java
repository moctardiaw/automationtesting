package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 *
 */
public class ClientToken {

    /**
     *
     */
    public ClientToken(){

        this.UrlToken     = getAuth(this.path,"api.url.token");
        this.UrlCucumber  = getAuth(this.path,"api.url.cucumber");
        this.ClientId     = getAuth(this.path,"api.clientid");
        this.ClientSecret = getAuth(this.path,"api.clientsecret");
    }

    protected String UrlToken;
    protected String UrlCucumber;
    protected String ClientId;
    protected String ClientSecret;
    private String path="src/main/java/resources/auth.properties";

    /**
     *
     * @return String Url
     */
    public String getUrlToken() {
        return this.UrlToken;
    }

    public String getUrlCucumber() {
        return this.UrlCucumber;
    }

    /**
     * @return String ClientId
     */
    public String getClientId() {
        return this.ClientId;
    }

    /**
     *
     * @return String ClientSecret
     */
    public String getClientSecret() {
        return this.ClientSecret;
    }

    /**
     *
     * @param path
     * @param key
     * @return String api.url | api.clientid | api.clientsecret |
     */
    public String getAuth(String path, String key) {

        Properties prop = null;
        try (InputStream input = new FileInputStream(path)) {
            prop = new Properties();
            if (input == null) {
                return "Sorry, unable to find auth.properties";
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
