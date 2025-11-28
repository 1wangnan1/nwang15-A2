public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    
    // remove visitor from queue
    void removeVisitorFromQueue();
    
    // print waiting visitors
    void printQueue();
    
    // add visitor to ride history
    void addVisitorToHistory(Visitor visitor);
    
    // check if visitor in history
    boolean checkVisitorFromHistory(Visitor visitor);
    
    // get number of visitors in history
    int numberOfVisitors();
    
    // print ride history
    void printRideHistory();
    
    // run one cycle of ride
    void runOneCycle();
}