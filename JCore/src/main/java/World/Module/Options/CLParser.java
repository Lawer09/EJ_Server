package World.Module.Options;

import org.apache.commons.cli.*;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.function.Consumer;

public class CLParser<T> {
    private final static CommandLineParser defaultParser = new DefaultParser();

    private Consumer<String> error;
    private Consumer<T> result;

    private Options options;
    private String[] args;
    private T obj;
    public CLParser<T> Create(T obj, String[] args) {
        options = GetOptions(obj);
        this.args = args;
        this.obj = obj;
        return this;
    }

    private static <T> Options GetOptions(T obj) {
        Options options = new Options();
        for (Field field : obj.getClass().getDeclaredFields()) {
            JOption jOption = field.getAnnotation(JOption.class);
            if (jOption != null) {
                //创建Option
                String opt = jOption.Opt();
                String longOpt = jOption.LongOpt();
                boolean hasArgs = jOption.HasArgs();
                boolean required = jOption.Required();
                String description = jOption.Description();

                Option option = new Option(opt, hasArgs, description);
                option.setRequired(required);
                option.setArgName(opt);
                option.setLongOpt(longOpt);
                options.addOption(option);
            }
        }
        return options;
    }

    public CLParser<T> WithNoParsed(Consumer<String> error) {
        this.error = error;
        return this;
    }

    public CLParser<T> WithParsed(Consumer<T> result) {
        this.result = result;
        return this;
    }

    public void Parse()
    {
        try {
            CommandLine cl = defaultParser.parse(options, args);
            //遍历对象中的字段并赋值
            for (Field field : obj.getClass().getDeclaredFields()) {
                JOption jOption = field.getAnnotation(JOption.class);
                Class<?> type = field.getType();
                if (cl.hasOption(jOption.Opt())) {
                    String value = cl.getOptionValue(jOption.Opt());
                    if(type.equals(int.class))
                    {
                        field.setInt(obj, Integer.parseInt(value));
                    } else if (type.equals(String.class)) {
                        field.set(obj,value);
                    } else if (type.equals(boolean.class)) {
                        field.setBoolean(obj, Boolean.parseBoolean(value));
                    } else if (type.equals(AppType.class)) {
                        field.set(obj, Enum.valueOf(AppType.class, value));
                    }
                }
            }
            if(this.result != null)
                this.result.accept(obj);
        } catch (ParseException | IllegalAccessException e) {
            this.error.accept(e.getMessage());
        }
    }
}
