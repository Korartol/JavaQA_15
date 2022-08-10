import java.util.Arrays;

public class ManagerTickets {
    private TicketsRepository repo;

    public ManagerTickets(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Tickets tickets) {
        repo.save(tickets);
    }

    public Tickets[] getTicket() {
        Tickets[] all = repo.getTickets();
        return all;
    }


    // findAll чтобы искать сразу по отправлению и прибытию одновременно
    public Tickets[] findAll(String from, String to) {
        Tickets[] result = new Tickets[0];
        for (Tickets tickets : repo.getTickets()) {
            if (matches(tickets, from) & matches(tickets, to)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }
        }
        return result;
    }

    // метод поиска

    public Tickets[] searchBy(String text) {
        Tickets[] result = new Tickets[0];
        for (Tickets tickets : repo.getTickets()) {
            if (matches(tickets, text)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    // метод определения соответствия билета запросу поиск
    public boolean matches(Tickets tickets, String search) {
        if (tickets.getDeparture().contains(search)) {  // аэропорт вылета
            return true;
        }
        if (tickets.getArrival().contains(search)) {  // аэропорт прилета
            return true;
        } else {
            return false;
        }
    }
}
