package worksheet02_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ClassInterface {

    private String className;
    private Boolean validClassName;
    private Class cls;

    public ClassInterface(String className) {
        try {
            this.cls = Class.forName(className);
            validClassName = true;
            this.className = className.substring(className.lastIndexOf('.') + 1);
        } catch (ClassNotFoundException ex) {
            validClassName = false;
            Logger.getLogger(ClassInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printClass() {
        int modifiers = cls.getModifiers();
        System.out.println(getClassHead(modifiers));
        //print only constructors and fields for classes (interfaces have no constructors nor fields)
        if (!Modifier.isInterface(modifiers)) {
            System.out.println(getClassFields());
            System.out.println(getClassConstructors());
        }
        System.out.println(getClassMethods());
        System.out.println("\n }");
    }

    private String getClassHead(int modifiers) {
        String classHead = "";
        if (Modifier.isPublic(modifiers)) {
            classHead += "public";
        }
        if (Modifier.isPrivate(modifiers)) {
            classHead += "private";
        }
        if (Modifier.isProtected(modifiers)) {
            classHead += "protected";
        }
        //interfaces are always abstract (so do not need to include abstract in front of interface)
        if (Modifier.isAbstract(modifiers) && !Modifier.isInterface(modifiers) ) {
            classHead += " abstract";
        }
        if (Modifier.isInterface(modifiers)) {
            classHead += " interface ";
        } else {
            classHead += " class ";
        }
        classHead += className;
        classHead += " {";
        return classHead;
    }

    private String getClassFields() {
        String fieldsPrint = "";
        //Field[] fields = cls.getFields();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldsPrint += "\n     ";
            int modifiersOfField = field.getModifiers();
            if (Modifier.isPrivate(modifiersOfField)) {
                fieldsPrint += "private ";
            }
            if (Modifier.isPublic(modifiersOfField)) {
                fieldsPrint += "public ";
            }
            if (Modifier.isProtected(modifiersOfField)) {
                fieldsPrint += "protected ";
            }
            fieldsPrint +=field.getType().getName().substring(field.getType().getName().lastIndexOf('.') + 1);
            fieldsPrint +=" ";
            fieldsPrint +=field.getName();
            fieldsPrint +=";";
        }
        return fieldsPrint;
    }

    private String getClassConstructors() {
        String constuctorsPrint = "";
        Constructor[] constructors = cls.getConstructors();
        for (Constructor cons : constructors) {
            constuctorsPrint += "\n     public ";
            constuctorsPrint += className;
            constuctorsPrint += " (";
            Class[] parameterTypes = cons.getParameterTypes();
            for (Class parameter : parameterTypes) {
                constuctorsPrint += parameter.getTypeName().substring(parameter.getTypeName().lastIndexOf('.') + 1);
                constuctorsPrint += ",";
            }
            constuctorsPrint += ");";
        }
        return constuctorsPrint;
    }
    
    private String getClassMethods(){
        String methodsPrint = "";
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            methodsPrint += "\n     public ";
            methodsPrint += method.getReturnType().getName().substring(method.getReturnType().getName().lastIndexOf('.') + 1);
            methodsPrint += " ";
            methodsPrint += method.getName();
            methodsPrint += "(";
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameter : parameterTypes) {
                methodsPrint += parameter.getTypeName().substring(parameter.getTypeName().lastIndexOf('.') + 1);
                methodsPrint += ",";
            }
            methodsPrint += ");";
        }
        return methodsPrint;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public Boolean getValidClassName() {
        return validClassName;
    }

    public void setValidClassName(Boolean validClassName) {
        this.validClassName = validClassName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void printClassInterface() {
        try {
            Class cls = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
