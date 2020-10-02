public class Event {
    private String name;
    private Date date;
    private int numInvites;

    public Event(String name, Date date, int numInvites) {
        this.name = name;
        this.date = date;
        this.numInvites = numInvites;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getNumInvites() {
        return numInvites;
    }

    /*
     * Purpose: return the string representation for this event
     * Parameters: none
     * Returns: String - the string representation
     */
    public String toString() {
        String result;
        result = "Event name: "+name+"\n";
        result += "Event date: "+date+"\n";
        result += "Number of invites: "+numInvites;
        return result;
    }

    /*
     * Purpose: determine if the other event is equal to this event
     * Parameters: Event other - the other event to examine
     * Returns: boolean - true if this event is equal to other, false otherwise
     */
    public boolean equals(Event other) {
        return this.name.equals(other.getName()) && this.date.equals(other.getDate());
    }

}