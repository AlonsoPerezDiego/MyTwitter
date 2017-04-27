/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytwitter;
/**
 *
 * @author Diego
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;

/**
 * Todos lo métodos para en funcionamiento de twitter.
 * @author Diego
 */
public class Autentificar {
    
    static Status status;
    static List<Status> statuses;
    static DirectMessage message;
    static QueryResult result;
    static Twitter twitter;
//    static ArrayList <TimeLineInfo> timeLine;
//    static Iterator <Status> myIterator;

    /**
     * Autentifican los datos para la aplicación.
     */
    public Autentificar(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey("dhBekEC7YAZwzFQOZY9G0vwwQ")
        .setOAuthConsumerSecret("OGjNkJhJvE2WTQkSqrIOi9UHW2rJaonaomgES8IEuIVbTdgiLo")
        .setOAuthAccessToken("843737127691173888-6rDKy9Q9XOOgCNpjH6907v46dTA2Rre")
        .setOAuthAccessTokenSecret("Ezl4IJt00FRvDDIoCnk1uqI12CSPKYrBRdCZpgX73NawK");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
//        timeLine = new ArrayList<TimeLineInfo>();
//        myIterator ;
    }
    
    /**
     * Publica un tweet.
     * @param latestStatus 
     */
    public static void postATweet(String latestStatus){
        try {
            status = twitter.updateStatus(latestStatus);
        } catch (TwitterException ex) {
            Logger.getLogger(Autentificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
    
    /**
     * Muestra todos los tweets.
     * @param confirmacion 
     */
    public static void getTimeline(String confirmacion){
        //Twitter twitter = TwitterFactory.getSingleton();
        try {
            statuses = twitter.getHomeTimeline();
            System.out.println(confirmacion);
        } catch (TwitterException ex) {
            Logger.getLogger(Autentificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" + status.getText());
//        timeLine.add(new TimeLineInfo(status.getUser().getName(), status.getText()));
        }
    }
    
    /**
     * Envia un mensaje directo al usuario que se introduzca.
     * @param recipientId
     * @param texto 
     */
    public static void directMessages(String recipientId, String texto){
        
//        Twitter twitter = TwitterFactory.getSingleton();
        try {
            message = twitter.sendDirectMessage(recipientId, texto);
        } catch (TwitterException ex) {
            Logger.getLogger(Autentificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
    }
    
    /**
     * Busca un hashtag.
     * @param dato 
     */
    public static void searchTweet(String dato){
//        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query(dato);
        try {
            result = twitter.search(query);
        } catch (TwitterException ex) {
            Logger.getLogger(Autentificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }
}
