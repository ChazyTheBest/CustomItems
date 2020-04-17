package org.custom.items;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppController
{
    @FXML private BorderPane appBody;
    @FXML private VBox content;
    @FXML private Button exit, closePreview;
    @FXML private RadioButton gold, pve;
    @FXML private Pane inventory, previewBody;
    @FXML private GridPane form;
    @FXML private Label status;
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
    private final TreeMap<String, VBox> tabs = new TreeMap<String, VBox>();
    private final TreeMap<String, CharacterInventory> classes = new TreeMap<String, CharacterInventory>();
    private String previousClass, currentClass, currentSlot;
    private ItemTemplate currentItem, currentItemCopy;
    private boolean success = false, preview = false;
    private final Stage previewStage = new Stage();
    private String clicked;
    private final GridPane item = new GridPane();


    AppController(RootController r) throws IOException
    {
        root = r;
        FXMLLoader appLoader        = new FXMLLoader(getClass().getResource("app.fxml")), // primaryStage
                   inventoryLoader  = new FXMLLoader(getClass().getResource("inventory.fxml")), // app.fxml Vbox id=content
                   formLoader       = new FXMLLoader(getClass().getResource("form.fxml")); // secondaryStage

        root.setCenter(null);
        appLoader.setRoot(root.getCenter());
        appLoader.setController(this);

        inventoryLoader.setRoot(content);
        inventoryLoader.setController(this);

        formLoader.setRoot(content);
        formLoader.setController(this);

        try
        {
            appLoader.load();
            inventoryLoader.load();
            formLoader.load();
        }

        catch (Exception e)
        {
            System.out.println("Error loading the interface");
            //e.printStackTrace();
        }
    }

    public void displayAppWindow(Stage s)
    {
        s.hide();
        root.setCenter(appBody);
        s.show();

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

            tabs.put(key, new VBox());

            tabs.get(key).getChildren().add(new Text("Create new custom items for class: " + key));
            tabs.get(key).getChildren().add(new Text("Select donor gear based on role to use as a base:"));

            int index = 2;

            for (String role : classRoles)
            {
                Node l = new Label(role.toUpperCase());

                l.getStyleClass().add("role");

                switch (role)
                {
                    case "tank": l.getStyleClass().add("tank"); break;
                    case "healer": l.getStyleClass().add("healer"); break;
                    case "melee":
                    case "caster":
                    case "ranged": l.getStyleClass().add("dps");
                }

                tabs.get(key).getChildren().add(l);
                tabs.get(key).getStylesheets().add(getClass().getResource("roles.css").toString());
                tabs.get(key).getChildren().get(index).setOnMouseClicked(e -> showItemPicker(key, role));
                index++;
            }
        }

        exit.setOnAction(e -> Platform.exit());

        status.setText("DB Status: Connected");
    }

    @FXML
    private void showRoles(MouseEvent event) throws Exception
    {
        content.getChildren().clear();
        content.getChildren().add(tabs.get(((Control) event.getSource()).getId()));
        success = false;

        gold.setSelected(false);
        pve.setSelected(false);

        closePreview();
    }

    private void showItemPicker(String c, String r)
    {
        content.getChildren().clear();

        String key = c + "_" + r;

        if (!classes.containsKey(key))
        {
            classes.put(key, new CharacterInventory());
            classes.get(key).getEntries(key + ".conf");
        }

        previousClass = currentClass != null && !currentClass.isEmpty() ? currentClass : "";
        currentClass = key;

        content.getChildren().add(inventory);
    }

    @FXML
    private void showForm(ActionEvent event)
    {
        clicked = "";
        currentSlot = ((Control) event.getSource()).getId();

        try
        {
            currentItem = classes.get(currentClass).getSlot(currentSlot);
        }

        catch (Exception e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "SQL Exception!", e.getMessage());
            //e.printStackTrace();
            return;
        }

        currentItemCopy = new ItemTemplate();

        String stats[] = currentItem.getStat_value();
        String statsCopy[] = currentItemCopy.getStat_value();

        for (int i = 0; i < 10; i++)
        {
            statsCopy[i] = stats[i];
        }

        currentItemCopy.setDmg_min1(currentItem.getDmg_min1());
        currentItemCopy.setDmg_max1(currentItem.getDmg_max1());
        currentItemCopy.setDmg_min2(currentItem.getDmg_min2());
        currentItemCopy.setDmg_max2(currentItem.getDmg_max2());
        currentItemCopy.setSocketColor_1(currentItem.getSocketColor_1());

        String id, n, d;

        if (!previousClass.isEmpty() && previousClass.equals(currentClass) && success)
        {
            id = !entry.getText().isEmpty() ? (1 + Integer.parseInt(entry.getText())) + "" : currentItem.getEntry();
            n = !name.getText().isEmpty() ? name.getText() : currentItem.getName();
            d = !description.getText().isEmpty() ? description.getText() : currentItem.getDescription();
        }

        else
        {
            id = currentItem.getEntry();
            n = currentItem.getName();
            d = currentItem.getDescription();
        }

        entry.setText(id);
        name.setText(n);
        quality.setText(currentItem.getQuality());
        description.setText(d);
        displayID.setText(currentItem.getDisplayid());

        String spellId[] = currentItem.getSpellid(),
               spellTrigger[] = currentItem.getSpelltrigger();

        spell1.setText(spellId[0]);
        spell2.setText(spellId[1]);
        spell3.setText(spellId[2]);
        spell4.setText(spellId[3]);
        spell5.setText(spellId[4]);
        trigger1.setText(spellTrigger[0]);
        trigger2.setText(spellTrigger[1]);
        trigger3.setText(spellTrigger[2]);
        trigger4.setText(spellTrigger[3]);
        trigger5.setText(spellTrigger[4]);

        content.getChildren().clear();
        content.getChildren().add(form);
    }

    @FXML
    private void itemModifier(MouseEvent event)
    {
        RadioButton rb = (RadioButton) type.getSelectedToggle();

        if (rb == null)
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", "Please select an item type (Gold or PvE).");
            return;
        }

        double mod = 0;

        if (rb.getId().equals("gold") && !clicked.equals("gold"))
        {
            clicked = "gold";

            // +10% to stats
            mod = 1.1;

            // no meta
            currentItem.setSocketColor_1(currentItemCopy.getSocketColor_1());
        }

        else if (rb.getId().equals("pve") && !clicked.equals("pve"))
        {
            clicked = "pve";

            // +50% to stats
            mod = 1.5;

            // 1: meta, 2: red, 4: yellow, 8: blue
            currentItem.setSocketColor_1("1");
        }

        if (mod != 0)
        {
            int stat_value[] = Stream.of(currentItemCopy.getStat_value()).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < 10; i++)
            {
                currentItem.setStat_value(i, Integer.toString(Double.valueOf(mod * stat_value[i]).intValue()));
            }

            // if weapon
            if (currentItem.getClas().equals("2"))
            {
                currentItem.setDmg_min1(Integer.toString(Double.valueOf(mod * Integer.parseInt(currentItemCopy.getDmg_min1())).intValue()));
                currentItem.setDmg_max1(Integer.toString(Double.valueOf(mod * Integer.parseInt(currentItemCopy.getDmg_max1())).intValue()));
                currentItem.setDmg_min2(Integer.toString(Double.valueOf(mod * Integer.parseInt(currentItemCopy.getDmg_min2())).intValue()));
                currentItem.setDmg_max2(Integer.toString(Double.valueOf(mod * Integer.parseInt(currentItemCopy.getDmg_max2())).intValue()));
            }

            itemPreview();
        }
    }

    @FXML
    private void preview(ActionEvent event)
    {
        if (!itemPreview())
        {
            return;
        }

        if (!preview)
        {
            initPreview();
        }

        else
        {
            previewStage.hide();
            previewStage.show();
        }
    }

    private void initPreview()
    {
        RootController PreviewRoot = new RootController();
        PreviewRoot.setStage(previewStage);

        item.setOnMousePressed(PreviewRoot::pressed);
        item.setOnMouseDragged(PreviewRoot::dragged);

        Scene scene = new Scene(item);
        scene.setCursor(root.getMouse());

        previewStage.initStyle(StageStyle.UNDECORATED);
        previewStage.getIcons().add(root.getLogo());
        previewStage.setTitle("Item Preview");
        previewStage.setScene(scene);
        previewStage.show();

        preview = true;
    }

    @FXML
    private void closePreview()
    {
        previewStage.close();
    }

    @FXML
    private void create (ActionEvent event) throws Exception
    {
        if (!setFields(false))
        {
            return;
        }

        if (currentItem.createItem())
        {
            gold.setSelected(false);
            pve.setSelected(false);

            success = true;
            closePreview();

            content.getChildren().clear();
            content.getChildren().add(inventory);
        }

        else
        {
            success = false;
        }
    }

    private boolean setFields(boolean isPreview)
    {
        RadioButton rb = (RadioButton) type.getSelectedToggle();

        if (rb == null)
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", "Please select an item type (Gold or PvE).");
            return false;
        }

        if (!isPreview && entry.getText().equals(currentItem.getBaseEntry()))
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", "Base entry shouldn't be overwritten, please use a different one.");
            return false;
        }

        currentItem.setEntry(entry.getText());
        currentItem.setName(name.getText());
        currentItem.setQuality(quality.getText());
        currentItem.setDescription(description.getText());
        currentItem.setDisplayid(displayID.getText());

        String spells[] = { spell1.getText(), spell2.getText(), spell3.getText(), spell4.getText(), spell5.getText() },
               spellId[] = currentItem.getSpellid();

        for (int i = 0; i < 5; i++)
        {
            spellId[i] = spells[i];
        }

        String triggers[] = { trigger1.getText(), trigger2.getText(), trigger3.getText(), trigger4.getText(), trigger5.getText() },
               spellTrigger[] = currentItem.getSpelltrigger();

        Map<Integer, String> check = ItemPreview.getSpellTrigger();

        for (int i = 0; i < 5; i++)
        {
            if (check.containsKey(Integer.parseInt(triggers[i])))
            {
                spellTrigger[i] = triggers[i];
            }

            else
            {
                UX.showAlert(Alert.AlertType.ERROR, "Form Error!", "The spell trigger is not valid.\n\nValid values are:\n0 (Use), 1 (Equip), 2 (Chance on hit), 4 (Soulstone), 5 (Use with no delay) and 6 (Learn Spell ID)");
            }
        }

        return true;
    }

    private boolean itemPreview()
    {
        if (!setFields(true))
        {
            return false;
        }

        int row = 0;

        item.getChildren().clear();

        String itemName = currentItem.getName();
        Node name;

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

        item.add(name, 0, row);

        // item bonding
        if (ItemPreview.getBonding().containsKey(Integer.parseInt(currentItem.getBonding())))
        {
            Node bonding = new Text(ItemPreview.getBonding().get(Integer.parseInt(currentItem.getBonding())));
            item.add(bonding, 0, row += 1);
        }

        // item maxcount
        if (!currentItem.getMaxcount().equals("0"))
        {
            Node unique = new Text(String.format("Unique (%s)", currentItem.getMaxcount()));
            item.add(unique, 0, row += 1);
        }

        // container slots
        if (currentItem.getClas().equals("1") && currentItem.getSubclass().equals("0"))
        {
            // it's a bag
            Node slots = new Text(String.format("%s Slot Bag", currentItem.getContainerSlots()));
            item.add(slots, 0, row += 1);
        }

        // it's a weapon
        else if (currentItem.getClas().equals("2"))
        {
            int wRow = row += 1,
                    dRow = row += 1,
                    min1 = Integer.parseInt(currentItem.getDmg_min1()),
                    max1 = Integer.parseInt(currentItem.getDmg_max1()),
                    min = min1,
                    max = max1;

            double del = Integer.parseInt(currentItem.getDelay()) / 1000.0;

            Node wType = new Text(ItemPreview.getInventoryType().get(Integer.parseInt(currentItem.getInventoryType()))),
                    wName = new Text(ItemPreview.getWeaponNameSubClass().get(Integer.parseInt(currentItem.getSubclass()))),
                    dmg = new Text(String.format("%d - %d Damage", min1, max1)),
                    delay = new Text(String.format("Speed %.2f", del));

            item.add(wType, 0, wRow);
            item.add(wName, 1, wRow);
            item.add(dmg, 0, dRow);
            item.add(delay, 1, dRow);

            item.setHalignment(wName, HPos.RIGHT);

            if (!currentItem.getDmg_min2().equals("0") && !currentItem.getDmg_max2().equals("0"))
            {
                int min2 = Integer.parseInt(currentItem.getDmg_min2()),
                        max2 = Integer.parseInt(currentItem.getDmg_max2());

                min += min2;
                max += max2;

                Node dmg2 = new Text(String.format("+%d - %d %s Damage", min2, max2, ItemPreview.getDmgType().get(Integer.parseInt(currentItem.getDmg_type2()))));

                item.add(dmg2, 0, row += 1);
            }

            Node wDps = new Text(String.format("(%.1f damage per second)", ((min + max) / 2) / del));

            item.add(wDps, 0, row += 1);
        }

        // it's armor
        else if (currentItem.getClas().equals("4"))
        {
            int aRow = row += 1;

            Node aType = new Text(ItemPreview.getInventoryType().get(Integer.parseInt(currentItem.getInventoryType()))),
                    aName = new Text(ItemPreview.getArmorTypeSubClass().get(Integer.parseInt(currentItem.getSubclass())));

            item.add(aType, 0, aRow);
            item.add(aName, 1, aRow);

            if (!currentItem.getArmor().equals("0"))
            {
                Node aValue = new Text(String.format("%s Armor", currentItem.getArmor()));
                item.add(aValue, 0, row += 1);
            }
        }

        int     stat_type[] = Stream.of(currentItem.getStat_type()).mapToInt(Integer::parseInt).toArray();
        String stat_value[] = currentItem.getStat_value();
        Map<Integer, String> stats = ItemPreview.getStatType();
        List<Node> stuff = new ArrayList<Node>();

        // item primary stats
        for (int i = 0; i < 10; i++)
        {
            if (stats.containsKey(stat_type[i]) && !stat_value[i].equals("0"))
            {
                String line = String.format(stats.get(stat_type[i]), stat_value[i]);
                Node text = new Text(line);

                if (line.charAt(0) == '+')
                {
                    item.add(text, 0, row += 1);
                }

                else
                {
                    text.getStyleClass().add("green");
                    stuff.add(text);
                }
            }
        }

        // socket color 1
        if (!currentItem.getSocketColor_1().equals("0"))
        {
            int sameRow1 = row += 1;
            String color1 = ItemPreview.getSocketColor().get(Integer.parseInt(currentItem.getSocketColor_1()));
            Node sImg1 = new Label(),
                 sText1 = new Text(String.format("      %s Socket", color1));

            sImg1.getStyleClass().add("socket");
            sImg1.setId(color1.toLowerCase() + "Socket");
            sText1.getStyleClass().add("gray");
            item.add(sImg1, 0, sameRow1);
            item.add(sText1, 0, sameRow1);
        }

        // socket color 2
        if (!currentItem.getSocketColor_2().equals("0"))
        {
            int sameRow2 = row += 1;
            String color2 = ItemPreview.getSocketColor().get(Integer.parseInt(currentItem.getSocketColor_2()));
            Node sImg2 = new Label(),
                 sText2 = new Text(String.format("      %s Socket", color2));

            sImg2.getStyleClass().add("socket");
            sImg2.setId(color2.toLowerCase() + "Socket");
            sText2.getStyleClass().add("gray");
            item.add(sImg2, 0, sameRow2);
            item.add(sText2, 0, sameRow2);
        }

        // socket color 3
        if (!currentItem.getSocketColor_3().equals("0"))
        {
            int sameRow3 = row += 1;
            String color3 = ItemPreview.getSocketColor().get(Integer.parseInt(currentItem.getSocketColor_3()));
            Node sImg3 = new Label(),
                 sText3 = new Text(String.format("      %s Socket", color3));

            sImg3.getStyleClass().add("socket");
            sImg3.setId(color3.toLowerCase() + "Socket");
            sText3.getStyleClass().add("gray");
            item.add(sImg3, 0, sameRow3);
            item.add(sText3, 0, sameRow3);
        }

        // socket bonus
        if (!currentItem.getSocketBonus().equals("0"))
        {
            Node sBonus = new Text(String.format("Socket Bonus: %s", ItemPreview.getSocketBonus().get(Integer.parseInt(currentItem.getSocketBonus()))));
            item.add(sBonus, 0, row += 1);
        }

        // allowable classes
        if (!currentItem.getAllowableClass().equals("-1"))
        {
            Node aClass = new Text(String.format("Classes: %s", ItemPreview.getAllowableClass().get(Integer.parseInt(currentItem.getAllowableClass()))));
            item.add(aClass, 0, row += 1);
        }

        // required level
        if (!currentItem.getRequiredLevel().equals("0"))
        {
            Node req = new Text(String.format("Requires Level %s", currentItem.getRequiredLevel()));
            item.add(req, 0, row += 1);
        }

        // item secondary stats
        for (Node text : stuff)
        {
            text.getStyleClass().add("green");
            item.add(text, 0, row += 1);
        }

        int spellId[] = Stream.of(currentItem.getSpellid()).mapToInt(Integer::parseInt).toArray(),
            spellTrigger[] = Stream.of(currentItem.getSpelltrigger()).mapToInt(Integer::parseInt).toArray();

        Map<Integer, String> spellIdText = ItemPreview.getSpellId(),
                spellTriggerText = ItemPreview.getSpellTrigger();

        // item spells
        for (int i = 0; i < 5; i++)
        {
            if (spellId[i] != 0)
            {
                Node spell = new Text(String.format("%s%s", spellTriggerText.get(spellTrigger[i]), spellIdText.get(spellId[i])));
                spell.getStyleClass().add("green");
                item.add(spell, 0, row += 1);
            }
        }

        // item description
        if (!currentItem.getDescription().equals(""))
        {
            Node desc = new Text(String.format("\"%s\"", currentItem.getDescription()));
            desc.getStyleClass().add("gold");
            item.add(desc, 0, row += 1);
        }

        item.getStylesheets().add(getClass().getResource("preview.css").toString());

        return true;
    }
}
