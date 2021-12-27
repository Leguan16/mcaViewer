package at.noah.mca.editor.ui;

import com.intellij.openapi.actionSystem.DataKey;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class McaFileEditorUI extends JPanel implements DataProvider {

    public static final DataKey<McaFileEditorUI> DATA_KEY = DataKey.create(McaFileEditorUI.class.getName());

    private Tree tree;
    private boolean autoSaveEnabled = true;



    public McaFileEditorUI(VirtualFile file, Project project) {
        this.setLayout(new BorderLayout());

        JPanel section = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton saveButton = new JButton("Save");

        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO: 26/12/2021 make this working
            }
        });

        section.add(saveButton);

        // TODO: 26/12/2021 continue here with listing the mca file


        this.add(section, BorderLayout.NORTH);
        this.add(new JBScrollPane(this.tree), BorderLayout.CENTER);
    }

    public Tree getTree() {
        return tree;
    }

    public boolean isAutoSaveEnabled() {
        return autoSaveEnabled;
    }

    @Override
    public @Nullable Object getData(@NotNull @NonNls String dataId) {
        if (DATA_KEY.is(dataId)) {
            return this;
        }
        return null;
    }
}
