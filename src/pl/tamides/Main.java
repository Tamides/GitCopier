package pl.tamides;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    private static final String PROJECT_NAME = "YTube";

    public static void main(String[] args) {
        String result = "Przetwarzam";

        JFrame window = new JFrame("GitCopier");
        window.setLocationRelativeTo(null);
        window.setSize(320, 240);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);

        JLabel textView = new JLabel();
        textView.setBounds(110, 44, 100, 32);
        textView.setHorizontalAlignment(SwingConstants.CENTER);
        textView.setText(result);

        JButton copyFrom = new JButton("Copy from");
        copyFrom.setBounds(32, 108, 112, 32);

        JButton copyTo = new JButton("Copy to");
        copyTo.setBounds(176, 108, 112, 32);

        copyFrom.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                copyTo.setEnabled(false);
                textView.setText("Copying...");

                try {
                    new ProcessBuilder().command("bash", "-c", "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "Git/README.md /home/rsyzdek/Git/ && " +
                            "rm -rf /home/rsyzdek/Git/" + PROJECT_NAME + "Git/* && " +
                            "cp -a /home/rsyzdek/Git/README.md /home/rsyzdek/Git/" + PROJECT_NAME + "Git/ && " +
                            "rm -rf /home/rsyzdek/Git/README.md && " +
                            "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "/build.gradle /home/rsyzdek/Git/" + PROJECT_NAME + "Git/ && " +
                            "mkdir /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/ && " +
                            "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "/app/build.gradle /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/ && " +
                            "mkdir /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/libs && " +
                            "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "/app/libs/. /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/libs/ && " +
                            "mkdir /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/src && " +
                            "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "/app/src/. /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/src/").start();

                    textView.setText("Copied from");
                    copyTo.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText("Error copying from");
                }
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
        copyTo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                copyFrom.setEnabled(false);
                textView.setText("Copying...");

                try {
                    new ProcessBuilder().command("bash", "-c",
                            "rm -rf /home/rsyzdek/Git/" + PROJECT_NAME + "/build.gradle && " +
                                    "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "Git/build.gradle /home/rsyzdek/Git/" + PROJECT_NAME + "/ && " +
                                    "rm -rf /home/rsyzdek/Git/" + PROJECT_NAME + "/app/build.gradle && " +
                                    "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/build.gradle /home/rsyzdek/Git/" + PROJECT_NAME + "/app/ && " +
                                    "rm -rf /home/rsyzdek/Git/" + PROJECT_NAME + "/app/libs/* && " +
                                    "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/libs/. /home/rsyzdek/Git/" + PROJECT_NAME + "/app/libs/ && " +
                                    "rm -rf /home/rsyzdek/Git/" + PROJECT_NAME + "/app/src/* && " +
                                    "cp -a /home/rsyzdek/Git/" + PROJECT_NAME + "Git/app/src/. /home/rsyzdek/Git/" + PROJECT_NAME + "/app/src/").start();

                    textView.setText("Copied to");
                    copyFrom.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText("Error copying to");
                }
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

        window.add(textView);
        window.add(copyFrom);
        window.add(copyTo);
        window.setVisible(true);
    }
}
