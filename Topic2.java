/*Topic 2: Working With Java Data Types 
 * Declare and initialize variables (including casting of primitive data types)
 * Differentiate between object reference variables and primitive variables
 * Know how to read or write to object fields
 * Explain an Object's Lifecycle (creation, "dereference by reassignment" and garbage collection)
 * Develop code that uses wrapper classes such as Boolean, Double, and Integer.
 */
package topic2;

import java.util.Date;

/**
 *
 * @author Hlabedy
 */
public class Topic2 {
    private final int x = 1;  //write x
    private final int y = 2;  //write y
    protected int z = x + y;  //read x, y and write z
    
    
    /*Type Casting of primitive data type*/
    void primicasting(){
        
	
        byte b = 0;
        short s = 0;
        char c = 0;
        int i = 0;
        long L = 0;
        float f = 0.0F;
        double d = 50_000.99D;

        b = (byte) d;
        s = (short) d;
        c = (char) d;
        i = (int) d;
        L = (long) d;
        f = (float) d;

        System.out.println("double d value: "+d);
        System.out.println("cast (byte): "+b);
        System.out.println("cast (short): "+s);
        System.out.println("cast (char): "+c);
        System.out.println("cast (int): "+i);
        System.out.println("cast (long): "+L);
        System.out.println("cast (float): "+f);

        System.out.println();
        c = 'A';
        i = (int) c;
        System.out.println("ASCII A is decimal " + i);
        System.out.println();
        b = (byte) 100.45; // cast on a literal, legal but stupid.
        System.out.println("b = " + b);
        System.out.println();
        s = (short) (i*2); // cast on an expression - special rules
        System.out.println("s = " + s);
        System.out.println();
        System.out.println();

    }
    
    public void Wrapperobj(){
        Integer i = new Integer ("17"); 
        Double d = new Double ("3.14159");
        
        Boolean bu = new Boolean(true);
        boolean bu1 =bu.booleanValue();
      
        boolean bu3 = Boolean.parseBoolean("true");
        Boolean bu4 = Boolean.valueOf("true");
        Boolean bu5 = Boolean.parseBoolean("tree");
        System.out.println("-wrapper classes such as Boolean, Integer, and Double output respectively-");
        System.out.println("boolean 5 = " + bu5);
        }
    
    
   //The finalize method is called because an object gets garbage collected
  protected void finalize() {
        
        System.out.println("ran to finalizer");
    } 

  private void Objcycle() {
        Date ref1 = new Date();  
        Date ref2 = new Date();  
        Date ref3 = ref1;  
        Date ref4 = ref1;  
        ref4 = ref2; 
        ref4 = null; 
        ref2 = ref1; 
        }//ref1, ref2, ref3 run out of scope, object1 is read for garbage collection

  
    public static void main(String[] args) {
        Topic2 obj = new Topic2();
        obj.primicasting();
        obj.Wrapperobj();
        obj.Objcycle();
        
        //printing wrapper classes object values
        Integer i = new Integer (17); 
        Double d = new Double (3.14159);
       
        System.out.println (i); 
        System.out.println (d); 
        System.out.println();
        int w = obj.z; //read z and write w
        
       //several cabbage collectin can be made throuh usage of loops
        Topic2 objref = new Topic2();
        objref.Objcycle();
        
        //Calling System.gc(); is not a guarantee that the garbage collection  actually running
        System.gc();  //suggest JVM it is a good point to garbage collection, JVM may ignore
        objref = new Topic2();  //object is ready for garbage collection
        objref = null; 
        for(int j = 1; j < 2; j++) {
            new Date(); System.gc();
        }
        }
    
}
