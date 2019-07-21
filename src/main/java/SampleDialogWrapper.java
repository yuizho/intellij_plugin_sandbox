import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SampleDialogWrapper extends DialogWrapper {
    private final Map<String, String> dictionary;

    public SampleDialogWrapper() {
        super(false); // use current window as parent
        init();
        setTitle("Test DialogWrapper");
        setModal(false);

        dictionary = new HashMap<>();
        dictionary.put("保険", "insurance");
        dictionary.put("保険外", "outsideInsurance");
        dictionary.put("保険内", "insideInsurance");
    }

    @NotNull
    @Override
    protected Action[] createActions() {
        //Action helpAction = getHelpAction();
        return new Action[]{};
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());

        EditorTextField editorTextField = new EditorTextField();
        editorTextField.setOneLineMode(true);
        editorTextField.setPreferredSize(new Dimension(300, 50));
        dialogPanel.add(editorTextField, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JBList jbList = new JBList<>(listModel);
        jbList.setExpandableItemsEnabled(true);
        dialogPanel.add(jbList, BorderLayout.CENTER);

        editorTextField.addDocumentListener(new DocumentListener() {
            @Override
            public void documentChanged(@NotNull DocumentEvent event) {
                String enteredText = event.getDocument().getCharsSequence().toString();
                System.out.println(enteredText);
                System.out.println("--------------------------");
                listModel.clear();
                if (enteredText == null || enteredText.isEmpty()) {
                    return;
                }
                List<String> values = dictionary
                        .entrySet()
                        .stream()
                        .filter(entrySet -> entrySet.getKey().contains(enteredText))
                        .peek(entrySet -> System.out.println(entrySet))
                        .map(entrySet -> entrySet.getValue())
                        .collect(Collectors.toList());
                for (String value : values) {
                    listModel.addElement(value);
                }
            }
        });

        dialogPanel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                System.out.println("focus gained");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                System.out.println("focus out");
            }
        });

        dialogPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                dialogPanel.requestFocusInWindow();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });

        return dialogPanel;
    }
}