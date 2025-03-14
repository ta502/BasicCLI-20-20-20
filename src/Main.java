package src;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        // Creating Scanner
        try (Scanner scan = new Scanner(System.in)) {
            // Let the user input what they need
            System.out.println("Set interval (for example your interval is 20, it will be 20-20-20):");
            int userInput = scan.nextInt();
            // Letting the user know what their interval looks, and notifying them that the program started
            System.out.println("Info: your interval is " + userInput + "-" + userInput + "-" + userInput);
            System.out.println("Info: starting, get ready.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Info: Started.");
            // Start the loop
            while (true) {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                TrayIcon trayIcon = new TrayIcon(image, "BasicCLI-20-20-20");
                trayIcon.setImageAutoSize(true);
                tray.add(trayIcon);
                TimeUnit.MINUTES.sleep(userInput);
                System.out.println("Info: " + userInput + " minutes out, now look at something " + userInput + " feet " + "(approx " + userInput * 0.3048 + " meters)" + " away for " + userInput + " seconds!");
                trayIcon.displayMessage("BasicCLI-20-20-20", userInput + " minutes out, now look at something " + userInput + " feet " + "(approx " + userInput * 0.3048 + " meters)" + " away for " + userInput + " seconds!", TrayIcon.MessageType.INFO);
                TimeUnit.SECONDS.sleep(userInput);
                System.out.println("Info: Starting again.");
            }
        // Catching exceptions.
        } catch (InterruptedException e) {
            System.out.println("Error: Interrupted.");
        } catch (AWTException e) {
            System.out.println("Error: AWT Exception.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input.");
        }
    }
}