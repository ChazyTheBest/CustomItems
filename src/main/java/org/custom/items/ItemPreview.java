package org.custom.items;

import java.util.Map;

public class ItemPreview
{
    private static final Map<Integer, String> weaponNameSubClass = initWeaponNameSubClass();

    private static Map<Integer, String> initWeaponNameSubClass()
    {
        return Map.ofEntries
        (
            Map.entry(0, "Axe"),
            Map.entry(1, "Axe"),
            Map.entry(2, "Bow"),
            Map.entry(3, "Gun"),
            Map.entry(4, "Mace"),
            Map.entry(5, "Mace"),
            Map.entry(6, "Polearm"),
            Map.entry(7, "Sword"),
            Map.entry(8, "Sword"),
            Map.entry(9, "Obsolete"),
            Map.entry(10, "Staff"),
            Map.entry(11, "Exotic"),
            Map.entry(12, "Exotic"),
            Map.entry(13, "Fist Weapon"),
            Map.entry(14, "Miscellaneous"),
            Map.entry(15, "Dagger"),
            Map.entry(16, "Thrown"),
            Map.entry(17, "Spear"),
            Map.entry(18, "Crossbow"),
            Map.entry(19, "Wand"),
            Map.entry(20, "Fishing Pole")
        );
    }

    private static final Map<Integer, String> armorTypeSubClass = initArmorTypeSubClass();

    private static Map<Integer, String> initArmorTypeSubClass()
    {
        return Map.ofEntries
        (
            Map.entry(0, ""),
            Map.entry(1, "Cloth"),
            Map.entry(2, "Leather"),
            Map.entry(3, "Mail"),
            Map.entry(4, "Plate"),
            Map.entry(5, "Buckler(OBSOLETE)"),
            Map.entry(6, "Shield"),
            Map.entry(7, "Libram"),
            Map.entry(8, "Idol"),
            Map.entry(9, "Totem"),
            Map.entry(10, "Sigil")
        );
    }

    private static final Map<Integer, String> quality = initQuality();

    private static Map<Integer, String> initQuality()
    {
        return Map.of
        (
            0, "grey",
            1, "white",
            2, "green",
            3, "blue",
            4, "purple",
            5, "orange",
            6, "red",
            7, "gold"
        );
    }

    private static final Map<Integer, String> inventoryType = initInventoryType();

    private static Map<Integer, String> initInventoryType()
    {
        //noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
        return Map.<Integer, String>ofEntries
        (
            Map.entry(0, "Non equipable"),
            Map.entry(1, "Head"),
            Map.entry(2, "Neck"),
            Map.entry(3, "Shoulder"),
            Map.entry(4, "Shirt"),
            Map.entry(5, "Chest"),
            Map.entry(6, "Waist"),
            Map.entry(7, "Legs"),
            Map.entry(8, "Feet"),
            Map.entry(9, "Wrists"),
            Map.entry(10, "Hands"),
            Map.entry(11, "Finger"),
            Map.entry(12, "Trinket"),
            Map.entry(13, "One-Hand"),
            Map.entry(14, "Off Hand"),
            Map.entry(15, "Ranged"),
            Map.entry(16, "Back"),
            Map.entry(17, "Two-Hand"),
            Map.entry(18, "Bag"),
            Map.entry(19, "Tabard"),
            Map.entry(20, "Robe"),
            Map.entry(21, "Main Hand"),
            Map.entry(22, "Off Hand"),
            Map.entry(23, "Held In Off-hand"),
            Map.entry(24, "Ammo"),
            Map.entry(25, "Thrown"),
            Map.entry(26, "Ranged"),
            Map.entry(27, "Quiver"),
            Map.entry(28, "Relic")
        );
    }

    private static final Map<Integer, String> allowableClass = initAllowableClass();

    private static Map<Integer, String> initAllowableClass()
    {
        return Map.of
        (
             1,     "Warrior",
             2,     "Paladin",
             4,     "Hunter",
             8,     "Rogue",
             16,    "Priest",
             32,    "Death Knight",
             64,    "Shaman",
             128,   "Mage",
             256,   "Warlock",
            1024, "Druid"
        );
    }

    private static final Map<Integer, String> statType = initStatType();

    private static Map<Integer, String> initStatType()
    {
        //noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
        return Map.<Integer, String>ofEntries
        (
            Map.entry(0, "+%s Mana"),
            Map.entry(1, "+%s Health"),
            Map.entry(3, "+%s Agility"),
            Map.entry(4, "+%s Strength"),
            Map.entry(5, "+%s Intellect"),
            Map.entry(6, "+%s Spirit"),
            Map.entry(7, "+%s Stamina"),
            Map.entry(12, "Equip: Increases defense rating by %s."),
            Map.entry(13, "Equip: Increases your dodge rating by %s."),
            Map.entry(14, "Equip: Increases your parry rating by %s."),
            Map.entry(15, "Equip: Increases your shield block rating by %s."),
            Map.entry(16, "Equip: Improves melee hit rating by %s."),
            Map.entry(17, "Equip: Improves ranged hit rating by %s."),
            Map.entry(18, "Equip: Improves spell hit rating by %s."),
            Map.entry(19, "Equip: Improves melee critical strike rating by %s."),
            Map.entry(20, "Equip: Improves ranged critical strike rating by %s."),
            Map.entry(21, "Equip: Improves spell critical strike rating by %s."),
            Map.entry(28, "Equip: Improves melee haste rating by %s."),
            Map.entry(29, "Equip: Improves ranged haste rating by %s."),
            Map.entry(30, "Equip: Improves spell haste rating by %s."),
            Map.entry(31, "Equip: Improves hit rating by %s."),
            Map.entry(32, "Equip: Improves critical strike rating by %s."),
            Map.entry(35, "Equip: Increases your resilience rating by %s."),
            Map.entry(36, "Equip: Improves haste rating by %s."),
            Map.entry(37, "Equip: Increases expertise rating by %s."),
            Map.entry(38, "Equip: Increases attack power by %s."),
            Map.entry(39, "Equip: Increases ranged attack power by %s."),
            Map.entry(41, "Equip: Increases healing done by magical spells and effects by up to %s."),
            Map.entry(42, "Equip: Increases damage done by magical spells and effects by up to %s."),
            Map.entry(43, "Equip: Restores %s mana per 5 sec."),
            Map.entry(44, "Equip: Increases your armor penetration rating by %s."),
            Map.entry(45, "Equip: Increases spell power by %s."),
            Map.entry(46, "Equip: Restores %s health per 5 sec."),
            Map.entry(47, "Equip: Increases spell penetration by %s."),
            Map.entry(48, "Equip: Increases the block value of your shield by %s.")
        );
    }

    private static final Map<Integer, String> dmgType = initDmgType();

    private static Map<Integer, String> initDmgType()
    {
        return Map.of
        (
            0, "Physical",
            1, "Holy",
            2, "Fire",
            3, "Nature",
            4, "Frost",
            5, "Shadow",
            6, "Arcane"
        );
    }

    private static final Map<Integer, String> spellId = initSpellId();

    private static Map<Integer, String> initSpellId()
    {
        //noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
        return Map.<Integer, String>ofEntries
        (
            Map.entry(12712, "Adds 6% extra damage to 2-handed weapons."),
            Map.entry(15069, "Increases the damage done by your spells and your critical strike chance by 10%."),
            Map.entry(15310, "Increases your Shadow spell damage by 10%."),
            Map.entry(15494, "Your Shield Wall ability now causes you to absorb damage equal to 20% of your maximum health. Lasts 10 sec."),
            Map.entry(16041, "Increases the critical strike chance of your Lightning Bolt, Chain Lightning and Thunderstorm spells by an additional 5%."),
            Map.entry(16309, "Increases your Stamina by 10%, and reduces the duration of movement slowing effects on you by 30%."),
            Map.entry(16494, "Increases critical strike damage bonus of your abilities by 20%."),
            Map.entry(16551, "All attacks are guaranteed to land and will be critical strikes for the next 3 seconds."),
            Map.entry(16620, "When struck in combat has a 5% chance to make you invulnerable to melee damage for 3 sec. This effect can only occur once every 30 sec."),
            Map.entry(18275, "Increases the damage dealt or life drained by your Shadow spells and your Felhunter's Shadow Bite ability by 15%."),
            Map.entry(18278, "Silences an enemy preventing it from casting spells for 6 sec. (1 Min Cooldown)"),
            Map.entry(19180, "Increases your Agility by 6%."),
            Map.entry(19506, "Increases attack power by 10%."),
            Map.entry(20100, "Increases your chance to dodge by 5%."),
            Map.entry(20113, "Increases the damage you deal with two-handed melee weapons by 6%."),
            Map.entry(20182, "Gives you a 10% chance after blocking or being hit by any damaging attack that the next 4 weapon swings within 8 sec will generate an additional attack."),
            Map.entry(20550, "Total Health increased by 5%."),
            Map.entry(21162, "Hurls a fiery ball that causes 273 to 333 fire damage and an additional 75 damage over 10 seconds."),
            Map.entry(21874, "Reduces the cooldown of your Vanish ability by 30 sec."),
            Map.entry(21992, "Blasts your enemy with lightning, dealing 300 Nature damage and then jumping to additional nearby enemies. Each jump reduces that victim's Nature resistance by 25. Affects 5 targets. Your primary target is also consumed by a cyclone, slowing its attack speed by 20% for 12 seconds."),
            Map.entry(23554, "Health or Mana gained from Drain Life and Drain Mana increased by 15%."),
            Map.entry(24378, "Increaes all damage caused by 30% and all damage taken by 10%."),
            Map.entry(24941, "Increases the effect of all healing spells by 15%."),
            Map.entry(26113, "Eviscerate deals 15% extra damage."),
            Map.entry(26123, "Chain Lightning gets 5% extra chain target damage multiplier."),
            Map.entry(26172, "Shadow Word: Pain deals 5% extra damage."),
            Map.entry(27733, "Increases your chance to resist Silence and Interrupt effects by 10%."),
            Map.entry(27787, "Chance on melee attack to restore 35 energy."),
            Map.entry(29144, "Increases your total Strength by 6%, Stamina by 9% and your Expertise by 6."),
            Map.entry(30675, "Gives your Lightning Bolt and Chain Lightning spells a 11% chance to cast a second, similar spell on the same target at no additional cost that causes half damage and no threat."),
            Map.entry(31126, "Increases the damage dealt by Sinister Strike and Backstab by 10%, and your damaging melee attacks have a 10% chance to daze the target for 8 seconds."),
            Map.entry(31830, "All attacks against you have a 10% chance to cause half damage."),
            Map.entry(31850, "Damage that takes you below 35% health is reduced by 7%. In addition, attacks which would otherwise kill you cause you to be healed by up to 10% of your maximum health (amount healed based on defense).  This healing effect cannot occur more often than once every 2 min."),
            Map.entry(31860, "Increases your expertise by 6, total Stamina and chance to critically hit by 6%."),
            Map.entry(33371, "Increases the critical strike chance of your Mind Blast, Mind Flay and Mind Sear spells by 4%, and increases the periodic critical strike chance of your Vampiric Touch, Devouring Plague and Shadow Word: Pain spells by 6%."),
            Map.entry(33795, "Increases all damage done by 5%."),
            Map.entry(36482, "Increases Physical damage taken by the target by 5%. Can be applied up to 5 times. Lasts 30 sec."),
            Map.entry(37170, "Your attacks have a chance to make your next finishing move cost no energy."),
            Map.entry(37187, "Increases the damage dealt by your Judgements by 10%."),
            Map.entry(37327, "Starfire deals 10% extra damage to targets affected by Moonfire or Insect Swarm."),
            Map.entry(37381, "Causes your pet to be healed for 15% of the damage you deal."),
            Map.entry(37439, "Reduces cooldown for Presence of Mind by 24 seconds, Blast Wave by 4 seconds, and Ice Block for 40 seconds."),
            Map.entry(37571, "Mind Flay and Smite deal 5% extra damage."),
            Map.entry(38229, "Gives the caster 2 extra attacks."),
            Map.entry(38389, "Hemorrhage, Sinister Strike, Backstab and Mutilate deal 6% extra damage."),
            Map.entry(38392, "Increases the damage dealt by your Steady Shot ability by 10%."),
            Map.entry(38397, "Increases the damage of your Fireball, Frostbolt, and Arcane Missiles abilities by 5%."),
            Map.entry(38399, "Increases the damage of your Mortal Strike and Bloodthirst abilities by 5%."),
            Map.entry(38412, "Mind Blast deals 10% extra damage."),
            Map.entry(38416, "Rip, Swipe and Ferocious Bite deal 15% extra damage."),
            Map.entry(38422, "Consecration deals 10% extra damage."),
            Map.entry(38424, "Hammer of Wrath deals 10% extra damage."),
            Map.entry(38447, "Mangle costs 5 less energy in cat form and does 15% more threat in bear form (Mangle)."),
            Map.entry(39957, "Increases your critical strike damage by 3."),
            Map.entry(41888, "Increases Strength by 20."),
            Map.entry(43689, "+20% Hit Chance."),
            Map.entry(46699, "When your Serpent Sting and Wyvern Sting abilitied deal damage, you have a 5% chance to gain 20% attack power for 10 sec."),
            Map.entry(49638, "Your spells receive an additional 20% benefit from your attack power."),
            Map.entry(49789, "Increases your armor value from items by 10% and reduces the duration of all movement slowing effects by 30%."),
            Map.entry(50029, "Increases your total strength by 6%, stamina by 3% and expertise by 6."),
            Map.entry(50150, "Damage that would take you below 35% health or taken while you are at 35% health is reduced by 15%."),
            Map.entry(51465, "Auto attacks deal an additional 20% shadow damage."),
            Map.entry(52803, "Increases the damage and healing done by your instant spells by 5%."),
            Map.entry(52879, "Increases your chance to parry attacks by 25%."),
            Map.entry(53365, "Affixes your rune weapon with a rune that has a chance to heal you for 3% and increase total strength by 15% for 15 seconds."),
            Map.entry(53382, "When your Judgement, Crusader Strike and Divine Storm spells deal a critical strike, your target will take 30% additional damage over 8 sec."),
            Map.entry(53386, "Damage increased by 20% for your next 2 attacks that deal Frost or Shadow damage."),
            Map.entry(5361,  "Increases your damage with Two-Handed Swords by 40 and your chance to parry with one by 5%."),
            Map.entry(55344, "Increases your armor value from items by 2%."),
            Map.entry(58874, "Whenever you take damage from or block a melee attack you cause damage equal to 20% of your block value."),
            Map.entry(60146, "Your offensive spells gain 5% extra critical damage."),
            Map.entry(60152, "Divine Storm deals 10% extra damage."),
            Map.entry(60162, "Rupture deals 10% extra damage."),
            Map.entry(60165, "Lava Burst deals 10% extra critical damage."),
            Map.entry(60168, "Lightning Shield deals 10% extra damage."),
            Map.entry(60174, "Slam deals 10% extra damage."),
            Map.entry(60175, "Increases the duration of your Shield Wall by 3 seconds."),
            Map.entry(61331, "Increases the damage of your Sinister Strike, Backstab, and Eviscerate abilities by 15%."),
            Map.entry(61776, "Reduces the cooldown of judgments by 1 second."),
            Map.entry(62670, "Increases all damage done by 10% and healing received from all sources by 20%."),
            Map.entry(63650, "Increases all healing done by you and all healing effects on you by 5%."),
            Map.entry(64735, "Increases the critical strike chance of Death Coil and Frost Strike by 8%."),
            Map.entry(64744, "Rune Strike deals 10% extra damage."),
            Map.entry(64854, "Serpent Sting deals 10% extra damage."),
            Map.entry(64878, "Increases the damage done by your Exorcism and Hammer of Wrath abilities by 10%."),
            Map.entry(64881, "Increases the damage done by your Seals of Vengeance, Corruption, and Righteousness by 10%."),
            Map.entry(64906, "Devouring Plague deals 15% extra damage."),
            Map.entry(64916, "Increases the damage done by Lava Lash and Stormstrike by 20%."),
            Map.entry(64928, "Your critical strikes from Lightning Bolt cause the target to take nature damage equal to 8% of the Lightning Bolt's damage over 4 sec."),
            Map.entry(64931, "Increases the damage done by your Unstable Affliction by 20% and your Immolate by 10%."),
            Map.entry(67126, "Starfire and Wrath spells deal 4% more damage."),
            Map.entry(67150, "The damage done by your Serpent Sting ability can now be critical strikes."),
            Map.entry(67167, "20% more armour from Ice Armor, 10% more mana regeneration from Mage Armor, 15% more spirit to crit chance from Molten Armor."),
            Map.entry(67185, "Increases the critical strike chance of your Fireball, Frostbolt, Frostfire Bolt, Arcane Missiles, and Arcane Blast spells by 5%."),
            Map.entry(67187, "Decreases the cooldown on your Divine Protection ability and reduces the duration of Forbearance by 30 sec."),
            Map.entry(67188, "Righteous Vengeance now has the ability to critically strike."),
            Map.entry(67193, "Vampiric Touch lasts 6 seconds longer."),
            Map.entry(67209, "Rupture has a chance to reduce the cost of your next ability by 40 energy."),
            Map.entry(67211, "Hemorrhage, Sinister Strike, Backstab and Mutilate have 5% extra crit chance."),
            Map.entry(67221, "Increases the damage done by your Earth Shock, Flame Shock, and Frost Shock spells by 25%."),
            Map.entry(67228, "Your Lava Burst spell causes your target to burn for an additonal 10% of your spell's damage over 6 sec."),
            Map.entry(67231, "Immolate, Corruption and Unstable Affliction deal 10% extra damage."),
            Map.entry(67268, "Slam and Heroic Strike have 5% extra crit chance."),
            Map.entry(67273, "Decreases the cooldown on your Shield Block ability by 10 sec."),
            Map.entry(68251, "+10 All Stats."),
            Map.entry(70650, "Death and Decay deals 20% extra damage."),
            Map.entry(70652, "Blood Tap gives you 12% damage reduction from all attacks for 10 seconds."),
            Map.entry(70655, "Obliterate and Scourge Strike deals 10% extra damage, Heart Strike deals 7% extra damage."),
            Map.entry(70656, "Whenever all your runes are on cooldown, you gain 3% increased damage done with weapons, spells, and abilities for the next 15 sec."),
            Map.entry(70718, "When you gain Clearcasting from \"Omen of Clarity\" talent, you deal 15% more nature and arcane dmg for 6 sec."),
            Map.entry(70726, "Barkskin reduces damage taken by an additional 10%, and the damage done by your Rake ability is increased by 10%."),
            Map.entry(70727, "Auto shots have a 5% chance to cause you and your pet to deal 15% extra damage for 10 seconds."),
            Map.entry(70730, "Thori'dal generates magical arrows when the bow string is drawn. Does not use ammo."),
            Map.entry(70748, "Mirror Image grants 18% extra damage done for 30 seconds."),
            Map.entry(70762, "Seals and judgments deal 10% extra damage."),
            Map.entry(70801, "Reduces the channel duration by 0.5 sec and period by 0.17 sec on your Mind Flay spell."),
            Map.entry(70803, "Your finishing moves have a 13% chance to add 3 combo points to your target."),
            Map.entry(70817, "Lava Burst causes your Flame Shock effect on the target to deal two extra ticks before expiring."),
            Map.entry(70830, "When you activate your Shamanistic Rage abillity you also deal 12% additional damage for 15 seconds."),
            Map.entry(70832, "When \"Maelstrom Weapon\" reaches 5 stacks, you have a 15% chance to get 20% bonus AP for 10 sec."),
            Map.entry(70841, "Inmolate and Unstable Affliction have a 15% chance to make you deal 10% extra damage for 10 seconds."),
            Map.entry(70843, "Your Shield Slam and Shockwave abilities deal 10% more damage."),
            Map.entry(70854, "Deep Wounds have a 3% chance to give you +16% attack power for 10 seconds."),
            Map.entry(70871, "Empowers the caster with dark might, increasing all damage dealt by 1 to 0% and heal the caster for 10% of his damage dealt."),
            Map.entry(71545, "Your melee attacks have a chance to grant you a Mote of Anger.  When you reach 7 Motes of Anger, they will release, causing you to instantly attack for 50% weapon damage with one of your melee weapons."),
            Map.entry(71878, "Your melee attacks have a chance to grant you Necrotic Touch for 10 Sek., causing all your melee attacks to deal an additional 10% damage as shadow damage."),
            Map.entry(71903, "Your melee attacks have a chance to drain a Soul Fragment granting you 5 Strength. When you have acquired 10 Soul Fragments you will unleash Chaos Bane, dealing 68 Shadow damage split between all enemies within 15 yards and granting you 46 Strength for 10 seconds."),
            Map.entry(73824, "The King of Stormwind lends you his strength, increasing total health, healing done, damage absorption, and damage dealt by 10%."),
            Map.entry(999961, "Increases your total Intellect by 15%."),
            Map.entry(999962, "Increases your total Spirit by 15%."),
            Map.entry(999963, "Increases spell power by 150,000."),
            Map.entry(999971, "Increases your total Intellect by 50%."),
            Map.entry(999972, "Increases your total Spirit by 50%."),
            Map.entry(999973, "Increases spell power by 500,000."),
            Map.entry(999980, "Increases attack power by 15%."),
            Map.entry(999981, "Increases Strenght by 100,000."),
            Map.entry(999982, "Increases Agility by 8,000."),
            Map.entry(999983, "Increases all Damage done by 15%."),
            Map.entry(999984, "Increases total Strenght by 15%."),
            Map.entry(999985, "Increases Stamina by 15%."),
            Map.entry(999986, "Increases the damage you deal with two-handed melee weapons by 15%."),
            Map.entry(999987, "Increases your chance to dodge by 15%."),
            Map.entry(999988, "Increases your chance to parry attacks by 15%."),
            Map.entry(999989, "Increases Healing recieved by 15%."),
            Map.entry(999990, "Increases attack power by 50%."),
            Map.entry(999991, "Increases Strenght by 500,000."),
            Map.entry(999992, "Increases Agility by 50,000."),
            Map.entry(999993, "Increases all Damage done by 50%."),
            Map.entry(999994, "Increases total Strenght by 50%."),
            Map.entry(999995, "Increases Stamina by 50%."),
            Map.entry(999996, "Increases the damage you deal with two-handed melee weapons by 50%."),
            Map.entry(999997, "Increases your chance to dodge by 50%."),
            Map.entry(999998, "Increases your chance to parry attacks by 50%."),
            Map.entry(999999, "Increases Healing recieved by 50%.")
        );
    }

    private static final Map<Integer, String> spellTrigger = initSpellTrigger();

    private static Map<Integer, String> initSpellTrigger()
    {
        return Map.of
        (
            0, "Use: ",
            1, "Equip: ",
            2, "Chance on hit: ",
            4, "",
            5, "",
            6, ""
        );
    }

    private static final Map<Integer, String> bonding = initBonding();

    private static Map<Integer, String> initBonding()
    {
        return Map.of
        (
            1, "Binds when picked up",
            2, "Binds when equipped",
            3, "Binds when used",
            4, "Quest item",
            5, "Quest Item"
        );
    }

    private static final Map<Integer, String> socketColor = initSocketColor();

    private static Map<Integer, String> initSocketColor()
    {
        return Map.of
        (
            1, "Meta",
            2, "Red",
            4, "Yellow",
            8, "Blue"
        );
    }

    private static final Map<Integer, String> socketBonus = initSocketBonus();

    private static Map<Integer, String> initSocketBonus()
    {
        return Map.ofEntries
        (
            Map.entry(2340, "+40 Spell Power"),
            Map.entry(2787, "+8 Critical Strike Rating"),
            Map.entry(2854, "3 mana per 5 sec"),
            Map.entry(2864, "+4 Critical Strike Rating"),
            Map.entry(2872, "+5 Spell Power"),
            Map.entry(2900, "+4 Spell Power"),
            Map.entry(3305, "+12 Stamina"),
            Map.entry(3307, "+9 Stamina"),
            Map.entry(3312, "+8 Strength"),
            Map.entry(3313, "+8 Agility"),
            Map.entry(3351, "+6 Hit Rating"),
            Map.entry(3352, "+8 Spirit"),
            Map.entry(3353, "+8 Intellect"),
            Map.entry(3358, "+6 Dodge Rating"),
            Map.entry(3753, "+9 Spell Power"),
            Map.entry(3821, "+8 Resilience Rating"),
            Map.entry(3877, "+16 Attack power")
        );
    }

    public static Map<Integer, String> getWeaponNameSubClass()
    {
        return weaponNameSubClass;
    }

    public static Map<Integer, String> getArmorTypeSubClass()
    {
        return armorTypeSubClass;
    }

    public static Map<Integer, String> getQuality()
    {
        return quality;
    }

    public static Map<Integer, String> getInventoryType()
    {
        return inventoryType;
    }

    public static Map<Integer, String> getAllowableClass()
    {
        return allowableClass;
    }

    public static Map<Integer, String> getStatType()
    {
        return statType;
    }

    public static Map<Integer, String> getDmgType()
    {
        return dmgType;
    }

    public static Map<Integer, String> getSpellId()
    {
        return spellId;
    }

    public static Map<Integer, String> getSpellTrigger()
    {
        return spellTrigger;
    }

    public static Map<Integer, String> getBonding()
    {
        return bonding;
    }

    public static Map<Integer, String> getSocketColor()
    {
        return socketColor;
    }

    public static Map<Integer, String> getSocketBonus()
    {
        return socketBonus;
    }
}
