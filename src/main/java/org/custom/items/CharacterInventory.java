package org.custom.items;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.control.Alert;

public class CharacterInventory
{
    private Properties entries = new Properties();

    private final Map<String, ItemTemplate> slots = new HashMap<>();

    public void getEntries(String name)
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

            UX.showAlert(Alert.AlertType.ERROR, "Filesystem error", msg.toString());
            return;
        }
    }

    public ItemTemplate getSlot(String slotName) throws Exception
    {
        setSlot(slotName);

        return slots.get(slotName);
    }

    private void setSlot(String slotName) throws Exception
    {
        slots.put(slotName, populateSlot(slotName));
    }

    private ItemTemplate populateSlot(String slotName) throws Exception
    {
        ItemTemplate item = new ItemTemplate(entries.getProperty(slotName));
        item.populateItem();
        return item;
    }
}
