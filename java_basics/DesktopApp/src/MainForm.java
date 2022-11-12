import javax.swing.*;
import java.awt.*;

public class MainForm {
    private JPanel mainPanel;
    private JTextField lastNameF;
    private JTextField firstNameF;
    private JTextField middleNameF;
    private JButton button;
    private JLabel lastNameL;
    private JLabel firstNameL;
    private JLabel middleNameL;
    private boolean isCollapsed = false;

    public MainForm() {
        button.addActionListener(e -> {
            boolean isLastName = !lastNameF.getText().isEmpty();
            boolean isFirstName = !firstNameF.getText().isEmpty();


            if (isFirstName && isLastName && !isCollapsed) {

                toggle(false);
                isCollapsed = !isCollapsed;
                lastNameF.setText((lastNameF.getText() + " " + firstNameF.getText() + " " + middleNameF.getText()).strip());
                firstNameF.setText("");
                middleNameF.setText("");

            } else if (isCollapsed && isLastName) {

                String[] collapsedToExpand = lastNameF.getText().split(" ");
                if (collapsedToExpand.length == 3) {
                    lastNameF.setText(collapsedToExpand[0]);
                    firstNameF.setText(collapsedToExpand[1]);
                    middleNameF.setText(collapsedToExpand[2]);
                    toggle(true);
                    isCollapsed = !isCollapsed;
                } else if (collapsedToExpand.length == 2) {
                    lastNameF.setText(collapsedToExpand[0]);
                    firstNameF.setText(collapsedToExpand[1]);
                    toggle(true);
                    isCollapsed = !isCollapsed;
                } else message("Неполные данные");


            } else message("Поля не заполнены");
        });
    }

    private void toggle(boolean isExpanded) {
        firstNameF.setVisible(isExpanded);
        firstNameL.setVisible(isExpanded);
        middleNameF.setVisible(isExpanded);
        middleNameL.setVisible(isExpanded);
        if (!isExpanded) {
            Dimension preferredSize = new Dimension(230, 20);
            lastNameF.setMinimumSize(preferredSize);
            button.setText("Expand");
            lastNameL.setText("Ф.И.О");
        } else {
            Dimension preferredSize = new Dimension(100, 20);
            lastNameF.setMinimumSize(preferredSize);
            button.setText("Collapse");
            lastNameL.setText("Фамилия");
        }
    }

    private void message(String text) {
        JOptionPane.showMessageDialog(mainPanel, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
