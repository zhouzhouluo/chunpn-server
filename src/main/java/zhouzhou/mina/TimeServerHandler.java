package zhouzhou.mina;

import java.util.Date;  
import java.util.Scanner;

import org.apache.mina.core.service.IoHandler;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
  
public class TimeServerHandler implements IoHandler {  
  
    @Override  
    public void exceptionCaught(IoSession arg0, Throwable arg1)  
            throws Exception {  
        arg1.printStackTrace();  
  
    }  
  
    @Override  
    public void messageReceived(IoSession session, Object message) throws Exception {  
          
        String str = message.toString();  
          
        System.out.println("接受到的消息:"+str);  
          
        if( str.trim().equalsIgnoreCase("quit") ) {  
            session.close(true);  
            return;  
        }  
        Date date = new Date();  
        session.write( date.toString() );  
        System.out.println("Message written...");  
    }  
  
    @Override  
    public void messageSent(IoSession arg0, Object arg1) throws Exception {  
        // TODO Auto-generated method stub  
        System.out.println("发送信息:"+arg1.toString());  
    }  
  
    @Override  
    public void sessionClosed(IoSession session) throws Exception {  
        // TODO Auto-generated method stub  
        System.out.println("IP:"+session.getRemoteAddress().toString()+"断开连接");  
    }  
  
    @Override  
    public void sessionCreated(IoSession session) throws Exception {  
        // TODO Auto-generated method stub  
        System.out.println("IP:"+session.getRemoteAddress().toString());  
    }  
  
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {  
        // TODO Auto-generated method stub  
        System.out.println( "IDLE " + session.getIdleCount( status ));  
  
    }  
  
    @Override  
    public void sessionOpened(IoSession arg0) throws Exception {  
        // TODO Auto-generated method stub 
    	System.out.println("sessionOpened--------");
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);  
		        boolean quit = false;  
		    	while(!quit){  
		            
		            String str = sc.next();  
		            if(str.equalsIgnoreCase("quit")){  
		                quit = true;  
		            }  
		            arg0.write(str);  
		        }
			}
		}).start();
    }

	@Override
	public void inputClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println( "inputClosed ");  
		arg0.closeNow();
	}  
  
}  
