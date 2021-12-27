package at.noah.mca.editor;

import me.ratsiel.nbt.enums.NBTType;

import javax.swing.tree.DefaultMutableTreeNode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CompoundTagTreeNode extends DefaultMutableTreeNode {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat();
    static {
        DECIMAL_FORMAT.setGroupingUsed(false);
        DecimalFormatSymbols symbols = DECIMAL_FORMAT.getDecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DECIMAL_FORMAT.setDecimalFormatSymbols(symbols);
    }

    private NBTType type;
    private String name;
    private Object value;

    public CompoundTagTreeNode(NBTType type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
        update();
    }

    private void update() {
        setUserObject(this.name + ": " + getValueAsString());
    }

    public NBTType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public String getValueAsString() {
        String value = "Unknown value type";

        if (this.value == null) {
            value = "";
        } else if (this.value instanceof String) {
            value = "\"" + this.value + "\"";
        } else if (this.value instanceof Number) {
            value = DECIMAL_FORMAT.format(this.value);
        }

        return value;
    }

    public void setType(NBTType type) {
        this.type = type;
        setValue(type.getDefaultValue());
    }

    public void setName(String name) {
        this.name = name;
        update();
    }

    public void setValue(Object value) {
        this.value = value;
        update();
    }
}
