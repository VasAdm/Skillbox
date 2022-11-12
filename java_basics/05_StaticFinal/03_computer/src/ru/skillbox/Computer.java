package ru.skillbox;

public class Computer {
    Processor processor;
    Memory memory;
    Drive drive;
    Display display;
    Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double getSummaryWeight () {
        return processor.getWeight() + memory.getWeight() + drive.getWeight() + keyboard.getWeight();
    }

    @Override
    public String toString() {
        return vendor + " - " + name +
                "\n\t - процессор - " + getProcessor() +
                "\n\t - оперативная память - " + getMemory() +
                "\n\t - жесткий диск - " + getDrive() +
                "\n\t - монитор - " + getDisplay() +
                "\n\t - клавиатура - " + getKeyboard() +
                "\n\t ======================" +
                "\n\t - общий вес - " + getSummaryWeight() / 1000 + " кг";
    }
}
