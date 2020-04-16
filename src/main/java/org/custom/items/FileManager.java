package org.custom.items;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileManager
{
    private final static String path = new StringBuilder(System.getProperty("user.home")).append("/WotG/").toString();

    public static void loadFile(String name, Properties p) throws Exception
    {
        try (InputStream input = new FileInputStream(path + name))
        {
            p.load(input);
        }

        catch (Exception e)
        {
            throw new Exception("There was a problem while reading the file: " + e.getMessage());
        }
    }

    public static void writeFile(String name, Properties p)
    {
        try (OutputStream output = new FileOutputStream(path + name))
        {
            p.store(output, null);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
