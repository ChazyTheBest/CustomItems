package org.custom.items;

import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

public class AppController
{
    @FXML private VBox welcome;
    @FXML private GridPane classes, inventory, itemForm;
    @FXML private RadioButton gold, pve;
    @FXML private ToggleGroup type;
    @FXML private TextField

                    entry,
                    name,
                    quality,
                    description,
                    displayID,
                    spell1,
                    spell2,
                    spell3,
                    spell4,
                    spell5,
                    trigger1,
                    trigger2,
                    trigger3,
                    trigger4,
                    trigger5;

    private final RootController root;
    private final TreeMap<String, VBox> tabs = new TreeMap<String, VBox>(); // aka roles
    private final TreeMap<String, CharacterInventory> characterInventoryTreeMap = new TreeMap<String, CharacterInventory>();
    private final TreeMap<Integer, ItemTemplate> createdItems = new TreeMap<Integer, ItemTemplate>();
    private String previousClass, currentClass;
    private GridPane currentSelected;
    private ItemTemplate currentItem, currentItemCopy;
    private boolean success = false, preview = false;
    private final Stage previewStage = new Stage();
    private final GridPane itemPreview = new GridPane();
    private final Scene previewScene = new Scene(itemPreview);


    AppController(RootController r)
    {
        root = r;
    }

    private void loader(String name, Node parent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));

        //loader.setRoot(parent);
        loader.setController(this);

        try
        {
            loader.load();
        }

        catch (Exception e)
        {
            System.out.println("Error loading interface file: " + name);
            e.printStackTrace();
        }
    }

    public void displayAppWindow(Stage s)
    {
        s.hide();

        root.setCenter(null);
        loader("welcome", root.getCenter());
        loader("classes", root.getBottom());
        loader("inventory", root.getLeft());
        loader("itemForm", root.getRight());

        root.getStyleClass().add("rootBG");
        root.setCenter(welcome);
        root.setBottom(classes);
        root.setCenter(welcome);

        Properties roles = new Properties();

        try
        {
            FileManager.loadFile("roles.conf", roles);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        for (String key : roles.stringPropertyNames())
        {
            String classRoles[] = roles.getProperty(key).split(",");

            for (int i = 0; i < classRoles.length; i++)
            {
                classRoles[i] = classRoles[i].trim();
            }

            VBox vbox = new VBox();
            Text selectText = new Text("Select the type of items you want to create:");

            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().add(selectText);

            for (String role : classRoles)
            {
                Node l = new Label(role.toUpperCase());

                l.getStyleClass().add("role");
                l.setCursor(root.getMouseCursorGossip());
                l.setOnMouseClicked(e -> showInventory(key, role));

                switch (role)
                {
                    case "tank": l.getStyleClass().add("tank"); break;
                    case "healer": l.getStyleClass().add("healer"); break;
                    case "melee":
                    case "caster":
                    case "ranged": l.getStyleClass().add("dps");
                }

                vbox.getChildren().add(l);
            }

            tabs.put(key, vbox);
        }

        for (Node node : classes.getChildren())
        {
            node.setCursor(root.getMouseCursorAttack());
        }

        for (Node node : inventory.getChildren())
        {
            node.setCursor(root.getMouseCursorGlow());
        }

        itemForm.getChildren().get(0).setCursor(root.getMouseCursorGossip());
        itemForm.getChildren().get(7).setCursor(root.getMouseCursorGlow());
        itemForm.getChildren().get(8).setCursor(root.getMouseCursorGlow());
        itemForm.getChildren().get(29).setCursor(root.getMouseCursorCreateOff());
        itemForm.getChildren().get(30).setCursor(root.getMouseCursorPreviewOff());

        spell1.setCursor(root.getMouseCursorWheel());
        spell2.setCursor(root.getMouseCursorWheel());
        spell3.setCursor(root.getMouseCursorWheel());
        spell4.setCursor(root.getMouseCursorWheel());
        spell5.setCursor(root.getMouseCursorWheel());
        trigger1.setCursor(root.getMouseCursorWheel());
        trigger2.setCursor(root.getMouseCursorWheel());
        trigger3.setCursor(root.getMouseCursorWheel());
        trigger4.setCursor(root.getMouseCursorWheel());
        trigger5.setCursor(root.getMouseCursorWheel());

        entry.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        quality.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        displayID.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        spell1.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        spell2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        spell3.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        spell4.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        spell5.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        trigger1.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        trigger2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        trigger3.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        trigger4.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        trigger5.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

        s.show();
    }

    @FXML
    private void showRoles(MouseEvent event)
    {
        if (currentSelected != null)
        {
            currentSelected.getStyleClass().removeAll("selected");
        }

        currentSelected = (GridPane) event.getSource();
        event.consume();

        currentSelected.getStyleClass().add("selected");

        previewStage.close();
        gold.setSelected(false);
        pve.setSelected(false);
        success = false;

        root.setCenter(tabs.get(currentSelected.getUserData().toString()));
    }

    private void showInventory(String c, String r)
    {
        String key = c + "_" + r;

        if (!characterInventoryTreeMap.containsKey(key))
        {
            try
            {
                characterInventoryTreeMap.put(key, new CharacterInventory());
                characterInventoryTreeMap.get(key).getEntries(key + ".conf");
            }

            catch (Exception e)
            {
                UX.showAlert(Alert.AlertType.ERROR, "Filesystem error", e.toString());
                return;
            }
        }

        previousClass = currentClass != null && !currentClass.isEmpty() ? currentClass : "";
        currentClass = key;

        root.setCenter(inventory);
    }

    @FXML
    private void showForm(MouseEvent event)
    {
        String slotName = ((ImageView) event.getSource()).getUserData().toString();

        event.consume();

        if (characterInventoryTreeMap.get(currentClass).checkSlot(slotName))
        {
            currentItem = characterInventoryTreeMap.get(currentClass).getSlot(slotName);
            currentItemCopy = characterInventoryTreeMap.get(currentClass).getSlotCopy(slotName);
        }

        else
        {
            try
            {
                characterInventoryTreeMap.get(currentClass).setSlot(slotName);
            }

            catch (Exception e)
            {
                UX.showAlert(Alert.AlertType.ERROR, "SQL Exception!", e.getMessage());
                return;
            }

            currentItem = characterInventoryTreeMap.get(currentClass).getSlot(slotName);
            currentItemCopy = characterInventoryTreeMap.get(currentClass).getSlotCopy(slotName);

            currentItemCopy.setEntry(currentItem.getEntry());
            currentItemCopy.setArmor(currentItem.getArmor());
            currentItemCopy.setBlock(currentItem.getBlock());

            System.arraycopy(currentItem.getStat_value(), 0, currentItemCopy.getStat_value(), 0, 10);
            System.arraycopy(currentItem.getDmg_min(), 0, currentItemCopy.getDmg_min(), 0, 2);
            System.arraycopy(currentItem.getDmg_max(), 0, currentItemCopy.getDmg_max(), 0, 2);

            currentItemCopy.getSocketColor()[0] = currentItem.getSocketColor()[0];
        }

        int id;
        String n, d;

        if (!previousClass.isEmpty() && previousClass.equals(currentClass) && success)
        {
            id = !entry.getText().isEmpty() ? (1 + Integer.parseInt(entry.getText())) : currentItem.getEntry();
            n = !name.getText().isEmpty() ? name.getText() : currentItem.getName();
            d = !description.getText().isEmpty() ? description.getText() : currentItem.getDescription();
        }

        else
        {
            id = currentItem.getEntry();
            n = currentItem.getName();
            d = currentItem.getDescription();
        }

        entry.setText(String.valueOf(id));
        name.setText(n);
        quality.setText(String.valueOf(currentItem.getQuality()));
        description.setText(d);
        displayID.setText(String.valueOf(currentItem.getDisplayid()));

        int spellId[] = currentItem.getSpellid(),
            spellTrigger[] = currentItem.getSpelltrigger();

        spell1.setText(String.valueOf(spellId[0]));
        spell2.setText(String.valueOf(spellId[1]));
        spell3.setText(String.valueOf(spellId[2]));
        spell4.setText(String.valueOf(spellId[3]));
        spell5.setText(String.valueOf(spellId[4]));
        trigger1.setText(String.valueOf(spellTrigger[0]));
        trigger2.setText(String.valueOf(spellTrigger[1]));
        trigger3.setText(String.valueOf(spellTrigger[2]));
        trigger4.setText(String.valueOf(spellTrigger[3]));
        trigger5.setText(String.valueOf(spellTrigger[4]));

        root.setCenter(itemForm);
    }

    @FXML
    private void handleFormClicks(MouseEvent event)
    {
        MouseButton button = event.getButton();

        if (button == MouseButton.PRIMARY)
        {
            root.requestFocus();
        }

        else if (button == MouseButton.BACK)
        {
            backToInventory();
        }
    };

    @FXML
    private void backToInventory()
    {
        gold.setSelected(false);
        pve.setSelected(false);
        itemForm.getChildren().get(29).setCursor(root.getMouseCursorCreateOff());
        itemForm.getChildren().get(30).setCursor(root.getMouseCursorPreviewOff());
        previewStage.close();
        root.setCenter(inventory);
    }

    @FXML
    private void itemModifier()
    {
        RadioButton rb = (RadioButton) type.getSelectedToggle();
        double mod = 0;

        if (rb.getId().equals("gold"))
        {
            // +10% to stats
            mod = 1.1;

            // revert back to base socketColor
            currentItem.getSocketColor()[0] = currentItemCopy.getSocketColor()[0];
        }

        else if (rb.getId().equals("pve"))
        {
            // +50% to stats
            mod = 1.5;

            // no meta socket for containers
            if (currentItem.getClas() != 1)
            {
                // pve items get 1 meta socket
                currentItem.getSocketColor()[0] = 1;
            }
        }

        if (mod != 0)
        {
            // armor value
            currentItem.setArmor(Double.valueOf(mod * currentItemCopy.getArmor()).intValue());

            // block value
            currentItem.setBlock(Double.valueOf(mod * currentItemCopy.getBlock()).intValue());

            int stat_value[] = currentItemCopy.getStat_value(),
                currentStatValue[] = currentItem.getStat_value();

            for (int i = 0; i < 10; i++)
            {
                currentStatValue[i] = Double.valueOf(mod * stat_value[i]).intValue();
            }

            // if weapon
            if (currentItem.getClas() == 2)
            {
                double min[] = currentItem.getDmg_min(),
                       max[] = currentItem.getDmg_max(),
                       minCopy[] = currentItemCopy.getDmg_min(),
                       maxCopy[] = currentItemCopy.getDmg_max();

                for (int i = 0; i < 2; i++)
                {
                    min[i] = mod * minCopy[i];
                    max[i] = mod * maxCopy[i];
                }
            }

            try
            {
                itemPreview();
            }

            catch (Exception e)
            {
                UX.showAlert(Alert.AlertType.ERROR, "Form Error!", e.getMessage());
            }
        }

        itemForm.getChildren().get(29).setCursor(root.getMouseCursorCreate());
        itemForm.getChildren().get(30).setCursor(root.getMouseCursorPreview());
    }

    @FXML
    private void preview()
    {
        try
        {
            itemPreview();
        }

        catch (Exception e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", e.getMessage());
            return;
        }

        if (!preview)
        {
            RootController PreviewRoot = new RootController();
            PreviewRoot.setStage(previewStage);

            itemPreview.setId("itemPreview");
            itemPreview.setOnMousePressed(PreviewRoot::pressed);
            itemPreview.setOnMouseDragged(PreviewRoot::dragged);

            previewScene.setCursor(root.getMouseCursor());

            previewStage.initStyle(StageStyle.UNDECORATED);
            previewStage.getIcons().add(root.getLogo());
            previewStage.setTitle("Item Preview");
            previewStage.setScene(previewScene);
            previewStage.show();

            preview = true; // won't get executed again
        }

        else
        {
            previewStage.close();
            previewStage.show();
        }
    }

    @FXML
    private void create()
    {
        try
        {
            setFields(false);
        }

        catch (Exception e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", e.getMessage());
            return;
        }

        try
        {
            currentItem.createItem();
            createdItems.put(currentItem.getEntry(), currentItem);
            success = true;
        }

        catch (Exception e)
        {
            success = false;
            UX.showAlert(Alert.AlertType.ERROR, "SQL Exception!", e.getMessage());
        }

        finally
        {
            backToInventory();
        }
    }

    private void setFields(boolean isPreview) throws Exception
    {
        RadioButton rb = (RadioButton) type.getSelectedToggle();

        if (rb == null)
        {
            throw new Exception("Please select an item type (Gold or PvE).");
        }

        if (!isPreview && entry.getText().equals(String.valueOf(currentItemCopy.getEntry())))
        {
            throw new Exception("Base entry shouldn't be overwritten, please use a different one.");
        }

        try
        {
            currentItem.setName(name.getText());
            currentItem.setDescription(description.getText());
            currentItem.setEntry(Integer.parseInt(entry.getText()));
            currentItem.setQuality(Integer.parseInt(quality.getText()));
            currentItem.setDisplayid(Integer.parseInt(displayID.getText()));

            int spells[] =
            {
                Integer.parseInt(spell1.getText()),
                Integer.parseInt(spell2.getText()),
                Integer.parseInt(spell3.getText()),
                Integer.parseInt(spell4.getText()),
                Integer.parseInt(spell5.getText())
            };

            System.arraycopy(spells, 0, currentItem.getSpellid(), 0, 5);

            int triggers[] =
            {
                Integer.parseInt(trigger1.getText()),
                Integer.parseInt(trigger2.getText()),
                Integer.parseInt(trigger3.getText()),
                Integer.parseInt(trigger4.getText()),
                Integer.parseInt(trigger5.getText())
            };

            int spellTrigger[] = currentItem.getSpelltrigger();
            Map<Integer, String> check = ItemPreview.getSpellTrigger();

            for (int i = 0; i < 5; i++)
            {
                spellTrigger[i] = triggers[i];

                if (!check.containsKey(triggers[i]))
                {
                    throw new Exception("The spell trigger is not valid.\n\nValid values are:\n0 (Use), 1 (Equip), 2 (Chance on hit), 4 (Soulstone), 5 (Use with no delay) and 6 (Learn Spell ID)");
                }
            }
        }

        catch (NumberFormatException e)
        {
            throw new Exception("Only numbers allowed!");
        }
    }

    private void itemPreview() throws Exception
    {
        try
        {
            setFields(true);
        }

        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }

        int row = 0;

        itemPreview.getChildren().clear();

        String itemName = currentItem.getName();
        Text name;

        // TODO: implement more than one color
        if (itemName.startsWith("|cff"))
        {
            name = new Text(itemName.substring(10));
            name.setStyle("-fx-fill: #" + itemName.substring(4,10));
        }

        else
        {
            name = new Text(itemName);
        }

        name.getStyleClass().add("itemName");

        itemPreview.add(name, 0, row, 2, 1);

        // item bonding
        if (ItemPreview.getBonding().containsKey(currentItem.getBonding()))
        {
            Text bonding = new Text(ItemPreview.getBonding().get(currentItem.getBonding()));
            itemPreview.add(bonding, 0, row += 1);
        }

        // item maxcount
        if (currentItem.getMaxcount() != 0)
        {
            Text unique = new Text(String.format("Unique (%d)", currentItem.getMaxcount()));
            itemPreview.add(unique, 0, row += 1);
        }

        // container slots
        if (currentItem.getClas() == 1 && currentItem.getSubclass() == 0)
        {
            // it's a bag
            Text slots = new Text(String.format("%d Slot Bag", currentItem.getContainerSlots()));
            itemPreview.add(slots, 0, row += 1);
        }

        // it's a weapon
        else if (currentItem.getClas() == 2)
        {
            int     wRow = row += 1,
                    dRow = row += 1;
            double  min1 = currentItem.getDmg_min()[0],
                    max1 = currentItem.getDmg_max()[0],
                    min = min1,
                    max = max1,
                    min2 = currentItem.getDmg_min()[1],
                    max2 = currentItem.getDmg_min()[1];

            double del = currentItem.getDelay() / 1000.0;

            Text wType = new Text(ItemPreview.getInventoryType().get(currentItem.getInventoryType())),
                    wName = new Text(ItemPreview.getWeaponNameSubClass().get(currentItem.getSubclass())),
                    dmg = new Text(String.format("%.0f - %.0f Damage", min1, max1)),
                    delay = new Text(String.format("Speed %.2f", del));

            itemPreview.add(wType, 0, wRow);
            itemPreview.add(wName, 1, wRow);
            itemPreview.add(dmg, 0, dRow);
            itemPreview.add(delay, 1, dRow);

            GridPane.setHalignment(wName, HPos.RIGHT);
            GridPane.setHalignment(delay, HPos.RIGHT);

            if (min2 != 0 && max2 != 0)
            {
                min += min2;
                max += max2;

                Text dmg2 = new Text(String.format("+%.0f - %.0f %s Damage", min2, max2, ItemPreview.getDmgType().get(currentItem.getDmg_type()[1])));

                itemPreview.add(dmg2, 0, row += 1);
            }

            Text wDps = new Text(String.format("(%.1f damage per second)", ((min + max) / 2) / del));

            itemPreview.add(wDps, 0, row += 1);
        }

        // it's armor
        else if (currentItem.getClas() == 4)
        {
            int aRow = row += 1;

            Text aType = new Text(ItemPreview.getInventoryType().get(currentItem.getInventoryType())),
                 aName = new Text(ItemPreview.getArmorTypeSubClass().get(currentItem.getSubclass()));

            itemPreview.add(aType, 0, aRow);
            itemPreview.add(aName, 1, aRow);

            GridPane.setHalignment(aName, HPos.RIGHT);

            if (currentItem.getArmor() != 0)
            {
                Text aValue = new Text(String.format("%d Armor", currentItem.getArmor()));
                itemPreview.add(aValue, 0, row += 1);
            }

            if (currentItem.getBlock() != 0)
            {
                Text bValue = new Text(String.format("%d Block", currentItem.getBlock()));
                itemPreview.add(bValue, 0, row += 1);
            }
        }

        int  stat_type[] = currentItem.getStat_type();
        int stat_value[] = currentItem.getStat_value();
        Map<Integer, String> stats = ItemPreview.getStatType();
        List<Text> stuff = new ArrayList<Text>();

        // item primary stats
        for (int i = 0; i < 10; i++)
        {
            if (stats.containsKey(stat_type[i]) && stat_value[i] != 0)
            {
                String line = String.format(stats.get(stat_type[i]), stat_value[i]);
                Text text = new Text(line);

                if (line.charAt(0) == '+')
                {
                    itemPreview.add(text, 0, row += 1);
                }

                else
                {
                    text.getStyleClass().add("green");
                    stuff.add(text);
                }
            }
        }

        int socketColor[] = currentItem.getSocketColor();

        // socket color
        for (int i = 0; i < 3; i++)
        {
            if (socketColor[i] != 0)
            {
                int sameRow = row += 1;
                String color = ItemPreview.getSocketColor().get(socketColor[i]);
                Label sImg = new Label();
                Text sText = new Text(String.format("      %s Socket", color));

                sImg.getStyleClass().add("socket");
                sImg.setId(color.toLowerCase() + "Socket");
                sText.getStyleClass().add("gray");

                itemPreview.add(sImg, 0, sameRow);
                itemPreview.add(sText, 0, sameRow);
            }
        }

        // socket bonus
        if (currentItem.getSocketBonus() != 0)
        {
            Text sBonus = new Text(String.format("Socket Bonus: %s", ItemPreview.getSocketBonus().get(currentItem.getSocketBonus())));
            itemPreview.add(sBonus, 0, row += 1);
        }

        // allowable classes
        if (currentItem.getAllowableClass() != -1)
        {
            Text aClass = new Text(String.format("Classes: %s", ItemPreview.getAllowableClass().get(currentItem.getAllowableClass())));
            itemPreview.add(aClass, 0, row += 1);
        }

        // required level
        if (currentItem.getRequiredLevel() != 0)
        {
            Text req = new Text(String.format("Requires Level %d", currentItem.getRequiredLevel()));
            itemPreview.add(req, 0, row += 1);
        }

        // item secondary stats
        for (Node text : stuff)
        {
            text.getStyleClass().add("green");
            itemPreview.add(text, 0, row += 1);
        }

        int spellId[] = currentItem.getSpellid(),
            spellTrigger[] = currentItem.getSpelltrigger();

        Map<Integer, String> spellIdText = ItemPreview.getSpellId(),
                             spellTriggerText = ItemPreview.getSpellTrigger();

        // item spells
        for (int i = 0; i < 5; i++)
        {
            if (spellId[i] != 0)
            {
                int sameRow = row += 1;
                Text spell = new Text(String.format("%s%s", spellTriggerText.get(spellTrigger[i]), spellIdText.get(spellId[i])));
                spell.getStyleClass().add("green");
                spell.wrappingWidthProperty().bind(itemPreview.maxWidthProperty());
                itemPreview.add(spell, 0, sameRow, 2, 1);
            }
        }

        // item description
        if (!currentItem.getDescription().equals(""))
        {
            Node desc = new Text(String.format("\"%s\"", currentItem.getDescription()));
            desc.getStyleClass().add("gold");
            //desc.wrappingWidthProperty().bind(itemPreview.maxWidthProperty());
            itemPreview.add(desc, 0, row + 1, 2, 1);
        }

        itemPreview.getStylesheets().add(getClass().getResource("itemPreview.css").toString());
        itemPreview.setMaxWidth(400);
    }
}
