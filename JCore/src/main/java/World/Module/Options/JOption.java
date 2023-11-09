package World.Module.Options;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//保留在程序运行时
@Target(ElementType.FIELD)
public @interface JOption {
    String Opt() default "";
    String LongOpt() default "";
    boolean Required() default false;
    String Description() default "";
    boolean HasArgs() default true;
}
