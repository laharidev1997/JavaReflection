//Lahari Devaraju
//2092487
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
        public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException
        {
                try
                {
                Class cls = ATM.class;
                //Getting name of the java file
                System.out.println("Getting name of the class: " +cls.getName());
                System.out.println();
                //Constructors
                Constructor constructor = cls.getConstructor();
                System.out.println("The name of constructor is "+ constructor.getName());
                System.out.println();
                System.out.println("The public methods of class are : ");
                String field = Arrays.toString(cls.getDeclaredFields());
                String[] f = field.split(",");
                //System.out.println("Declared Fields : " + field);
                for(String fi : f)
                {
                        System.out.println(fi);
                }
                System.out.println();
                System.out.println("Declared methods both private and public methods : " );
                String methods = Arrays.toString(cls.getDeclaredMethods());
                String[] methods_Array = methods.split(",");
                for(String a : methods_Array)
                {
                        System.out.println(a);
                }
                System.out.println();
                
                Field fg = cls.getDeclaredField("BALANCE_INQUIRY");
                Field fg1 = cls.getDeclaredField("WITHDRAWAL");
                Field fg2 = cls.getDeclaredField("currentAccountNumber");
                
                fg.setAccessible(true);
                fg1.setAccessible(true);
                fg2.setAccessible(true);
                System.out.println("Accessing the value of the " +fg + " is " +fg.get(cls));
                System.out.println("Accessing the value of the " +fg1 + " is " +fg1.get(cls));
                // /System.out.println(fg2.get(cls));

                ATM a = (ATM)constructor.newInstance();
                Method m1 =cls.getDeclaredMethod("run");    
                m1.setAccessible(true);    
                m1.invoke(a);

                ATM a2 = (ATM)constructor.newInstance();
                Method m3 = cls.getDeclaredMethod("authenticateUser", null);    
                m3.setAccessible(true);    
                m3.invoke(a2);
                
                //InvocationTargetExceptionDemo invoked = new InvocationTargetExceptionDemo(); 
                ATM a1 = (ATM)constructor.newInstance();
                Method m2 = cls.getDeclaredMethod("performTransactions", null);    
                m2.setAccessible(true);    
                m2.invoke(a1);
                }
                catch(Exception e)
                {
                        System.out.println(e);
                }
                
	}
}
