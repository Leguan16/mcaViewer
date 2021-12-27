package at.noah.mca.fileType;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.impl.FileTypeOverrider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class McaFileTypeOverrider implements FileTypeOverrider {

    @Override
    public @Nullable FileType getOverriddenFileType(@NotNull VirtualFile file) {
        return "mca".equals(file.getExtension()) ? McaFileType.INSTANCE : null;
    }
}
