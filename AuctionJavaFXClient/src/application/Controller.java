package application;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import emulator.BidEmulator;
import emulator.BidListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Bid;
import model.Product;
import model.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

public class Controller implements MessageListener{
	
    // Default values for JMS
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/queue/test";
    private static final String DEFAULT_USERNAME = "quickstartUser";
    private static final String DEFAULT_PASSWORD = "quickstartPwd1!";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "http-remoting://127.0.0.1:9080";
    
    private Context namingContext = null;
    private JMSConsumer consumer = null;

    //Bid emulator
    private static BidEmulator bidEmulator;

    //A collection of Bid objects representing current bids
    private static List<Bid> currentBids;

    @FXML
    TextArea simulatorConsole;

    @FXML
    private void handleStartSimulationButtonClicked(ActionEvent ae){
    	
        //Initialize bid emulator
        bidEmulator = new BidEmulator();
        //Register this class as a listener
        //bidEmulator.addListener(this);
    	
    	// Create the JMS consumer

            try {
                String userName = System.getProperty("username", DEFAULT_USERNAME);
                String password = System.getProperty("password", DEFAULT_PASSWORD);

                // Set up the namingContext for the JNDI lookup
                final Properties env = new Properties();
                env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
                env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
                env.put(Context.SECURITY_PRINCIPAL, userName);
                env.put(Context.SECURITY_CREDENTIALS, password);
                namingContext = new InitialContext(env);

                // Perform the JNDI lookups
                String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
                ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup(connectionFactoryString);

                String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
                Destination destination = (Destination) namingContext.lookup(destinationString);

                try (JMSContext context = connectionFactory.createContext(userName, password)) {

                    // Create the JMS consumer
                    consumer = context.createConsumer(destination);
                    //consumer.setMessageListener(this);
                    MessageListener myMessageListener = new MessageListener() {
                        @Override
                        public void onMessage(Message message) {

                            try {
                                String receivedBid = message.getBody(String.class);
                                System.out.println(receivedBid);
                            } catch (JMSException e) {
                                System.out.println(e.getStackTrace());
                            }
                            finally {
                                System.out.println("onMessage called!!!");
                            }
                        }
                    };
                    consumer.setMessageListener(myMessageListener);
                    /*
                    for (int i = 0; i < 10; i++) {
                        String text = consumer.receiveBody(String.class, 5000);
                        System.out.println("Received message with content " + text);
                    }
                    */
                }

            } catch (NamingException e) {
                System.out.println(e.getMessage());
            } finally {
                if (namingContext != null) {
                    try {
                        namingContext.close();
                    } catch (NamingException e) {
                System.out.println(e.getMessage());        
                    }
                }
            }
        
        //Create list of bids
        currentBids = new ArrayList<Bid>();

        //Place some bids in the list
        loadUsersProductsAndBids();
        
        //Start bidding process emulation
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(bidEmulator, 0, 100);

        simulatorConsole.setText("Simulation started");
    }
	

	@FXML
    private void handleStopSimulationButtonClicked(ActionEvent ae){
    	bidEmulator.cancel();
        simulatorConsole.setText("Simulation stopped");
    }
    
	@Override
	public void onMessage(Message message) {
		
			try {
//				Bid receivedBid = message.getBody(Bid.class);
				String receivedBid = message.getBody(String.class);
				System.out.println(receivedBid);
				System.out.println("onMessage called!!!");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

    /*
    @Override
    public void bidEvent(Bid bid) {
       System.out.println("Received a new bid!");
 //      simulatorConsole.setText("Received a new bid!");
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Bid id: " + bid.id + " Product id: " + bid.product.id +
                " User id: " + bid.user.id + " Amount: " + df.format(bid.amount));
        //add the new bid to the collection of bids
        currentBids.add(bid);
        //announce all bidders who opted for receiving overbid emails
        currentBids.stream()
                .filter(b -> b.product.id == bid.product.id)
                .filter(b -> b.user.getOverbidNotifications == true)
                .map(b -> b.user.id)
                .distinct()
                .forEach(i -> {
                    switch(i){
                        case 1: System.out.println("Mail sent to Mary: m.smith@xyz.com"); break;
                        case 2: System.out.println("Mail sent to Julia: j.roberts@abc.org"); break;
                        case 3: System.out.println("Mail sent to James: james.bond@xyz.com"); break;
                        case 4: System.out.println("Mail sent to Cristina: cristina.f@abc.org"); break;
                        default:;
                    }
                });
        //if the bid is less than a min Product price, send the bidder a sorry email
        //ff the bid is greater or equal to the Product reserved price, send the bidder a winning email
        System.out.println();
    }
    */

    private void loadUsersProductsAndBids(){
        //users
        User mary = new User();
        User julia = new User();
        User james = new User();
        User me = new User();

        mary.id = 1;
        mary.name = "Mary";
        mary.email = "m.smith@xyz.com";
        mary.getOverbidNotifications = true;

        julia.id = 2;
        julia.name = "Julia";
        julia.email = "j.roberts@abc.org";
        julia.getOverbidNotifications = true;

        james.id = 3;
        james.name = "James";
        james.email = "james.bond@xyz.com";
        james.getOverbidNotifications = false;

        me.id = 4;
        me.name = "Cristina";
        me.email = "cristina.f@abc.org";
        me.getOverbidNotifications = true;

        //selling a bicycle and a ring
        Product bicycle = new Product();
        Product ring = new Product();

        bicycle.id = 1;
        bicycle.title = "Pegas Mountain Bike";
        bicycle.minimalPrice = BigDecimal.valueOf(100);
        bicycle.reservedPrice = BigDecimal.valueOf(3000);

        ring.id = 2;
        ring.title = "Engagement Ring";
        ring.minimalPrice = BigDecimal.valueOf(2500);
        ring.reservedPrice = BigDecimal.valueOf(7000);

        //some bids
        Bid bid1 = new Bid();
        bid1.id = 1;
        bid1.product = ring;
        bid1.amount = BigDecimal.valueOf(7000);
        bid1.user = james;

        Bid bid2 = new Bid();
        bid2.id = 2;
        bid2.product = ring;
        bid2.amount = BigDecimal.valueOf(7500);
        bid2.user = me;

        Bid bid3 = new Bid();
        bid3.id = 3;
        bid3.product = bicycle;
        bid3.amount = BigDecimal.valueOf(1000);
        bid3.user = me;

        currentBids.add(bid1);
        currentBids.add(bid2);
        currentBids.add(bid3);

        //print current bids
        currentBids.forEach(bid -> {
            System.out.println(bid.user.name + " bids for " + bid.product.title);
        });

        //Use Streams API with the collection of Bid objects.
        //Use Comparator and sort the stream.

        // Filter, map, reduce
        int numberOfBidsOnRing = currentBids.stream()
                .filter(b -> b.product.id == 2)
                .mapToInt(b -> 1)
                .sum();        // Combining the results (reducing)

        System.out.println("Number of bids on ring is " + numberOfBidsOnRing);

        System.out.println("\n Bids on ring, in descending order of bid amount:");
        Comparator<Bid> comparator = Comparator.comparing(b -> b.amount);
        currentBids.stream()
                .filter(b -> b.product.id == 2)
                .sorted(comparator.reversed())
                .forEach(b -> {
                    System.out.println(b.user.name + " bids " + b.amount + " for " + b.product.title);
                });


        System.out.println();

    }


}
