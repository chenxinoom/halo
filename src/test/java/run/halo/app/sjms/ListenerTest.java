package run.halo.app.sjms;

import lombok.Data;
import org.junit.jupiter.api.Test;
import run.halo.app.event.logger.LogEvent;

public class ListenerTest {


    @Data
    static class Event{
        String name;

        public Event(String name){
            this.name = name;
        }
    }

    static class Listener{
        public void onApplicationEvent(Event event){
            System.out.println(event.getName());
        }
    }

    static class Publisher{
        void publishEvent(Event event){
            new Listener().onApplicationEvent(event);
        }
    }

    @Test
    public static void main(String[] args) {

        Publisher publisher = new Publisher();
        publisher.publishEvent(new Event("chen"));
    }
//    public void test(){
}
