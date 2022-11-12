package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("HP", "first");

        Processor processor = new Processor(3500, 4, "Intel", 30);
        Memory memory = new Memory(DdrType.DDR4, 16384, 20);
        Drive drive = new Drive(4096, 550);
        Display display = new Display(32, DisplayType.IPS, 2000);
        Keyboard keyboard = new Keyboard(KeyboardType.MECHANICAL, true, 450);

        computer.setProcessor(processor);
        computer.setMemory(memory);
        computer.setDrive(drive);
        computer.setDisplay(display);
        computer.setKeyboard(keyboard);

        System.out.println(computer);
    }
}