package xyz.crazyh.liteminecrafticon;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class IconStorage {
    private static final String RESOURCES_ROOT = "assets/liteminecrafticon/icons/";
    private static final Map<String, byte[]> STORAGE = Maps.newLinkedHashMap();
    private static final List<String> PNG_PATH = Lists.newArrayList();
    private static boolean inited = false;

    public synchronized static void init() {
        if (inited) {
            return;
        }

        loadResource("icon_16x16.png", true);
        loadResource("icon_32x32.png", true);
        loadResource("icon_48x48.png", true);
        loadResource("icon_128x128.png", true);
        loadResource("icon_256x256.png", true);
        loadResource("minecraft.icns", false);

        System.out.println("LiteMinecraftIcon inited");

        inited = true;
    }

    private static void loadResource(String path, boolean isPng) {
        System.out.println("loading..." + path);
        String fullPath = RESOURCES_ROOT + path;
        ClassLoader classLoader = IconStorage.class.getClassLoader();

        try (InputStream stream = classLoader.getResourceAsStream(fullPath)) {
            if (stream == null) {
                throw new IOException("getResourceAsStream failed, null file stream");
            }

            byte[] data = IOUtils.toByteArray(stream);
            STORAGE.put(path, data);
            if (isPng) {
                PNG_PATH.add(path);
            }

        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to load resource %s: %s", fullPath, e));
        }
    }

    public static InputStream getResource(String path) {
        init();
        byte[] data = STORAGE.get(path);
        if (data == null) {
            throw new RuntimeException("Unexpected resource path " + path);
        }
        return new ByteArrayInputStream(data);
    }
}
