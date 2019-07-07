import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;

/**
 * Project level components: IDE上の各プロジェクトごとに作成されるコンポーネント
 * Module level components: IDE上の各モジュールごとに作成されるコンポーネント
 */
public class DictionaryProjectComponent implements ProjectComponent {
    @Override
    public void initComponent() {
        System.out.println("aaaaa");
    }
}
