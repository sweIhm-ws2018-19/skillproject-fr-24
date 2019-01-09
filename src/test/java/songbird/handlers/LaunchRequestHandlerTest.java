package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LaunchRequestHandlerTest {

    LaunchRequestHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setUp() {
        handler = new LaunchRequestHandler();
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandle() {
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }
}