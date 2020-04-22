package org.custom.items;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class ItemTemplate
{
    private String

        name,
        description,
        ScriptName;

    private double

        dmg_min[] = new double[2],
        dmg_max[] = new double[2],
        RangedModRange,
        spellppmRate[] = new double[5],
        ArmorDamageModifier;

    private int

        entry,
        clas,
        subclass,
        SoundOverrideSubclass,
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
        stat_type[] = new int[10],
        stat_value[] = new int[10],
        ScalingStatDistribution,
        ScalingStatValue,
        dmg_type[] = new int[2],
        armor,
        resistance[] = new int[6],
        delay,
        ammo_type,
        spellid[] = new int[5],
        spelltrigger[] = new int[5],
        spellcharges[] = new int[5],
        spellcooldown[] = new int[5],
        spellcategory[] = new int[5],
        spellcategorycooldown[] = new int[5],
        bonding,
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
        socketColor[] = new int[3],
        socketContent[] = new int[3],
        socketBonus,
        GemProperties,
        RequiredDisenchantSkill,
        duration,
        ItemLimitCategory,
        HolidayId,
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
            entry = Integer.parseInt(id); // must be a valid number
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

            entry = rs.getInt("entry");
            clas = rs.getInt("class");
            subclass = rs.getInt("subclass");
            SoundOverrideSubclass = rs.getInt("SoundOverrideSubclass");
            name = rs.getString("name");
            displayid = rs.getInt("displayid");
            Quality = rs.getInt("Quality");
            Flags = rs.getInt("Flags");
            FlagsExtra = rs.getInt("FlagsExtra");
            BuyCount = rs.getInt("BuyCount");
            BuyPrice = rs.getInt("BuyPrice");
            SellPrice = rs.getInt("SellPrice");
            InventoryType = rs.getInt("InventoryType");
            AllowableClass = rs.getInt("AllowableClass");
            AllowableRace = rs.getInt("AllowableRace");
            ItemLevel = rs.getInt("ItemLevel");
            RequiredLevel = rs.getInt("RequiredLevel");
            RequiredSkill = rs.getInt("RequiredSkill");
            RequiredSkillRank = rs.getInt("RequiredSkillRank");
            requiredspell = rs.getInt("requiredspell");
            requiredhonorrank = rs.getInt("requiredhonorrank");
            RequiredCityRank = rs.getInt("RequiredCityRank");
            RequiredReputationFaction = rs.getInt("RequiredReputationFaction");
            RequiredReputationRank = rs.getInt("RequiredReputationRank");
            maxcount = rs.getInt("maxcount");
            stackable = rs.getInt("stackable");
            ContainerSlots = rs.getInt("ContainerSlots");
            StatsCount = rs.getInt("StatsCount");
            stat_type[0] = rs.getInt("stat_type1");
            stat_value[0] = rs.getInt("stat_value1");
            stat_type[1] = rs.getInt("stat_type2");
            stat_value[1] = rs.getInt("stat_value2");
            stat_type[2] = rs.getInt("stat_type3");
            stat_value[2] = rs.getInt("stat_value3");
            stat_type[3] = rs.getInt("stat_type4");
            stat_value[3] = rs.getInt("stat_value4");
            stat_type[4] = rs.getInt("stat_type5");
            stat_value[4] = rs.getInt("stat_value5");
            stat_type[5] = rs.getInt("stat_type6");
            stat_value[5] = rs.getInt("stat_value6");
            stat_type[6] = rs.getInt("stat_type7");
            stat_value[6] = rs.getInt("stat_value7");
            stat_type[7] = rs.getInt("stat_type8");
            stat_value[7] = rs.getInt("stat_value8");
            stat_type[8] = rs.getInt("stat_type9");
            stat_value[8] = rs.getInt("stat_value9");
            stat_type[9] = rs.getInt("stat_type10");
            stat_value[9] = rs.getInt("stat_value10");
            ScalingStatDistribution = rs.getInt("ScalingStatDistribution");
            ScalingStatValue = rs.getInt("ScalingStatValue");
            dmg_min[0] = rs.getDouble("dmg_min1"); //.replace(".0$", "");
            dmg_max[0] = rs.getDouble("dmg_max1"); //.replace(".0$", "");
            dmg_type[0] = rs.getInt("dmg_type1");
            dmg_min[1] = rs.getDouble("dmg_min2"); //.replace(".0$", "");
            dmg_max[1] = rs.getDouble("dmg_max2"); //.replace(".0$", "");
            dmg_type[1] = rs.getInt("dmg_type2");
            armor = rs.getInt("armor");
            resistance[0] = rs.getInt("holy_res");
            resistance[1] = rs.getInt("fire_res");
            resistance[2] = rs.getInt("nature_res");
            resistance[3] = rs.getInt("frost_res");
            resistance[4] = rs.getInt("shadow_res");
            resistance[5] = rs.getInt("arcane_res");
            delay = rs.getInt("delay");
            ammo_type = rs.getInt("ammo_type");
            RangedModRange = rs.getDouble("RangedModRange"); //.replace(".0$", "");
            spellid[0] = rs.getInt("spellid_1");
            spelltrigger[0] = rs.getInt("spelltrigger_1");
            spellcharges[0] = rs.getInt("spellcharges_1");
            spellppmRate[0] = rs.getDouble("spellppmRate_1"); //.replace(".0$", "");
            spellcooldown[0] = rs.getInt("spellcooldown_1");
            spellcategory[0] = rs.getInt("spellcategory_1");
            spellcategorycooldown[0] = rs.getInt("spellcategorycooldown_1");
            spellid[1] = rs.getInt("spellid_2");
            spelltrigger[1] = rs.getInt("spelltrigger_2");
            spellcharges[1] = rs.getInt("spellcharges_2");
            spellppmRate[1] = rs.getDouble("spellppmRate_2"); //.replace(".0$", "");
            spellcooldown[1] = rs.getInt("spellcooldown_2");
            spellcategory[1] = rs.getInt("spellcategory_2");
            spellcategorycooldown[1] = rs.getInt("spellcategorycooldown_2");
            spellid[2] = rs.getInt("spellid_3");
            spelltrigger[2] = rs.getInt("spelltrigger_3");
            spellcharges[2] = rs.getInt("spellcharges_3");
            spellppmRate[2] = rs.getDouble("spellppmRate_3"); //.replace(".0$", "");
            spellcooldown[2] = rs.getInt("spellcooldown_3");
            spellcategory[2] = rs.getInt("spellcategory_3");
            spellcategorycooldown[2] = rs.getInt("spellcategorycooldown_3");
            spellid[3] = rs.getInt("spellid_4");
            spelltrigger[3] = rs.getInt("spelltrigger_4");
            spellcharges[3] = rs.getInt("spellcharges_4");
            spellppmRate[3] = rs.getDouble("spellppmRate_4"); //.replace(".0$", "");
            spellcooldown[3] = rs.getInt("spellcooldown_4");
            spellcategory[3] = rs.getInt("spellcategory_4");
            spellcategorycooldown[3] = rs.getInt("spellcategorycooldown_4");
            spellid[4] = rs.getInt("spellid_5");
            spelltrigger[4] = rs.getInt("spelltrigger_5");
            spellcharges[4] = rs.getInt("spellcharges_5");
            spellppmRate[4] = rs.getDouble("spellppmRate_5"); //.replace(".0$", "");
            spellcooldown[4] = rs.getInt("spellcooldown_5");
            spellcategory[4] = rs.getInt("spellcategory_5");
            spellcategorycooldown[4] = rs.getInt("spellcategorycooldown_5");
            bonding = rs.getInt("bonding");
            description = rs.getString("description");
            PageText = rs.getInt("PageText");
            LanguageID = rs.getInt("LanguageID");
            PageMaterial = rs.getInt("PageMaterial");
            startquest = rs.getInt("startquest");
            lockid = rs.getInt("lockid");
            Material = rs.getInt("Material");
            sheath = rs.getInt("sheath");
            RandomProperty = rs.getInt("RandomProperty");
            RandomSuffix = rs.getInt("RandomSuffix");
            block = rs.getInt("block");
            itemset = rs.getInt("itemset");
            MaxDurability = rs.getInt("MaxDurability");
            area = rs.getInt("area");
            Map = rs.getInt("Map");
            BagFamily = rs.getInt("BagFamily");
            TotemCategory = rs.getInt("TotemCategory");
            socketColor[0] = rs.getInt("socketColor_1");
            socketContent[0] = rs.getInt("socketContent_1");
            socketColor[1] = rs.getInt("socketColor_2");
            socketContent[1] = rs.getInt("socketContent_2");
            socketColor[2] = rs.getInt("socketColor_3");
            socketContent[2] = rs.getInt("socketContent_3");
            socketBonus = rs.getInt("socketBonus");
            GemProperties = rs.getInt("GemProperties");
            RequiredDisenchantSkill = rs.getInt("RequiredDisenchantSkill");
            ArmorDamageModifier = rs.getDouble("ArmorDamageModifier"); //.replace(".0$", "");
            duration = rs.getInt("duration");
            ItemLimitCategory = rs.getInt("ItemLimitCategory");
            HolidayId = rs.getInt("HolidayId");
            ScriptName = rs.getString("ScriptName");
            DisenchantID = rs.getInt("DisenchantID");
            FoodType = rs.getInt("FoodType");
            minMoneyLoot = rs.getInt("minMoneyLoot");
            maxMoneyLoot = rs.getInt("maxMoneyLoot");
            flagsCustom = rs.getInt("flagsCustom");
            VerifiedBuild = rs.getInt("VerifiedBuild");
            System.out.println("this item has been populated.");
        }

        catch (SQLException e)
        {
            throw new Exception("Database problem. Can't fetch data.\n\n" + e.getMessage());
        }
    }

    public void createItem() throws Exception
    {
        try
        {
            System.out.println("Creating item...");
            PreparedStatement ps = DB.prepare("INSERT INTO `item_template` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, entry);
            ps.setInt(2, clas);
            ps.setInt(3, subclass);
            ps.setInt(4, SoundOverrideSubclass);
            ps.setString(5, name);
            ps.setInt(6, displayid);
            ps.setInt(7, Quality);
            ps.setInt(8, Flags);
            ps.setInt(9, FlagsExtra);
            ps.setInt(10, BuyCount);
            ps.setInt(11, BuyPrice);
            ps.setInt(12, SellPrice);
            ps.setInt(13, InventoryType);
            ps.setInt(14, AllowableClass);
            ps.setInt(15, AllowableRace);
            ps.setInt(16, ItemLevel);
            ps.setInt(17, RequiredLevel);
            ps.setInt(18, RequiredSkill);
            ps.setInt(19, RequiredSkillRank);
            ps.setInt(20, requiredspell);
            ps.setInt(21, requiredhonorrank);
            ps.setInt(22, RequiredCityRank);
            ps.setInt(23, RequiredReputationFaction);
            ps.setInt(24, RequiredReputationRank);
            ps.setInt(25, maxcount);
            ps.setInt(26, stackable);
            ps.setInt(27, ContainerSlots);
            ps.setInt(28, StatsCount);
            ps.setInt(29, stat_type[0]);
            ps.setInt(30, stat_value[0]);
            ps.setInt(31, stat_type[1]);
            ps.setInt(32, stat_value[1]);
            ps.setInt(33, stat_type[2]);
            ps.setInt(34, stat_value[2]);
            ps.setInt(35, stat_type[3]);
            ps.setInt(36, stat_value[3]);
            ps.setInt(37, stat_type[4]);
            ps.setInt(38, stat_value[4]);
            ps.setInt(39, stat_type[5]);
            ps.setInt(40, stat_value[5]);
            ps.setInt(41, stat_type[6]);
            ps.setInt(42, stat_value[6]);
            ps.setInt(43, stat_type[7]);
            ps.setInt(44, stat_value[7]);
            ps.setInt(45, stat_type[8]);
            ps.setInt(46, stat_value[8]);
            ps.setInt(47, stat_type[9]);
            ps.setInt(48, stat_value[9]);
            ps.setInt(49, ScalingStatDistribution);
            ps.setInt(50, ScalingStatValue);
            ps.setDouble(51, dmg_min[0]);
            ps.setDouble(52, dmg_max[0]);
            ps.setInt(53, dmg_type[0]);
            ps.setDouble(54, dmg_min[1]);
            ps.setDouble(55, dmg_max[1]);
            ps.setInt(56, dmg_type[1]);
            ps.setInt(57, armor);
            ps.setInt(58, resistance[0]);
            ps.setInt(59, resistance[1]);
            ps.setInt(60, resistance[2]);
            ps.setInt(61, resistance[3]);
            ps.setInt(62, resistance[4]);
            ps.setInt(63, resistance[5]);
            ps.setInt(64, delay);
            ps.setInt(65, ammo_type);
            ps.setDouble(66, RangedModRange);
            ps.setInt(67, spellid[0]);
            ps.setInt(68, spelltrigger[0]);
            ps.setInt(69, spellcharges[0]);
            ps.setDouble(70, spellppmRate[0]);
            ps.setInt(71, spellcooldown[0]);
            ps.setInt(72, spellcategory[0]);
            ps.setInt(73, spellcategorycooldown[0]);
            ps.setInt(74, spellid[1]);
            ps.setInt(75, spelltrigger[1]);
            ps.setInt(76, spellcharges[1]);
            ps.setDouble(77, spellppmRate[1]);
            ps.setInt(78, spellcooldown[1]);
            ps.setInt(79, spellcategory[1]);
            ps.setInt(80, spellcategorycooldown[1]);
            ps.setInt(81, spellid[2]);
            ps.setInt(82, spelltrigger[2]);
            ps.setInt(83, spellcharges[2]);
            ps.setDouble(84, spellppmRate[2]);
            ps.setInt(85, spellcooldown[2]);
            ps.setInt(86, spellcategory[2]);
            ps.setInt(87, spellcategorycooldown[2]);
            ps.setInt(88, spellid[3]);
            ps.setInt(89, spelltrigger[3]);
            ps.setInt(90, spellcharges[3]);
            ps.setDouble(91, spellppmRate[3]);
            ps.setInt(92, spellcooldown[3]);
            ps.setInt(93, spellcategory[3]);
            ps.setInt(94, spellcategorycooldown[3]);
            ps.setInt(95, spellid[4]);
            ps.setInt(96, spelltrigger[4]);
            ps.setInt(97, spellcharges[4]);
            ps.setDouble(98, spellppmRate[4]);
            ps.setInt(99, spellcooldown[4]);
            ps.setInt(100, spellcategory[4]);
            ps.setInt(101, spellcategorycooldown[4]);
            ps.setInt(102, bonding);
            ps.setString(103, description);
            ps.setInt(104, PageText);
            ps.setInt(105, LanguageID);
            ps.setInt(106, PageMaterial);
            ps.setInt(107, startquest);
            ps.setInt(108, lockid);
            ps.setInt(109, Material);
            ps.setInt(110, sheath);
            ps.setInt(111, RandomProperty);
            ps.setInt(112, RandomSuffix);
            ps.setInt(113, block);
            ps.setInt(114, itemset);
            ps.setInt(115, MaxDurability);
            ps.setInt(116, area);
            ps.setInt(117, Map);
            ps.setInt(118, BagFamily);
            ps.setInt(119, TotemCategory);
            ps.setInt(120, socketColor[0]);
            ps.setInt(121, socketContent[0]);
            ps.setInt(122, socketColor[1]);
            ps.setInt(123, socketContent[1]);
            ps.setInt(124, socketColor[2]);
            ps.setInt(125, socketContent[2]);
            ps.setInt(126, socketBonus);
            ps.setInt(127, GemProperties);
            ps.setInt(128, RequiredDisenchantSkill);
            ps.setDouble(129, ArmorDamageModifier);
            ps.setInt(130, duration);
            ps.setInt(131, ItemLimitCategory);
            ps.setInt(132, HolidayId);
            ps.setString(133, ScriptName);
            ps.setInt(134, DisenchantID);
            ps.setInt(135, FoodType);
            ps.setInt(136, minMoneyLoot);
            ps.setInt(137, maxMoneyLoot);
            ps.setInt(138, flagsCustom);
            ps.setInt(139, VerifiedBuild);
            ps.executeUpdate();
            System.out.println("The item was created.");
            UX.showAlert(Alert.AlertType.ERROR, "Item Created", "The item has been created.");
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw new Exception("Database problem. Can't insert data.\n\n" + e.getMessage());
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getScriptName()
    {
        return ScriptName;
    }

    public void setScriptName(String scriptName)
    {
        ScriptName = scriptName;
    }

    public double[] getDmg_min()
    {
        return dmg_min;
    }

    public void setDmg_min(double[] dmg_min)
    {
        this.dmg_min = dmg_min;
    }

    public double[] getDmg_max()
    {
        return dmg_max;
    }

    public void setDmg_max(double[] dmg_max)
    {
        this.dmg_max = dmg_max;
    }

    public double getRangedModRange()
    {
        return RangedModRange;
    }

    public void setRangedModRange(double rangedModRange)
    {
        RangedModRange = rangedModRange;
    }

    public double[] getSpellppmRate()
    {
        return spellppmRate;
    }

    public void setSpellppmRate(double[] spellppmRate)
    {
        this.spellppmRate = spellppmRate;
    }

    public double getArmorDamageModifier()
    {
        return ArmorDamageModifier;
    }

    public void setArmorDamageModifier(double armorDamageModifier)
    {
        ArmorDamageModifier = armorDamageModifier;
    }

    public int getEntry()
    {
        return entry;
    }

    public void setEntry(int entry)
    {
        this.entry = entry;
    }

    public int getClas()
    {
        return clas;
    }

    public void setClas(int clas)
    {
        this.clas = clas;
    }

    public int getSubclass()
    {
        return subclass;
    }

    public void setSubclass(int subclass)
    {
        this.subclass = subclass;
    }

    public int getSoundOverrideSubclass()
    {
        return SoundOverrideSubclass;
    }

    public void setSoundOverrideSubclass(int soundOverrideSubclass)
    {
        SoundOverrideSubclass = soundOverrideSubclass;
    }

    public int getDisplayid()
    {
        return displayid;
    }

    public void setDisplayid(int displayid)
    {
        this.displayid = displayid;
    }

    public int getQuality()
    {
        return Quality;
    }

    public void setQuality(int quality)
    {
        Quality = quality;
    }

    public int getFlags()
    {
        return Flags;
    }

    public void setFlags(int flags)
    {
        Flags = flags;
    }

    public int getFlagsExtra()
    {
        return FlagsExtra;
    }

    public void setFlagsExtra(int flagsExtra)
    {
        FlagsExtra = flagsExtra;
    }

    public int getBuyCount()
    {
        return BuyCount;
    }

    public void setBuyCount(int buyCount)
    {
        BuyCount = buyCount;
    }

    public int getBuyPrice()
    {
        return BuyPrice;
    }

    public void setBuyPrice(int buyPrice)
    {
        BuyPrice = buyPrice;
    }

    public int getSellPrice()
    {
        return SellPrice;
    }

    public void setSellPrice(int sellPrice)
    {
        SellPrice = sellPrice;
    }

    public int getInventoryType()
    {
        return InventoryType;
    }

    public void setInventoryType(int inventoryType)
    {
        InventoryType = inventoryType;
    }

    public int getAllowableClass()
    {
        return AllowableClass;
    }

    public void setAllowableClass(int allowableClass)
    {
        AllowableClass = allowableClass;
    }

    public int getAllowableRace()
    {
        return AllowableRace;
    }

    public void setAllowableRace(int allowableRace)
    {
        AllowableRace = allowableRace;
    }

    public int getItemLevel()
    {
        return ItemLevel;
    }

    public void setItemLevel(int itemLevel)
    {
        ItemLevel = itemLevel;
    }

    public int getRequiredLevel()
    {
        return RequiredLevel;
    }

    public void setRequiredLevel(int requiredLevel)
    {
        RequiredLevel = requiredLevel;
    }

    public int getRequiredSkill()
    {
        return RequiredSkill;
    }

    public void setRequiredSkill(int requiredSkill)
    {
        RequiredSkill = requiredSkill;
    }

    public int getRequiredSkillRank()
    {
        return RequiredSkillRank;
    }

    public void setRequiredSkillRank(int requiredSkillRank)
    {
        RequiredSkillRank = requiredSkillRank;
    }

    public int getRequiredspell()
    {
        return requiredspell;
    }

    public void setRequiredspell(int requiredspell)
    {
        this.requiredspell = requiredspell;
    }

    public int getRequiredhonorrank()
    {
        return requiredhonorrank;
    }

    public void setRequiredhonorrank(int requiredhonorrank)
    {
        this.requiredhonorrank = requiredhonorrank;
    }

    public int getRequiredCityRank()
    {
        return RequiredCityRank;
    }

    public void setRequiredCityRank(int requiredCityRank)
    {
        RequiredCityRank = requiredCityRank;
    }

    public int getRequiredReputationFaction()
    {
        return RequiredReputationFaction;
    }

    public void setRequiredReputationFaction(int requiredReputationFaction)
    {
        RequiredReputationFaction = requiredReputationFaction;
    }

    public int getRequiredReputationRank()
    {
        return RequiredReputationRank;
    }

    public void setRequiredReputationRank(int requiredReputationRank)
    {
        RequiredReputationRank = requiredReputationRank;
    }

    public int getMaxcount()
    {
        return maxcount;
    }

    public void setMaxcount(int maxcount)
    {
        this.maxcount = maxcount;
    }

    public int getStackable()
    {
        return stackable;
    }

    public void setStackable(int stackable)
    {
        this.stackable = stackable;
    }

    public int getContainerSlots()
    {
        return ContainerSlots;
    }

    public void setContainerSlots(int containerSlots)
    {
        ContainerSlots = containerSlots;
    }

    public int getStatsCount()
    {
        return StatsCount;
    }

    public void setStatsCount(int statsCount)
    {
        StatsCount = statsCount;
    }

    public int[] getStat_type()
    {
        return stat_type;
    }

    public void setStat_type(int[] stat_type)
    {
        this.stat_type = stat_type;
    }

    public int[] getStat_value()
    {
        return stat_value;
    }

    public void setStat_value(int[] stat_value)
    {
        this.stat_value = stat_value;
    }

    public int getScalingStatDistribution()
    {
        return ScalingStatDistribution;
    }

    public void setScalingStatDistribution(int scalingStatDistribution)
    {
        ScalingStatDistribution = scalingStatDistribution;
    }

    public int getScalingStatValue()
    {
        return ScalingStatValue;
    }

    public void setScalingStatValue(int scalingStatValue)
    {
        ScalingStatValue = scalingStatValue;
    }

    public int[] getDmg_type()
    {
        return dmg_type;
    }

    public void setDmg_type(int[] dmg_type)
    {
        this.dmg_type = dmg_type;
    }

    public int getArmor()
    {
        return armor;
    }

    public void setArmor(int armor)
    {
        this.armor = armor;
    }

    public int[] getResistance()
    {
        return resistance;
    }

    public void setResistance(int[] resistance)
    {
        this.resistance = resistance;
    }

    public int getDelay()
    {
        return delay;
    }

    public void setDelay(int delay)
    {
        this.delay = delay;
    }

    public int getAmmo_type()
    {
        return ammo_type;
    }

    public void setAmmo_type(int ammo_type)
    {
        this.ammo_type = ammo_type;
    }

    public int[] getSpellid()
    {
        return spellid;
    }

    public void setSpellid(int[] spellid)
    {
        this.spellid = spellid;
    }

    public int[] getSpelltrigger()
    {
        return spelltrigger;
    }

    public void setSpelltrigger(int[] spelltrigger)
    {
        this.spelltrigger = spelltrigger;
    }

    public int[] getSpellcharges()
    {
        return spellcharges;
    }

    public void setSpellcharges(int[] spellcharges)
    {
        this.spellcharges = spellcharges;
    }

    public int[] getSpellcooldown()
    {
        return spellcooldown;
    }

    public void setSpellcooldown(int[] spellcooldown)
    {
        this.spellcooldown = spellcooldown;
    }

    public int[] getSpellcategory()
    {
        return spellcategory;
    }

    public void setSpellcategory(int[] spellcategory)
    {
        this.spellcategory = spellcategory;
    }

    public int[] getSpellcategorycooldown()
    {
        return spellcategorycooldown;
    }

    public void setSpellcategorycooldown(int[] spellcategorycooldown)
    {
        this.spellcategorycooldown = spellcategorycooldown;
    }

    public int getBonding()
    {
        return bonding;
    }

    public void setBonding(int bonding)
    {
        this.bonding = bonding;
    }

    public int getPageText()
    {
        return PageText;
    }

    public void setPageText(int pageText)
    {
        PageText = pageText;
    }

    public int getLanguageID()
    {
        return LanguageID;
    }

    public void setLanguageID(int languageID)
    {
        LanguageID = languageID;
    }

    public int getPageMaterial()
    {
        return PageMaterial;
    }

    public void setPageMaterial(int pageMaterial)
    {
        PageMaterial = pageMaterial;
    }

    public int getStartquest()
    {
        return startquest;
    }

    public void setStartquest(int startquest)
    {
        this.startquest = startquest;
    }

    public int getLockid()
    {
        return lockid;
    }

    public void setLockid(int lockid)
    {
        this.lockid = lockid;
    }

    public int getMaterial()
    {
        return Material;
    }

    public void setMaterial(int material)
    {
        Material = material;
    }

    public int getSheath()
    {
        return sheath;
    }

    public void setSheath(int sheath)
    {
        this.sheath = sheath;
    }

    public int getRandomProperty()
    {
        return RandomProperty;
    }

    public void setRandomProperty(int randomProperty)
    {
        RandomProperty = randomProperty;
    }

    public int getRandomSuffix()
    {
        return RandomSuffix;
    }

    public void setRandomSuffix(int randomSuffix)
    {
        RandomSuffix = randomSuffix;
    }

    public int getBlock()
    {
        return block;
    }

    public void setBlock(int block)
    {
        this.block = block;
    }

    public int getItemset()
    {
        return itemset;
    }

    public void setItemset(int itemset)
    {
        this.itemset = itemset;
    }

    public int getMaxDurability()
    {
        return MaxDurability;
    }

    public void setMaxDurability(int maxDurability)
    {
        MaxDurability = maxDurability;
    }

    public int getArea()
    {
        return area;
    }

    public void setArea(int area)
    {
        this.area = area;
    }

    public int getMap()
    {
        return Map;
    }

    public void setMap(int map)
    {
        Map = map;
    }

    public int getBagFamily()
    {
        return BagFamily;
    }

    public void setBagFamily(int bagFamily)
    {
        BagFamily = bagFamily;
    }

    public int getTotemCategory()
    {
        return TotemCategory;
    }

    public void setTotemCategory(int totemCategory)
    {
        TotemCategory = totemCategory;
    }

    public int[] getSocketColor()
    {
        return socketColor;
    }

    public void setSocketColor(int[] socketColor)
    {
        this.socketColor = socketColor;
    }

    public int[] getSocketContent()
    {
        return socketContent;
    }

    public void setSocketContent(int[] socketContent)
    {
        this.socketContent = socketContent;
    }

    public int getSocketBonus()
    {
        return socketBonus;
    }

    public void setSocketBonus(int socketBonus)
    {
        this.socketBonus = socketBonus;
    }

    public int getGemProperties()
    {
        return GemProperties;
    }

    public void setGemProperties(int gemProperties)
    {
        GemProperties = gemProperties;
    }

    public int getRequiredDisenchantSkill()
    {
        return RequiredDisenchantSkill;
    }

    public void setRequiredDisenchantSkill(int requiredDisenchantSkill)
    {
        RequiredDisenchantSkill = requiredDisenchantSkill;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getItemLimitCategory()
    {
        return ItemLimitCategory;
    }

    public void setItemLimitCategory(int itemLimitCategory)
    {
        ItemLimitCategory = itemLimitCategory;
    }

    public int getHolidayId()
    {
        return HolidayId;
    }

    public void setHolidayId(int holidayId)
    {
        HolidayId = holidayId;
    }

    public int getDisenchantID()
    {
        return DisenchantID;
    }

    public void setDisenchantID(int disenchantID)
    {
        DisenchantID = disenchantID;
    }

    public int getFoodType()
    {
        return FoodType;
    }

    public void setFoodType(int foodType)
    {
        FoodType = foodType;
    }

    public int getMinMoneyLoot()
    {
        return minMoneyLoot;
    }

    public void setMinMoneyLoot(int minMoneyLoot)
    {
        this.minMoneyLoot = minMoneyLoot;
    }

    public int getMaxMoneyLoot()
    {
        return maxMoneyLoot;
    }

    public void setMaxMoneyLoot(int maxMoneyLoot)
    {
        this.maxMoneyLoot = maxMoneyLoot;
    }

    public int getFlagsCustom()
    {
        return flagsCustom;
    }

    public void setFlagsCustom(int flagsCustom)
    {
        this.flagsCustom = flagsCustom;
    }

    public int getVerifiedBuild()
    {
        return VerifiedBuild;
    }

    public void setVerifiedBuild(int verifiedBuild)
    {
        VerifiedBuild = verifiedBuild;
    }
}
