package Tests;

import controllers.IndexServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class IndexServletTest extends HttpServlet {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Mock
    Logger loggerMock;

    IndexServlet servlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new IndexServlet();
    }

    @Test
    void testDoPost_whenCollegeExists() throws IOException {
        // Arrange
        when(request.getParameter("college")).thenReturn("New Mexico Institute of Mining and Technology");
        when(request.getSession(true)).thenReturn(session);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(session).setAttribute("college", "New Mexico Institute of Mining and Technology");
        verify(response).sendRedirect("home.jsp");
    }

    @Test
    void testDoPost_whenCollegeDoesNotExist() throws IOException {
        // Arrange
        when(request.getParameter("college")).thenReturn("NonExistingCollege");
        when(request.getSession(true)).thenReturn(session);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(session).setAttribute("college", "N/A");
        verify(response).sendRedirect("index.jsp");
    }

//    @Test
//    void testDoPost_handlesException() throws IOException {
//        // Arrange
//        when(request.getParameter("college")).thenThrow(new RuntimeException("Database connection failed"));
//        loggerMock = mock(Logger.class);
//
//        // Act
//        servlet.doPost(request, response);
//
//        // Assert
//        // Verify that the exception is logged
//        verify(loggerMock).severe("An error occurred: Database connection failed");
//        verify(loggerMock).throwing(eq(IndexServlet.class.getName()), anyString(), any(RuntimeException.class));
//    }
}
