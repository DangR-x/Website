package xiongjunmiao.top.Website.repeat.util;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 类型转换器
 * 
 * @author ruoyi
 */
public class Convert
{
    /**
     * 转换为字符串<br>
     * 如果给定的值为null，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static String toStr(Object value, String defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof String)
        {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * 转换为字符串<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static String toStr(Object value)
    {
        return toStr(value, null);
    }

    /**
     * 转换为字符<br>
     * 如果给定的值为null，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Character toChar(Object value, Character defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof Character)
        {
            return (Character) value;
        }

        final String valueStr = toStr(value, null);
        return StringUtils.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
    }

    /**
     * 转换为字符<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Character toChar(Object value)
    {
        return toChar(value, null);
    }

    /**
     * 转换为byte<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Byte toByte(Object value, Byte defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Byte)
        {
            return (Byte) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).byteValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Byte.parseByte(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为byte<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Byte toByte(Object value)
    {
        return toByte(value, null);
    }

    /**
     * 转换为Short<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Short toShort(Object value, Short defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Short)
        {
            return (Short) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).shortValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Short.parseShort(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为Short<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Short toShort(Object value)
    {
        return toShort(value, null);
    }

    /**
     * 转换为Number<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Number toNumber(Object value, Number defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Number)
        {
            return (Number) value;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return NumberFormat.getInstance().parse(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为Number<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Number toNumber(Object value)
    {
        return toNumber(value, null);
    }

    /**
     * 转换为int<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Integer toInt(Object value, Integer defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Integer)
        {
            return (Integer) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为int<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Integer toInt(Object value)
    {
        return toInt(value, null);
    }

    /**
     * 转换为Integer数组<br>
     * 
     * @param str 被转换的值
     * @return 结果
     */
    public static Integer[] toIntArray(String str)
    {
        return toIntArray(",", str);
    }

    /**
     * 转换为Long数组<br>
     * 
     * @param str 被转换的值
     * @return 结果
     */
    public static Long[] toLongArray(String str)
    {
        return toLongArray(",", str);
    }

    /**
     * 转换为Integer数组<br>
     * 
     * @param split 分隔符
     * @param split 被转换的值
     * @return 结果
     */
    public static Integer[] toIntArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Integer[] {};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    /**
     * 转换为Long数组<br>
     * 
     * @param split 分隔符
     * @param str 被转换的值
     * @return 结果
     */
    public static Long[] toLongArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Long[] {};
        }
        String[] arr = str.split(split);
        final Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Long v = toLong(arr[i], null);
            longs[i] = v;
        }
        return longs;
    }

    /**
     * 转换为String数组<br>
     * 
     * @param str 被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String str)
    {
        return toStrArray(",", str);
    }

    /**
     * 转换为String数组<br>
     * 
     * @param split 分隔符
     * @param split 被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String split, String str)
    {
        return str.split(split);
    }

    /**
     * 转换为long<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Long toLong(Object value, Long defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Long)
        {
            return (Long) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).longValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            // 支持科学计数法
            return new BigDecimal(valueStr.trim()).longValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为long<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Long toLong(Object value)
    {
        return toLong(value, null);
    }

    /**
     * 转换为double<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Double toDouble(Object value, Double defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Double)
        {
            return (Double) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).doubleValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            // 支持科学计数法
            return new BigDecimal(valueStr.trim()).doubleValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为double<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Double toDouble(Object value)
    {
        return toDouble(value, null);
    }

    /**
     * 转换为Float<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Float toFloat(Object value, Float defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Float)
        {
            return (Float) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).floatValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Float.parseFloat(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为Float<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Float toFloat(Object value)
    {
        return toFloat(value, null);
    }

    /**
     * 转换为boolean<br>
     * String支持的值为：true、false、yes、ok、no，1,0 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Boolean toBool(Object value, Boolean defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Boolean)
        {
            return (Boolean) value;
        }
        String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        valueStr = valueStr.trim().toLowerCase();
        switch (valueStr)
        {
            case "true":
                return true;
            case "false":
                return false;
            case "yes":
                return true;
            case "ok":
                return true;
            case "no":
                return false;
            case "1":
                return true;
            case "0":
                return false;
            default:
                return defaultValue;
        }
    }

    /**
     * 转换为boolean<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static Boolean toBool(Object value)
    {
        return toBool(value, null);
    }

    /**
     * 转换为Enum对象<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 
     * @param clazz Enum的Class
     * @param value 值
     * @param defaultValue 默认值
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (clazz.isAssignableFrom(value.getClass()))
        {
            @SuppressWarnings("unchecked")
            E myE = (E) value;
            return myE;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Enum.valueOf(clazz, valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为Enum对象<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 
     * @param clazz Enum的Class
     * @param value 值
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value)
    {
        return toEnum(clazz, value, null);
    }

    /**
     * 转换为BigInteger<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static BigInteger toBigInteger(Object value, BigInteger defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigInteger)
        {
            return (BigInteger) value;
        }
        if (value instanceof Long)
        {
            return BigInteger.valueOf((Long) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigInteger(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为BigInteger<br>
     * 如果给定的值为空，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static BigInteger toBigInteger(Object value)
    {
        return toBigInteger(value, null);
    }

    /**
     * 转换为BigDecimal<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigDecimal)
        {
            return (BigDecimal) value;
        }
        if (value instanceof Long)
        {
            return new BigDecimal((Long) value);
        }
        if (value instanceof Double)
        {
            return new BigDecimal((Double) value);
        }
        if (value instanceof Integer)
        {
            return new BigDecimal((Integer) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigDecimal(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 转换为BigDecimal<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     * 
     * @param value 被转换的值
     * @return 结果
     */
    public static BigDecimal toBigDecimal(Object value)
    {
        return toBigDecimal(value, null);
    }

    /**
     * 将对象转为字符串<br>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组 2、对象数组会调用Arrays.toString方法
     * 
     * @param obj 对象
     * @return 字符串
     */
    public static String utf8Str(Object obj)
    {
        return str(obj, CharsetKit.CHARSET_UTF_8);
    }

    /**
     * 将对象转为字符串<br>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组 2、对象数组会调用Arrays.toString方法
     * 
     * @param obj 对象
     * @param charsetName 字符集
     * @return 字符串
     */
    public static String str(Object obj, String charsetName)
    {
        return str(obj, Charset.forName(charsetName));
    }

    /**
     * 将对象转为字符串<br>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组 2、对象数组会调用Arrays.toString方法
     * 
     * @param obj 对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String str(Object obj, Charset charset)
    {
        if (null == obj)
        {
            return null;
        }

        if (obj instanceof String)
        {
            return (String) obj;
        }
        else if (obj instanceof byte[] || obj instanceof Byte[])
        {
            return str((Byte[]) obj, charset);
        }
        else if (obj instanceof ByteBuffer)
        {
            return str((ByteBuffer) obj, charset);
        }
        return obj.toString();
    }

    /**
     * 将byte数组转为字符串
     * 
     * @param bytes byte数组
     * @param charset 字符集
     * @return 字符串
     */
    public static String str(byte[] bytes, String charset)
    {
        return str(bytes, StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * 解码字节码
     * 
     * @param data 字符串
     * @param charset 字符集，如果此字段为空，则解码的结果取决于平台
     * @return 解码后的字符串
     */
    public static String str(byte[] data, Charset charset)
    {
        if (data == null)
        {
            return null;
        }

        if (null == charset)
        {
            return new String(data);
        }
        return new String(data, charset);
    }

    /**
     * 将编码的byteBuffer数据转换为字符串
     * 
     * @param data 数据
     * @param charset 字符集，如果为空使用当前系统字符集
     * @return 字符串
     */
    public static String str(ByteBuffer data, String charset)
    {
        if (data == null)
        {
            return null;
        }

        return str(data, Charset.forName(charset));
    }

    /**
     * 将编码的byteBuffer数据转换为字符串
     * 
     * @param data 数据
     * @param charset 字符集，如果为空使用当前系统字符集
     * @return 字符串
     */
    public static String str(ByteBuffer data, Charset charset)
    {
        if (null == charset)
        {
            charset = Charset.defaultCharset();
        }
        return charset.decode(data).toString();
    }

    // ----------------------------------------------------------------------- 全角半角转换
    /**
     * 半角转全角
     * 
     * @param input String.
     * @return 全角字符串.
     */
    public static String toSBC(String input)
    {
        return toSBC(input, null);
    }

    /**
     * 半角转全角
     * 
     * @param input String
     * @param notConvertSet 不替换的字符集合
     * @return 全角字符串.
     */
    public static String toSBC(String input, Set<Character> notConvertSet)
    {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                // 跳过不替换的字符
                continue;
            }

            if (c[i] == ' ')
            {
                c[i] = '\u3000';
            }
            else if (c[i] < '\177')
            {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     * 
     * @param input String.
     * @return 半角字符串
     */
    public static String toDBC(String input)
    {
        return toDBC(input, null);
    }

    /**
     * 替换全角为半角
     * 
     * @param text 文本
     * @param notConvertSet 不替换的字符集合
     * @return 替换后的字符
     */
    public static String toDBC(String text, Set<Character> notConvertSet)
    {
        char c[] = text.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                // 跳过不替换的字符
                continue;
            }

            if (c[i] == '\u3000')
            {
                c[i] = ' ';
            }
            else if (c[i] > '\uFF00' && c[i] < '\uFF5F')
            {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);

        return returnString;
    }

    /**
     * 数字金额大写转换 先写个完整的然后将如零拾替换成零
     * 
     * @param n 数字
     * @return 中文大写数字
     */
    public static String digitUppercase(double n)
    {
        String[] fraction = { "角", "分" };
        String[] digit = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[][] unit = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

        String head = n < 0 ? "负" : "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++)
        {
            s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if (s.length() < 1)
        {
            s = "整";
        }
        int integerPart = (int) Math.floor(n);

        for (int i = 0; i < unit[0].length && integerPart > 0; i++)
        {
            String p = "";
            for (int j = 0; j < unit[1].length && n > 0; j++)
            {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart = integerPart / 10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }

    /**
     * 字符串工具类
     *
     * @author ruoyi
     */
    public static class StringUtils extends org.apache.commons.lang3.StringUtils
    {
        /** 空字符串 */
        private static final String NULLSTR = "";

        /** 下划线 */
        private static final char SEPARATOR = '_';

        /**
         * 获取参数不为空值
         *
         * @param value defaultValue 要判断的value
         * @return value 返回值
         */
        public static <T> T nvl(T value, T defaultValue)
        {
            return value != null ? value : defaultValue;
        }

        /**
         * * 判断一个Collection是否为空， 包含List，Set，Queue
         *
         * @param coll 要判断的Collection
         * @return true：为空 false：非空
         */
        public static boolean isEmpty(Collection<?> coll)
        {
            return isNull(coll) || coll.isEmpty();
        }

        /**
         * * 判断一个Collection是否非空，包含List，Set，Queue
         *
         * @param coll 要判断的Collection
         * @return true：非空 false：空
         */
        public static boolean isNotEmpty(Collection<?> coll)
        {
            return !isEmpty(coll);
        }

        /**
         * * 判断一个对象数组是否为空
         *
         * @param objects 要判断的对象数组
         ** @return true：为空 false：非空
         */
        public static boolean isEmpty(Object[] objects)
        {
            return isNull(objects) || (objects.length == 0);
        }

        /**
         * * 判断一个对象数组是否非空
         *
         * @param objects 要判断的对象数组
         * @return true：非空 false：空
         */
        public static boolean isNotEmpty(Object[] objects)
        {
            return !isEmpty(objects);
        }

        /**
         * * 判断一个Map是否为空
         *
         * @param map 要判断的Map
         * @return true：为空 false：非空
         */
        public static boolean isEmpty(Map<?, ?> map)
        {
            return isNull(map) || map.isEmpty();
        }

        /**
         * * 判断一个Map是否为空
         *
         * @param map 要判断的Map
         * @return true：非空 false：空
         */
        public static boolean isNotEmpty(Map<?, ?> map)
        {
            return !isEmpty(map);
        }

        /**
         * * 判断一个字符串是否为空串
         *
         * @param str String
         * @return true：为空 false：非空
         */
        public static boolean isEmpty(String str)
        {
            return isNull(str) || NULLSTR.equals(str.trim());
        }

        /**
         * * 判断一个字符串是否为非空串
         *
         * @param str String
         * @return true：非空串 false：空串
         */
        public static boolean isNotEmpty(String str)
        {
            return !isEmpty(str);
        }

        /**
         * * 判断一个对象是否为空
         *
         * @param object Object
         * @return true：为空 false：非空
         */
        public static boolean isNull(Object object)
        {
            return object == null;
        }

        /**
         * * 判断一个对象是否非空
         *
         * @param object Object
         * @return true：非空 false：空
         */
        public static boolean isNotNull(Object object)
        {
            return !isNull(object);
        }

        /**
         * * 判断一个对象是否是数组类型（Java基本型别的数组）
         *
         * @param object 对象
         * @return true：是数组 false：不是数组
         */
        public static boolean isArray(Object object)
        {
            return isNotNull(object) && object.getClass().isArray();
        }

        /**
         * 去空格
         */
        public static String trim(String str)
        {
            return (str == null ? "" : str.trim());
        }

        /**
         * 截取字符串
         *
         * @param str 字符串
         * @param start 开始
         * @return 结果
         */
        public static String substring(final String str, int start)
        {
            if (str == null)
            {
                return NULLSTR;
            }

            if (start < 0)
            {
                start = str.length() + start;
            }

            if (start < 0)
            {
                start = 0;
            }
            if (start > str.length())
            {
                return NULLSTR;
            }

            return str.substring(start);
        }

        /**
         * 截取字符串
         *
         * @param str 字符串
         * @param start 开始
         * @param end 结束
         * @return 结果
         */
        public static String substring(final String str, int start, int end)
        {
            if (str == null)
            {
                return NULLSTR;
            }

            if (end < 0)
            {
                end = str.length() + end;
            }
            if (start < 0)
            {
                start = str.length() + start;
            }

            if (end > str.length())
            {
                end = str.length();
            }

            if (start > end)
            {
                return NULLSTR;
            }

            if (start < 0)
            {
                start = 0;
            }
            if (end < 0)
            {
                end = 0;
            }

            return str.substring(start, end);
        }

        /**
         * 格式化文本, {} 表示占位符<br>
         * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
         * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
         * 例：<br>
         * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
         * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
         * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
         *
         * @param template 文本模板，被替换的部分用 {} 表示
         * @param params 参数值
         * @return 格式化后的文本
         */
        public static String format(String template, Object... params)
        {
            if (isEmpty(params) || isEmpty(template))
            {
                return template;
            }
            return StrFormatter.format(template, params);
        }

        /**
         * 下划线转驼峰命名
         */
        public static String toUnderScoreCase(String str)
        {
            if (str == null)
            {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            // 前置字符是否大写
            boolean preCharIsUpperCase = true;
            // 当前字符是否大写
            boolean curreCharIsUpperCase = true;
            // 下一字符是否大写
            boolean nexteCharIsUpperCase = true;
            for (int i = 0; i < str.length(); i++)
            {
                char c = str.charAt(i);
                if (i > 0)
                {
                    preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
                }
                else
                {
                    preCharIsUpperCase = false;
                }

                curreCharIsUpperCase = Character.isUpperCase(c);

                if (i < (str.length() - 1))
                {
                    nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
                }

                if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
                {
                    sb.append(SEPARATOR);
                }
                else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
                {
                    sb.append(SEPARATOR);
                }
                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }

        /**
         * 是否包含字符串
         *
         * @param str 验证字符串
         * @param strs 字符串组
         * @return 包含返回true
         */
        public static boolean inStringIgnoreCase(String str, String... strs)
        {
            if (str != null && strs != null)
            {
                for (String s : strs)
                {
                    if (str.equalsIgnoreCase(trim(s)))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
         *
         * @param name 转换前的下划线大写方式命名的字符串
         * @return 转换后的驼峰式命名的字符串
         */
        public static String convertToCamelCase(String name)
        {
            StringBuilder result = new StringBuilder();
            // 快速检查
            if (name == null || name.isEmpty())
            {
                // 没必要转换
                return "";
            }
            else if (!name.contains("_"))
            {
                // 不含下划线，仅将首字母大写
                return name.substring(0, 1).toUpperCase() + name.substring(1);
            }
            // 用下划线将原始字符串分割
            String[] camels = name.split("_");
            for (String camel : camels)
            {
                // 跳过原始字符串中开头、结尾的下换线或双重下划线
                if (camel.isEmpty())
                {
                    continue;
                }
                // 首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
            return result.toString();
        }

        /**
         * 驼峰式命名法 例如：user_name->userName
         */
        public static String toCamelCase(String s)
        {
            if (s == null)
            {
                return null;
            }
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s.length());
            boolean upperCase = false;
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);

                if (c == SEPARATOR)
                {
                    upperCase = true;
                }
                else if (upperCase)
                {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                }
                else
                {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        @SuppressWarnings("unchecked")
        public static <T> T cast(Object obj)
        {
            return (T) obj;
        }
    }
}
