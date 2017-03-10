
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;
import worksheet02_3.FailTestExample;

/**
 *
 * @author pablo
 */
public class StudentsAssignmentsJUnitTest {

    public StudentsAssignmentsJUnitTest() {
    }

    @Test
    public void test4FieldsMaximum() {
        Class cls = FailTestExample.class;
        int result = cls.getDeclaredFields().length;
        assertTrue("check if there is 4 or less fields", result <= 4);
    }

    @Test
    public void testAllFieldsPrivate() {
        Class cls = FailTestExample.class;
        Field[] fields = cls.getDeclaredFields();
        Boolean allFieldsPrivate = true;
        for (Field field : fields) {
            int modifiersOfField = field.getModifiers();
            if (!Modifier.isPrivate(modifiersOfField)) {
                allFieldsPrivate = false;
            }
        }
        assertTrue("check that all fields are private", allFieldsPrivate);
    }

    @Test
    public void testNoArrayListTypeFields() {
        Class cls = FailTestExample.class;
        Field[] fields = cls.getDeclaredFields();
        Boolean noArrayListTypeFields = true;
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(ArrayList.class)) {
                noArrayListTypeFields = false;
            }
        }
        assertTrue("check that there is no array list type fields", noArrayListTypeFields);
    }

    @Test
    public void testFewerThan2PrivateHelperMethods() {
        Class cls = FailTestExample.class;
        Method[] methods = cls.getDeclaredMethods();
        int numPrivateHelperMethods = 0;
        for (Method method : methods) {
            int modifiersOfMethod = method.getModifiers();
            if (Modifier.isPrivate(modifiersOfMethod)) {
                numPrivateHelperMethods++;
            }
        }
        assertTrue("check that there is fewer than 2 private helper methods", numPrivateHelperMethods < 2);
    }

    @Test
    public void testNoThrowClauseMethods() {
        Class cls = FailTestExample.class;
        Method[] methods = cls.getDeclaredMethods();
        Boolean noMethodThrowsException = true;
        for (Method method : methods) {
            if (method.getExceptionTypes().length != 0) {
                noMethodThrowsException = false;
            }
        }
        assertTrue("check that there is no methods throwing Exceptions", noMethodThrowsException);
    }
    
    @Test
    public void testNoIntegerReturnMethods() {
        Class cls = FailTestExample.class;
        Method[] methods = cls.getDeclaredMethods();
        Boolean noMethodReturnsInt = true;
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getReturnType().isAssignableFrom(int.class)) {
               noMethodReturnsInt = false;
            }
        }
        assertTrue("check that there is no methods returning Integers", noMethodReturnsInt);
    }
    
    @Test
    public void testMissing0ArgumentConstructor() {
        Class cls = FailTestExample.class;
        Constructor[] constructors = cls.getConstructors();
        Boolean notMissing0ArgumentConstructor = false;
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount()==0) {
               notMissing0ArgumentConstructor=true;
            }
        }
        assertTrue("check that there is no methods returning Integers", notMissing0ArgumentConstructor);
    }

}
