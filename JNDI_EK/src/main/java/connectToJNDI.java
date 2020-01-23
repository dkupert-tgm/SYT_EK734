import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class connectToJNDI {

    public static void main(String[] args) {
        String url = "ldap://192.168.176.159/";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=dkupert,ou=itdept,dc=syt,dc=tgm,dc=ac,dc=at");
        env.put(Context.SECURITY_CREDENTIALS, "dkupert");

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("connected");
            System.out.println(ctx.getEnvironment());
            Attributes att = ctx.getAttributes("uid=dkupert,ou=itdept,dc=syt,dc=tgm,dc=ac,dc=at");
            System.out.println(att.get("givenName"));
            System.out.println(att.get("sn"));
            System.out.println(att.get("uidNumber"));
            ctx.close();

        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
        }
    }

}
