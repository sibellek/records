package personal.records.ui;

import java.util.List;

public abstract class DefaultAbstractComboBoxModel<T> extends javax.swing.DefaultComboBoxModel<T> {

    @Override
    public T getSelectedItem() {
        return (T) super.getSelectedItem();
    }

    public void addElements(Iterable<T> elements) {
        elements.forEach(this::addElement);
    }

    public void clear() {
        removeAllElements();
    }
}
