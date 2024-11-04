package db;

import java.util.Date;

enum State{prepare, delivery, complete}

public class Delivery {
	State state;
	Date arrival_date;
	
}
