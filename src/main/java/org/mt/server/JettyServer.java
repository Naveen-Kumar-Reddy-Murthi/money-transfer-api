package org.mt.server;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.mt.util.DBUtils;

public class JettyServer {
	
	private static final String LOG_FILE_PATH = System.getProperty("user.home")+File.separator;

    public static void main(String[] args) {
    	
    	HandlerCollection handlers = new HandlerCollection();
    	handlers.addHandler(createRequestLogHandler());
    	
    	ServletContextHandler ctx = 
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);     
        ctx.setContextPath("/");
        
        handlers.addHandler(ctx);
    	
        Server server = new Server(8080);
        server.setHandler(handlers);
        
        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/rest/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages", 
                "org.mt.rest.controller");

		try {
			initializeH2DB();

			server.start();
			server.join();
		} catch (Exception ex) {
            Logger.getLogger(JettyServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            server.destroy();
        }
    }
    
    private static void initializeH2DB() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    	
    	Class.forName(DBUtils.DRIVER).newInstance();
    	Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
    	connection.setAutoCommit(true);
    	
    	org.h2.tools.Server server = org.h2.tools.Server.createWebServer(new String[]{"-web","-webAllowOthers","-webPort","7071"}).start();
    	
    	System.out.println("URL: jdbc:h2:" + server.getURL() + "/mtapiDB" );
    }
    
	private static RequestLogHandler createRequestLogHandler() {
		
		NCSARequestLog requestLog = new NCSARequestLog();
		requestLog.setFilename(LOG_FILE_PATH+"yyyy_mm_dd.request.log");
		requestLog.setFilenameDateFormat("yyyy_MM_dd");
		requestLog.setRetainDays(90);
		requestLog.setAppend(true);
		requestLog.setExtended(true);
		requestLog.setLogCookies(false);
		requestLog.setLogTimeZone("GMT");
		RequestLogHandler requestLogHandler = new RequestLogHandler();
		requestLogHandler.setRequestLog(requestLog);

		return requestLogHandler;

	}
}