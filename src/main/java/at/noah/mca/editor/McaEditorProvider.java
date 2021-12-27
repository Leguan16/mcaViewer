package at.noah.mca.editor;

import at.noah.mca.fileType.McaFileType;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorProvider;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

public class McaEditorProvider extends PsiAwareTextEditorProvider {
    @Override
    public @NotNull FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file) {
        return new McaEditor(file, project);
    }

    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile file) {
        return FileTypeRegistry.getInstance().isFileOfType(file, McaFileType.INSTANCE);
    }

    @Override
    public @NotNull FileEditorState readState(@NotNull Element element, @NotNull Project project, @NotNull VirtualFile file) {

        throw new UnsupportedOperationException("not yet implemented!");
    }

    @Override
    public void writeState(@NotNull FileEditorState _state, @NotNull Project project, @NotNull Element element) {
        // TODO: 26/12/2021 implement this


        Element rootElement = new Element("root");

        element.addContent(rootElement);

    }

    @Override
    public @NotNull String getEditorTypeId() {
        return "mca";
    }

    @Override
    public @NotNull FileEditorPolicy getPolicy() {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }
}
