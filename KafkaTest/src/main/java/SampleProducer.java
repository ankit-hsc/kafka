import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SampleProducer {

	private static final String topicName="demo-topic";
	static String key="sample key";
	static String value="suresh";
	
	
	
	
	
	public static void main(String[] args) {

		
		Properties props=new Properties();
		
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		
		KafkaProducer<String,String> sampleProducer=new KafkaProducer<String, String>(props);
		ProducerRecord<String,String> record=new ProducerRecord<String, String>(topicName, key,value);
		sampleProducer.send(record);
		
		
		/*for(int i=0;i<10;i++) {
			sampleProducer.send(new ProducerRecord<String, String>(topicName, "get: "+Integer.toString(i)));
		}*/
		
		sampleProducer.close();
	}

}
