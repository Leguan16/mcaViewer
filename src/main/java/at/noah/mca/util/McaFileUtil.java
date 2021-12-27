package at.noah.mca.util;

import at.noah.mca.editor.CompoundTagTreeNode;
import at.noah.mca.editor.ui.McaFileEditorUI;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.treeStructure.Tree;
import me.ratsiel.mca.model.chunk.RegionChunk;
import me.ratsiel.nbt.NBTInputStream;
import me.ratsiel.nbt.abstracts.AbstractCompound;
import me.ratsiel.nbt.model.CompoundTag;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipException;

@SuppressWarnings("unused")
public class McaFileUtil {


    public static void saveTree(AnActionEvent event) {
        McaFileEditorUI editorUI = event.getData(McaFileEditorUI.DATA_KEY);
        Project project = event.getProject();
        VirtualFile file = event.getData(CommonDataKeys.VIRTUAL_FILE);

        if (editorUI == null || editorUI.getTree() == null || file == null) {
            new Notification("McaSaveError",
                    "Error saving MCA file",
                    "Due to an unknown error the file could not be saved.",
                    NotificationType.WARNING);

            return;
        }

        if (!editorUI.isAutoSaveEnabled()) {
            return;
        }

        saveTreeToFile(editorUI.getTree(), file, project);
    }

    private static void saveTreeToFile(Tree tree, VirtualFile file, Project project) {
        ApplicationManager.getApplication().runWriteAction(() -> {
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(file.getOutputStream(tree));
                 DataOutputStream outputStream = new DataOutputStream(gzipOutputStream)) {

                //writeNodeToStream((NBTType) tree.getModel().getRoot(), outputStream, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void writeNodeToStream(RegionChunk chunk) {

    }


    public static DefaultMutableTreeNode loadMcaFileIntoTree(VirtualFile file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        try (NBTInputStream inputStream = new NBTInputStream(uncompress(file.getInputStream()))){
            CompoundTag root = inputStream.readRoot();

            var children = root.getValues();

            if(children.isEmpty()) {
                node.add(new DefaultMutableTreeNode("empty", false));
                return node;
            }


            for (var compoundTag : children.entrySet()) {
                node.add(createNode(compoundTag));
            }
        } catch (IOException e) {
            return null;
        }

        // TODO: 26/12/2021 this
        throw new UnsupportedOperationException("not yet implemented!");
    }

    private static CompoundTagTreeNode createNode(Map.Entry<String, AbstractCompound> compoundTag) {
        // TODO: 26/12/2021 this
        throw new UnsupportedOperationException("not yet implemented!");
    }

    private static NBTInputStream uncompress(InputStream inputStream) throws IOException {
        try {
            return new NBTInputStream(new GZIPInputStream(inputStream));
        } catch (ZipException e) {
            inputStream.reset();
            return new NBTInputStream(inputStream);
        }
    }
}
