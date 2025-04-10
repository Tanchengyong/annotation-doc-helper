package com.tancy.plug.shouce;



import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.event.*;
import com.intellij.openapi.editor.Editor;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

@SuppressWarnings("all")
public class AnnotationDocCaretListener implements EditorMouseListener {



    @Override
    public void mouseClicked(EditorMouseEvent event) {
        if (event.getArea() == EditorMouseEventArea.EDITING_AREA && event.getMouseEvent().getClickCount() == 2) {
            handleDoubleClick(event.getEditor(), event.getLogicalPosition());
        }
    }

    private void handleDoubleClick(Editor editor, LogicalPosition pos) {
        Project project = editor.getProject();
        if (project == null) return;

        PsiFile psiFile = PsiDocumentManager.getInstance(project)
                .getPsiFile(editor.getDocument());
        if (psiFile == null) return;

        int offset = editor.logicalPositionToOffset(pos);
        PsiElement element = psiFile.findElementAt(offset);
        PsiAnnotation annotation = PsiTreeUtil.getParentOfType(element, PsiAnnotation.class);

        if (annotation != null) {
            showAnnotationDoc(annotation, editor);
        }
    }

    public void showAnnotationDoc(PsiAnnotation annotation, Editor editor) {
        String qualifiedName = annotation.getQualifiedName();
        JBPopupFactory factory = JBPopupFactory.getInstance();
        Color jbColor = new Color(35, 41, 68);
        Color borderColor = new Color(151, 144, 248);
        factory.createBalloonBuilder(createCenterPanel(qualifiedName))
                .setHideOnClickOutside(true)
                .setFillColor(jbColor)
                .setBorderColor(borderColor)
                .createBalloon()
                .show(factory.guessBestPopupLocation(editor), Balloon.Position.above);
    }


    protected JComponent createCenterPanel(String qualifiedName) {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(AnnotationDocLoader.getHtmlStr(qualifiedName));
        editorPane.setEditable(false);
        editorPane.setBorder(null);

        // 强制计算内容尺寸并立即布局
        editorPane.setSize(800, Integer.MAX_VALUE); // 临时高度设为最大值
        Dimension realHeight = editorPane.getPreferredSize();
        editorPane.setPreferredSize(realHeight); // 锁定实际内容高度
        editorPane.setCaretPosition(0); // 将光标强制置顶

        JScrollPane jbScrollPane = new JScrollPane(editorPane);
        jbScrollPane.getViewport().setViewPosition(new Point(0, 0)); // 显式设置视口位置
        jbScrollPane.setPreferredSize(new Dimension(800, 500));
        jbScrollPane.setBorder(BorderFactory.createEmptyBorder());

        JScrollBar verticalScrollBar =jbScrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());

        return jbScrollPane;
    }


    static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            Color huaKuai = new Color(149, 141, 247);
            Color guiDao = new Color(35, 41, 68);
            // 设置滚动条的背景颜色
            this.scrollbar.setBackground(guiDao);
            // 设置滚动条滑块的颜色
            this.thumbColor =huaKuai;
            // 设置滚动条滑块的悬停颜色
            this.thumbHighlightColor = huaKuai;
            // 设置滚动条滑块的按下颜色
            this.thumbDarkShadowColor =huaKuai;
            // 设置滚动条轨道的颜色
            this.trackColor = guiDao;
            this.scrollBarWidth=5;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            // 隐藏减少按钮
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            // 隐藏增加按钮
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }

}