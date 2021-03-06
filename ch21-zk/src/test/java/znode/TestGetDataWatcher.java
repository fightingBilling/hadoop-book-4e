package znode;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import common.ZooKeeperGenerator;

public class TestGetDataWatcher {

	@Test
	public void testDubbo() throws IOException, InterruptedException, KeeperException{
		
		ZooKeeper keeper = ZooKeeperGenerator.generate("localhost", 5000);
		
		for(String child : keeper.getChildren("/dubbo/org.shangyang.dubbo.provider.api.intf.DemoService/providers", null, null ) ){
			
			System.out.println( child );
			
			byte[] data = keeper.getData("/dubbo/org.shangyang.dubbo.provider.api.intf.DemoService/providers"+"/"+child, null, null);
			
			if( data != null ){
				
				System.out.println( new String( data, Charset.forName( "UTF-8" ) ) );
				
			}else{
				
				System.out.println( "no data value:" + data );
				
			}
			
		};
		
		byte[] data = keeper.getData("/dubbo/org.shangyang.dubbo.provider.api.intf.DemoService/providers", null, null);
		
		if( data != null ){
			
			System.out.println( new String( data, Charset.forName( "UTF-8" ) ) );
			
		}else{
			
			System.out.println( "no data value:" + data );
			
		}
		
		
	}
	
	
}
