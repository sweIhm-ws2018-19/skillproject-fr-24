package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionEndedRequestHandlerTest {

    SessionEndedRequestHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setUp() {
        handler = new SessionEndedRequestHandler();
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
    }

    @Test
    public void testCanHandle() {
        when(mockInputHandler.matches(any())).thenReturn(true);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertTrue(actual.isPresent());
    }
}