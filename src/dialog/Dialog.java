package dialog;

import com.intellij.openapi.ui.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldName;
    private JComboBox comboBoxType;
    private JComboBox comboBoxLang;

    public Dialog() {
        setContentPane(contentPane);
        setModal(true);
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        int screenWidth = kit.getScreenSize().width; //获取屏幕的宽
        int screenHeight = kit.getScreenSize().height; //获取屏幕的高
        this.setLocation(screenWidth / 2 - windowWidth / 2 - 200, screenHeight / 4 - windowHeight / 4);//设置窗口居中显示
        getRootPane().setDefaultButton(buttonOK);
        setTitle("输入您的模块名称");
        setSize(600, 300);
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        if (textFieldName.getText().trim().isEmpty()) {
            Messages.showInfoMessage("名称好像啥也没填！", "提示");
            return;
        }
//        if (aaViewType.getSelectedIndex() > 1 && aacTpye.getSelectedIndex() > 0) {
//            Messages.showInfoMessage("Service只支持aac类型", "提示");
//            return;
//        }
//        if (aacTpye.getSelectedIndex() > 0 && beanName.getText().trim().isEmpty()) {
//            Messages.showInfoMessage("Bean,好像啥也没填！", "提示");
//            return;
//        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setListener(DataListener listener) {
        //this.listener = listener;
    }

    public interface DataListener {
        //void selectValue(DialogValueBean bean);

    }
}
