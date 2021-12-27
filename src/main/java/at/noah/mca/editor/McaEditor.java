package at.noah.mca.editor;

import at.noah.mca.editor.ui.McaFileEditorUI;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public class McaEditor implements FileEditor {

    private final McaFileEditorUI component;
    private final VirtualFile file;

    public McaEditor(VirtualFile file, Project project) {
        this.component = new McaFileEditorUI(file, project);
        this.file = file;
    }

    @Override
    public @NotNull JComponent getComponent() {
        return this.component;
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return null;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) @NotNull String getName() {
        return "MCAFileEditor";
    }

    @Override
    public void setState(@NotNull FileEditorState state) {
        // TODO: 26/12/2021 this
    }

    @Override
    public @NotNull FileEditorState getState(@NotNull FileEditorStateLevel level) {
        // TODO: 26/12/2021 this
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public VirtualFile getFile() {
        return this.file;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void selectNotify() {

    }

    @Override
    public void deselectNotify() {

    }

    @Override
    public @Nullable BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public @Nullable FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {

    }

    @Override
    public <T> @Nullable T getUserData(@NotNull Key<T> key) {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

    }
}
