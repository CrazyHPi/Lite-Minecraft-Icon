package xyz.crazyh.liteminecrafticon;

import com.mumfrey.liteloader.LiteMod;
import xyz.crazyh.liteminecrafticon.IconStorage;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LiteMinecraftIcon implements LiteMod {

    public static final String MOD_ID = "liteminecrafticon";
    public static final String MOD_NAME = "Lite-Minecraft-Icon";
    public static final String MOD_VERSION = "@MOD_VERSION@";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger(MOD_NAME);


    public LiteMinecraftIcon() {

    }

    /**
     * Get the mod version string
     *
     * @return the mod version as a string
     */
    @Override
    public String getVersion() {
        return MOD_VERSION;
    }

    /**
     * Do startup stuff here, minecraft is not fully initialised when this
     * function is called so mods <b>must not</b> interact with minecraft in any
     * way here.
     *
     * @param configPath Configuration path to use
     */
    @Override
    public void init(File configPath) {
        IconStorage.init();
    }

    /**
     * Called when the loader detects that a version change has happened since
     * this mod was last loaded.
     *
     * @param version       new version
     * @param configPath    Path for the new version-specific config
     * @param oldConfigPath Path for the old version-specific config
     */
    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {

    }

    /**
     * Get the display name
     *
     * @return display name
     */
    @Override
    public String getName() {
        return MOD_NAME;
    }
}
