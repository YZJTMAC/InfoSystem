package project.util;

public class NullUtil
{
    public static String null2Blank(String arg, String defaultstr)
    {
        if(arg == null || "".equals(arg))
        {
            return defaultstr;
        }
        return arg;
    }
    
    public static String null2Blank(Object arg, String defaultstr)
    {
        if(arg == null || "".equals(arg))
        {
            return defaultstr;
        }
        return arg.toString();
    }
    
    public static String null2Blank(Float arg, String defaultstr)
    {
        if(arg == null)
        {
            return defaultstr;
        }
        return arg.toString();
    }
    
    public static String null2Blank(Integer arg, String defaultstr)
    {
        if(arg == null)
        {
            return defaultstr;
        }
        return arg.toString();
    }
    
    public static String null2Blank(String arg)
    {
        if(arg == null)
        {
            return "";
        }
        return arg;
    }
    
    public static String null2Blank(Object arg)
    {
        if(arg == null)
        {
            return "";
        }
        return arg.toString();
    }
    
    public static String null2Blank(Float arg)
    {
        if(arg == null)
        {
            return "";
        }
        return arg.toString();
    }
    
    public static String nullZero2Blank(Integer arg)
    {
        if(arg == null || arg.intValue() == 0)
        {
            return "";
        }
        return arg.toString();
    }
    
    public static String nullZero2Blank(Float arg)
    {
        if(arg == null || arg.floatValue() == 0)
        {
            return "";
        }
        return arg.toString();
    }
    
    public static String null2Blank(Integer arg)
    {
        if(arg == null)
        {
            return "";
        }
        return arg.toString();
    }
    
    public static void main(String[] args)
    {
        
    }
}
