package org.custom.items;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CharacterInventory
{
    private final Properties entries = new Properties();

    private final Map<String, ItemTemplate> slots = new HashMap<>(), slotsCopy = new HashMap<>();

    public void getEntries(String name) throws Exception
    {
        try
        {
            FileManager.loadFile("offset.conf", entries);
            FileManager.loadFile(name, entries);
        }

        catch (Exception e)
        {
            StringBuilder msg = new StringBuilder("The file ").append(name).append(" may be missing.\n\n")
                                          .append("More information is detailed below, if you can't solve this problem please contact chazy :)\n\n")
                                          .append(e.getMessage());

            throw new Exception(msg.toString());
        }
    }

    public boolean checkSlot(String slotName)
    {
        return slots.containsKey(slotName);
    }

    public ItemTemplate getSlot(String slotName)
    {
        return slots.get(slotName);
    }

    public ItemTemplate getSlotCopy(String slotName)
    {
        return slotsCopy.get(slotName);
    }

    public void setSlot(String slotName) throws Exception
    {
        slots.put(slotName, populateSlot(slotName));
        slotsCopy.put(slotName, new ItemTemplate());
    }

    private ItemTemplate populateSlot(String slotName) throws Exception
    {
        ItemTemplate item = new ItemTemplate(entries.getProperty(slotName));
        item.populateItem();
        return item;
    }
}
