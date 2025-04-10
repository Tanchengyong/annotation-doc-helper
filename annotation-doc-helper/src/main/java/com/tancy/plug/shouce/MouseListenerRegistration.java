package com.tancy.plug.shouce;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.EditorEventMulticaster;
import org.jetbrains.annotations.NotNull;

public class MouseListenerRegistration implements StartupActivity {
    @Override
    public void runActivity(@NotNull Project project) {
        EditorEventMulticaster eventMulticaster = EditorFactory.getInstance().getEventMulticaster();
        eventMulticaster.addEditorMouseListener(new AnnotationDocCaretListener(), project);
    }
}