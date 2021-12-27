package at.noah.mca.fileType;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class McaFileType implements FileType {

    public static final McaFileType INSTANCE = new McaFileType();

    @Override
    public @NonNls
    @NotNull
    String getName() {
        return "Minecraft Anvil";
    }

    @Override
    public @NlsContexts.Label
    @NotNull
    String getDescription() {
        return "Minecraft anvil file";
    }

    @Override
    public @NlsSafe
    @NotNull
    String getDefaultExtension() {
        return "mca";
    }

    @Override
    public @Nullable
    Icon getIcon() {
        return IconLoader.getIcon("/icons/mca16.png", McaFileType.class);
    }

    @Override
    public boolean isBinary() {
        return true;
    }
}
