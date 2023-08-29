import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private String from; // аэропорт вылета
    private String to; // аэропорт прилёта
    private int price; // цена билета
    private int timeFrom; // время вылета (по Москве)
    private int timeTo; // время прилёта (по Москве)

    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    // Вспомогательные методы для корректной работы equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && timeFrom == ticket.timeFrom && timeTo == ticket.timeTo && from.equals(ticket.from) && to.equals(ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, price, timeFrom, timeTo);
    }

}