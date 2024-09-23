package hotelkjw.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotelkjw.config.kafka.KafkaProcessor;
import hotelkjw.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RoomRepository roomRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reservationcompleted'"
    )
    public void wheneverReservationcompleted_DecreseRoom(
        @Payload Reservationcompleted reservationcompleted
    ) {
        Reservationcompleted event = reservationcompleted;
        System.out.println(
            "\n\n##### listener DecreseRoom : " + reservationcompleted + "\n\n"
        );

        // Sample Logic //
        Room.decreseRoom(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
