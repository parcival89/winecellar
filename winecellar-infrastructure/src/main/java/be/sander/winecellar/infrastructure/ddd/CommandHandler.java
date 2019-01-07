package be.sander.winecellar.infrastructure.ddd;

public interface CommandHandler {
    boolean canHandle(Command<?> command);

    void handle(Command<?> command);
}
