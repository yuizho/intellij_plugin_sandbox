import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class SampleDialogWrapper extends DialogWrapper {

    public SampleDialogWrapper() {
        super(true); // use current window as parent
        init();
        setTitle("Test DialogWrapper");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());


        EditorTextField editorTextField = new EditorTextField();
        editorTextField.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(editorTextField, BorderLayout.CENTER);

        //JLabel label = new JLabel("testing");
        //label.setPreferredSize(new Dimension(100, 100));
        //dialogPanel.add(label, BorderLayout.CENTER);

        return dialogPanel;
    }
}