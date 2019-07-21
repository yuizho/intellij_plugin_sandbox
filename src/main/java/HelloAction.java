import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;

public class HelloAction extends AnAction {
    public HelloAction() {
        super("Hello");
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();

        new SampleDialogWrapper().show();
    }
}
