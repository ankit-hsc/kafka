import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class AsyncProducer {

	private static final String topicName="demo-topic";
	static String value="Ankit";
	
	public static void main(String[] args) throws InterruptedException {

		
		
		Properties props=new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		
		KafkaProducer<String,String> sampleProducer=new KafkaProducer<String, String>(props);
		
		
	/*	ProducerRecord<String,String> record=new ProducerRecord<String, String>(topicName,value);
		sampleProducer.send(record,(metadata,exception)->{
			if(exception==null) {System.out.println("producer successfully send.");}
			else {System.out.println("Error in producer");}
		});
		*/
		
		
		for(int i=0;i<1000;i++) {
			sampleProducer.send(new ProducerRecord<String, String>(topicName, "get: "+Integer.toString(i)),(metadata,exception)->{
				if(exception==null) {System.out.println("producer successfully send.");}
				else {System.out.println("Error in producer");}
			});
			Thread.sleep(250);
		}
		
		
		
		sampleProducer.close();
	}

}
