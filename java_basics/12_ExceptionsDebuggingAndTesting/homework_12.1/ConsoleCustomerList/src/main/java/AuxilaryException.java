class AuxiliaryException extends IllegalArgumentException{
    private final String name;

    public String getName() {
        return name;
    }

    public AuxiliaryException(String message, String name) {
        super(message);
        this.name = name;
    }
}
