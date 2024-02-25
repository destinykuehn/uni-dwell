package Tests;

import java.io.StringWriter;
import java.io.PrintWriter;
import controllers.MyServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServletTest extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

//        when(request.getParameter("username")).thenReturn("me");
//        when(request.getParameter("password")).thenReturn("secret");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new MyServlet().doGet(request, response);

        // only if you want to verify username was called...
//        verify(request, atLeast(1)).getParameter("username");
        writer.flush(); // it may not have been flushed yet...
        assertEquals("Hello, World!", stringWriter.toString().trim());
    }
}
