package pattern.state;


import java.util.Scanner;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        BotContext bot = new BotContext();
        for (;;) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String output = bot.chat(input);
            System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
        }
    }
}

class BotContext {

    private State state = new DisconnectedState();

    public String chat(String input) {
        if ("hello".equalsIgnoreCase(input)) {
            state = new ConnectedState();
            return state.init();
        } else if ("bye".equalsIgnoreCase(input)) {
            state = new DisconnectedState();
            return state.init();
        } else if ("busy".equalsIgnoreCase(input)) {
            state = new BusyState();
            return state.init();
        }
        return state.reply(input);
    }
}



class ConnectedState implements State {

    @Override
    public String init() {
        return "Hello, I'm Bob.";
    }

    @Override
    public String reply(String input) {
        if (input.endsWith("?")) {
            return "Yes. " + input.substring(0, input.length() - 1) + "!";
        }
        if (input.endsWith(".")) {
            return input.substring(0, input.length() - 1) + "!";
        }
        return input.substring(0, input.length() - 1) + "?";
    }
}

class DisconnectedState implements State {

    @Override
    public String init() {
        return "Bye!";
    }

    @Override
    public String reply(String input) {
        return "";
    }
}

class BusyState implements State {
    @Override
    public String init() {
        return "I'm Busy, Bey!";
    }

    @Override
    public String reply(String input) {
        return "";
    }
}

interface State {

    String init();

    String reply(String input);

}
