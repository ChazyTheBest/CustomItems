package org.custom.items;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class ItemTemplate
{
    private String

        stat_type[] = new String[10],
        stat_value[] = new String[10],
        spellid[] = new String[5],
        spelltrigger[] = new String[5];


    private String

        baseEntry,
        entry,
        clas,
        subclass,
        SoundOverrideSubclass,
        name,
        displayid,
        Quality,
        Flags,
        FlagsExtra,
        BuyCount,
        BuyPrice,
        SellPrice,
        InventoryType,
        AllowableClass,
        AllowableRace,
        ItemLevel,
        RequiredLevel,
        RequiredSkill,
        RequiredSkillRank,
        requiredspell,
        requiredhonorrank,
        RequiredCityRank,
        RequiredReputationFaction,
        RequiredReputationRank,
        maxcount,
        stackable,
        ContainerSlots,
        StatsCount,
        ScalingStatDistribution,
        ScalingStatValue,
        dmg_min1,
        dmg_max1,
        dmg_type1,
        dmg_min2,
        dmg_max2,
        dmg_type2,
        armor,
        holy_res,
        fire_res,
        nature_res,
        frost_res,
        shadow_res,
        arcane_res,
        delay,
        ammo_type,
        RangedModRange,
        spellcharges_1,
        spellppmRate_1,
        spellcooldown_1,
        spellcategory_1,
        spellcategorycooldown_1,
        spellcharges_2,
        spellppmRate_2,
        spellcooldown_2,
        spellcategory_2,
        spellcategorycooldown_2,
        spellcharges_3,
        spellppmRate_3,
        spellcooldown_3,
        spellcategory_3,
        spellcategorycooldown_3,
        spellcharges_4,
        spellppmRate_4,
        spellcooldown_4,
        spellcategory_4,
        spellcategorycooldown_4,
        spellcharges_5,
        spellppmRate_5,
        spellcooldown_5,
        spellcategory_5,
        spellcategorycooldown_5,
        bonding,
        description,
        PageText,
        LanguageID,
        PageMaterial,
        startquest,
        lockid,
        Material,
        sheath,
        RandomProperty,
        RandomSuffix,
        block,
        itemset,
        MaxDurability,
        area,
        Map,
        BagFamily,
        TotemCategory,
        socketColor_1,
        socketContent_1,
        socketColor_2,
        socketContent_2,
        socketColor_3,
        socketContent_3,
        socketBonus,
        GemProperties,
        RequiredDisenchantSkill,
        ArmorDamageModifier,
        duration,
        ItemLimitCategory,
        HolidayId,
        ScriptName,
        DisenchantID,
        FoodType,
        minMoneyLoot,
        maxMoneyLoot,
        flagsCustom,
        VerifiedBuild;


    public ItemTemplate() { }

    public ItemTemplate(String id)
    {
        try
        {
            entry = Integer.parseInt(id) + ""; // must be a valid number
        }

        catch (Exception e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "Wrong or missing values", "The config files have wrong or missing values, they must be numbers.");
        }
    }

    public void populateItem() throws Exception
    {
        try
        {
            ResultSet rs = DB.get("SELECT * FROM `item_template` WHERE `entry` = " + entry);

            if (!rs.next())
            {
                throw new Exception("item_template.entry " + entry + " does not exist!");
            }

            baseEntry = rs.getString("entry");
            entry = rs.getString("entry");
            clas = rs.getString("class");
            subclass = rs.getString("subclass");
            SoundOverrideSubclass = rs.getString("SoundOverrideSubclass");
            name = rs.getString("name");
            displayid = rs.getString("displayid");
            Quality = rs.getString("Quality");
            Flags = rs.getString("Flags");
            FlagsExtra = rs.getString("FlagsExtra");
            BuyCount = rs.getString("BuyCount");
            BuyPrice = rs.getString("BuyPrice");
            SellPrice = rs.getString("SellPrice");
            InventoryType = rs.getString("InventoryType");
            AllowableClass = rs.getString("AllowableClass");
            AllowableRace = rs.getString("AllowableRace");
            ItemLevel = rs.getString("ItemLevel");
            RequiredLevel = rs.getString("RequiredLevel");
            RequiredSkill = rs.getString("RequiredSkill");
            RequiredSkillRank = rs.getString("RequiredSkillRank");
            requiredspell = rs.getString("requiredspell");
            requiredhonorrank = rs.getString("requiredhonorrank");
            RequiredCityRank = rs.getString("RequiredCityRank");
            RequiredReputationFaction = rs.getString("RequiredReputationFaction");
            RequiredReputationRank = rs.getString("RequiredReputationRank");
            maxcount = rs.getString("maxcount");
            stackable = rs.getString("stackable");
            ContainerSlots = rs.getString("ContainerSlots");
            StatsCount = rs.getString("StatsCount");
            stat_type[0] = rs.getString("stat_type1");
            stat_value[0] = rs.getString("stat_value1");
            stat_type[1] = rs.getString("stat_type2");
            stat_value[1] = rs.getString("stat_value2");
            stat_type[2] = rs.getString("stat_type3");
            stat_value[2] = rs.getString("stat_value3");
            stat_type[3] = rs.getString("stat_type4");
            stat_value[3] = rs.getString("stat_value4");
            stat_type[4] = rs.getString("stat_type5");
            stat_value[4] = rs.getString("stat_value5");
            stat_type[5] = rs.getString("stat_type6");
            stat_value[5] = rs.getString("stat_value6");
            stat_type[6] = rs.getString("stat_type7");
            stat_value[6] = rs.getString("stat_value7");
            stat_type[7] = rs.getString("stat_type8");
            stat_value[7] = rs.getString("stat_value8");
            stat_type[8] = rs.getString("stat_type9");
            stat_value[8] = rs.getString("stat_value9");
            stat_type[9] = rs.getString("stat_type10");
            stat_value[9] = rs.getString("stat_value10");
            ScalingStatDistribution = rs.getString("ScalingStatDistribution");
            ScalingStatValue = rs.getString("ScalingStatValue");
            dmg_min1 = rs.getString("dmg_min1").replace(".0$", "");
            dmg_max1 = rs.getString("dmg_max1").replace(".0$", "");
            dmg_type1 = rs.getString("dmg_type1");
            dmg_min2 = rs.getString("dmg_min2").replace(".0$", "");
            dmg_max2 = rs.getString("dmg_max2").replace(".0$", "");
            dmg_type2 = rs.getString("dmg_type2");
            armor = rs.getString("armor");
            holy_res = rs.getString("holy_res");
            fire_res = rs.getString("fire_res");
            nature_res = rs.getString("nature_res");
            frost_res = rs.getString("frost_res");
            shadow_res = rs.getString("shadow_res");
            arcane_res = rs.getString("arcane_res");
            delay = rs.getString("delay");
            ammo_type = rs.getString("ammo_type");
            RangedModRange = rs.getString("RangedModRange").replace(".0$", "");
            spellid[0] = rs.getString("spellid_1");
            spelltrigger[0] = rs.getString("spelltrigger_1");
            spellcharges_1 = rs.getString("spellcharges_1");
            spellppmRate_1 = rs.getString("spellppmRate_1").replace(".0$", "");
            spellcooldown_1 = rs.getString("spellcooldown_1");
            spellcategory_1 = rs.getString("spellcategory_1");
            spellcategorycooldown_1 = rs.getString("spellcategorycooldown_1");
            spellid[1] = rs.getString("spellid_2");
            spelltrigger[1] = rs.getString("spelltrigger_2");
            spellcharges_2 = rs.getString("spellcharges_2");
            spellppmRate_2 = rs.getString("spellppmRate_2").replace(".0$", "");
            spellcooldown_2 = rs.getString("spellcooldown_2");
            spellcategory_2 = rs.getString("spellcategory_2");
            spellcategorycooldown_2 = rs.getString("spellcategorycooldown_2");
            spellid[2] = rs.getString("spellid_3");
            spelltrigger[2] = rs.getString("spelltrigger_3");
            spellcharges_3 = rs.getString("spellcharges_3");
            spellppmRate_3 = rs.getString("spellppmRate_3").replace(".0$", "");
            spellcooldown_3 = rs.getString("spellcooldown_3");
            spellcategory_3 = rs.getString("spellcategory_3");
            spellcategorycooldown_3 = rs.getString("spellcategorycooldown_3");
            spellid[3] = rs.getString("spellid_4");
            spelltrigger[3] = rs.getString("spelltrigger_4");
            spellcharges_4 = rs.getString("spellcharges_4");
            spellppmRate_4 = rs.getString("spellppmRate_4").replace(".0$", "");
            spellcooldown_4 = rs.getString("spellcooldown_4");
            spellcategory_4 = rs.getString("spellcategory_4");
            spellcategorycooldown_4 = rs.getString("spellcategorycooldown_4");
            spellid[4] = rs.getString("spellid_5");
            spelltrigger[4] = rs.getString("spelltrigger_5");
            spellcharges_5 = rs.getString("spellcharges_5");
            spellppmRate_5 = rs.getString("spellppmRate_5").replace(".0$", "");
            spellcooldown_5 = rs.getString("spellcooldown_5");
            spellcategory_5 = rs.getString("spellcategory_5");
            spellcategorycooldown_5 = rs.getString("spellcategorycooldown_5");
            bonding = rs.getString("bonding");
            description = rs.getString("description");
            PageText = rs.getString("PageText");
            LanguageID = rs.getString("LanguageID");
            PageMaterial = rs.getString("PageMaterial");
            startquest = rs.getString("startquest");
            lockid = rs.getString("lockid");
            Material = rs.getString("Material");
            sheath = rs.getString("sheath");
            RandomProperty = rs.getString("RandomProperty");
            RandomSuffix = rs.getString("RandomSuffix");
            block = rs.getString("block");
            itemset = rs.getString("itemset");
            MaxDurability = rs.getString("MaxDurability");
            area = rs.getString("area");
            Map = rs.getString("Map");
            BagFamily = rs.getString("BagFamily");
            TotemCategory = rs.getString("TotemCategory");
            socketColor_1 = rs.getString("socketColor_1");
            socketContent_1 = rs.getString("socketContent_1");
            socketColor_2 = rs.getString("socketColor_2");
            socketContent_2 = rs.getString("socketContent_2");
            socketColor_3 = rs.getString("socketColor_3");
            socketContent_3 = rs.getString("socketContent_3");
            socketBonus = rs.getString("socketBonus");
            GemProperties = rs.getString("GemProperties");
            RequiredDisenchantSkill = rs.getString("RequiredDisenchantSkill");
            ArmorDamageModifier = rs.getString("ArmorDamageModifier").replace(".0$", "");
            duration = rs.getString("duration");
            ItemLimitCategory = rs.getString("ItemLimitCategory");
            HolidayId = rs.getString("HolidayId");
            ScriptName = rs.getString("ScriptName");
            DisenchantID = rs.getString("DisenchantID");
            FoodType = rs.getString("FoodType");
            minMoneyLoot = rs.getString("minMoneyLoot");
            maxMoneyLoot = rs.getString("maxMoneyLoot");
            flagsCustom = rs.getString("flagsCustom");
            VerifiedBuild = rs.getString("VerifiedBuild");
            System.out.println("this item has been populated.");
        }

        catch (SQLException e)
        {
            throw new Exception("Database problem. Can't fetch data.\n\n" + e.getMessage());
        }
    }

    public boolean createItem()
    {
        StringBuilder query = new StringBuilder();

        query.append("REPLACE INTO `item_template` (`entry`, `class`, `subclass`, `SoundOverrideSubclass`, `name`, `displayid`, `Quality`, `Flags`, `FlagsExtra`, `BuyCount`, `BuyPrice`, `SellPrice`, `InventoryType`, `AllowableClass`, `AllowableRace`, `ItemLevel`, `RequiredLevel`, `RequiredSkill`, `RequiredSkillRank`, `requiredspell`, `requiredhonorrank`, `RequiredCityRank`, `RequiredReputationFaction`, `RequiredReputationRank`, `maxcount`, `stackable`, `ContainerSlots`, `StatsCount`, `stat_type1`, `stat_value1`, `stat_type2`, `stat_value2`, `stat_type3`, `stat_value3`, `stat_type4`, `stat_value4`, `stat_type5`, `stat_value5`, `stat_type6`, `stat_value6`, `stat_type7`, `stat_value7`, `stat_type8`, `stat_value8`, `stat_type9`, `stat_value9`, `stat_type10`, `stat_value10`, `ScalingStatDistribution`, `ScalingStatValue`, `dmg_min1`, `dmg_max1`, `dmg_type1`, `dmg_min2`, `dmg_max2`, `dmg_type2`, `armor`, `holy_res`, `fire_res`, `nature_res`, `frost_res`, `shadow_res`, `arcane_res`, `delay`, `ammo_type`, `RangedModRange`, `spellid_1`, `spelltrigger_1`, `spellcharges_1`, `spellppmRate_1`, `spellcooldown_1`, `spellcategory_1`, `spellcategorycooldown_1`, `spellid_2`, `spelltrigger_2`, `spellcharges_2`, `spellppmRate_2`, `spellcooldown_2`, `spellcategory_2`, `spellcategorycooldown_2`, `spellid_3`, `spelltrigger_3`, `spellcharges_3`, `spellppmRate_3`, `spellcooldown_3`, `spellcategory_3`, `spellcategorycooldown_3`, `spellid_4`, `spelltrigger_4`, `spellcharges_4`, `spellppmRate_4`, `spellcooldown_4`, `spellcategory_4`, `spellcategorycooldown_4`, `spellid_5`, `spelltrigger_5`, `spellcharges_5`, `spellppmRate_5`, `spellcooldown_5`, `spellcategory_5`, `spellcategorycooldown_5`, `bonding`, `description`, `PageText`, `LanguageID`, `PageMaterial`, `startquest`, `lockid`, `Material`, `sheath`, `RandomProperty`, `RandomSuffix`, `block`, `itemset`, `MaxDurability`, `area`, `Map`, `BagFamily`, `TotemCategory`, `socketColor_1`, `socketContent_1`, `socketColor_2`, `socketContent_2`, `socketColor_3`, `socketContent_3`, `socketBonus`, `GemProperties`, `RequiredDisenchantSkill`, `ArmorDamageModifier`, `duration`, `ItemLimitCategory`, `HolidayId`, `ScriptName`, `DisenchantID`, `FoodType`, `minMoneyLoot`, `maxMoneyLoot`, `flagsCustom`, `VerifiedBuild`) VALUES\n")
             .append("(")
             .append(entry).append(", ")
             .append(clas).append(", ")
             .append(subclass).append(", ")
             .append(SoundOverrideSubclass).append(", ")
             .append("'").append(name).append("', ")
             .append(displayid).append(", ")
             .append(Quality).append(", ")
             .append(Flags).append(", ")
             .append(FlagsExtra).append(", ")
             .append(BuyCount).append(", ")
             .append(BuyPrice).append(", ")
             .append(SellPrice).append(", ")
             .append(InventoryType).append(", ")
             .append(AllowableClass).append(", ")
             .append(AllowableRace).append(", ")
             .append(ItemLevel).append(", ")
             .append(RequiredLevel).append(", ")
             .append(RequiredSkill).append(", ")
             .append(RequiredSkillRank).append(", ")
             .append(requiredspell).append(", ")
             .append(requiredhonorrank).append(", ")
             .append(RequiredCityRank).append(", ")
             .append(RequiredReputationFaction).append(", ")
             .append(RequiredReputationRank).append(", ")
             .append(maxcount).append(", ")
             .append(stackable).append(", ")
             .append(ContainerSlots).append(", ")
             .append(StatsCount).append(", ")
             .append(stat_type[0]).append(", ")
             .append(stat_value[0]).append(", ")
             .append(stat_type[1]).append(", ")
             .append(stat_value[1]).append(", ")
             .append(stat_type[2]).append(", ")
             .append(stat_value[2]).append(", ")
             .append(stat_type[3]).append(", ")
             .append(stat_value[3]).append(", ")
             .append(stat_type[4]).append(", ")
             .append(stat_value[4]).append(", ")
             .append(stat_type[5]).append(", ")
             .append(stat_value[5]).append(", ")
             .append(stat_type[6]).append(", ")
             .append(stat_value[6]).append(", ")
             .append(stat_type[7]).append(", ")
             .append(stat_value[7]).append(", ")
             .append(stat_type[8]).append(", ")
             .append(stat_value[8]).append(", ")
             .append(stat_type[9]).append(", ")
             .append(stat_value[9]).append(", ")
             .append(ScalingStatDistribution).append(", ")
             .append(ScalingStatValue).append(", ")
             .append(dmg_min1).append(", ")
             .append(dmg_max1).append(", ")
             .append(dmg_type1).append(", ")
             .append(dmg_min2).append(", ")
             .append(dmg_max2).append(", ")
             .append(dmg_type2).append(", ")
             .append(armor).append(", ")
             .append(holy_res).append(", ")
             .append(fire_res).append(", ")
             .append(nature_res).append(", ")
             .append(frost_res).append(", ")
             .append(shadow_res).append(", ")
             .append(arcane_res).append(", ")
             .append(delay).append(", ")
             .append(ammo_type).append(", ")
             .append(RangedModRange).append(", ")
             .append(spellid[0]).append(", ")
             .append(spelltrigger[0]).append(", ")
             .append(spellcharges_1).append(", ")
             .append(spellppmRate_1).append(", ")
             .append(spellcooldown_1).append(", ")
             .append(spellcategory_1).append(", ")
             .append(spellcategorycooldown_1).append(", ")
             .append(spellid[1]).append(", ")
             .append(spelltrigger[1]).append(", ")
             .append(spellcharges_2).append(", ")
             .append(spellppmRate_2).append(", ")
             .append(spellcooldown_2).append(", ")
             .append(spellcategory_2).append(", ")
             .append(spellcategorycooldown_2).append(", ")
             .append(spellid[2]).append(", ")
             .append(spelltrigger[2]).append(", ")
             .append(spellcharges_3).append(", ")
             .append(spellppmRate_3).append(", ")
             .append(spellcooldown_3).append(", ")
             .append(spellcategory_3).append(", ")
             .append(spellcategorycooldown_3).append(", ")
             .append(spellid[3]).append(", ")
             .append(spelltrigger[3]).append(", ")
             .append(spellcharges_4).append(", ")
             .append(spellppmRate_4).append(", ")
             .append(spellcooldown_4).append(", ")
             .append(spellcategory_4).append(", ")
             .append(spellcategorycooldown_4).append(", ")
             .append(spellid[4]).append(", ")
             .append(spelltrigger[4]).append(", ")
             .append(spellcharges_5).append(", ")
             .append(spellppmRate_5).append(", ")
             .append(spellcooldown_5).append(", ")
             .append(spellcategory_5).append(", ")
             .append(spellcategorycooldown_5).append(", ")
             .append(bonding).append(", ")
             .append("'").append(description).append("', ")
             .append(PageText).append(", ")
             .append(LanguageID).append(", ")
             .append(PageMaterial).append(", ")
             .append(startquest).append(", ")
             .append(lockid).append(", ")
             .append(Material).append(", ")
             .append(sheath).append(", ")
             .append(RandomProperty).append(", ")
             .append(RandomSuffix).append(", ")
             .append(block).append(", ")
             .append(itemset).append(", ")
             .append(MaxDurability).append(", ")
             .append(area).append(", ")
             .append(Map).append(", ")
             .append(BagFamily).append(", ")
             .append(TotemCategory).append(", ")
             .append(socketColor_1).append(", ")
             .append(socketContent_1).append(", ")
             .append(socketColor_2).append(", ")
             .append(socketContent_2).append(", ")
             .append(socketColor_3).append(", ")
             .append(socketContent_3).append(", ")
             .append(socketBonus).append(", ")
             .append(GemProperties).append(", ")
             .append(RequiredDisenchantSkill).append(", ")
             .append(ArmorDamageModifier).append(", ")
             .append(duration).append(", ")
             .append(ItemLimitCategory).append(", ")
             .append(HolidayId).append(", ")
             .append("'").append(ScriptName).append("', ")
             .append(DisenchantID).append(", ")
             .append(FoodType).append(", ")
             .append(minMoneyLoot).append(", ")
             .append(maxMoneyLoot).append(", ")
             .append(flagsCustom).append(", ")
             .append(VerifiedBuild).append(");");
System.out.println(query.toString());
        try
        {
            System.out.println("Creating item...");
            DB.execute(query.toString());
            System.out.println("The item was created.");
            UX.showAlert(Alert.AlertType.ERROR, "Item Created", "The item has been created.");
        }

        catch (SQLException e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "SQL Exception!", "Database problem. Can't insert data.\n\n" + e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public String[] getStat_type()
    {
        return stat_type;
    }

    public String[] getStat_value()
    {
        return stat_value;
    }

    public void setStat_value(int i, String stat_value)
    {
        this.stat_value[i] = stat_value;
    }

    public String[] getSpellid()
    {
        return spellid;
    }

    public void setSpellid(String[] spellid)
    {
        this.spellid = spellid;
    }

    public String[] getSpelltrigger()
    {
        return spelltrigger;
    }

    public void setSpelltrigger(String[] spelltrigger)
    {
        this.spelltrigger = spelltrigger;
    }

    public String getBaseEntry()
    {
        return baseEntry;
    }

    public String getEntry()
    {
        return entry;
    }

    public void setEntry(String entry)
    {
        this.entry = entry;
    }

    public String getClas()
    {
        return clas;
    }

    public void setClas(String clas)
    {
        this.clas = clas;
    }

    public String getSubclass()
    {
        return subclass;
    }

    public void setSubclass(String subclass)
    {
        this.subclass = subclass;
    }

    public String getSoundOverrideSubclass()
    {
        return SoundOverrideSubclass;
    }

    public void setSoundOverrideSubclass(String soundOverrideSubclass)
    {
        SoundOverrideSubclass = soundOverrideSubclass;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDisplayid()
    {
        return displayid;
    }

    public void setDisplayid(String displayid)
    {
        this.displayid = displayid;
    }

    public String getQuality()
    {
        return Quality;
    }

    public void setQuality(String quality)
    {
        Quality = quality;
    }

    public String getFlags()
    {
        return Flags;
    }

    public void setFlags(String flags)
    {
        Flags = flags;
    }

    public String getFlagsExtra()
    {
        return FlagsExtra;
    }

    public void setFlagsExtra(String flagsExtra)
    {
        FlagsExtra = flagsExtra;
    }

    public String getBuyCount()
    {
        return BuyCount;
    }

    public void setBuyCount(String buyCount)
    {
        BuyCount = buyCount;
    }

    public String getBuyPrice()
    {
        return BuyPrice;
    }

    public void setBuyPrice(String buyPrice)
    {
        BuyPrice = buyPrice;
    }

    public String getSellPrice()
    {
        return SellPrice;
    }

    public void setSellPrice(String sellPrice)
    {
        SellPrice = sellPrice;
    }

    public String getInventoryType()
    {
        return InventoryType;
    }

    public void setInventoryType(String inventoryType)
    {
        InventoryType = inventoryType;
    }

    public String getAllowableClass()
    {
        return AllowableClass;
    }

    public void setAllowableClass(String allowableClass)
    {
        AllowableClass = allowableClass;
    }

    public String getAllowableRace()
    {
        return AllowableRace;
    }

    public void setAllowableRace(String allowableRace)
    {
        AllowableRace = allowableRace;
    }

    public String getItemLevel()
    {
        return ItemLevel;
    }

    public void setItemLevel(String itemLevel)
    {
        ItemLevel = itemLevel;
    }

    public String getRequiredLevel()
    {
        return RequiredLevel;
    }

    public void setRequiredLevel(String requiredLevel)
    {
        RequiredLevel = requiredLevel;
    }

    public String getRequiredSkill()
    {
        return RequiredSkill;
    }

    public void setRequiredSkill(String requiredSkill)
    {
        RequiredSkill = requiredSkill;
    }

    public String getRequiredSkillRank()
    {
        return RequiredSkillRank;
    }

    public void setRequiredSkillRank(String requiredSkillRank)
    {
        RequiredSkillRank = requiredSkillRank;
    }

    public String getRequiredspell()
    {
        return requiredspell;
    }

    public void setRequiredspell(String requiredspell)
    {
        this.requiredspell = requiredspell;
    }

    public String getRequiredhonorrank()
    {
        return requiredhonorrank;
    }

    public void setRequiredhonorrank(String requiredhonorrank)
    {
        this.requiredhonorrank = requiredhonorrank;
    }

    public String getRequiredCityRank()
    {
        return RequiredCityRank;
    }

    public void setRequiredCityRank(String requiredCityRank)
    {
        RequiredCityRank = requiredCityRank;
    }

    public String getRequiredReputationFaction()
    {
        return RequiredReputationFaction;
    }

    public void setRequiredReputationFaction(String requiredReputationFaction)
    {
        RequiredReputationFaction = requiredReputationFaction;
    }

    public String getRequiredReputationRank()
    {
        return RequiredReputationRank;
    }

    public void setRequiredReputationRank(String requiredReputationRank)
    {
        RequiredReputationRank = requiredReputationRank;
    }

    public String getMaxcount()
    {
        return maxcount;
    }

    public void setMaxcount(String maxcount)
    {
        this.maxcount = maxcount;
    }

    public String getStackable()
    {
        return stackable;
    }

    public void setStackable(String stackable)
    {
        this.stackable = stackable;
    }

    public String getContainerSlots()
    {
        return ContainerSlots;
    }

    public void setContainerSlots(String containerSlots)
    {
        ContainerSlots = containerSlots;
    }

    public String getStatsCount()
    {
        return StatsCount;
    }

    public void setStatsCount(String statsCount)
    {
        StatsCount = statsCount;
    }

    public String getScalingStatDistribution()
    {
        return ScalingStatDistribution;
    }

    public void setScalingStatDistribution(String scalingStatDistribution)
    {
        ScalingStatDistribution = scalingStatDistribution;
    }

    public String getScalingStatValue()
    {
        return ScalingStatValue;
    }

    public void setScalingStatValue(String scalingStatValue)
    {
        ScalingStatValue = scalingStatValue;
    }

    public String getDmg_min1()
    {
        return dmg_min1;
    }

    public void setDmg_min1(String dmg_min1)
    {
        this.dmg_min1 = dmg_min1;
    }

    public String getDmg_max1()
    {
        return dmg_max1;
    }

    public void setDmg_max1(String dmg_max1)
    {
        this.dmg_max1 = dmg_max1;
    }

    public String getDmg_type1()
    {
        return dmg_type1;
    }

    public void setDmg_type1(String dmg_type1)
    {
        this.dmg_type1 = dmg_type1;
    }

    public String getDmg_min2()
    {
        return dmg_min2;
    }

    public void setDmg_min2(String dmg_min2)
    {
        this.dmg_min2 = dmg_min2;
    }

    public String getDmg_max2()
    {
        return dmg_max2;
    }

    public void setDmg_max2(String dmg_max2)
    {
        this.dmg_max2 = dmg_max2;
    }

    public String getDmg_type2()
    {
        return dmg_type2;
    }

    public void setDmg_type2(String dmg_type2)
    {
        this.dmg_type2 = dmg_type2;
    }

    public String getArmor()
    {
        return armor;
    }

    public void setArmor(String armor)
    {
        this.armor = armor;
    }

    public String getHoly_res()
    {
        return holy_res;
    }

    public void setHoly_res(String holy_res)
    {
        this.holy_res = holy_res;
    }

    public String getFire_res()
    {
        return fire_res;
    }

    public void setFire_res(String fire_res)
    {
        this.fire_res = fire_res;
    }

    public String getNature_res()
    {
        return nature_res;
    }

    public void setNature_res(String nature_res)
    {
        this.nature_res = nature_res;
    }

    public String getFrost_res()
    {
        return frost_res;
    }

    public void setFrost_res(String frost_res)
    {
        this.frost_res = frost_res;
    }

    public String getShadow_res()
    {
        return shadow_res;
    }

    public void setShadow_res(String shadow_res)
    {
        this.shadow_res = shadow_res;
    }

    public String getArcane_res()
    {
        return arcane_res;
    }

    public void setArcane_res(String arcane_res)
    {
        this.arcane_res = arcane_res;
    }

    public String getDelay()
    {
        return delay;
    }

    public void setDelay(String delay)
    {
        this.delay = delay;
    }

    public String getAmmo_type()
    {
        return ammo_type;
    }

    public void setAmmo_type(String ammo_type)
    {
        this.ammo_type = ammo_type;
    }

    public String getRangedModRange()
    {
        return RangedModRange;
    }

    public void setRangedModRange(String rangedModRange)
    {
        RangedModRange = rangedModRange;
    }

    public String getSpellcharges_1()
    {
        return spellcharges_1;
    }

    public void setSpellcharges_1(String spellcharges_1)
    {
        this.spellcharges_1 = spellcharges_1;
    }

    public String getSpellppmRate_1()
    {
        return spellppmRate_1;
    }

    public void setSpellppmRate_1(String spellppmRate_1)
    {
        this.spellppmRate_1 = spellppmRate_1;
    }

    public String getSpellcooldown_1()
    {
        return spellcooldown_1;
    }

    public void setSpellcooldown_1(String spellcooldown_1)
    {
        this.spellcooldown_1 = spellcooldown_1;
    }

    public String getSpellcategory_1()
    {
        return spellcategory_1;
    }

    public void setSpellcategory_1(String spellcategory_1)
    {
        this.spellcategory_1 = spellcategory_1;
    }

    public String getSpellcategorycooldown_1()
    {
        return spellcategorycooldown_1;
    }

    public void setSpellcategorycooldown_1(String spellcategorycooldown_1)
    {
        this.spellcategorycooldown_1 = spellcategorycooldown_1;
    }

    public String getSpellcharges_2()
    {
        return spellcharges_2;
    }

    public void setSpellcharges_2(String spellcharges_2)
    {
        this.spellcharges_2 = spellcharges_2;
    }

    public String getSpellppmRate_2()
    {
        return spellppmRate_2;
    }

    public void setSpellppmRate_2(String spellppmRate_2)
    {
        this.spellppmRate_2 = spellppmRate_2;
    }

    public String getSpellcooldown_2()
    {
        return spellcooldown_2;
    }

    public void setSpellcooldown_2(String spellcooldown_2)
    {
        this.spellcooldown_2 = spellcooldown_2;
    }

    public String getSpellcategory_2()
    {
        return spellcategory_2;
    }

    public void setSpellcategory_2(String spellcategory_2)
    {
        this.spellcategory_2 = spellcategory_2;
    }

    public String getSpellcategorycooldown_2()
    {
        return spellcategorycooldown_2;
    }

    public void setSpellcategorycooldown_2(String spellcategorycooldown_2)
    {
        this.spellcategorycooldown_2 = spellcategorycooldown_2;
    }

    public String getSpellcharges_3()
    {
        return spellcharges_3;
    }

    public void setSpellcharges_3(String spellcharges_3)
    {
        this.spellcharges_3 = spellcharges_3;
    }

    public String getSpellppmRate_3()
    {
        return spellppmRate_3;
    }

    public void setSpellppmRate_3(String spellppmRate_3)
    {
        this.spellppmRate_3 = spellppmRate_3;
    }

    public String getSpellcooldown_3()
    {
        return spellcooldown_3;
    }

    public void setSpellcooldown_3(String spellcooldown_3)
    {
        this.spellcooldown_3 = spellcooldown_3;
    }

    public String getSpellcategory_3()
    {
        return spellcategory_3;
    }

    public void setSpellcategory_3(String spellcategory_3)
    {
        this.spellcategory_3 = spellcategory_3;
    }

    public String getSpellcategorycooldown_3()
    {
        return spellcategorycooldown_3;
    }

    public void setSpellcategorycooldown_3(String spellcategorycooldown_3)
    {
        this.spellcategorycooldown_3 = spellcategorycooldown_3;
    }

    public String getSpellcharges_4()
    {
        return spellcharges_4;
    }

    public void setSpellcharges_4(String spellcharges_4)
    {
        this.spellcharges_4 = spellcharges_4;
    }

    public String getSpellppmRate_4()
    {
        return spellppmRate_4;
    }

    public void setSpellppmRate_4(String spellppmRate_4)
    {
        this.spellppmRate_4 = spellppmRate_4;
    }

    public String getSpellcooldown_4()
    {
        return spellcooldown_4;
    }

    public void setSpellcooldown_4(String spellcooldown_4)
    {
        this.spellcooldown_4 = spellcooldown_4;
    }

    public String getSpellcategory_4()
    {
        return spellcategory_4;
    }

    public void setSpellcategory_4(String spellcategory_4)
    {
        this.spellcategory_4 = spellcategory_4;
    }

    public String getSpellcategorycooldown_4()
    {
        return spellcategorycooldown_4;
    }

    public void setSpellcategorycooldown_4(String spellcategorycooldown_4)
    {
        this.spellcategorycooldown_4 = spellcategorycooldown_4;
    }

    public String getSpellcharges_5()
    {
        return spellcharges_5;
    }

    public void setSpellcharges_5(String spellcharges_5)
    {
        this.spellcharges_5 = spellcharges_5;
    }

    public String getSpellppmRate_5()
    {
        return spellppmRate_5;
    }

    public void setSpellppmRate_5(String spellppmRate_5)
    {
        this.spellppmRate_5 = spellppmRate_5;
    }

    public String getSpellcooldown_5()
    {
        return spellcooldown_5;
    }

    public void setSpellcooldown_5(String spellcooldown_5)
    {
        this.spellcooldown_5 = spellcooldown_5;
    }

    public String getSpellcategory_5()
    {
        return spellcategory_5;
    }

    public void setSpellcategory_5(String spellcategory_5)
    {
        this.spellcategory_5 = spellcategory_5;
    }

    public String getSpellcategorycooldown_5()
    {
        return spellcategorycooldown_5;
    }

    public void setSpellcategorycooldown_5(String spellcategorycooldown_5)
    {
        this.spellcategorycooldown_5 = spellcategorycooldown_5;
    }

    public String getBonding()
    {
        return bonding;
    }

    public void setBonding(String bonding)
    {
        this.bonding = bonding;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPageText()
    {
        return PageText;
    }

    public void setPageText(String pageText)
    {
        PageText = pageText;
    }

    public String getLanguageID()
    {
        return LanguageID;
    }

    public void setLanguageID(String languageID)
    {
        LanguageID = languageID;
    }

    public String getPageMaterial()
    {
        return PageMaterial;
    }

    public void setPageMaterial(String pageMaterial)
    {
        PageMaterial = pageMaterial;
    }

    public String getStartquest()
    {
        return startquest;
    }

    public void setStartquest(String startquest)
    {
        this.startquest = startquest;
    }

    public String getLockid()
    {
        return lockid;
    }

    public void setLockid(String lockid)
    {
        this.lockid = lockid;
    }

    public String getMaterial()
    {
        return Material;
    }

    public void setMaterial(String material)
    {
        Material = material;
    }

    public String getSheath()
    {
        return sheath;
    }

    public void setSheath(String sheath)
    {
        this.sheath = sheath;
    }

    public String getRandomProperty()
    {
        return RandomProperty;
    }

    public void setRandomProperty(String randomProperty)
    {
        RandomProperty = randomProperty;
    }

    public String getRandomSuffix()
    {
        return RandomSuffix;
    }

    public void setRandomSuffix(String randomSuffix)
    {
        RandomSuffix = randomSuffix;
    }

    public String getBlock()
    {
        return block;
    }

    public void setBlock(String block)
    {
        this.block = block;
    }

    public String getItemset()
    {
        return itemset;
    }

    public void setItemset(String itemset)
    {
        this.itemset = itemset;
    }

    public String getMaxDurability()
    {
        return MaxDurability;
    }

    public void setMaxDurability(String maxDurability)
    {
        MaxDurability = maxDurability;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getMap()
    {
        return Map;
    }

    public void setMap(String map)
    {
        Map = map;
    }

    public String getBagFamily()
    {
        return BagFamily;
    }

    public void setBagFamily(String bagFamily)
    {
        BagFamily = bagFamily;
    }

    public String getTotemCategory()
    {
        return TotemCategory;
    }

    public void setTotemCategory(String totemCategory)
    {
        TotemCategory = totemCategory;
    }

    public String getSocketColor_1()
    {
        return socketColor_1;
    }

    public void setSocketColor_1(String socketColor_1)
    {
        this.socketColor_1 = socketColor_1;
    }

    public String getSocketContent_1()
    {
        return socketContent_1;
    }

    public void setSocketContent_1(String socketContent_1)
    {
        this.socketContent_1 = socketContent_1;
    }

    public String getSocketColor_2()
    {
        return socketColor_2;
    }

    public void setSocketColor_2(String socketColor_2)
    {
        this.socketColor_2 = socketColor_2;
    }

    public String getSocketContent_2()
    {
        return socketContent_2;
    }

    public void setSocketContent_2(String socketContent_2)
    {
        this.socketContent_2 = socketContent_2;
    }

    public String getSocketColor_3()
    {
        return socketColor_3;
    }

    public void setSocketColor_3(String socketColor_3)
    {
        this.socketColor_3 = socketColor_3;
    }

    public String getSocketContent_3()
    {
        return socketContent_3;
    }

    public void setSocketContent_3(String socketContent_3)
    {
        this.socketContent_3 = socketContent_3;
    }

    public String getSocketBonus()
    {
        return socketBonus;
    }

    public void setSocketBonus(String socketBonus)
    {
        this.socketBonus = socketBonus;
    }

    public String getGemProperties()
    {
        return GemProperties;
    }

    public void setGemProperties(String gemProperties)
    {
        GemProperties = gemProperties;
    }

    public String getRequiredDisenchantSkill()
    {
        return RequiredDisenchantSkill;
    }

    public void setRequiredDisenchantSkill(String requiredDisenchantSkill)
    {
        RequiredDisenchantSkill = requiredDisenchantSkill;
    }

    public String getArmorDamageModifier()
    {
        return ArmorDamageModifier;
    }

    public void setArmorDamageModifier(String armorDamageModifier)
    {
        ArmorDamageModifier = armorDamageModifier;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getItemLimitCategory()
    {
        return ItemLimitCategory;
    }

    public void setItemLimitCategory(String itemLimitCategory)
    {
        ItemLimitCategory = itemLimitCategory;
    }

    public String getHolidayId()
    {
        return HolidayId;
    }

    public void setHolidayId(String holidayId)
    {
        HolidayId = holidayId;
    }

    public String getScriptName()
    {
        return ScriptName;
    }

    public void setScriptName(String scriptName)
    {
        ScriptName = scriptName;
    }

    public String getDisenchantID()
    {
        return DisenchantID;
    }

    public void setDisenchantID(String disenchantID)
    {
        DisenchantID = disenchantID;
    }

    public String getFoodType()
    {
        return FoodType;
    }

    public void setFoodType(String foodType)
    {
        FoodType = foodType;
    }

    public String getMinMoneyLoot()
    {
        return minMoneyLoot;
    }

    public void setMinMoneyLoot(String minMoneyLoot)
    {
        this.minMoneyLoot = minMoneyLoot;
    }

    public String getMaxMoneyLoot()
    {
        return maxMoneyLoot;
    }

    public void setMaxMoneyLoot(String maxMoneyLoot)
    {
        this.maxMoneyLoot = maxMoneyLoot;
    }

    public String getFlagsCustom()
    {
        return flagsCustom;
    }

    public void setFlagsCustom(String flagsCustom)
    {
        this.flagsCustom = flagsCustom;
    }

    public String getVerifiedBuild()
    {
        return VerifiedBuild;
    }

    public void setVerifiedBuild(String verifiedBuild)
    {
        VerifiedBuild = verifiedBuild;
    }
}
